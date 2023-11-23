# Guideline for the VSCode Extensions for the LEMMA DSLs

This dir contains all VSCode extensions offering language support for the LEMMA DSLs by using the (Language Server Protocol (LSP))[https://microsoft.github.io/language-server-protocol/]. The extensions contain a Fat JAR of the language server with the language features of each DSL as well as a VSCode implementation of a language client to access the language features and offer them to the user in VSCode. The Fat JARs with the language servers are created when building the .ide subprojects of each DSL Xtext project and will be done automatically with each LEMMA build.

## Available VSCode extensions

So far, this dir contains the following extensions:

- Extension for the Domain Data Modeling Language
- Extension for the Service Modeling Language
- Extension for the Operation Modeling Language
- Extension for the Technology Modeling Language
- Extension for the Technology Mapping Modeling Language
- Extension pack containing all extensions mentioned above

## Extension structure

Each extension (except the extension pack) has the following project structure:

- out -> Compiler output of the TypeScript files
- src -> Source files for the language client and language server
    - de.fhdo.lemma. ... .jar -> The Fat JAR containing the language server for the DSL with it's language definitions
- syntaxes -> TextMate grammars to support the syntax highlighting feature
    - ... .tmLanguage.json -> JSON file with the TextMate grammar containing all grammar rules for the correct syntax highlighting
- themes -> Contains the color rules for correct colored syntax highlighting
    - ... color-theme.json -> JSON from VSCode to describe the color and text style of each text area identified by the TextMate grammar rules. Color style bases on the VSCode dark theme and the color definitions for the LEMMA DSLs in the Eclipse Dark Theme.
- language-configuration.json -> Set of terminal symbols to define closing pairs, brackets and comments
- LICENSE -> The MIT license
- package-lock.json -> The downloaded keys and descriptions of the extension dependencies defined in package.json
- package.json -> General info about this extension, e.g. the publisher, repo, files to offer the language support to, themes, TextMate grammars, configs and dependencies.
- README.md -> README of the extension as seen on the VSCode Marketplace
- SEELAB\_Logo.jpg -> The SEELAB logo as seen on the VSCode Marketplace
- tsconfig.json -> JSON for defining compiler options

## Installation

If the extension(s) shall be used only, simply search the extension marketplace of VSCode for "LEMMA" and install the extension(s) needed.

For developing and modifying, simply: 
- Copy the extension dir(s) to your ```.vscode/extensions``` dir located in your user home dir
- Open your terminal and execute ```npm install``` in the dir(s)
- Compile the extension(s) by executing the ```compile``` script with ```npm compile``` or clicking on the "Debug" button above the ```scripts``` section in the package.json file inside VSCode and selecting ```compile```

## Support

If there are any issues or you have questions, feel free to ask the developer of the extensions, (Marcel Mitas)[mailto:marcel.mitas@fh-dortmund.de], or the great LEMMA contributors.
