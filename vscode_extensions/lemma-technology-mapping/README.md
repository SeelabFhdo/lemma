# LEMMA Technology Mapping Modeling Language Extension

This extension gives language support for the Technology Mapping Modeling Language of the [LEMMA ecosystem](https://github.com/SeelabFhdo/lemma). It is based on a language server of this language (embedded in this extension) offering all language features (auto completion, syntax highlighting,...) that it's home IDE, Eclipse, offer.

## Features

Full language support according to the language features the implementation of the language server offers, including:

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

## Extension Settings

This extension offers settings about what host and port the embedded language server should listen to:

* `technologyMapping.languageServerHost`: The host the language server should listen to.
* `technologyMapping.languageServerPort`: The port the language server should listen to.

These settings are also available at the VSCode Settings (Settings > Extensions > LEMMA Technology Mapping Modeling Language).

## Known Issues

If you find any issue for this extension or LEMMA itself, feel free to ask the [LEMMA contributors](https://github.com/SeelabFhdo/lemma#contributors).

## Release Notes

The releases of this extension follow the releases of LEMMA according to it's [GitHub Page](https://github.com/SeelabFhdo/lemma/releases).