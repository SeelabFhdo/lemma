# LEMMA Extension

This extension pack gives language support for all modeling languages of the [LEMMA ecosystem](https://github.com/SeelabFhdo/lemma), namely:
- Domain Data Modeling Language
- Service Modeling Language
- Operation Modeling Language
- Technology Modeling Language
- Technology Mapping Modeling Lanugage

It is based on a language server of those languages (embedded in the extensions of this extension pack) offering all language features (auto completion, syntax highlighting,...) that it's home IDE, Eclipse, offer.

## Features

Full language support according to the language features the implementation of the language servers offers, including:

- Diagnostic
- Syntax Highlighting
- Rename
- Auto completion
- Show syntax / semantic errors and warnings
- The Goto's (Goto Declaration, Goto Definition, Goto Type Definition, ...)
- ...

## Requirements

- Java installed with version >= 11.
- Your Visual studio code installation.

## Extension Pack Settings

This extension pack offers settings about what host and port the embedded language servers should listen to:

* `modelingLanguage.languageServerHost`: The host the language server should listen to.
* `modelingLanguage.languageServerPort`: The port the language server should listen to.

These settings are also available at the VSCode Settings (Settings > Extensions > LEMMA ... Modeling Language).

## Known Issues

If you find any issue for this extension or LEMMA itself, feel free to ask the [LEMMA contributors](https://github.com/SeelabFhdo/lemma#contributors).

## Release Notes

The releases of this extension pack follow the releases of LEMMA according to it's [GitHub Page](https://github.com/SeelabFhdo/lemma/releases).