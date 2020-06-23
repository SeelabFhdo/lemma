#!/usr/bin/env bash

# Send a notify message with notify-send if available
notify() {
    if hash notify-send 2>/dev/null; then
        notify-send "$1"
    fi
}

# Send a notify error message with notify-send if available
notify_error() {
    if hash notify-send 2>/dev/null; then
        notify-send -u critical "$1"
    fi
}

### MAIN SCRIPT

# Tell Maven to use the "eclipse-updatesite" profile defined in the LEMMA
# Eclipse Updatesite modules' POM files. The profile skips tests and sets the
# compiled Java class versions to 52 (Java 8) as currently expected by Eclipse.
export LEMMA_UPDATESITE_BUILD="true"

# We use LEMMA's Linux build script to first build all modules, which shall
# belong to LEMMA's Eclipse Updatesite, with the "eclipse-updatesite" profile
cd ..
bash ./lemma.sh updatesite/lemma-build-updatesite-modules.txt
rc=$?; if [[ $rc != 0 ]]; then exit $rc; fi

# Bundle all modules built with the "eclipse-updatesite" profile in the LEMMA
# Eclipse Updatesite
echo -e "\033[1;35m------------------------------------------------------------------------"
echo "Building Eclipse Update Site"
echo -e "------------------------------------------------------------------------\033[0m"
cd ..
mvn -f de.fhdo.lemma.eclipse.updatesite.parent/pom.xml clean install || {
    echo -e "\033[0;31mBuild of Update Site unsuccessful\033[0m"; \
        notify_error "LEMMA Build Process Error: Build of Update Site unsuccessful!"; \
        exit 1;
}
notify "LEMMA Build Process: Update Site successfully built"