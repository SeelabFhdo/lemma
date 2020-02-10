.. sectnum::

.. _Introduction:

Introduction
============

This document describes the Intermediate Data Model format of the 
`Language Ecosystem for Modeling Microservice Archictecture`_. The project aims 
to facilitate the development of *microservice-based software systems* 
:cite:`Newman2015` by employing Model-driven Development (MDD) 
:cite:`Combemale2017`.

In this context, a microservice architecture consists of several different types
of models, listed in :numref:`tab__model_types`.

.. _tab__model_types:

.. table:: Model types

    =================   ========================================================
    **Model Type**      **Description**
    -----------------   --------------------------------------------------------
    Domain Data Model   A Domain Data Model describes the domain-specific data 
                        used by a modeled microservice to specify its 
                        input/output data.
    Mapping Model       A Mapping Model allows for assigning (alternative) 
                        technologies to, e.g., modeled microservices in a
                        Service Model and complex types in a Data Model.
    Service Model       A Service Model contains several microservice models, 
                        their interfaces, and operations. The contents of 
                        imported Domain Data Models, e.g., data structures, may 
                        be used to type operations' parameters. See also the 
                        :doc:`Intermediate Service Model Format Specification 
                        <service_model:index>`.
    Operation Model     An Operation Model expresses the deployment of 
                        microservices being imported from Service Models.
    Technology Model    A Technology models encapsulates descriptions of 
                        technologies. For instance, certain implementation 
                        technologies, e.g., Java or Go, and protocol 
                        technologies, e.g., REST or AMQP, may be contained in a
                        Technology Model. Moreover, service or operation 
                        *aspects* :cite:`Kiczales1997` may be defined, which 
                        enable to reify technology specifications in Mapping, 
                        Operation, or Service Models.
    =================   ========================================================

.. _ModelProcessing:

Model Processing
================
The creation of the models happens within a bundle of Eclipse [#eclipse]_ 
plugins that are based on Xcore [#xcore]_ and Xtext [#xtext]_. These 
technologies build upon the Ecore metamodeling standard :cite:`Steinberg2011`
and the Eclipse Modeling Framework (EMF) [#emf]_.

However, to detach the processing of the models from the Eclipse ecosystem and 
allow microservice teams for creating custom model processors like validators 
and *code generators* :cite:`Combemale2017` that do not need to depend on EMF, 
the models are exported [#model-export]_ from Eclipse to the technology-agnostic
XML Metadata Interchange (XMI) format [#xmi]_.

XMI is based on XML and encodes a model instance, whose *metamodel*
:cite:`Combemale2017` is based on the Meta Object Facility (MOF) [#mof]_ which
is generally the case for Ecore metamodels and derived model instances.

Format Specification
====================
This document describes the metamodel and thus the structure of XMI files of
Intermediate Data Models, i.e., instances of Domain Data Models that were
exported from Eclipse (cf. :ref:`Introduction` and :ref:`ModelProcessing`). It 
may be used as reference, when implementing custom model processors for 
microservice-related Domain Data Models.

:numref:`fig_metamodel` shows the structure of the metamodel of the Intermediate
Data Models in an object-oriented way in the form of a UML class diagram. The
modeling concepts, their properties, and relationships are depicted as classes, 
attributes, and associations, respectively.

.. _fig_metamodel:

.. figure:: figures/metamodel.png
    :target: _images/metamodel.png

    Metamodel of Intermediate Data Models

In the following, the document contains a reference of each modeling concept of 
the metamodel depicted in :numref:`fig_metamodel`.

.. HINT::

    Attributes that may contain more than one value but exhibit a ``*`` 
    multiplicity, i.e., they may contain an arbitrary number of values or even
    none at all (``*`` is shorthand UML notation for ``0..*``), are never null.

    In case no multiplicity is stated after the object type of an attribute, the
    attribute may be null. For example, an attribute defined as ``String name``
    implicitly has a multiplicity ``0..1`` and in the zero-case the String may
    be null.

    However, in case the attribute's type is a built-in primitive Java type, 
    e.g. ``int``, the attribute will never be null but exhibits the type's 
    default value in case it did not receive an explicit value.

Model Root
----------

.. _link__IntermediateDataModel:

.. java:type:: class IntermediateDataModel

    Root of the Intermediate Data Model instance.

    .. py:attribute:: String[1] sourceModelUri

        `\"file\"` URI pointing to the source Data Model file from which this
        model was derived.

    .. py:attribute:: IntermediateImport[*] imports

        References to Intermediate Data Model instances that were 
        imported into the source Domain Data Model 
        (cf. :py:class:`IntermediateImport`).

    .. py:attribute:: IntermediateVersion[*] versions

        Versions being defined in the source Domain Data Model (cf. 
        :py:class:`IntermediateVersion`).    

    .. py:attribute:: IntermediateContext[*] contexts

        Contexts being defined in the source Domain Data Model (cf. 
        :py:class:`IntermediateContext`). If a Domain Data Model has 
        ``versions``, it may not have ``contexts`` under the model root. They
        are, instead, encapsulated within the ``versions`` attribute.

    .. py:attribute:: IntermediateComplexType[*] complexTypes

        :ref:`IntermediateDataStructure <link__IntermediateDataStructure>`,
        :ref:`IntermediateListType <link__IntermediateListType>`, and
        :ref:`IntermediateEnumeration <link__IntermediateEnumeration>`
        instances being defined in the source Domain Data Model. If a Domain 
        Data Model has ``versions`` or ``contexts``, it may not have 
        ``complexTypes`` under the model root. They are, instead, encapsulated 
        within the ``versions`` or ``contexts`` attributes.

    .. NOTE::

        At least one of the attributes ``versions``, ``contexts``, and
        ``compexTypes`` will have values, because empty Domain Data Models are 
        not allowed.

Imports
-------

Instances of the different model types (cf. :numref:`tab__model_types`) may 
refer to each other. For instance, a Service Model may refer to domain-specific
types being defined in a Domain Data Model. This *interlinkage* of the different
model types is realized on the basis of an import mechanism. That is, a Service 
Model may import a Domain Data Model to enable the modeler to refer to the 
modeled data types. However, certain model types also allow for importing 
instances of the same type. A Domain Data Model, for example, may import other 
Domain Data Models to use their 
:ref:`data structures <link__IntermediateDataStructure>` as types within its own
structures.

.. _link__IntermediateImport:

.. java:type:: class IntermediateImport

    Concept to represent the import of a Domain Data Model into the source 
    Domain Data Model.

    .. py:attribute:: String[1] name

        Unique alias name of the import.

    .. py:attribute:: String[1] importUri

        Unique `"file"` URI that points to the location of the imported Data 
        Model, which itself is an Intermediate Data Model instance.

    .. _link__IntermediateImport_importTypeName:

    .. py:attribute:: String[1] importTypeName

        Name of the import type. In the context of Domain Data Models, the value
        of this attribute is always \"DATATYPES\".

    .. py:attribute:: IntermediateDataModel[1] dataModel

        Link to the containing :py:class:`IntermediateDataModel` instance.

    .. py:method:: String[1] getImportTypeNameForDatatypes()

        Helper that returns the name of the import type for data types. This
        method will always return the value \"DATATYPES\". This corresponds to 
        the possible value of the 
        :ref:`importTypeName <link__IntermediateImport_importTypeName>`
        attribute.

Namespace Concepts
------------------

Namespace concepts allow for organizing a Domain Data Model. Conceptually, they 
correspond to Java's package mechanism.

.. _link__IntermediateVersion:

.. java:type:: class IntermediateVersion

    A namespace concept to organize evolved contents of a Domain Data Model in 
    different versions.

    .. py:attribute:: String[1] name

        Unique name of the version.

    .. py:attribute:: IntermediateComplexType [*] complexTypes

        Complex types defined directly within the version.

    .. py:attribute:: IntermediateContext[*] contexts

        Contexts encapsulated by the version. 

    .. NOTE::

        Either the ``complexTypes`` or the ``contexts`` attribute will contain 
        values, but neither both of the same :py:class:`IntermediateVersion` 
        instance.

    .. py:attribute:: IntermediateDataModel[1] dataModel

        Link to the containing :py:class:`IntermediateDataModel` instance.

.. _link__IntermediateContext:

.. java:type:: class IntermediateContext

    A namespace concept to organize domain-specific types of a Domain Data Model
    in semantic domains that may correspond to Bounded Contexts 
    :cite:`Evans2004`.
    
    .. NOTE::
        
        Contexts may not be nested.

    .. _link__IntermediateContext_name:

    .. py:attribute:: String[1] name

        Name of the context. Is unique within the 
        :py:class:`IntermediateDataModel` or :py:class:`IntermediateVersion` 
        instance that contains the context.

    .. py:attribute:: String[1] qualifiedName

        Qualified name of the context. The qualified name of the context
        consists of the name of the :ref:`version <link__IntermediateVersion>` 
        if any and the name of the context separated by a dot. In case the 
        context is not part of a :ref:`version <link__IntermediateVersion>`, the
        qualifiedName equals the context's 
        :ref:`name <link__IntermediateContext_name>`.

    .. HINT::

        The :py:class:`IntermedateVersion` class does not comprise a 
        ``qualifiedName`` attribute, because versions may not be contained
        within an instance of another model concept's class except for the
        nameless :ref:`model root <link__IntermediateDataModel>`.

    .. py:attribute:: IntermediateComplexType[1..*] complexTypes

        :ref:`Complex types <link__IntermediateComplexType>` being defined 
        within the context.

    .. py:attribute:: IntermediateDataModel dataModel

        Link to the containing :py:class:`IntermediateDataModel` instance.

    .. py:attribute:: IntermediateVersion version

        Link to the containing :py:class:`IntermediateVersion` instance.

    .. NOTE::

        Only one of the attributes ``dataModel`` or ``version`` has a value,
        depending on whether the context is defined directly under the
        :ref:`model root <link__IntermediateDataModel>` or within a
        :ref:`version <link__IntermediateVersion>`.

.. _link__built_in_type_system:

Built-in Type System
--------------------

This subsection describes concepts that are part of the built-in type system of
the Domain Data Model. Basically, it is aligned to Java and contains all 
built-in Java primitive types as well as native ``Date``, ``String``, and
``unspecified`` types.

Besides the ``unspecified`` type, the type conversions observe Java's *widening*
*primitive conversions* [#java-type-conversions]_ for primitively typed 
:ref:`fields <link__IntermediateDataField>`. The ``unspecified`` type, however,
is not compatible with any other type. More precisely, two distinct fields with
the ``unspecified`` type are not considered to be compatible. That is, the 
``unspecified`` type communicates the intended current absence of a type, e.g.,
to specify that a typing decision has not been taken, yet.

Two :ref:`data structures <link__IntermediateDataStructure>` are compatible, if
their fields are compatible, independent of their type ordering. Two distinct
:ref:`enumerations <link__IntermediateEnumeration>` are compatible, if the 
value-receiving enumeration comprises all initialization values of the
value-providing enumeration.

.. _link__IntermediateTypeKind:

.. cpp:enum:: IntermediateTypeKind

    Enumeration to specify the kind of an :py:class:`IntermediateType` instance
    being referenced in some place.

    .. cpp:enumerator:: ENUMERATION

        Referenced type is an 
        :ref:`IntermediateEnumeration <link__IntermediateEnumeration>`.

    .. cpp:enumerator:: LIST

        Referenced type is an 
        :ref:`IntermediateListType <link__IntermediateListType>`.

    .. cpp:enumerator:: PRIMITIVE
    
        Referenced type is an 
        :ref:`IntermediatePrimitiveType <link__IntermediatePrimitiveType>`.

    .. cpp:enumerator:: STRUCTURE
    
        Referenced type is an 
        :ref:`IntermediateDataStructure <link__IntermediateDataStructure>`.

.. _link__IntermediateTypeOrigin:

.. cpp:enum:: IntermediateTypeOrigin

    Enumeration to specify the origin of an :py:class:`IntermediateType` 
    instance being referenced in some place.

    .. cpp:enumerator:: DATA_MODEL

        Type is an 
        :ref:`IntermediateComplexType <link__IntermediateComplexType>` defined 
        in a Domain Data Model.

    .. cpp:enumerator:: BUILTIN

        Type is a built-in type.

    .. cpp:enumerator:: TECHNOLOGY

        Type is technology-specific. Technology-specific types may be used to
        map built-in primitive types to technology-specific types, e.g., 
        ``float`` to ``float32`` in the Go programming language [#golang]_. They
        are particularly useful to even allow for mapping the built-in 
        ``unspecified`` primitive type to a corresponding programming language
        type like ``Object`` in Java. Moreover, they may be used to declare
        technology-specific structure or list types. Code generators need to be
        able to interpret technology-specific types that were defined in a
        Technology Model (cf. :numref:`tab__model_types`).

    .. HINT::

        Currently, the following combinations of 
        :cpp:enum:`IntermediateTypeKind` and :cpp:enum:`IntermediateTypeOrigin`
        values are possible:

        ===========   ======================
        **Kind**      **Origin**
        -----------   ----------------------
        ENUMERATION   DATA_MODEL
        LIST          DATA_MODEL, TECHNOLOGY
        PRIMITIVE     BUILTIN, TECHNOLOGY
        STRUCTURE     DATA_MODEL, TECHNOLOGY
        ===========   ======================

.. _link__IntermediateType:

.. java:type:: abstract class IntermediateType

    Abstract super class for all types.

    .. py:attribute:: String[1] name

        Name of the unique. Unique within the respective context.

    .. py:attribute:: IntermediateTypeOrigin[1] origin

        :ref:`Origin <link__IntermediateTypeOrigin>` of the type.

    .. py:attribute:: IntermediateTypeKind[1] kind

        :ref:`Kind <link__IntermediateTypeKind>` of the type.

    .. py:attribute:: IntermediateDataField[1] dataField

        :ref:`Data field <link__IntermediateDataField>` that is typed by this
        type's instance.

.. _link__IntermediatePrimitiveType:

.. java:type:: class IntermediatePrimitiveType extends IntermediateType

    Representation of a primitive type being used within the Domain Data Model.

    .. py:attribute:: Integer size

        Size of the primitive type in bits. The built-in primitive types have
        the following sizes:

        ===========     ======================================
        **Type**        **Size (in bits)**
        -----------     --------------------------------------
        boolean         1
        byte            8
        char            16
        date            null (object type)
        double          64
        float           32
        int             32
        long            64
        short           16
        string          null (object type)
        unspecified     null (no precise type given by intent)
        ===========     ======================================

    .. py:attribute:: IntermediateDataField initializedDataField

        Link to the 
        :ref:`IntermediateDataField <link__IntermediateDataField>` whose
        initialization value is compatible with this primitive type.

    .. py:attribute:: IntermediateEnumerationField initializedEnumerationField

        Link to the 
        :ref:`IntermediateEnumerationField <link__IntermediateEnumerationField>`
        whose initialization value is compatible with this primitive type.
        
.. _link__custom_types:

Custom, domain-specific Types
-----------------------------

.. _link__IntermediateComplexType:

.. java:type:: class IntermediateComplexType extends IntermediateType

    Super class of complex types like 
    :ref:`IntermediateDataStructure <link__IntermediateDataStructure>`,
    :ref:`IntermediateListType <link__IntermediateListType>`, and
    :ref:`IntermediateEnumeration <link__IntermediateEnumeration>`.

    .. py:attribute:: String[1] qualifiedName

        Qualified name of the type. This corresponds to the name of the type
        prefixed by its :ref:`version <link__IntermediateVersion>` if any and
        its :ref:`context <link__IntermediateContext>` if any. The qualifying
        fragments are separated by dots.

    .. py:attribute:: IntermediateDataModel dataModel

        Link to the containing :py:class:`IntermediateDataModel` instance.

    .. py:attribute:: IntermediateVersion version

        Link to the containing :py:class:`IntermediateVersion` instance.

    .. py:attribute:: IntermediateContext context

        Link to the containing :py:class:`IntermediateContext` instance.

    .. NOTE::

        Only one of the attributes ``dataModel``, ``version``, or ``context``
        has a value, depending on whether the type is defined directly under the
        :ref:`model root <link__IntermediateDataModel>`, or within a
        :ref:`version <link__IntermediateVersion>` or
        :ref:`context <link__IntermediateContext>`.

.. java:type:: class IntermediateImportedComplexType extends \
    IntermediateComplexType

    This class represents an 
    :ref:`IntermediateComplexType <link__IntermediateComplexType>` that has been
    imported from another Domain Data Model.

    .. py:attribute:: IntermediateImport[1] import

        The :ref:`import <link__IntermediateImport>` from which the complex
        type originates.

.. _link__IntermediateDataStructure:

.. java:type:: class IntermediateDataStructure extends IntermediateComplexType

    A domain-specific data structure that usually comprises a variety of typed
    data fields.

    .. _link__IntermediateDataStructure_featureNames:

    .. py:attribute:: String[*] featureNames

        This attribute contains the names of all features specified for the data
        structure. The following values are possible:

        ======================   ===============================================
        **Feature Name**         **Description**
        ----------------------   -----------------------------------------------
               AGGREGATE         Data structure is an Aggregate in the sense of
                                 Domain-driven Design (DDD) :cite:`Evans2004`.
        ----------------------   -----------------------------------------------
          APPLICATION_SERVICE    Data structure is a Service with application
                                 focus in the sense of DDD.
        ----------------------   -----------------------------------------------
             DOMAIN_EVENT        Data structure is a Domain Event 
                                 [#enterprise-patterns-event-message]_.
        ----------------------   -----------------------------------------------
            DOMAIN_SERVICE       Data structure is a Service with domain focus
                                 in the sense of DDD.
        ----------------------   -----------------------------------------------
                ENTITY           Data structure is an Entity in the sense of 
                                 DDD.
        ----------------------   -----------------------------------------------
                FACTORY          Data structure is a Factory in the sense of
                                 DDD.
        ----------------------   -----------------------------------------------
        INFRASTRUCTURE_SERVICE   Data structure is a Service with infrastructure
                                 focus in the sense of DDD.
        ----------------------   -----------------------------------------------
               REPOSITORY        Data structure is a Repository in the sense of
                                 DDD.
        ----------------------   -----------------------------------------------
                SERVICE          Data structure is a Service in the sense of
                                 DDD.
        ----------------------   -----------------------------------------------
             SPECIFICATION       Data structure is a Specification in the sense
                                 of DDD.
        ----------------------   -----------------------------------------------
              VALUE_OBJECT       Data structure is a Value Object in the sense
                                 of DDD.
        ======================   ===============================================

        .. NOTE::

            DDD-related features should follow the constraints described in
            :cite:`Rademacher2018`. The Data Modeling Language currently issues 
            a warning in case they are violated. Code generators are free to
            also check the constraints and deny code generation in case they are
            violated.

    .. py:attribute:: IntermediateDataStructure super

        The super data structure from which this data structure inherits.

        .. NOTE::

            The modeling language for creating Domain Data Models supports 
            single inheritance only. Furthermore, the super data structure must 
            be defined within the same Domain Data Model. It cannot be imported 
            from another Domain Data Model.

    .. py:attribute:: IntermediateDataField[*] dataFields

        Data fields of the structure.

        .. HINT::

            In case the data structure inherits from a super data structure, the
            data fields also contain inherited, non-hidden data fields from the
            inheritance hierarchy, i.e., the *effective fields* of the 
            structure. The inherited fields can be distinguished from \"local\" 
            fields of the structure on the basis of the
            :ref:`IntermediateDataField.inherited 
            <link__IntermediateDataField_inherited>` attribute.

    .. py:attribute:: IntermediateDataOperation[*] operations

        Operations of the structure.

        .. HINT::

            In case the data structure inherits from a super data structure, the
            operations also contain inherited, non-hidden operations from the
            inheritance hierarchy, i.e., the *effective operations* of the 
            structure. The inherited operations can be distinguished from 
            \"local\" operations of the structure on the basis of the
            :ref:`IntermediateDataOperation.inherited 
            <link__IntermediateDataOperation_inherited>` attribute.

.. _link__IntermediateDataOperation:

.. java:type:: class IntermediateDataOperation

    An operation within an 
    :ref:`IntermediateDataStructure <link__IntermediateDataStructure>`.

    .. py:attribute:: String[1] name

        Unique name of the operation.

    .. py:attribute:: String[1] qualifiedName

        Qualified name of the operation. This is the operation's name prefixed
        by the qualified name of the surrounding 
        :ref:`data structure <link__IntermediateDataStructure>`. The name
        fragments are separated by dots.

    .. py:attribute:: boolean hidden

        Flag to indicate whether the operation is hidden or not. Semantically,
        this flag corresponds to Java's ``private`` accessibility specifier.
        However, its functionality differs in that an inherited operation may be
        set to hidden. That is, operations' visibility may be overridden. A 
        hidden operation is not visible in any of the following levels of the 
        inheritance hierarchy.

    .. _link__IntermediateDataOperation_inherited:
    
    .. py:attribute:: boolean inherited
      
        Flag to indicate whether this operation was inherited from a super
        :ref:`structure <link__IntermediateDataStructure>`.
    
    .. py:attribute:: String[*] featureNames

        This attribute contains the names of all features specified for the data
        operation. The following values are possible:

        ================   =====================================================
        **Feature Name**         **Description**
        ----------------   -----------------------------------------------------
             CLOSURE       Data operation is a Closure in the sense of DDD.
        ----------------   -----------------------------------------------------
           IDENTIFIER      Data operation acts as identifier for an Entity in
                           the sense of DDD (see also 
                           :ref:`IntermediateDataStructure.featureNames 
                           <link__IntermediateDataStructure_featureNames>`).
        ----------------   -----------------------------------------------------
        SIDE_EFFECT_FREE   Data operation is side-effect-free in the sense of 
                           DDD.
        ----------------   -----------------------------------------------------
            VALIDATOR      Data operation acts as validator for a Specification
                           in the sense of DDD (see also 
                           :ref:`IntermediateDataStructure.featureNames 
                           <link__IntermediateDataStructure_featureNames>`).
        ================   =====================================================

        .. NOTE::

            DDD-related features should follow the constraints described in
            :cite:`Rademacher2018`. The Data Modeling Language currently issues 
            a warning in case they are violated. Code generators are free to
            also check the constraints and deny code generation in case they are
            violated.

    .. py:attribute:: IntermediateDataOperationReturnType returnType

        The :ref:`return type <link__IntermediateDataOperationReturnType>` of 
        the operation. This is empty when no return type for the operation was
        specified.

    .. py:attribute:: IntermediateDataOperationParameter[*] parameters

        The :ref:`parameters <link__IntermediateDataOperationParameter>` of the
        operation.

    .. py:attribute:: IntermediateImportedAspect[*] aspects

        The :java:type:`aspects <IntermediateImportedAspect>` that were assigned
        to the operation within a Mapping Model.

.. _link__IntermediateDataOperationReturnType:

.. java:type:: class IntermediateDataOperationReturnType

    The return type of an
    :ref:`IntermediateDataOperation <link__IntermediateDataOperation>`.

    .. _link__IntermediateDataOperationReturnType_type:

    .. py:attribute:: IntermediateType[1] type

        The return type.

        .. HINT::

            The ``type`` attribute always holds a unique instance of 
            :py:class:`IntermediateType`, i.e., instances of the same types are
            not reused.

        .. HINT::

            Code generators must use this type as the operation's return type
            and not :ref:`originalType
            <link__IntermediateDataOperationReturnType_originalType>`.

    .. _link__IntermediateDataOperationReturnType_originalType:

    .. py:attribute:: IntermediateType[1] originalType

        The original return type of the operation in case it got mapped within a 
        Mapping Model.

        .. HINT::

            This attribute always holds a value. In case it differs from the
            :ref:`type <link__IntermediateDataOperationReturnType_type>`, the
            return type got mapped and the 
            :ref:`type <link__IntermediateDataOperationReturnType_type>` 
            attribute holds an 
            :java:type:`IntermediateImportedTechnologySpecificType 
            <IntermediateImportedTechnologySpecificType>` instance that points
            to the technology-specific type to which the return type was mapped.

    .. py:attribute:: IntermediateImportedAspect[*] aspects

        The :java:type:`aspects <IntermediateImportedAspect>` that were assigned
        to the return type within a Mapping Model.

.. _link__IntermediateDataOperationParameter:

.. java:type:: class IntermediateDataOperationParameter

    A parameter within an 
    :ref:`IntermediateDataOperation <link__IntermediateDataOperation>`.

    .. py:attribute:: String[1] name

        Unique name of the parameter.

    .. py:attribute:: String[1] qualifiedName

        Qualified name of the parameter. This is the parameter's name prefixed
        by the qualified name of the surrounding 
        :ref:`operation <link__IntermediateDataOperation>`. The name fragments
        are separated by dots.

    .. _link__IntermediateDataOperationParameter_type:

    .. py:attribute:: IntermediateType[1] type

        The type of the parameter.

        .. HINT::

            The ``type`` attribute always holds a unique instance of 
            :py:class:`IntermediateType`, i.e., instances of the same types are
            not reused.

        .. HINT::

            Code generators must use this type as the parameter's type and not
            its :ref:`original type
            <link__IntermediateDataOperationParameter_originalType>`.

    .. _link__IntermediateDataOperationParameter_originalType:

    .. py:attribute:: IntermediateType[1] originalType

        The original type of the parameter in case it got mapped within a 
        Mapping Model.

        .. HINT::

            This attribute always holds a value. In case it differs from the
            :ref:`type <link__IntermediateDataOperationParameter_type>` of the
            parameter, the parameter got mapped and the 
            :ref:`type <link__IntermediateDataOperationParameter_type>` 
            attribute holds an 
            :java:type:`IntermediateImportedTechnologySpecificType 
            <IntermediateImportedTechnologySpecificType>` instance that points
            to the technology-specific type to which the parameter was mapped.

    .. py:attribute:: IntermediateImportedAspect[*] aspects

        The :java:type:`aspects <IntermediateImportedAspect>` that were assigned
        to the parameter within a Mapping Model.

.. _link__IntermediateDataField:

.. java:type:: class IntermediateDataField

    A data field within an 
    :ref:`IntermediateDataStructure <link__IntermediateDataStructure>`.

    .. py:attribute:: String[1] name

        Unique name of the field.

    .. py:attribute:: String[1] qualifiedName

        Qualified name of the field. This is the field's name prefixed by
        the qualified name of the surrounding 
        :ref:`data structure <link__IntermediateDataStructure>`. The name
        fragments are separated by dots.

    .. py:attribute:: boolean hidden

        Flag to indicate whether the field is hidden or not. Semantically, this
        flag corresponds to Java's ``private`` accessibility specifier. However,
        its functionality differs in that an inherited field may be set to 
        hidden. That is, fields' visibility may be overridden. A hidden field is
        not visible in any of the following levels of the inheritance hierarchy.

    .. py:attribute:: boolean immutable

        Flag to indicate whether the field is immutable or not. In Java, for 
        instance, this could correspond to a field that has no public setter.

    .. _link__IntermediateDataField_inherited:
    
    .. py:attribute:: boolean inherited
      
        Flag to indicate whether this field was inherited from a super
        :ref:`structure <link__IntermediateDataStructure>`.

    .. py:attribute:: String[*] featureNames

        This attribute contains the names of all features specified for the data
        field. The following values are possible:

        ================   =====================================================
        **Feature Name**         **Description**
        ----------------   -----------------------------------------------------
           IDENTIFIER      Data field acts as identifier for an Entity in the
                           sense of DDD (see also 
                           :ref:`IntermediateDataStructure.featureNames 
                           <link__IntermediateDataStructure_featureNames>`).
        ----------------   -----------------------------------------------------
           NEVER_EMPTY     Data field should never be empty.
        ----------------   -----------------------------------------------------
              PART         Data field is a part of an Aggregate in the sense of
                           DDD (see also
                           :ref:`IntermediateDataStructure.featureNames 
                           <link__IntermediateDataStructure_featureNames>`).
        ================   =====================================================

        .. NOTE::

            DDD-related features should follow the constraints described in
            :cite:`Rademacher2018`. The Data Modeling Language currently issues 
            a warning in case they are violated. Code generators are free to
            also check the constraints and deny code generation in case they are
            violated.

    .. py:attribute:: String initializationValue

        If the field has an initialization value, it is encoded in this String 
        attribute. It is guaranteed that the initialization value is compatible
        to all :ref:`primitive types <link__IntermediatePrimitiveType>` in the
        ``initializationValueCompatibleTypes`` list.

        .. NOTE::

            Only data fields defined in :ref:`data structures
            <link__IntermediateDataStructure>` can be initialized.

        .. NOTE::

            A data field with the built-in ``unspecified`` primitive type cannot
            exhibit an initialization value.
    
    .. py:attribute:: IntermediatePrimitiveType[*]
        initializationValueCompatibleTypes

        If the data field exhibits an initialization value, this list comprises
        all :ref:`primitive types <link__IntermediatePrimitiveType>`, with which
        the initialization value is compatible.

        .. NOTE::

            There is no determined order in which the primitive types appear in 
            the list.

    .. _link__IntermediateDataField_type:

    .. py:attribute:: IntermediateType[1] type

        The type of the data field.

        .. HINT::

            The ``type`` attribute always holds a unique instance of 
            :py:class:`IntermediateType`, i.e., instances of the same types are
            not reused for data field typing.

        .. HINT::

            Code generators must use this type as the field's type and not its
            :ref:`original type <link__IntermediateDataField_originalType>`.

    .. _link__IntermediateDataField_originalType:

    .. py:attribute:: IntermediateType[1] originalType

        The original type of the data field in case it got mapped within a 
        Mapping Model.

        .. HINT::

            This attribute always holds a value. In case it differs from the
            :ref:`type <link__IntermediateDataField_type>` of the data field,
            the field got mapped and the 
            :ref:`type <link__IntermediateDataField_type>` attribute holds an 
            :java:type:`IntermediateImportedTechnologySpecificType 
            <IntermediateImportedTechnologySpecificType>` instance that points
            to the technology-specific type to which the field was mapped.

    .. py:attribute:: IntermediateImportedAspect[*] aspects

        The :java:type:`aspects <IntermediateImportedAspect>` that were assigned
        to the field within a Mapping Model.

    .. py:attribute:: IntermediateDataStructure dataStructure

        Link to the containing 
        :ref:`IntermediateDataStructure <link__IntermediateDataStructure>` 
        instance.

.. _link__IntermediateListType:

.. java:type:: class IntermediateListType extends IntermediateComplexType

    A domain-specific list type.

    .. _link__IntermediateListType_primitiveList:

    .. py:attribute:: boolean primitiveList

        Flag to indicate if this is a list that contains a sequence of primitive
        values.

    .. _link__IntermediateListType_structuredList:
    
    .. py:attribute:: boolean structuredList

        Flag to indicate if this list holds instances of structured 
        :ref:`data fields <link__IntermediateDataField>`.

    .. NOTE::

        Exactly one of the flags ``primitiveList`` and ``structuredList`` is
        always ``true``.

    .. py:attribute:: IntermediatePrimitiveType primitiveType

        If the list is a 
        :ref:`primitiveList <link__IntermediateListType_primitiveList>` this
        attribute contains the 
        :ref:`IntermediatePrimitiveType <link__IntermediatePrimitiveType>` 
        instance that corresponds to the primitive type of the list's values.

    .. py:attribute:: IntermediateDataField[*] dataFields

        If the list is a 
        :ref:`structuredList <link__IntermediateListType_structuredList>` this
        attribute contains the 
        :ref:`IntermediateDataStructure <link__IntermediateDataStructure>` 
        instances that prescribe the structure of the list's values.

.. _link__IntermediateEnumeration:

.. java:type:: class IntermediateEnumeration extends IntermediateComplexType

    A domain-specific enumeration.

    .. py:attribute:: IntermediateEnumerationField[1..*] fields

    The fields of the enumeration.

.. _link__IntermediateEnumerationField:

.. java:type:: class IntermediateEnumerationField

    A field of an IntermediateEnumeration.

    .. py:attribute:: String[1] name

        Unique name of the field.

    .. py:attribute:: String[1] qualifiedName

        Qualified name of the field. This is the field's name prefixed by
        the qualified name of the surrounding 
        :ref:`enumeration <link__IntermediateEnumeration>`. The name
        fragments are separated by dots.

    .. py:attribute:: String initializationValue

        If the field has an initialization value, it is encoded in this String 
        attribute. It is guaranteed that the initialization value is compatible
        to all :ref:`primitive types <link__IntermediatePrimitiveType>` in the
        ``initializationValueCompatibleTypes`` list.

    .. py:attribute:: IntermediatePrimitiveType[*]
        initializationValueCompatibleTypes

        If the enumeration field exhibits an initialization value, this list
        comprises all :ref:`primitive types <link__IntermediatePrimitiveType>`,
        with which the initialization value is compatible.

        .. NOTE::

            There is no determined order in which the primitive types appear in 
            the list.

    .. py:attribute:: IntermediateEnumeration enumeration

        Link to the :ref:`enumeration <link__IntermediateEnumeration>` in which
        this field is defined.

Technologies
------------

In the following, concepts for assigning technologies to, e.g., complex types
and other modeling concepts such as :java:type:`microservices 
<IntermediateMicroservice>` are described.

.. java:type:: class IntermediateImportedTechnologySpecificType extends \
    IntermediateType

    Representation of a type defined in a Technology Model.

    .. py:attribute:: String[1] qualifiedName

        Qualified name of the type. It consists of the name of the defining
        technology, the \"_types\" prefix as internal qualifier within the 
        Technology Model, and the name of the type.

    .. py:attribute:: IntermediateImport[1] import

        The :java:type:`IntermediateImport <IntermediateImport>` instance that 
        points to the Technology Model from which the type was imported.

.. java:type:: class IntermediateImportedAspect

    Aspects enable to semantically reify modeled 
    :ref:`complex types <link__IntermediateComplexType>`,
    :java:type:`data and enumeration fields <IntermediateMappedField>`
    :java:type:`microservices <IntermediateMicroservice>`,
    :java:type:`interfaces <IntermediateInterface>`,
    :java:type:`operations <IntermediateOperation>`, and
    :java:type:`parameters <IntermediateParameter>`, in the sense of 
    Aspect-oriented Programming (AOP) :cite:`Kiczales1997`.

    Aspects are defined within Technology Models. An aspect definition might be
    accompanied with properties and constrained to the concepts to which they 
    apply. With this mechanism it is possible to create, e.g., aspects for the
    OR mapping of data structures or HTTP status codes being returned by a
    service operation's execution.

    .. py:attribute:: String[1] name

        Name of the aspect.

    .. py:attribute:: String[*] featureNames

        This attribute contains the names of all features specified for the
        aspect. The following values are possible:

        =================   ====================================================
        **Feature Name**      **Description**
        -----------------   ----------------------------------------------------
          SINGE_VALUED      Flag to indicate that an aspect may only receive a
                            value once, i.e., it may only be specified once at a
                            target element.
        =================   ====================================================

    .. py:attribute:: IntermediateImport[1] import

        :java:type:`Import <IntermediateImport>` of the Technology Model which 
        defines the aspect.

    .. py:attribute:: IntermediateAspectProperty[*] properties

        All :java:type:`properties <IntermediateAspectProperty>` of the aspect 
        as defined in its Technology Model.

    .. py:attribute:: IntermediateAspectPropertyValue[*] propertyValues

        :java:type:`Values <IntermediateAspectPropertyValue>` for aspect 
        properties specified in the source Service Model.

    .. py:attribute:: IntermediateComplexType complexType

        :ref:`IntermediateComplexType <link__IntermediateComplexType>` to which 
        the aspect was assigned.

    .. py:attribute:: IntermediateDataOperation operation

        :ref:`IntermediateDataOperation <link__IntermediateDataOperation>` to 
        which the aspect was assigned.

    .. py:attribute:: IntermediateDataOperationParameter parameter

        :ref:`IntermediateDataOperationParameter 
        <link__IntermediateDataOperationParameter>` to which the aspect was 
        assigned.

    .. py:attribute:: IntermediateDataField dataField

        :ref:`IntermediateDataField <link__IntermediateDataField>` to which the
        aspect was assigned.

.. java:type:: class IntermediateAspectProperty

    Specification of an :java:type:`aspect's <IntermediateImportedAspect>` 
    property.

    .. py:attribute:: String[1] name
    
        Name of the property.

    .. _link__IntermediateAspectProperty_type:

    .. py:attribute:: String[1] type

        Name of the :ref:`primitive type <link__IntermediatePrimitiveType>` of 
        the property. This can be one of the values:

        - \"boolean\"
        - \"byte\"
        - \"char\"
        - \"date\"
        - \"double\"
        - \"float\"
        - \"int\"
        - \"long\"
        - \"short\"
        - \"string\"

        .. NOTE::

            A property cannot be of the built-in primitive type ``unspecified``.

    .. py:attribute:: String defaultValue

        If the property has a default value, it is encoded in this String 
        attribute. However, it is guaranteed that the default value fits the
        :ref:`type <link__IntermediateAspectProperty_type>` of the property by
        the Technology Modeling Language validator.

    .. py:attribute:: String[*] featureNames

        This attribute contains the names of all features specified for the
        property. The following values are possible:

        =================   ====================================================
        **Feature Name**      **Description**
        -----------------   ----------------------------------------------------
            MANDATORY       Flag to indicate if the property needs to receive a 
                            value. It is guaranteed by the languages' validators
                            that all mandatory values of a property receive a 
                            value when the respective 
                            :java:type:`IntermediateImportedAspect` is used.
          SINGE_VALUED      Flag to indicate that a property may only receive a
                            value once. Note that for :java:type:`aspects
                            <IntermediateImportedAspect>` the languages' 
                            validators guarantee that properties receive values
                            only once. However, it is not guaranteed that aspect
                            properties exhibit this feature.
        =================   ====================================================

    .. py:attribute:: IntermediateImportedAspect aspect

        The :java:type:`aspect <IntermediateImportedAspect>` to which the
        property belongs.

.. java:type:: class IntermediateAspectPropertyValue

    Value of an :java:type:`IntermediateAspectProperty`.

    .. py:attribute:: String[1] value

        The value.

    .. py:attribute:: IntermediateAspectProperty[1] property

        The :java:type:`property <IntermediateAspectProperty>` for which the
        value was set.

    .. py:attribute:: IntermediateImportedAspect aspect

        The :java:type:`aspect <IntermediateImportedAspect>` to which the
        property value belongs.

.. rubric:: Footnotes

.. [#eclipse] https://www.eclipse.org
.. [#xcore] https://wiki.eclipse.org/Xcore
.. [#xtext] https://www.eclipse.org/Xtext
.. [#emf] https://www.eclipse.org/modeling/emf
.. [#model-export] Actually, the models are *transformed* into the XMI format.
    Please refer to :cite:`Combemale2017` to learn more about *model* 
    *transformation*.
.. [#xmi] https://www.omg.org/spec/XMI
.. [#mof] https://www.omg.org/mof
.. [#java-type-conversions] 
    https://docs.oracle.com/javase/specs/jls/se11/html/jls-5.html#jls-5.1.2
.. [#golang] https://www.golang.org
.. [#enterprise-patterns-event-message]
    https://www.enterpriseintegrationpatterns.com/patterns/messaging/EventMessage.html

Indices and Tables
==================

* :ref:`genindex`
* :ref:`search`

References
==========

.. bibliography:: references.bib

.. _Language Ecosystem for Modeling Microservice Archictecture:
  https://github.com/SeelabFhdo/lemma
