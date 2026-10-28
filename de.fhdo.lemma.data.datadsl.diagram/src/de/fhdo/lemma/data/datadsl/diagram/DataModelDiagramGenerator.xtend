package de.fhdo.lemma.data.datadsl.diagram

import de.fhdo.lemma.data.CollectionType
import de.fhdo.lemma.data.ComplexType
import de.fhdo.lemma.data.ComplexTypeFeature
import de.fhdo.lemma.data.Context
import de.fhdo.lemma.data.DataField
import de.fhdo.lemma.data.DataFieldFeature
import de.fhdo.lemma.data.DataModel
import de.fhdo.lemma.data.DataStructure
import de.fhdo.lemma.data.Enumeration
import de.fhdo.lemma.data.Version
import java.util.LinkedHashSet
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.nodemodel.util.NodeModelUtils

/**
 * Generator of a PlantUML class diagram from a LEMMA data model.
 *
 * A data model describes structures, the fields they hold and the types of those
 * fields, which is a class diagram: a structure is a class, a field of a
 * primitive type is an attribute, and a field whose type is another structure is
 * an association to it. The domain-driven-design features a structure and a
 * field carry - entity, value object, identifier - are what a class diagram
 * calls stereotypes.
 *
 * PlantUML text rather than a picture, so the result is diffable, renders
 * wherever the model is read, and needs nothing installed to generate.
 *
 * The generator is a function of the model and nothing else: no file system, no
 * workspace, no Eclipse. What invokes it is a separate concern, so what it
 * produces can be checked without any of them.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class DataModelDiagramGenerator {
    /**
     * The name a structure's feature is given as a stereotype. Every feature the
     * Data DSL offers, so a model that uses one is never drawn without it.
     */
    static val STRUCTURE_STEREOTYPES = #{
        ComplexTypeFeature.AGGREGATE -> "aggregate",
        ComplexTypeFeature.APPLICATION_SERVICE -> "application service",
        ComplexTypeFeature.DOMAIN_EVENT -> "domain event",
        ComplexTypeFeature.DOMAIN_SERVICE -> "domain service",
        ComplexTypeFeature.ENTITY -> "entity",
        ComplexTypeFeature.FACTORY -> "factory",
        ComplexTypeFeature.INFRASTRUCTURE_SERVICE -> "infrastructure service",
        ComplexTypeFeature.REPOSITORY -> "repository",
        ComplexTypeFeature.SERVICE -> "service",
        ComplexTypeFeature.SPECIFICATION -> "specification",
        ComplexTypeFeature.VALUE_OBJECT -> "value object"
    }

    /**
     * The name a field's feature is given as a stereotype.
     */
    static val FIELD_STEREOTYPES = #{
        DataFieldFeature.IDENTIFIER -> "identifier",
        DataFieldFeature.NEVER_EMPTY -> "never empty",
        DataFieldFeature.PART -> "part"
    }

    static val UNSPECIFIED = "unspecified"

    /**
     * Shown where a model names an imported type that could not be read.
     *
     * Distinct from "unspecified", which is a type the model itself leaves
     * open: this one says the model named a type and the diagram could not
     * follow it.
     */
    static val UNRESOLVED = "<unresolved>"

    /**
     * Generate the diagram of a data model.
     *
     * One diagram per model rather than per context: a model holds its contexts
     * together and a reader wants to see them together, each as a package. A
     * model may also declare types outside any context, which are drawn beside
     * the packages.
     *
     * A model declares versions, or contexts, or types - the grammar offers the
     * three alternatively - and a version in turn holds contexts or types. All
     * three are drawn, because a model that uses versions is otherwise drawn
     * empty.
     *
     * @param model the data model to diagram
     * @return the PlantUML source of the diagram
     */
    def String generate(DataModel model) {
        val associations = <String>newLinkedList

        val versions = '''
            «FOR version : model.versions»
                «generateVersion(version, associations)»
            «ENDFOR»
        '''
        val contexts = '''
            «FOR context : model.contexts»
                «generateContext(context, associations)»
            «ENDFOR»
        '''
        val loose = '''
            «FOR type : model.complexTypes»
                «generateType(type, associations)»
            «ENDFOR»
        '''

        return '''
            @startuml
            ' Generated from a LEMMA data model. Do not edit; regenerate.
            hide empty members
            hide circle
            skinparam shadowing false
            skinparam classAttributeIconSize 0

            «versions»«contexts»«loose»
            «FOR association : associations.filter[!empty].toSet.sort»
                «association»
            «ENDFOR»
            @enduml
        '''.toString
    }

    /**
     * Generate a version as a package of what it holds.
     *
     * Marked as a version, because a package is otherwise a context and a
     * reader could not tell which of the two a box is.
     */
    private def generateVersion(Version version, List<String> associations) {
        '''
        package «quote(version.name)» <<version>> {
            «FOR context : version.contexts»
                «generateContext(context, associations)»
            «ENDFOR»
            «FOR type : version.complexTypes»
                «generateType(type, associations)»
            «ENDFOR»
        }
        '''
    }

    /**
     * Generate a context as a package of the types it holds.
     */
    private def generateContext(Context context, List<String> associations) {
        '''
        package «quote(context.name)» {
            «FOR type : context.complexTypes»
                «generateType(type, associations)»
            «ENDFOR»
        }
        '''
    }

    /**
     * Generate one complex type, and collect the associations it holds.
     */
    private def generateType(ComplexType type, List<String> associations) {
        switch (type) {
            DataStructure: generateStructure(type, associations)
            CollectionType: generateCollection(type, associations)
            Enumeration: generateEnumeration(type)
            default: ""
        }
    }

    /**
     * Generate a structure as a class, with its primitive fields as attributes.
     *
     * A field whose type is another structure becomes an association instead,
     * because that is what makes the result a diagram rather than the model
     * written out again.
     */
    private def generateStructure(DataStructure structure, List<String> associations) {
        structure.dataFields.filter[!attribute].forEach[
            associations.add(association(structure, it))
        ]

        '''
        class «quote(structure.name)» as «aliasOf(structure)»«structureStereotypes(structure)» {
            «FOR field : structure.dataFields.filter[attribute]»
                «fieldLine(field)»
            «ENDFOR»
        }
        '''
    }

    /**
     * Generate a collection as a class of its own, marked as one.
     *
     * A collection is a type in LEMMA rather than a multiplicity of a field, so
     * it is drawn as a type. Its entry is an association when it holds a
     * structure and an attribute when it holds a primitive - including the
     * ``unspecified`` that a reconstruction leaves where it could not resolve
     * the entry, which the diagram then shows as the gap it is.
     */
    private def generateCollection(CollectionType collection, List<String> associations) {
        collection.dataFields.filter[!attribute].forEach[
            associations.add(association(collection, it))
        ]

        // A collection of a primitive holds that type instead of fields - the
        // grammar offers either - so its entry is shown rather than dropped.
        // "of x" rather than a field name, because the model names none.
        val entry = collection.primitiveType

        '''
        class «quote(collection.name)» as «aliasOf(collection)» <<collection>> {
            «IF entry !== null»
                of «entry.typeName»
            «ENDIF»
            «FOR field : collection.dataFields.filter[attribute]»
                «fieldLine(field)»
            «ENDFOR»
        }
        '''
    }

    /**
     * Generate an enumeration with its values.
     */
    private def generateEnumeration(Enumeration enumeration) {
        '''
        enum «quote(enumeration.name)» as «aliasOf(enumeration)» {
            «FOR field : enumeration.fields»
                «field.name»
            «ENDFOR»
        }
        '''
    }

    /**
     * One attribute line: its name, its type, and the stereotypes it carries.
     */
    private def fieldLine(DataField field) {
        '''«field.name» : «typeName(field)»«fieldStereotypes(field)»'''
    }

    /**
     * One association, labelled with the name of the field that holds it.
     *
     * Drawn between the aliases rather than the names: PlantUML identifies a
     * class by the name it is declared with, so an association by name would
     * attach to whichever class of that name it met first.
     */
    private def String association(ComplexType source, DataField field) {
        val target = field.complexType
        if (target === null) {
            return ""
        }
        return '''«aliasOf(source)» --> «aliasOf(target)» : «field.name»'''.toString
    }

    /**
     * The name a type is referred to by inside the diagram.
     *
     * Its own name qualified with the versions and contexts that hold it. Two
     * contexts of a model may declare a type of the same name - and in
     * ``examples/food-to-go`` two of them do - which PlantUML would otherwise
     * draw as one class holding the fields of both.
     */
    private def String aliasOf(ComplexType type) {
        val parts = <String>newLinkedList
        parts.add(type.name)

        var EObject container = type.eContainer
        while (container !== null) {
            switch (container) {
                Context: parts.addFirst(container.name)
                Version: parts.addFirst(container.name)
            }
            container = container.eContainer
        }
        // An alias is an identifier, so what a LEMMA name may hold and an
        // alias may not - a caret, a dot - becomes an underscore.
        return parts.join("_").replaceAll("[^A-Za-z0-9_]", "_")
    }

    /**
     * Whether a field is drawn inside the class rather than as an association.
     *
     * A field of a primitive type is. So is one whose type is imported from
     * another model, and one whose type could not be resolved: an association to
     * a class the diagram does not contain would point at nothing, and the
     * attribute keeps the type visible instead.
     */
    private def boolean isAttribute(DataField field) {
        return field.complexType === null
    }

    /**
     * The name a field's type is written as.
     *
     * An imported type keeps its alias, so a reader can tell a type of another
     * model from one of this one.
     */
    private def String typeName(DataField field) {
        val primitiveType = field.primitiveType
        if (primitiveType !== null) {
            return primitiveType.typeName
        }

        val imported = field.importedComplexType
        if (imported !== null) {
            val alias = imported.^import?.name
            val importedType = imported.importedType
            val name = if (importedType instanceof ComplexType) importedType.name else null

            if (name.nullOrEmpty) {
                // The reference is a proxy: linking a type across models needs
                // an index that only a running Xtext provides. The parse tree
                // still holds what the model wrote, so that is shown - the
                // diagram says what the model says, resolved or not.
                return written(imported) ?: UNRESOLVED
            }
            return if (alias.nullOrEmpty) name else '''«alias»::«name»'''.toString
        }

        val complexType = field.complexType
        if (complexType !== null) {
            return complexType.name
        }
        return UNSPECIFIED
    }

    /**
     * The stereotypes of a structure, or nothing.
     */
    private def String structureStereotypes(ComplexType type) {
        val names = new LinkedHashSet<String>
        type.features.forEach[
            val name = STRUCTURE_STEREOTYPES.get(it)
            if (name !== null) {
                names.add(name)
            }
        ]
        return render(names)
    }

    /**
     * The stereotypes of a field, or nothing.
     */
    private def String fieldStereotypes(DataField field) {
        val names = new LinkedHashSet<String>
        field.features.forEach[
            val name = FIELD_STEREOTYPES.get(it)
            if (name !== null) {
                names.add(name)
            }
        ]
        return render(names)
    }

    private def String render(LinkedHashSet<String> names) {
        if (names.empty) {
            return ""
        }
        return ''' <<«names.join(", ")»>>'''.toString
    }

    /**
     * What the model wrote for an element, read from the parse tree.
     *
     * Used where a cross-model reference could not be linked. The node model is
     * the parse tree of the file, so this is the model's own text rather than a
     * guess at it.
     */
    private def String written(EObject element) {
        val node = NodeModelUtils.findActualNodeFor(element)
        if (node === null) {
            return null
        }
        val text = NodeModelUtils.getTokenText(node)?.trim
        return if (text.nullOrEmpty) null else text
    }

    /**
     * Quote a name: a LEMMA identifier may be masked with a caret, which
     * PlantUML would otherwise read as its own syntax.
     */
    private def String quote(String name) {
        return '''"«name»"'''.toString
    }
}
