# Package de.fhdo.lemma.live_validation.protocol

This package encapsulates convenience methods for clients and servers to conform to the requirements of the [Language 
Server Protocol](https://microsoft.github.io/language-server-protocol/specification). These methods can be found for
- Live Validation clients as extension methods of [org.eclipse.lsp4j.services.LanguageServer](
https://github.com/eclipse/lsp4j/blob/master/org.eclipse.lsp4j/src/main/java/org/eclipse/lsp4j/services/LanguageServer.java)
in ``de.fhdo.lemma.live_validation.protocol.ClientProtocolImplKt``.
- Live Validation servers as extension methods of [org.eclipse.lsp4j.services.LanguageClient](
https://github.com/eclipse/lsp4j/blob/master/org.eclipse.lsp4j/src/main/java/org/eclipse/lsp4j/services/LanguageClient.java)
and ``de.fhdo.lemma.live_validation.protocol.LiveValidationLanguageClient`` in 
``de.fhdo.lemma.live_validation.protocol.ServerProtocolImplKt``.

Next to convenience methods, the package also bundles LSP extensions related to Live Validation (cf. 
``de.fhdo.lemma.live_validation.protocol.ExtensionsKt``).

The Live Validation mechanism uses the following protocol to establish a link between validation initiators and result
consumers (represented by implementers of ``de.fhdo.lemma.live_validation.clients.AbstractLiveValidationInitiator``), 
and validators and validation result producers (represented by implementers of 
``de.fhdo.lemma.live_validation.clients.AbstractLiveValidator``):

```
INITIALIZATION PHASE
--------------------
      AbstractLiveValidationInitiator      LiveValidationServer            LSP Extension?      Comment
I1)   Initialize Request              --->                                       no
I2)                                   <--- InitializeResult                      no
I3)   Initialized Notification        --->                                       no
I4)                                   <--- RegisterValidator Request             yes
I5)   Null Register Validator         --->                                       yes           Response identifies file
      Response                                                                                 formats supported by
                                                                                               validators, otherwise null

      AbstractLiveValidator                LiveValidationServer
V1)   Initialize Request              --->                                       no
V2)                                   <--- InitializeResult                      no
V3)   Initialized Notification        --->                                       no
V4)                                   <--- RegisterValidator Request             yes
V5)   RegisterValidator Response      --->                                       yes           Server keeps track of
      with supported file formats                                                              registered validators and
      (identified by file extensions)                                                          their supported formats

      
VALIDATION PHASE
-----------------
      AbstractLiveValidationInitiator      LiveValidationServer            LSP Extension?      Comment
I6)   DidChangeTextDocument           --->                                       no            Always sends full source
      Notification                                                                             code (TextDocumentSyncKind
                                                                                               = Full)
                                                                                               
      AbstractLiveValidator                LiveValidationServer
V6)                                   <--- PerformValidation Request             yes           Server queries all registered
                                                                                               validators that support the
                                                                                               file format identified by
                                                                                               the extension of the 
                                                                                               textDocument.uri in the
                                                                                               DidChangeTextDocumentParams
                                                                                               structure (cf. step I6)
V7)   PerformValidation Response      --->                                       yes           cf. de.fhdo.lemma.live_validation
      (list of IssueDiagnostics)                                                               .common.IssueDiagnostic
      
      AbstractLiveValidationInitiator      LiveValidationServer
I7)                                   <--- PublishIssues Notification            yes           Notifies the validation
                                                                                               initiator about the
                                                                                               validation results 
                                                                                               gathered in step V7

DISCONNECT PHASE
----------------
The disconnect phase uses the same pattern as LSP's Shutdown Request and Exit Notification. By contrast, however, not
the server is shut down, but a client informs the server that it is about to disconnect and won't initiate or perform
validations anymore.

       Any Live Validation client           LiveValidationServer            LSP Extension?      Comment
I/V8)  Disconnect Request              --->                                       yes
I/V9)                                  <--- Disconnect Response (void)            yes         
I/V9)  Bye Notification                --->                                       yes            Remove validators from
                                                                                                 internal map of file
                                                                                                 format --> validators
```