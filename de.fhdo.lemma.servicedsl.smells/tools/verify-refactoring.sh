#!/usr/bin/env bash
#
# Decide whether a proposed refactoring actually resolved the security smell.
#
# A patch is not evidence. ADR-0010 admits an AI into this toolchain only on the
# condition that what it produces is measured rather than trusted, and this is
# the measurement. Four gates, all of which must pass:
#
#   1. clean   the patch applies to a clean checkout and the build is green
#              there, with no generated key material present
#   2. inplace the build is green in a tree where the material has been
#              generated
#   3. smell   the addressed root cause has no finding left, and the total
#              count fell, both against a baseline taken before
#   4. starts  the system still comes up, and every peer a service can no
#              longer reach is one the unpatched system cannot reach either or
#              one REFACTORING-NOTES.md declares
#
# Gate 4 does not decide which lost channel is acceptable, because it cannot:
# mutual TLS on a service's actuator endpoints does stop an admin server that
# holds no client certificate from scraping them, and every proposal of this
# work does that. It decides whether the loss was declared - the prompt already
# requires a proposal to write down what its patch gives up, and this is where
# that is checked rather than trusted.
#
# The verdict is one of REPAIR COMPLETE, REPAIR PARTIAL, GATE FAILED and
# NOT MEASURED; exit status 0, 4, 1 and 3 respectively. A declared loss makes a
# repair partial rather than failed, and never complete.
#
# Gate 1 and gate 2 are deliberately separate. A patch whose tests read a key
# store from disk passes the second and fails the first, which is exactly what
# the second proposal of this work did - and nothing but a clean-room build
# found it.
#
# Usage:
#   tools/verify-refactoring.sh --proposal <folder> --source <checkout> \
#       --models <generated-models> [--mrf <mrf-repo>] [--base <ref>]
#       [--plugins "<list>"] [--build-command "<command>"]
#       [--skip-start] [--skip-smell] [--certs <command>]
#
# Verifying a system other than Lakeside Mutual needs two of these. --plugins
# is the MRF plugin selection for that system, and getting it wrong is the one
# mistake this script cannot catch: the smell gate would compare a baseline
# against a reconstruction of a different fact set and still print a number.
# --build-command says how to build a system that is not per-service Maven;
# without it, a system with no Maven wrapper skips the build gates rather than
# passing them.
#
# --base is the commit the patch is measured against, defaulting to HEAD. It
# matters when a patch depends on a prerequisite: a refactoring of a system
# whose container images no longer build has to be judged against the commit
# that fixes them, or the start gate can only ever skip.
#
# The proposal folder is one written by ProposalRecord: it must hold patch.diff,
# and the result is appended to verification.md inside it.
#
# Environment:
#   LEMMA_ECLIPSE   Eclipse installation the LEMMA tools take their classpath
#                   from (see detect-smells.sh)
#   LEMMA_SETTLE_SECONDS
#                   How long the start gate lets the stack settle before it
#                   reads the logs for unreachable peers (default: 25). Long
#                   enough that a client retrying its way through a starting
#                   broker has finished retrying; a slower machine wants more.
set -uo pipefail

BUNDLE="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
WORKSPACE="$(cd "$BUNDLE/.." && pwd)"

PROPOSAL=""; SOURCE=""; MODELS=""; MRF=""; CERTS=""; BASE="HEAD"
SKIP_START=0; SKIP_SMELL=0
# Defaults fit Lakeside Mutual. Both are options because they are the two
# places this script would otherwise be specific to one system - and getting
# either wrong is worse than it looks: the smell gate would compare a baseline
# against a reconstruction of a different fact set, and the build gates would
# pass without building anything.
PLUGINS="Java Spring Communication Docker Protobuf Node"
BUILD_COMMAND=""
while [[ $# -gt 0 ]]; do
    case "$1" in
        --proposal) PROPOSAL="$2"; shift 2 ;;
        --source)   SOURCE="$2";   shift 2 ;;
        --models)   MODELS="$2";   shift 2 ;;
        --mrf)      MRF="$2";      shift 2 ;;
        --certs)    CERTS="$2";    shift 2 ;;
        --base)     BASE="$2";     shift 2 ;;
        --plugins)  PLUGINS="$2";  shift 2 ;;
        --build-command) BUILD_COMMAND="$2"; shift 2 ;;
        --skip-start) SKIP_START=1; shift ;;
        --skip-smell) SKIP_SMELL=1; shift ;;
        -h|--help) sed -n '2,32p' "${BASH_SOURCE[0]}" | sed 's/^# \{0,1\}//'; exit 0 ;;
        *) echo "Unknown option: $1" >&2; exit 2 ;;
    esac
done

for required in PROPOSAL SOURCE MODELS; do
    if [[ -z "${!required}" ]]; then
        echo "Missing --${required,,}. See --help." >&2
        exit 2
    fi
done
PATCH="$PROPOSAL/patch.diff"
[[ -f "$PATCH" ]] || { echo "No patch.diff in $PROPOSAL" >&2; exit 2; }
[[ -d "$SOURCE/.git" ]] || { echo "Not a git checkout: $SOURCE" >&2; exit 2; }

PASSED=(); FAILED=(); SKIPPED=()

# Two things the gates establish but the verdict used to swallow.
#
# A patch that breaks a monitoring scrape and declares it passes gate 4, and so
# does a patch that breaks nothing: the declared-loss rule exists so the gate
# does not fail every correct refactoring, but folding both into one PASS erases
# the difference between them. Two proposals of this work differ in exactly that
# way. So the loss is reported as its own field instead of being hidden inside a
# verdict, and the verdict is left alone, because the four gates did pass.
#
# COVERAGE_LOST is read from the proposal's own notes rather than measured: the
# prompt requires a proposal to declare it when a test's transport changes, and
# nothing here detects it. A proposal that stays silent therefore reads "none
# declared", which is a statement about the notes and not about the tests.
DECLARED_LOSSES="not measured"
COVERAGE_LOST="not measured"

pass() { PASSED+=("$1"); printf '  PASS  %s\n' "$1"; }
fail() { FAILED+=("$1: $2"); printf '  FAIL  %s\n        %s\n' "$1" "$2"; }
skip() { SKIPPED+=("$1: $2"); printf '  SKIP  %s (%s)\n' "$1" "$2"; }

# Build and test the system in a tree.
#
# Returns 0 when everything built, the number of failures when something did
# not, and BUILD_NOTHING when there was nothing recognisable to build. That
# third case has to be distinguishable: a silent "no projects found" would
# otherwise be indistinguishable from success, and a gate that passes without
# building anything is worse than no gate.
#
# --build-command overrides the default for a system this does not fit. It runs
# once, from the root of the tree, and its exit status decides.
BUILD_NOTHING=250

build_all() {
    local tree="$1" log="$2"

    if [[ -n "$BUILD_COMMAND" ]]; then
        if (cd "$tree" && bash -c "$BUILD_COMMAND") >> "$log" 2>&1; then
            return 0
        fi
        echo "FAILED: $BUILD_COMMAND" >> "$log"
        return 1
    fi

    # The default: each Maven project under the root has its own wrapper, so
    # this is "every project", not one reactor build.
    local failures=0 projects=0
    while IFS= read -r wrapper; do
        local project
        project="$(dirname "$wrapper")"
        projects=$((projects + 1))
        if ! (cd "$project" && ./mvnw -q -DskipTests=false test) >> "$log" 2>&1; then
            echo "FAILED: ${project#$tree/}" >> "$log"
            failures=$((failures + 1))
        fi
    done < <(find "$tree" -maxdepth 2 -name mvnw -not -path "*/.git/*")

    if (( projects == 0 )); then
        echo "NOTHING TO BUILD: no Maven wrapper found under $tree" >> "$log"
        return $BUILD_NOTHING
    fi
    return $failures
}

# Generate the key material a tree needs, if the tree says how.
#
# Mutual TLS needs a key store per peer, and a patch that does it properly ships
# the script that makes them - the proposals of this work all did, under three
# different names and at two different depths. Hence two levels rather than one:
# the one that shipped scripts/generate-certificates.sh was found by nothing,
# its system could not come up for want of a key, and the gate blamed the patch
# for the tool's lookup.
#
# Used for the patched tree and for the control, because the control needs it as
# much. Its base may be a commit that already requires certificates, and that
# base run without them is not its own baseline: rc3's base is rc1 applied, and
# without key material its Customer Core never registers with the admin server,
# so the control logged none of the TLS errors rc1 causes and rc3 was charged
# with them.
#
# Returns NO_MATERIAL when the tree says nothing about key material, so a caller
# can tell "generated" from "there was nothing to generate".
NO_MATERIAL=250

generate_material() {
    local tree="$1" command=""
    if [[ -n "$CERTS" ]]; then
        command="$CERTS"
    else
        local generator
        generator="$(find "$tree" -maxdepth 2 \
            \( -name 'generate*certificate*' -o -name 'generate*certs*' \) \
            -not -path '*/.git/*' 2>/dev/null | sort | head -1)"
        [[ -n "$generator" ]] && command="bash '$generator'"
    fi
    [[ -z "$command" ]] && return $NO_MATERIAL
    (cd "$tree" && bash -c "$command") > /dev/null 2>&1
}

# What the proposal says it gave up in test coverage.
#
# Read from the patch's own added notes lines, not measured, and not from the
# file in the tree: a stacked proposal inherits the notes of the ones below it.
# The constraints allow a test's configuration to be
# updated so that it addresses the new transport, and require the proposal to
# say so; one proposal of this work moved a producer test to an in-process
# broker transport, which keeps every assertion and loses the network
# handshake. No gate observes that, and nothing here detects it: this reads the
# proposal's own notes, so silence prints as "none declared" and says something
# about the notes rather than about the tests.
coverage_lost() {
    local patch="$1"
    [[ -f "$patch" ]] || { echo "not measured (no patch)"; return; }

    # The lines this patch ADDS to REFACTORING-NOTES.md, not the file in the
    # tree. A proposal applied on top of another inherits the earlier notes -
    # rc4 is built on rc1 and rc2 - and reading the file would have credited
    # it with a declaration it never made.
    local notes
    notes="$(awk '/^\+\+\+ b\/REFACTORING-NOTES\.md$/ { inside = 1; next }
                  /^diff --git / { inside = 0 }
                  inside && /^\+/ { print substr($0, 2) }' "$patch")"
    [[ -z "${notes// /}" ]] && { echo "none declared"; return; }

    # The notes' own test section when they have one, otherwise all of them:
    # the proposals of this work head it "Tests", but a heading is a convention
    # and not a contract.
    local section
    section="$(printf '%s\n' "$notes" \
        | awk '/^#+[[:space:]]*Tests/ { inside = 1; next }
               /^#+[[:space:]]/ { inside = 0 }
               inside { print }')"
    [[ -z "${section// /}" ]] && section="$notes"

    # By sentence, not by line: the notes are wrapped prose, and the line a
    # keyword falls on usually starts mid-clause.
    local statement
    statement="$(printf '%s\n' "$section" | tr '\n' ' ' | sed -E 's/\. /.\n/g' \
        | grep -iE 'in-vm|in-process|vm://|coverage|no network connector|without opening a network' \
        | head -1 | sed -E 's/^[-* ]+//; s/[[:space:]]+/ /g; s/[`*]//g' \
        | awk '{ line = $0
                 if (length(line) <= 160) { print line; exit }
                 # Cut at the last word boundary, so the record does not end
                 # mid-word, and say that it was cut.
                 short = substr(line, 1, 160)
                 sub(/[^ ]*$/, "", short)
                 sub(/ +$/, "", short)
                 print short " [...]" }')"
    if [[ -z "${statement// /}" ]]; then
        echo "none declared"
    else
        echo "$statement"
    fi
}

echo "Verifying $(basename "$PROPOSAL")"
echo

# How much the patch changes.
#
# Not a gate: there is no number of files that is right, and a smaller patch is
# not a better one. It is measured because the claim that model-level input
# bounds a refactoring is a claim about extent, and a claim about extent that
# nobody counts is an anecdote. The one unguided run of this work changed 38
# files where the guided ones changed 33 between them, which is the kind of
# difference this line exists to make visible per proposal.
PATCH_FILES="$(grep -c '^diff --git ' "$PROPOSAL/patch.diff" 2>/dev/null || true)"
PATCH_ADDED="$(grep -c '^+[^+]' "$PROPOSAL/patch.diff" 2>/dev/null || true)"
PATCH_REMOVED="$(grep -c '^-[^-]' "$PROPOSAL/patch.diff" 2>/dev/null || true)"
EXTENT="${PATCH_FILES:-0} file(s), +${PATCH_ADDED:-0}/-${PATCH_REMOVED:-0} line(s)"
echo "  extent: $EXTENT"
echo

# ---------------------------------------------------------------- gate 3 (before)
BEFORE=""
if [[ "$SKIP_SMELL" == 0 ]]; then
    BEFORE_REPORT="$(mktemp -t lemma-before)"
    if "$BUNDLE/tools/detect-smells.sh" "$MODELS" --report "$BEFORE_REPORT" > /dev/null 2>&1 \
        || [[ $? -eq 1 ]]; then
        BEFORE="$(grep -m1 '^| Findings |' "$BEFORE_REPORT" | tr -dc '0-9')"
    fi
    if [[ -z "$BEFORE" ]]; then
        skip "baseline" "the finding count could not be read before patching"
        SKIP_SMELL=1
    else
        echo "  baseline: $BEFORE finding(s) before the patch"
    fi

    # Which cause this proposal was asked to resolve. A falling total is a weak
    # condition: it holds while the addressed cause still has findings, and it
    # also holds if the reconstruction simply stopped seeing a channel. The id
    # lets the gate ask the stronger question - does THIS cause still appear -
    # so the record's own statement of intent is what the gate is measured
    # against.
    # Only a real cause id counts. A record may carry prose there - the
    # ablation's says "(none given ...)" - and a gate that took the first word
    # regardless would announce a cause of "(none" and check for it.
    CAUSE="$(awk '$1 == "cause" && $2 ~ /^(endpoint|broker):/ { print $2; exit }' \
        "$PROPOSAL/model.txt" 2>/dev/null)"
    if [[ -n "$CAUSE" ]]; then
        BEFORE_CAUSE="$(grep -c -F "(\`$CAUSE\`)" "$BEFORE_REPORT" 2>/dev/null || true)"
        if [[ "$BEFORE_CAUSE" == 0 ]]; then
            echo "  note: cause $CAUSE has no finding in the baseline, so the cause check cannot bite"
            CAUSE=""
        else
            echo "  addressed cause: $CAUSE"
        fi
    else
        echo "  note: the record names no cause, so only the total is checked"
    fi
fi

# ---------------------------------------------------------------- gate 1: clean
CLEAN="$(mktemp -d -t lemma-clean)"
rm -rf "$CLEAN"
if git -C "$SOURCE" worktree add --detach "$CLEAN" "$BASE" > /dev/null 2>&1; then
    if git -C "$CLEAN" apply "$PATCH" > /dev/null 2>&1; then
        CLEAN_LOG="$(mktemp -t lemma-clean-build)"
        build_all "$CLEAN" "$CLEAN_LOG"; CLEAN_STATUS=$?
        if (( CLEAN_STATUS == 0 )); then
            pass "clean: the patch applies to a clean checkout and the build is green"
        elif (( CLEAN_STATUS == BUILD_NOTHING )); then
            skip "clean" "nothing recognisable to build in this system; pass --build-command to say how"
        else
            fail "clean" "the build fails on a clean checkout with no generated key material: $(grep -m2 '^FAILED:' "$CLEAN_LOG" | tr '\n' ' ')see $CLEAN_LOG"
        fi
    else
        fail "clean" "the patch does not apply to a clean checkout of $BASE"
    fi
    git -C "$SOURCE" worktree remove --force "$CLEAN" > /dev/null 2>&1
else
    fail "clean" "a clean worktree could not be created"
fi

# ---------------------------------------------------------------- gate 2: in place
WORK="$(mktemp -d -t lemma-work)"
rm -rf "$WORK"
BRANCH="refactoring/$(basename "$PROPOSAL")"
if git -C "$SOURCE" worktree add --detach "$WORK" "$BASE" > /dev/null 2>&1 \
    && git -C "$WORK" apply "$PATCH" > /dev/null 2>&1; then
    git -C "$WORK" checkout -q -b "$BRANCH" 2>/dev/null || true

    # Without key material this gate is gate 1 again, so it has to either
    # generate the material or admit it measured nothing.
    generate_material "$WORK"; MATERIAL_STATUS=$?

    if (( MATERIAL_STATUS == NO_MATERIAL )); then
        skip "inplace" "no key-material command and none found in the patch, so this would only repeat the clean gate"
    else
        if (( MATERIAL_STATUS != 0 )); then
            fail "inplace" "the key-material command failed, so the patch cannot be built at all"
        else
            WORK_LOG="$(mktemp -t lemma-work-build)"
            build_all "$WORK" "$WORK_LOG"; WORK_STATUS=$?
            if (( WORK_STATUS == 0 )); then
                pass "inplace: the build is green once key material exists"
            elif (( WORK_STATUS == BUILD_NOTHING )); then
                skip "inplace" "nothing recognisable to build in this system; pass --build-command to say how"
            else
                fail "inplace" "the build fails even with key material: $(grep -m2 '^FAILED:' "$WORK_LOG" | tr '\n' ' ')see $WORK_LOG"
            fi
        fi
    fi
else
    fail "inplace" "the patch could not be applied to a working tree"
fi

# ---------------------------------------------------------------- gate 3: smell
if [[ "$SKIP_SMELL" == 1 ]]; then
    skip "smell" "not measured"
elif [[ -z "$MRF" ]]; then
    skip "smell" "no --mrf given, so the system cannot be re-reconstructed"
else
    AFTER_MODELS="$(mktemp -d -t lemma-after-models)"
    # shellcheck disable=SC2086
    if (cd "$MRF" && uv run mrf -r -p $PLUGINS -t "$WORK") > /dev/null 2>&1 \
        && "$WORKSPACE/de.fhdo.lemma.reconstruction/tools/reconstruct.sh" \
            --target "$AFTER_MODELS" > /dev/null 2>&1; then
        AFTER_REPORT="$(mktemp -t lemma-after)"
        "$BUNDLE/tools/detect-smells.sh" "$AFTER_MODELS" --report "$AFTER_REPORT" \
            > /dev/null 2>&1
        AFTER="$(grep -m1 '^| Findings |' "$AFTER_REPORT" | tr -dc '0-9')"
        AFTER_CAUSE=0
        if [[ -n "${CAUSE:-}" ]]; then
            AFTER_CAUSE="$(grep -c -F "(\`$CAUSE\`)" "$AFTER_REPORT" 2>/dev/null || true)"
        fi
        if [[ -z "$AFTER" ]]; then
            fail "smell" "the finding count could not be read after patching"
        elif (( AFTER >= BEFORE )); then
            fail "smell" "findings did not fall: $BEFORE before, $AFTER after"
        elif [[ -n "${CAUSE:-}" ]] && (( AFTER_CAUSE > 0 )); then
            fail "smell" "findings fell from $BEFORE to $AFTER, but the addressed cause $CAUSE still has findings"
        elif [[ -n "${CAUSE:-}" ]]; then
            pass "smell: findings fell from $BEFORE to $AFTER, and the addressed cause $CAUSE has none left"
        else
            pass "smell: findings fell from $BEFORE to $AFTER"
        fi
    else
        fail "smell" "the system could not be re-reconstructed from the patched tree"
    fi
fi

# ---------------------------------------------------------------- gate 4: starts
#
# Coming up is not the same as working. A compose stack reports every container
# as up while a client inside it fails every connection attempt: that is what
# the Node consumer of Lakeside Mutual did when the broker's connector moved to
# TLS and its own configuration had not, and no gate saw it. So this gate waits
# for the stack to settle and then reads the logs for a peer that cannot be
# reached - and, because a sample system may log such errors unpatched as well,
# it compares against the base before blaming the patch.
SETTLE_SECONDS="${LEMMA_SETTLE_SECONDS:-25}"

# Errors that mean one service could not reach another. Chosen to be about the
# channel and nothing else: a failed health check is already the --wait gate's
# business, and an application error that has nothing to do with a peer must not
# fail this one.
CHANNEL_ERRORS="ECONNREFUSED|ECONNRESET|EPROTO|Connection refused\
|Connection error to|Connection reset|UnknownHostException|ConnectException\
|SSLHandshakeException|SSLException|certificate_unknown|handshake_failure\
|unable to find valid certification path|bad_certificate|tlsv1 alert"

# Bring a tree up, let it settle, and report what it says.
#
# Writes the log, sets CHANNEL_FAILURES to the distinct errors found after the
# settle period, and returns non-zero when the stack did not come up at all.
# Only what is logged *after* settling counts: a client that retries its way
# through a starting broker logs a refused connection and then works, and
# failing that would make this gate punish a healthy system for booting in an
# order nobody fixed.
compose_up_and_settle() {
    local tree="$1" log="$2" up=0

    # The same material the inplace gate needs. In the patched tree it has
    # usually been generated already and generating it again is harmless; in the
    # control it is what makes the comparison fair.
    generate_material "$tree"

    # --build matters: the compose file names published images as well as build
    # contexts, so without it a stale image would be started and the gate would
    # report on code the patch never touched.
    if (cd "$tree" && docker compose up -d --build --wait) > "$log" 2>&1; then
        up=1
        # No `timeout` on macOS, and nothing to wait for but time: the point is
        # to let whatever retries finish retrying.
        sleep "$SETTLE_SECONDS"
        (cd "$tree" && docker compose logs --since "${SETTLE_SECONDS}s") \
            > "$log.settled" 2>&1
        # One kind per line, in a file: several of these contain spaces, and a
        # space-separated variable cannot hold "unable to find valid
        # certification path" as one item.
        grep -oE "$CHANNEL_ERRORS" "$log.settled" | sort -u > "$log.errors"
        CHANNEL_FAILURES="$(tr '\n' '; ' < "$log.errors")"
    else
        # Which services are unhealthy is the whole value of this gate, so it
        # is captured before the stack is torn down.
        (cd "$tree" && docker compose ps -a) >> "$log" 2>&1
        (cd "$tree" && docker compose logs --tail 40) >> "$log" 2>&1
        : > "$log.errors"
        CHANNEL_FAILURES=""
    fi
    (cd "$tree" && docker compose down -v) >> "$log" 2>&1
    return $(( 1 - up ))
}

if [[ "$SKIP_START" == 1 ]]; then
    skip "starts" "asked to skip"
elif [[ ! -f "$WORK/docker-compose.yml" ]]; then
    skip "starts" "the system has no docker-compose.yml"
elif ! command -v docker > /dev/null 2>&1; then
    skip "starts" "docker is not available"
else
    START_LOG="$(mktemp -t lemma-start)"
    PATCHED_UP=1
    compose_up_and_settle "$WORK" "$START_LOG" || PATCHED_UP=0
    PATCHED_ERRORS="$CHANNEL_FAILURES"
    UNHEALTHY="$(grep -oE "(container|service) \"?[a-z0-9_-]+\"? is unhealthy" "$START_LOG" \
        | head -3 | tr '\n' ' ')"

    if [[ "$PATCHED_UP" == 1 && -z "$PATCHED_ERRORS" ]]; then
        DECLARED_LOSSES="none"
        pass "starts: the system comes up with the patch applied and no service reports an unreachable peer"
    else
        # This gate needs a baseline as much as the smell gate does. A sample
        # system whose base image has been withdrawn from the registry, or which
        # logs a refused connection of its own, does not come up clean patched
        # or unpatched - and blaming the patch for that is a false finding. The
        # control runs only on failure, because it costs a second full build.
        CONTROL="$(mktemp -d -t lemma-control)"; rm -rf "$CONTROL"
        CONTROL_LOG="$(mktemp -t lemma-control)"
        CONTROL_STARTS=1
        : > "$CONTROL_LOG.errors"
        if git -C "$SOURCE" worktree add --detach "$CONTROL" "$BASE" > /dev/null 2>&1; then
            compose_up_and_settle "$CONTROL" "$CONTROL_LOG" || CONTROL_STARTS=0
            git -C "$SOURCE" worktree remove --force "$CONTROL" > /dev/null 2>&1
        fi

        if [[ "$CONTROL_STARTS" == 0 ]]; then
            WHY="$(grep -oE "[^ ]+: not found|failed to solve: [^ ]+" "$CONTROL_LOG" \
                | head -1)"
            skip "starts" "the system does not come up unpatched either${WHY:+ ($WHY)}, so this gate cannot attribute anything to the patch; see $CONTROL_LOG"
        elif [[ "$PATCHED_UP" == 0 ]]; then
            fail "starts" "the system does not come up with the patch applied, though it does unpatched: ${UNHEALTHY:+$UNHEALTHY, }see $START_LOG"
        else
            # What is new is what can be attributed. A sample system logs errors
            # of its own - this one's Node consumer cannot reach the broker's
            # STOMP port in either tree - and a gate that gave up as soon as the
            # base logged anything would be silenced by that forever. So the
            # kinds of error are compared as sets, and only a kind the base does
            # not have is the patch's doing.
            comm -23 "$START_LOG.errors" "$CONTROL_LOG.errors" > "$START_LOG.new"
            if [[ ! -s "$START_LOG.new" ]]; then
                DECLARED_LOSSES="none"
                pass "starts: the system comes up with the patch applied, and reports no unreachable peer the unpatched system does not report too"
            else
                NEW_ERRORS="$(tr '\n' '; ' < "$START_LOG.new")"
                # Compose prefixes every line with the service it came from.
                NEW_SERVICES="$(grep -F -f "$START_LOG.new" "$START_LOG.settled" 2>/dev/null \
                    | sed -E 's/^([a-z0-9_-]+)[ ]*\|.*/\1/' | sort -u)"

                # A lost channel is not automatically a defect, and this gate
                # cannot decide which losses are acceptable: mutual TLS on a
                # service's actuator endpoints does stop an admin server that
                # holds no client certificate from scraping them, and all three
                # proposals of this work do exactly that. What the gate can
                # insist on is that the loss was declared. The prompt already
                # requires a proposal to write down what its patch gives up;
                # this is where that requirement is checked rather than trusted,
                # so an undeclared broken channel fails and a declared one is
                # reported and left to whoever reads the record.
                # Compared with the punctuation and the case removed from
                # both sides: the notes call it "Spring Boot Admin" and
                # "spring.boot.admin.client.url" where the compose file calls it
                # spring-boot-admin, and a literal search would have called
                # every one of those undeclared.
                NOTES="$(tr -cd '[:alnum:]' < "$WORK/REFACTORING-NOTES.md" 2>/dev/null \
                    | tr '[:upper:]' '[:lower:]')"
                UNDECLARED=""
                for service in $NEW_SERVICES; do
                    # The service's name as the compose file gives it: the log
                    # prefix is <service>-<replica>.
                    bare="${service%-[0-9]}"
                    key="$(printf '%s' "$bare" | tr -cd '[:alnum:]' \
                        | tr '[:upper:]' '[:lower:]')"
                    case "$NOTES" in
                        *"$key"*) ;;
                        *) UNDECLARED="$UNDECLARED $bare" ;;
                    esac
                done

                if [[ -n "${UNDECLARED// /}" ]]; then
                    DECLARED_LOSSES="$(printf '%s ' $NEW_SERVICES)(not declared:${UNDECLARED})"
                    fail "starts" "the system comes up, but${UNDECLARED} cannot reach a peer it reaches unpatched and REFACTORING-NOTES.md does not mention it: $NEW_ERRORS see $START_LOG.settled"
                else
                    DECLARED_LOSSES="$(printf '%s ' $NEW_SERVICES)(declared)"
                    pass "starts: the system comes up, and every peer it can no longer reach ($(printf '%s ' $NEW_SERVICES)) is declared in REFACTORING-NOTES.md"
                fi
            fi
        fi
    fi
fi

COVERAGE_LOST="$(coverage_lost "$PATCH")"

git -C "$SOURCE" worktree remove --force "$WORK" > /dev/null 2>&1
git -C "$SOURCE" worktree prune > /dev/null 2>&1

echo
echo "  declared losses: $DECLARED_LOSSES"
echo "  test coverage lost: $COVERAGE_LOST"

# ---------------------------------------------------------------- the verdict
echo
# Four words, and none of them is "verified". The gates measure what they
# measure: the build, this smell's findings for the addressed cause, and that
# the system comes up. A proposal can clear all four and still leave a
# deployment path inconsistent, break a component nobody reconstructed, or
# introduce a different smell of the catalogue - all three happened in this
# work.
#
#   REPAIR COMPLETE  every gate passed and no peer was lost
#   REPAIR PARTIAL   every gate passed, but a peer is gone and was declared
#   GATE FAILED      a gate failed
#   NOT MEASURED     a gate was skipped, which is not a gate that passed
#
# REPAIR PARTIAL exists because the declared-loss rule was swallowing a
# difference that matters. The rule stops gate 4 failing every correct patch,
# and that is right; but it also made a patch that breaks the monitoring
# scrape and says so read exactly like a patch that breaks nothing. Declaring
# a loss is what keeps it from being a failure. It is not what makes the
# repair complete, and the verdict now says which of the two happened.
VERDICT="REPAIR COMPLETE"
if (( ${#FAILED[@]} > 0 )); then
    VERDICT="GATE FAILED"
elif (( ${#SKIPPED[@]} > 0 )); then
    VERDICT="NOT MEASURED"
elif [[ "$DECLARED_LOSSES" != "none" && "$DECLARED_LOSSES" != "not measured" ]]; then
    # Every gate passed and a peer is gone. Declaring it is what keeps this from
    # being a failure; it is not what makes the repair complete.
    VERDICT="REPAIR PARTIAL"
fi
echo "$VERDICT — ${#PASSED[@]} passed, ${#FAILED[@]} failed, ${#SKIPPED[@]} skipped"

{
    echo
    echo "## Verification, $(date -u '+%Y-%m-%dT%H:%M:%SZ')"
    echo
    echo "**$VERDICT** — ${#PASSED[@]} passed, ${#FAILED[@]} failed, ${#SKIPPED[@]} skipped."
    echo
    echo "Extent of the patch: $EXTENT. Not a gate - no number of files is the"
    echo "right one - but the claim that model-level input bounds a refactoring"
    echo "is a claim about extent, so it is counted rather than recalled."
    echo
    echo "Declared losses: $DECLARED_LOSSES. A peer this patch can no longer"
    echo "reach, as the start gate measured it against the unpatched system."
    echo "Reported rather than folded into the verdict, because a patch that"
    echo "loses a monitoring scrape and declares it is not the same result as"
    echo "one that loses nothing, and both pass the four gates."
    echo
    echo "Test coverage lost: $COVERAGE_LOST. Read from REFACTORING-NOTES.md,"
    echo "not detected - a proposal that declares nothing reads \"none"
    echo "declared\", which is a statement about the notes."
    echo
    for entry in "${PASSED[@]:-}";  do [[ -n "$entry" ]] && echo "- PASS $entry"; done
    for entry in "${FAILED[@]:-}";  do [[ -n "$entry" ]] && echo "- FAIL $entry"; done
    for entry in "${SKIPPED[@]:-}"; do [[ -n "$entry" ]] && echo "- SKIP $entry"; done
    echo
    echo "A skipped gate is not a passed one: NOT MEASURED means the"
    echo "refactoring has not been shown to resolve the smell, only that"
    echo "nothing checked contradicts it. REPAIR PARTIAL means every gate"
    echo "passed and a peer is nevertheless gone, declared in the notes."
    echo "REPAIR COMPLETE means every gate passed and nothing was lost, which"
    echo "is still not the same as the application being secure: the gates"
    echo "cover this smell, this deployment and the declared scope only."
} >> "$PROPOSAL/verification.md"

(( ${#FAILED[@]} == 0 )) || exit 1
(( ${#SKIPPED[@]} == 0 )) || exit 3
[[ "$VERDICT" == "REPAIR PARTIAL" ]] && exit 4
exit 0
