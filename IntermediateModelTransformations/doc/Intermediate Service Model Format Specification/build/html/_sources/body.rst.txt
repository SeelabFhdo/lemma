.. sectnum::

.. _Introduction:

Introduction
============

This document describes the Intermediate Service Model format from the 
`Domain-driven Microservice Design`_ project. The project aims to facilitate the
development of *microservice-based software systems* :cite:`Newman2015` by
employing Model-driven Development (MDD) :cite:`Combemale2017`.

In this context, a microservice architecture consists of several different types
of models, listed in :numref:`tab__model_types`.

.. _tab__model_types:

.. table:: Model types

    =================   ========================================================
    **Model Type**      **Description**
    -----------------   --------------------------------------------------------
    Domain Data Model   A Domain Data Model describes the domain-specific data 
                        used by a modeled microservice to specify its 
                        input/output data. See also the 
                        :doc:`Intermediate Data Model Format Specification 
                        <data_model:index>`.
    Mapping Model       A Mapping Model allows for assigning (alternative) 
                        technologies to modeled microservices in a Service 
                        Model.
    Service Model       A Service Model contains several microservice models, 
                        their interfaces, and operations. The contents of 
                        imported Domain Data Models, e.g., data structures, may 
                        be used to type operations' parameters.
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
Intermediate Service Models, i.e., instances of Domain Data Models that were 
exported from Eclipse (cf. :ref:`Introduction` and :ref:`ModelProcessing`). It 
may be used as as reference, when implementing custom model processors for 
microservice-related Service Models.

:numref:`fig_metamodel` shows the structure of the metamodel of the Intermediate
Service Models in an object-oriented way in the form of a UML class diagram. The
modeling concepts, their properties, and relationships are depicted as classes, 
attributes, and associations, respectively.

.. _fig_metamodel:

.. figure:: figures/metamodel.png

    Metamodel of Intermediate Service Models

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

.. java:type:: class IntermediateServiceModel
    
    Root of the Intermediate Service Model instance.

    .. py:attribute:: IntermediateImport[*] imports

        References to :java:type:`data_model:IntermediateDataModel`, Technology
        Model (cf. :numref:`tab__model_types`), or Intermediate Service Model
        instances that were imported into the source Service Model
        (cf. :java:type:`data_model:IntermediateImport`).

    .. py:attribute:: IntermediateMicroservice[1..*] microservices

        Modeled :java:type:`microservices <IntermediateMicroservice>` in the
        source Service Model.

Microservices
-------------

.. java:type:: class IntermediateMicroservice

    A modeled microservice.    
    
    .. _link__IntermediateMicroservice_name:

    .. py:attribute:: String[1] name

        Unique name of the service.

    .. _link__IntermediateMicroservice_version:

    .. py:attribute:: String version

        Optional version of the service.

    .. _link__IntermediateMicroservice_qualifiedName:

    .. py:attribute:: String[1] qualifiedName

        Qualified name of the service. This is the service's name prefixed by
        its version, if any. Both name fragments are separated by dots.

    .. py:attribute:: MicroserviceType[1] type

        :cpp:enum:`Type <MicroserviceType>` of the microservice.

    .. py:attribute:: Visibility[1] visibility

        :cpp:enum:`Visibility` of the microservice.

    .. py:attribute:: boolean effectivelyImplemented

        Flag to indicate if the microservice has at least one 
        :java:type:`IntermediateOperation` that is not marked as being not
        not implemented (either directly or transitively via its encapsulating
        :java:type:`IntermediateInterface`.

        .. HINT::

            Code generators should consider to also generate code for not (yet)
            implemented microservices and, e.g., return failures to callers.

    .. _link__IntermediateMicroservice_technologies:

    .. py:attribute:: IntermediateTechnology[*] technologies

        :java:type:`Technologies <IntermediateTechnology>` assigned to the 
        microservice. 

        .. NOTE::

            In case, no technologies are specified for a microservice, code 
            generators are free to generate code for the microservice or not.

        .. HINT::

            There can only be one technology that defines types. Moreover, it is
            guaranteed that default protocol/data format combinations are
            unambiguous. For instance, there can only be one default synchronous
            protocol across all referenced technologies.
        
    .. _link__IntermediateMicroservice_endpoints:

    .. py:attribute:: IntermediateEndpoint[*] endpoints

        :java:type:`Endpoints <IntermediateEndpoint>` assigned to the 
        microservice.

        .. HINT::

            If no endpoints were specified for the microservice's (default)
            :ref:`protocol specifications 
            <link__IntermediateMicroservice_protocols>`, the 
            :ref:`addresses <link__IntermediateEndpoint_addresses>` attribute of
            the :java:type:`IntermediateEndpoint` class will be empty.
            
            If no endpoints were specified or could be determined from (default)
            :ref:`protocol specifications 
            <link__IntermediateMicroservice_protocols>`, or in case the 
            :ref:`addresses <link__IntermediateEndpoint_addresses>` attribute
            is empty, code generators should produce sensible defaults, e.g., 
            from the microservice's name.

    .. _link__IntermediateMicroservice_protocols:

    .. py:attribute:: IntermediateProtocolSpecification[0..2] protocols

        :java:type:`Protocol specifications <IntermediateProtocolSpecification>`
        assigned to the microservice. There might be exactly one protocol
        specification per :cpp:enum:`communication type <CommunicationType>`. 

        .. NOTE::

            In case the microservice had no protocols assigned in the source
            Service Model, the default protocols of the missing
            :cpp:enum:`communication types <CommunicationType>` are taken from
            the assigned 
            :ref:`technologies <link__IntermediateMicroservice_technologies>`.
            That is, the attribute is only empty if the microservice had no
            protocol-defining technology assigned.

        .. HINT::

            If no protocol specifications are assigned to the service, code 
            generators should produce sensible defaults, e.g., from the 
            microservice's name.

    .. _link__IntermediateMicroservice_requiredMicroservices:

    .. py:attribute:: MicroserviceReference[*] requiredMicroservices

        :java:type:`References <MicroserviceReference>` to required 
        microservices.

    .. _link__IntermediateMicroservice_requiredInterfaces:

    .. py:attribute:: InterfaceReference[*] requiredInterfaces

        :java:type:`References <InterfaceReference>` to required interfaces.

    .. _link__IntermediateMicroservice_requiredOperations:    

    .. py:attribute:: OperationReference[*] requiredOperations

        :java:type:`References <OperationReference>` to required operations.

    .. py:attribute:: IntermediateImportedAspect[*] aspects

        :java:type:`Aspects <IntermediateImportedAspect>` of the microservice.

    .. py:attribute:: IntermediateServiceModel serviceModel

        Link to the containing :java:type:`IntermediateServiceModel` instance.

.. cpp:enum:: MicroserviceType

    Possible types of an :java:type:`IntermediateMicroservice`.

    .. cpp:enumerator:: FUNCTIONAL

        A functional microservice realizes the business functions of the
        microservice-based software system.

    .. cpp:enumerator:: INFRASTRUCTURE

        Infrastructure microservices provide the architecture with capabilities
        that are not related to business but technical functions. Examples of
        such functions comprise database lookups or integration of legacy
        systems.

    .. cpp:enumerator:: UTILITY

        Teams may realize utility microservices to implement reusable, 
        business-related helper functions, e.g., for currency conversion.
        
.. cpp:enum:: Visibility

    Possible visibilitiy qualifiers of an 
    :java:type:`IntermediateMicroservice`, :java:type:`IntermediateInterface`,
    and :java:type:`IntermediateOperation`.

    .. cpp:enumerator:: INTERNAL

        Internal services/interfaces/operations must only be visible to the 
        services of the same team.

    .. cpp:enumerator:: IN_MODEL

        Qualifies an interface/operation to be visible only within the current
        service model file and its services.

    .. cpp:enumerator:: ARCHITECTURE

        Architecture services/interfaces/operations must only be visible to the 
        services of the same architecture, but not to external consumers.

    .. cpp:enumerator:: PUBLIC

        Public services/interfaces/operations must be visible to all services of
        the same architecture and also to external consumers.

.. java:type:: class IntermediateInterface

    This class represents an interface of an 
    :java:type:`IntermediateMicroservice`.

    .. _link__IntermediateInterface_name:
    
    .. py:attribute:: String[1] name

        Name of the interface.

    .. _link__IntermediateInterface_qualifiedName:

    .. py:attribute:: String[1] qualifiedName

        Qualified name of the interface. This is the interface's name prefixed 
        by its microservice's 
        :ref:`qualified name <link__IntermediateMicroservice_qualifiedName>`.
        Both name fragments are separated by dots.

    .. py:attribute:: Visibility[1] visibility

        :cpp:enum:`Visibility` of the interface.

    .. _link__IntermediateInterface_notImplemented:

    .. py:attribute:: boolean notImplemented

        Flag to indicate if the interface was marked as being not implemented.

        .. HINT::

            Code generators should consider to also generate code for not (yet)
            implemented interfaces and, e.g., return failures to callers.

    .. _link__IntermediateInterface_hasImplementedOperations:

    .. py:attribute:: boolean hasImplementedOperations

        Flag to indicate if the interface has at least one 
        :java:type:`operation <IntermediateOperation>` whose 
        :ref:`notImplemented <link__IntermediateOperation_notImplemented>`
        attribute is ``false``.

        .. HINT::

            Code generators should consider to also generate code for interfaces
            whose operations are not (yet) implemented and, e.g., return 
            failures to callers.

        .. NOTE::

            The 
            :ref:`notImplemented <link__IntermediateInterface_notImplemented>`
            and :ref:`hasImplementedOperations
            <link__IntermediateInterface_hasImplementedOperations>` are 
            independent of each other. The first is set by the modeler, while
            the second is derived from the corresponding flags of the 
            interface's :java:type:`operations <IntermediateOperation>`.

    .. _link__IntermediateInterface_endpoints:

    .. py:attribute:: IntermediateEndpoint[*] endpoints

        :java:type:`Endpoints <IntermediateEndpoint>` assigned to the interface.

        .. HINT::

            If no endpoints were specified for the interface's (default)
            :ref:`protocol specifications 
            <link__IntermediateInterface_protocols>`, the 
            :ref:`addresses <link__IntermediateEndpoint_addresses>` attribute of
            the :java:type:`IntermediateEndpoint` class will be empty.
            
            If no endpoints were specified or could be determined from (default)
            :ref:`protocol specifications 
            <link__IntermediateInterface_protocols>`, or in case the 
            :ref:`addresses <link__IntermediateEndpoint_addresses>` attribute
            is empty, code generators should produce sensible defaults, e.g., 
            from the interface's name.

    .. _link__IntermediateInterface_protocols:

    .. py:attribute:: IntermediateProtocolSpecification[0..2] protocols

        :java:type:`Protocol specifications <IntermediateProtocolSpecification>`
        assigned to the interface. There might be exactly one protocol
        specification per :cpp:enum:`communication type <CommunicationType>`.

        .. HINT::

            If no protocol specifications were explicitly assigned to the 
            interface, it "inherits" the specifications of its 
            :ref:`microservice <link__IntermediateMicroservice_protocols>`.

            If the service also exhibited no protocol specifications and thus 
            the interface does neither, code generators should produce sensible
            defaults, e.g., from the interface's name.

    .. py:attribute:: IntermediateOperation[*] operations

        :java:type:`Operations <IntermediateOperation>` of the interface.

    .. py:attribute:: IntermediateReferredOperation[*] referredOperations

        :java:type:`Referred Operations <IntermediateReferredOperation>` of the
        interface.

        .. NOTE::

            An interface defines at least one operation or refers to an existing
            operation, i.e., at least one of the ``operations`` and 
            ``referredOperations`` is not empty.

    .. py:attribute:: IntermediateImportedAspect[*] aspects

        :java:type:`Aspects <IntermediateImportedAspect>` of the interface.

    .. py:attribute:: IntermediateMicroservice microservice

        Link to the containing :java:type:`IntermediateMicroservice` instance.

.. java:type:: class IntermediateOperation

    This class represents an operation of an :java:type:`IntermediateInterface`.

    .. _link__IntermediateOperation_name:

    .. py:attribute:: String[1] name

        Name of the operation.

    .. _link__IntermediateOperation_qualifiedName:

    .. py:attribute:: String[1] qualifiedName

        Qualified name of the operation. This is the operation's name prefixed 
        by its interface's 
        :ref:`qualified name <link__IntermediateInterface_qualifiedName>`.
        Both name fragments are separated by dots.

    .. py:attribute:: Visibility[1] visibility

        :cpp:enum:`Visibility` of the operation.

    .. _link__IntermediateOperation_notImplemented:

    .. py:attribute:: boolean notImplemented

        Flag to indicate if the operation was marked as being not implemented.

        .. HINT::

            Code generators should consider to also generate code for not (yet)
            implemented operation and, e.g., return failures to callers.

    .. _link__IntermediateOperation_endpoints:

    .. py:attribute:: IntermediateEndpoint[*] endpoints

        :java:type:`Endpoints <IntermediateEndpoint>` assigned to the operation.

        .. HINT::

            If no endpoints were specified for the operation's (default)
            :ref:`protocol specifications 
            <link__IntermediateOperation_protocols>`, the 
            :ref:`addresses <link__IntermediateEndpoint_addresses>` attribute of
            the :java:type:`IntermediateEndpoint` class will be empty.
            
            If no endpoints were specified or could be determined from (default)
            :ref:`protocol specifications 
            <link__IntermediateOperation_protocols>`, or in case the 
            :ref:`addresses <link__IntermediateEndpoint_addresses>` attribute
            is empty, code generators should produce sensible defaults, e.g., 
            from the operation's name.

    .. _link__IntermediateOperation_protocols:

    .. py:attribute:: IntermediateProtocolSpecification[0..2] protocols

        :java:type:`Protocol specifications <IntermediateProtocolSpecification>`
        assigned to the operation. There might be exactly one protocol
        specification per :cpp:enum:`communication type <CommunicationType>`.

        .. HINT::

            If no protocol specifications were explicitly assigned to the 
            operation, it "inherits" the specifications of its 
            :ref:`interface <link__IntermediateInterface_protocols>`.

            If the interface also exhibited no protocol specifications and thus 
            the operation does neither, code generators should produce sensible
            defaults, e.g., from the operation's name.

    .. py:attribute:: IntermediateParameter[*] parameters

        :java:type:`Parameters <IntermediateParameter>` of the operation.

        .. NOTE::

            There might be more than one 
            :cpp:enum:`outgoing parameter <ExchangePattern>` and it is up to
            code generators on how to proceed with this. For example, all 
            outgoing parameters could be condensed within a uniforming data
            structure.

    .. py:attribute:: IntermediateImportedAspect[*] aspects

        :java:type:`Aspects <IntermediateImportedAspect>` of the operation.

    .. py:attribute:: IntermediateInterface interface

        Link to the containing :java:type:`IntermediateInterface` instance.

.. java:type:: class IntermediateParameter

    A parameter of an :java:type:`IntermediateOperation`.

    .. py:attribute:: String[1] name

        Name of the parameter.

    .. _link__IntermediateParameter_qualifiedName:

    .. py:attribute:: String[1] qualifiedName

        Qualified name of the parameter. This is the parameter's name prefixed 
        by its operation's 
        :ref:`qualified name <link__IntermediateOperation_qualifiedName>`.
        Both name fragments are separated by dots.

    .. _link__IntermediateParameter_exchangePattern:

    .. py:attribute:: ExchangePattern[1] exchangePattern

        :cpp:enum:`ExchangePattern` of the parameter.

    .. _link__IntermediateParameter_communicationType:

    .. py:attribute:: CommunicationType[1] communicationType

        :cpp:enum:`CommunicationType` of the parameter.

    .. py:attribute:: boolean communicatesFault

        Flag to indicate that the parameter is used to communicate fault values
        to the caller.

        .. NOTE::

            It is up to the code generator to ensure that the caller is aware 
            that the parameter communicates a fault.

    .. py:attribute:: boolean optional

        Flag to indicate that the parameter is optional.

        .. NOTE::

            The combination of the :ref:`exchangePattern 
            <link__IntermediateParameter_exchangePattern>`, 
            :ref:`communicationType 
            <link__IntermediateParameter_communicationType>`, and ``optional``
            attributes determine a parameter's "timing behavior":

            +------------+-----------------+---------+-------------------------+
            |**Exchange**|**Communication**|**Opt?** |**Operation Behavior**   |
            |**Pattern** |**Type**         |         |                         |
            +============+=================+=========+=========================+
            |``IN``      |``ASYNCHRONOUS`` |``false``|Operation may retrieve   |
            |            |                 |         |value at an arbitrary    |
            |            |                 |         |point in time during its |
            |            |                 |         |execution.               |
            +------------+-----------------+---------+-------------------------+
            |``IN``      |``ASYNCHRONOUS`` |``true`` |Operation must retrieve  |
            |            |                 |         |value at some point in   |
            |            |                 |         |time during its          |
            |            |                 |         |execution.               |
            +------------+-----------------+---------+-------------------------+
            |``IN``      |``SYNCHRONOUS``  |``false``|Operation can only be    |
            |            |                 |         |executed if parameter has|
            |            |                 |         |has a value.             |
            +------------+-----------------+---------+-------------------------+
            |``IN``      |``SYNCHRONOUS``  |``true`` |Operation can be executed|
            |            |                 |         |without the parameter    |
            |            |                 |         |value and it cannot      |
            |            |                 |         |expect to ever retrieve  |
            |            |                 |         |a value for the          |
            |            |                 |         |parameter.               |
            +------------+-----------------+---------+-------------------------+
            |``OUT``     |``ASYNCHRONOUS`` |``false``|Operation may emit value |
            |            |                 |         |at an arbitrary point in |
            |            |                 |         |time during its          |
            |            |                 |         |execution.               |
            +------------+-----------------+---------+-------------------------+
            |``OUT``     |``ASYNCHRONOUS`` |``true`` |Operation emits value at |
            |            |                 |         |some point in time during|
            |            |                 |         |its execution.           |
            +------------+-----------------+---------+-------------------------+
            |``OUT``     |``SYNCHRONOUS``  |``false``|Operation emits value    |
            |            |                 |         |when it finished its     |
            |            |                 |         |execution.               |
            +------------+-----------------+---------+-------------------------+
            |``OUT``     |``SYNCHRONOUS``  |``true`` |Operation might emit     |
            |            |                 |         |value after it finished  |
            |            |                 |         |its execution.           |
            +------------+-----------------+---------+-------------------------+
            |``INOUT``   |all              |all      |Parameter behaves        |
            |            |                 |         |like an incoming and     |
            |            |                 |         |outgoing parameter for   |
            |            |                 |         |the respective           |
            |            |                 |         |communication type and   |
            |            |                 |         |"optional" flag.         |
            +------------+-----------------+---------+-------------------------+
    
    .. _link__IntermediateParameter_type:

    .. py:attribute:: IntermediateType type

        :ref:`Type <data_model:link__IntermediateType>` of the parameter.

    .. _link__IntermediateParameter_initializedByOperation:

    .. py:attribute:: OperationReference initializedByOperation

        Link to the :java:type:`IntermediateOperation` that initializes the
        parameter.

        .. NOTE::

            It is not safely guaranteed that the operation's return values and
            the parameter's type are compatible. This is due to the Service
            Modeling Language only yielding a warning if a (possible) type 
            incompatibility is detected. Moreover, the type check is based on 
            the :ref:`type system <data_model:link__built_in_type_system>` of 
            the Domain Data Modeling Language, which may not be applicable to 
            all target languages.

    .. py:attribute:: IntermediateImportedAspect[*] aspects

        :java:type:`Aspects <IntermediateImportedAspect>` of the parameter.

    .. py:attribute:: IntermediateMappedDataField[*] mappedDataFields

        :java:type:`Mapped data fields <IntermediateMappedDataField>` of the
        parameter.

        .. HINT::

            If the parameter has mapped data fields, the corresponding types of
            the fields of the parameter's 
            :ref:`structure type <data_model:link__IntermediateDataStructure>`
            need to be replaced with the mapped types.

            Furthermore, mapped data fields are the only way to assign
            :java:type:`aspects <IntermediateImportedAspect>` to the fields of a 
            :ref:`data structure <data_model:link__IntermediateDataStructure>`.

    .. py:attribute:: IntermediateOperation operation

        Link to the containing :java:type:`IntermediateOperation` instance.

.. java:type:: class IntermediateMappedDataField

    A data field of a :java:type:`parameter's <IntermediateParameter>` 
    :ref:`structure type <data_model:link__IntermediateDataStructure>`, to which 
    a type differing from its original type and optional aspects were assigned.

    .. _link__IntermediateMappedDataField_mappedDataFieldName:

    .. py:attribute:: String[1] mappedDataFieldName

        Name of the mapped data field.

        .. HINT::

            There is not direct link to the field in the respective
            :java:type:`parameter's <IntermediateParameter>`
            :ref:`structure type <data_model:link__IntermediateDataStructure>`.
            Instead, the 
            :ref:`DataField <data_model:link__IntermediateDataField>` instance
            to which the parameter's 
            :ref:`type <link__IntermediateParameter_type>` attribute links needs
            to be iterated with the ``mappedDataFieldName`` in order to retrieve
            the instance.

    .. py:attribute:: String[1] qualifiedName

        Qualified name of the mapped data field.

        .. HINT::
        
            This is the name of the mapped data field prefixed by the 
            parameter's 
            :ref:`qualified name <link__IntermediateParameter_qualifiedName>`.
            The qualified name of the data field itself needs to be derived
            from the corresponding 
            :ref:`DataField <data_model:link__IntermediateDataField>` (see
            the documentation of the :ref:`mappedDataFieldName 
            <link__IntermediateMappedDataField_mappedDataFieldName>` attribute.

    .. py:attribute:: IntermediateType[1] mappedType

        New (mapped) type of the 
        :ref:`data field <data_model:link__IntermediateDataField>`. 

        .. HINT::

            Code generators must use this type as the field's type.

    .. py:attribute:: IntermediateImportedAspect[*] aspects

        :java:type:`Aspects <IntermediateImportedAspect>` of the data field.

    .. py:attribute:: IntermediateParameter parameter

        Link to the containing :java:type:`IntermediateParameter` instance.

.. java:type:: class IntermediateReferredOperation

    Referred operation of an :java:type:`IntermediateInterface`. In contrast to
    :java:type:`IntermediateOperations <IntermediateOperation>`, referred
    operations do not implement their own business logic. Instead, they act as
    façades to implemented 
    :java:type:`IntermediateOperations <IntermediateOperation>` within the same
    microservice. That is, requests/responses to the original operation/the
    caller are just forwarded by referred operations.

    Referred operations exhibit the same 
    :java:type:`parameters <IntermediateParameter>` as the original operations.
    However, they may have different 
    :java:type:`endpoints <IntermediateEndpoint>`,
    :java:type:`protocols <IntermediateProtocolSpecification>`, and
    :java:type:`aspects <IntermediateImportedAspect>`.

    .. py:attribute:: String[1] nameInReferringInterface

        The name of the referred operation within the referring interface.
        Currently, the name is identical to the name of the original operation.
        However, code generators should not rely on that and instead use the 
        content of this attribute to generate the referring operation.

    .. py:attribute:: String[1] qualifiedNameInReferringInterface

        The qualified name of the referred operation within the referring 
        interface. It consists of the name of the referring operation prefixed
        by the :ref:`qualified name 
        <link__IntermediateInterface_qualifiedName>` of its interface. Both name
        fragments are separated by dots.

    .. py:attribute:: IntermediateOperation[1] operation

        Link to the original :java:type:`operation <IntermediateOperation>`.

        .. NOTE::

            The type of the attribute is ``IntermediateOperation`` instead of
            :java:type:`OperationReference`, because the original operation must
            be in the same microservice as the referring operation and can thus
            not originate from an imported Service Model.
    
    .. _link__IntermediateReferredOperation_endpoints:

    .. py:attribute:: IntermediateEndpoint[*] endpoints

        :java:type:`Endpoints <IntermediateEndpoint>` assigned to the referred
        operation.

        .. HINT::

            If no endpoints were specified for the referred operation's 
            (default) :ref:`protocol specifications 
            <link__IntermediateOperation_protocols>`, the 
            :ref:`addresses <link__IntermediateEndpoint_addresses>` attribute of
            the :java:type:`IntermediateEndpoint` class will be empty.
            
            If no endpoints were specified or could be determined from (default)
            :ref:`protocol specifications 
            <link__IntermediateOperation_protocols>`, or in case the 
            :ref:`addresses <link__IntermediateEndpoint_addresses>` attribute
            is empty, code generators should produce sensible defaults, e.g., 
            from the referred operation's name.

    .. _link__IntermediateReferredOperation_protocols:

    .. py:attribute:: IntermediateProtocolSpecification[0..2] protocols

        :java:type:`Protocol specifications <IntermediateProtocolSpecification>`
        assigned to the referred operation. There might be exactly one protocol
        specification per :cpp:enum:`communication type <CommunicationType>`.

        .. HINT::

            If no protocol specifications were explicitly assigned to the 
            referred operation, it "inherits" the specifications of its 
            :ref:`interface <link__IntermediateInterface_protocols>`.

            If the interface also exhibited no protocol specifications and thus 
            the referred operation does neither, code generators should produce
            sensible defaults, e.g., from the referred operation's name.

    .. py:attribute:: IntermediateImportedAspect[*] aspects

        :java:type:`Aspects <IntermediateImportedAspect>` of the referred 
        operation.

    .. py:attribute:: IntermediateInterface referringInterface

        Link to the containing :java:type:`IntermediateInterface` instance.

Type System
-----------

:ref:`Built-in <data_model:link__built_in_type_system>` as well as
:ref:`custom types <data_model:link__custom_types>` are mostly covered within 
the ::doc:`Intermediate Data Model Format Specification <data_model:index>`.

However, Service Models may import technology-specific types from Technology
Models that are not known to Domain Data Models (cf. 
:numref:`tab__model_types`). Thus, intermediate concepts for technology-specific
types are needed to allow intermediate service models to refer to them.

.. java:type:: class IntermediateImportedTechnologySpecificType extends \
    IntermediateType

    Representation of a type defined in a Technology Model.

    .. py:attribute:: String[1] qualifiedName

        Qualified name of the type. It consists of the name of the defining
        technology, the "_types" prefix as internal qualifier within the 
        Technology Model, and the name of the type.

    .. py:attribute:: IntermediateImport[1] import

        The :java:type:`<data_model:IntermediateImport>` instance that points to
        the Technology Model from which the type was imported.

Communication
-------------

This subsection describes concepts related to specifying the communication
between microservices.

.. cpp:enum:: CommunicationType

    The values of this enum represent certain communication types.

    .. cpp:enumerator:: ASYNCHRONOUS
       
        Asynchronous communication.

    .. cpp:enumerator:: SYNCHRONOUS
       
        Synchronous communication.

.. cpp:enum:: ExchangePattern

    The values of this enum represent certain exchange patterns.

    .. cpp:enumerator:: IN

        Incoming information exchange.

    .. cpp:enumerator:: OUT

        Outgoing information exchange.

    .. cpp:enumerator:: INOUT

        Incoming and outgoing information exchange.

.. java:type:: class IntermediateEndpoint

    A protocol- and format-specific endpoint, e.g., "http://www.example.org" for
    HTTP and a format like JSON.

    .. py:attribute:: CommunicationType[1] communicationType

        The :cpp:enum:`communication type <CommunicationType>` assigned to the 
        endpoint. It corresponds to the communication type of the endpoint's
        :ref:`protocol <link__IntermediateEndpoint_protocol>`.

    .. _link__IntermediateEndpoint_protocol:

    .. py:attribute:: String[1] protocol

        Name of the endpoint's protocol.

    .. py:attribute:: String[1] dataFormat

        Name of the endpoint's data format.

    .. _link__IntermediateEndpoint_addresses:

    .. py:attribute:: String[*] addresses

        List of protocol- and format-specific addresses that were assigned to 
        the endpoint, e.g., "http://www.example.org".

        .. HINT::

            If the list of addresses is empty, code generators should produce 
            sensible defaults, as described 
            :java:type:`here <link__IntermediateMicroservice_endpoints>`,
            :java:type:`here <link__IntermediateInterface_endpoints>`,
            :java:type:`here <link__IntermediateOperation_endpoints>`, and
            :java:type:`here <link__IntermediateReferredOperation_endpoints>`.

        .. HINT::

            In case the modeler did not specify a data format for an endpoint,
            this is shorthand notation for "endpoint's addresses apply to all
            formats of the protocol". That is, ``IntermediateEndpoint`` 
            instances with the source addresses are generated for all formats
            of the protocol. However, code generators must only create endpoints
            for the protocols and data formats that were assigned to the 
            respective 
            :ref:`microservice <link__IntermediateMicroservice_protocols>`,
            :ref:`interface <link__IntermediateInterface_protocols>`,
            :ref:`operation <link__IntermediateOperation_protocols>`, or
            :ref:`referred operation 
            <link__IntermediateReferredOperation_protocols>`.

        .. HINT::

            The addresses are not checked for validity by the Service Modeling
            Language. This step has to be done by model processors.

    .. py:attribute:: IntermediateTechnology[1] technology

        Link to the Technology Model (cf. :numref:`tab__model_types`) which 
        defines the protocol and data format.

    .. py:attribute:: IntermediateMicroservice microservice

        :java:type:`IntermediateMicroservice` to which the endpoint was 
        assigned.

    .. py:attribute:: IntermediateInterface interface

        :java:type:`IntermediateInterface` to which the endpoint was assigned.

    .. py:attribute:: IntermediateOperation operation

        :java:type:`IntermediateOperation` to which the endpoint was assigned.

    .. py:attribute:: IntermediateReferredOperation referredOperation

        :java:type:`IntermediateReferredOperation` to which the endpoint was 
        assigned.
        
.. java:type:: class IntermediateProtocolSpecification

    A protocol and data format specification.

    .. py:attribute:: CommunicationType[1] communicationType

        :cpp:enum:`CommunicationType` of the specification.

    .. py:attribute:: String[1] protocol

        Name of the specification's protocol.

    .. py:attribute:: String[1] dataFormat

        Name of the specification's data format.

References
----------

This subsection describes concepts that are used to model references to possibly
imported :java:type:`microservices <IntermediateMicroservice>`,
:java:type:`interfaces <IntermediateInterface>`, or
:java:type:`operation <IntermediateOperation>`.

.. java:type:: class MicroserviceReference

    Reference to a possibly imported 
    :java:type:`microservice <IntermediateMicroservice>`.

    .. py:attribute:: String[1] name

        :ref:`Name <link__IntermediateMicroservice_name>` of the referenced
        microservice.

    .. py:attribute:: String version

        :ref:`Version <link__IntermediateMicroservice_version>` of the 
        referenced microservice.

    .. _link__MicroserviceReference_qualifiedName:

    .. py:attribute:: String[1] qualifiedName

        :ref:`Qualified name <link__IntermediateMicroservice_qualifiedName>` of 
        the referenced microservice.

    .. _link__MicroserviceReference_imported:

    .. py:attribute:: boolean imported

        Flag to indicate if the referenced microservice was imported from 
        another Service Model.

    .. py:attribute:: IntermediateImport import

        Link to the :java:type:`data_model:IntermediateImport` which points to
        the imported Service Model. If the 
        :ref:`imported <link__MicroserviceReference_imported>` flag is ``true``
        this attribute contains a value. Otherwise it is ``null``.

    .. py:attribute:: IntermediateMicroservice localMicroservice

        Link to the referenced :java:type:`IntermediateMicroservice` in the same
        Service Model as the ``MicroserviceReference``. If the 
        :ref:`imported <link__MicroserviceReference_imported>` flag is ``true``
        this attribute is ``null``. Otherwise it contains a value.

        .. HINT::

            If the attribute is ``null``, i.e., the referenced microservice is
            defined in another Service Model, model processors need to retrieve
            details of the referenced service from the imported Service Model
            themselves. That is, they need to parse the imported model and find
            the referenced microservice leveraging the
            :ref:`qualified name <link__MicroserviceReference_qualifiedName>` of
            this ``MicroserviceReference`` instance.

    .. py:attribute:: IntermediateMicroservice requiringMicroservice

        :java:type:`IntermediateMicroservice` that 
        :ref:`requires <link__IntermediateMicroservice_requiredMicroservices>`
        this microservice.

.. java:type:: class InterfaceReference

    Reference to a possibly imported 
    :java:type:`interface <IntermediateInterface>`.

    .. py:attribute:: String[1] name

        :ref:`Name <link__IntermediateInterface_name>` of the referenced
        interface.

    .. _link__InterfaceReference_qualifiedName:

    .. py:attribute:: String[1] qualifiedName

        :ref:`Qualified name <link__IntermediateInterface_qualifiedName>` of the
        referenced interface.

    .. _link__InterfaceReference_imported:

    .. py:attribute:: boolean imported

        Flag to indicate if the referenced interface was imported from another
        Service Model.

    .. py:attribute:: IntermediateImport import

        Link to the :java:type:`data_model:IntermediateImport` which points to
        the imported Service Model. If the 
        :ref:`imported <link__InterfaceReference_imported>` flag is ``true``
        this attribute contains a value. Otherwise it is ``null``.

    .. py:attribute:: IntermediateInterface localInterface

        Link to the referenced :java:type:`IntermediateInterface` in the same
        Service Model as the ``InterfaceReference``. If the 
        :ref:`imported <link__InterfaceReference_imported>` flag is ``true``
        this attribute is ``null``. Otherwise it contains a value.

        .. HINT::

            If the attribute is ``null``, i.e., the referenced interface is
            defined in another Service Model, model processors need to retrieve
            details of the referenced interface from the imported Service Model
            themselves. That is, they need to parse the imported model and find
            the referenced interface leveraging the
            :ref:`qualified name <link__InterfaceReference_qualifiedName>` of
            this ``InterfaceReference`` instance.

    .. py:attribute:: IntermediateMicroservice requiringMicroservice

        :java:type:`IntermediateMicroservice` that 
        :ref:`requires <link__IntermediateMicroservice_requiredInterfaces>`
        this interface.

.. java:type:: class OperationReference

    Reference to a possibly imported 
    :java:type:`operation <IntermediateOperation>`.

    .. py:attribute:: String[1] name

        :ref:`Name <link__IntermediateOperation_name>` of the referenced
        operation.

    .. _link__OperationReference_qualifiedName:

    .. py:attribute:: String[1] qualifiedName

        :ref:`Qualified name <link__IntermediateOperation_qualifiedName>` of the
        referenced operation.

    .. _link__OperationReference_imported:

    .. py:attribute:: boolean imported

        Flag to indicate if the referenced operation was imported from another
        Service Model.

    .. py:attribute:: IntermediateImport import

        Link to the :java:type:`data_model:IntermediateImport` which points to
        the imported Service Model. If the 
        :ref:`imported <link__OperationReference_imported>` flag is ``true``
        this attribute contains a value. Otherwise it is ``null``.

    .. py:attribute:: IntermediateOperation localOperation

        Link to the referenced :java:type:`IntermediateOperation` in the same
        Service Model as the ``OperationReference``. If the 
        :ref:`imported <link__OperationReference_imported>` flag is ``true``
        this attribute is ``null``. Otherwise it contains a value.

        .. HINT::

            If the attribute is ``null``, i.e., the referenced operation is
            defined in another Service Model, model processors need to retrieve
            details of the referenced operation from the imported Service Model
            themselves. That is, they need to parse the imported model and find
            the referenced operation leveraging the
            :ref:`qualified name <link__OperationReference_qualifiedName>` of
            this ``OperationReference`` instance.

    .. py:attribute:: IntermediateMicroservice requiringMicroservice

        :java:type:`IntermediateMicroservice` that 
        :ref:`requires <link__IntermediateMicroservice_requiredInterfaces>`
        this operation.

    .. py:attribute:: IntermediateParameter initializedParameter

        :java:type:`IntermediateParameter` that is :ref:`initialized by 
        <link__IntermediateParameter_initializedByOperation>`
        this operation.

Technologies
------------

In the following, concepts for assigning technologies to microservices and other
modeling concepts are described.

.. java:type:: class IntermediateTechnology

    Represents a Technology Model, which was assigned to an 
    :java:type:`IntermediateMicroservice`.

    .. py:attribute:: String[1] name

        Name of the source technology, e.g., "go" or "python" [#python]_.

    .. py:attribute:: IntermediateImport[1] import

        :java:type:`data_model:IntermediateImport` that points to the imported
        Technology Model.

    .. py:attribute:: IntermediateMicroservice microservice

        :java:type:`Microservice <IntermediateMicroservice>` to which the
        technology was assigned.

.. java:type:: class IntermediateImportedAspect

    Aspects enable to semantically reify modeled 
    :java:type:`microservices <IntermediateMicroservice>`,
    :java:type:`interfaces <IntermediateInterface>`,
    :java:type:`operations <IntermediateOperation>`,
    :java:type:`parameters <IntermediateParameter>`, and
    :java:type:`data fields <IntermediateMappedDataField>` in the sense of 
    Aspect-oriented Programming (AOP) :cite:`Kiczales1997`.

    Aspects are defined within Technology Models. An aspect definition might be
    accompanied with properties and constrained to the concepts to which they 
    apply. With this mechanism it is possible to create, e.g., aspects for HTTP 
    status codes being returned by a service operation's execution.

    .. py:attribute:: String[1] name

        Name of the aspect.

    .. py:attribute:: IntermediateImport[1] import

        :java:type:`Import <data_model:IntermediateImport>` of the Technology
        Model which defines the aspect.

    .. py:attribute:: IntermediateAspectProperty[*] properties

        All :java:type:`properties <IntermediateAspectProperty>` of the aspect 
        as defined in its Technology Model.

    .. py:attribute:: IntermediateAspectPropertyValue[*] propertyValues

        :java:type:`Values <IntermediateAspectPropertyValue>` for aspect 
        properties specified in the source Service Model.

    .. py:attribute:: IntermediateMicroservice microservice

        :java:type:`IntermediateMicroservice` to which the aspect was assigned.

    .. py:attribute:: IntermediateInterface interface

        :java:type:`IntermediateInterface` to which the aspect was assigned.

    .. py:attribute:: IntermediateOperation operation

        :java:type:`IntermediateOperation` to which the aspect was assigned.

    .. py:attribute:: IntermediateReferredOperation referredOperation

        :java:type:`IntermediateReferredOperation` to which the aspect was 
        assigned.

    .. py:attribute:: IntermediateParameter parameter

        :java:type:`IntermediateParameter` to which the aspect was assigned.

    .. py:attribute:: IntermediateMappedDataField mappedDataField

        :java:type:`IntermediateMappedDataField` to which the aspect was 
        assigned.

.. java:type:: class IntermediateAspectProperty

    Specification of an :java:type:`aspect's <IntermediateImportedAspect>` 
    property.

    .. py:attribute:: String[1] name
    
        Name of the property.

    .. _link__IntermediateAspectProperty_type:

    .. py:attribute:: String[1] type

        Name of the :ref:`primitive type 
        <data_model:link__IntermediatePrimitiveType>` of the property. This can
        be one of the values:

        - "boolean"
        - "byte"
        - "char"
        - "date"
        - "double"
        - "float"
        - "int"
        - "long"
        - "short"
        - "string"

    .. py:attribute:: String defaultValue

        If the property has a default value, it is encoded in this String 
        attribute. However, it is guaranteed that the default value fits the
        :ref:`type <link__IntermediateAspectProperty_type>` of the property by
        the Technology Modeling Language validator.

    .. py:attribute:: boolean mandatory

        Flag to indicate if the property needs to receive a value. It is 
        guaranteed by the Service Modeling Language that all mandatory values of
        a property receive a value when the respective 
        :java:type:`IntermediateImportedAspect` is used.

    .. py:attribute:: IntermediateImportedAspect aspect

        The :java:type:`aspect <IntermediateImportedAspect>` to which the
        property belongs.

.. java:type:: class IntermediateAspectPropertyValue

    Value of an :py:class`IntermediateAspectProperty`.

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
.. [#python] https://www.python.org

Indices and Tables
==================

* :ref:`genindex`
* :ref:`search`

References
==========

.. bibliography:: references.bib

.. _Domain-driven Microservice Design: https://github.com/frademacher/ddmm
