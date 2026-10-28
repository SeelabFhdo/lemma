# Data model diagrams

Generates a class diagram from a LEMMA data model. Select one or more `.data`
files in the Project Explorer, **Generate PlantUML diagram** from the context
menu, and a `.puml` and an `.svg` land beside each of them. The first image is
opened, so the command ends in a diagram rather than in a file.

The PlantUML is kept beside the image rather than written to a temporary file:
it is the diffable source of the diagram, it renders in GitHub as it is, and it
is what a reader can correct by hand.

```
context CustomerManagement {                 ->   package "CustomerManagement" {
    structure CustomerDto {                           class "CustomerDto" {
        string customerId,                                customerId : string
        CustomerProfileDto customerProfile            }
    }                                              }
}                                                  "CustomerDto" --> "CustomerProfileDto" : customerProfile
```

## What it draws

| In the model | In the diagram |
|---|---|
| `structure` | a class, with its primitive fields as attributes |
| a field whose type is another structure | an association labelled with the field's name |
| `collection` | a class marked `<<collection>>`; a collection of a primitive shows `of <type>` |
| `enum` | an enum with its values |
| `<entity>`, `<valueObject>`, `<aggregate>`, … | UML stereotypes on the class |
| `<identifier>`, `<part>`, `<neverEmpty>` | UML stereotypes on the attribute |
| `unspecified` | shown as it is, so a gap a reconstruction left is visible |
| `version` | a package marked `<<version>>`, holding its contexts |
| an imported type | the alias and the type, as the model wrote them |

PlantUML text rather than a picture: it is diffable, it renders in GitHub, VS
Code and LaTeX, and generating it needs nothing installed.

## Rendering the image

Rendering needs PlantUML on the machine:

```sh
brew install plantuml graphviz
```

PlantUML is run as a command rather than linked as a library: the jar is some
twelve megabytes, third-party jars here are resolved by Maven rather than
committed, and a research repository is the wrong place for a binary that large.
It is looked for in `$PLANTUML`, then on the `PATH`, then in the usual Homebrew
and `/usr/local` locations - an Eclipse started from the Finder inherits a
minimal `PATH`, so the `PATH` alone would find nothing however well PlantUML is
installed.

Without it the `.puml` files are still written, and the dialog says what to
install. Graphviz is what lays a class diagram out; PlantUML reports its absence
and that report is passed on verbatim.

Output is SVG: it scales in a PDF and its text stays selectable, which is what a
diagram in a thesis needs.

## Why two classes of one name are drawn as two

PlantUML identifies a class by the name it is declared with, whatever package it
sits in. A model may declare the same type name in two contexts -
`examples/food-to-go/Restaurant/Restaurant.data` declares `RestaurantCreated` in
both `Events` and `API` - and those would be drawn as one box holding the fields
of both. Every class therefore carries an alias qualified with the versions and
contexts that hold it, and associations join aliases rather than names. The label
stays the simple name, so the diagram reads the same.

## Why a field of an imported type is an attribute

A reference becomes an association only when the class it points at is in the
same diagram. A type from another model is not, so it stays an attribute with
its name - an arrow to a box that is not drawn would point at nothing.

The name of such a type is read from the parse tree rather than from the linked
model. Linking a type across models needs the index that a running Xtext
provides, and it is not available to a plain resource set - so the diagram shows
what the model wrote, which is right either way.

## Structure

`DataModelDiagramGenerator` is a function of a data model and nothing else: no
file system, no workspace, no Eclipse. `PlantUmlRenderer` runs PlantUML.
`GenerateDataModelDiagramHandler` is the shell that finds the selected files,
loads them, writes the result and opens it. Everything that decides what a
diagram looks like is therefore checkable without an Eclipse, and was checked
against all 133 data models of this repository: 682 classes, 40 enums, 359
associations, every one rendered, none silently empty, no failures.

That sweep asserts a model which declares a type draws one. An earlier sweep only
watched for exceptions, which an empty diagram does not raise - and so reported
success for every versioned model while drawing nothing at all, because a model
declares `versions`, *or* `contexts`, *or* types and only the latter two were
read. A check that cannot fail proves nothing; this one fails on an empty diagram
and on two classes sharing an alias.

## Checking the dependencies this bundle declares

```sh
python3 ../de.fhdo.lemma.diagram.common/tools/check-bundle-requires.py .
```

Resolves every package the sources import against the `Export-Package` of the
bundles the manifest requires, following `visibility:=reexport` as Eclipse does,
and fails on one that nothing exports.

This is here because the headless build cannot catch a missing `Require-Bundle`
entry. It compiles against a flat classpath of every jar of the Eclipse
installation, which ignores OSGi boundaries, so a bundle can compile headlessly
and still fail to resolve inside Eclipse - which is how
`org.eclipse.core.runtime` came to be missing from this manifest. The check
takes any bundle directory, not just this one.
