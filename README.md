# Language Ecosystem for Modeling Microservice Architecture (LEMMA)

![Version](https://img.shields.io/github/tag/SeelabFhdo/lemma?label=version) ![Eclipse]( https://img.shields.io/badge/eclipse-%3E%3D%202018--12-green) ![License](https://img.shields.io/github/license/SeelabFhdo/lemma)

This repository contains the modeling languages, model transformations, and related artifacts of the Language Ecosystem for Modeling Microservice Architecture (LEMMA). LEMMA provides means for the model-driven development of distributed software systems following the Microservice Architecture approach. The conceptual foundations of the languages are described in several publications [1&ndash;3]. For information about the current version of LEMMA refer to the [Changelog](https://github.com/SeelabFhdo/ddmm/blob/master/CHANGELOG.md).

Please follow these steps if you want to try out LEMMA on the basis of the case study example described in [3]:
1. The easiest way to try out LEMMA is to download one of the prepackaged [releases](https://github.com/SeelabFhdo/lemma/releases) for your OS. Then clone the repository to your harddrive, run the ``eclipse`` executable, and go to step 11.  

   If you are interested in LEMMA's implementation, either download one of the prepackaged [releases](https://github.com/SeelabFhdo/lemma/releases) for your OS and go to step 4. Otherwise, if you instead want to setup your own Eclipse environment for both studying LEMMA's implementation and trying it out, download the [Eclipse IDE for Java and DSL Developers](https://www.eclipse.org/downloads/packages/release/2019-06/r/eclipse-ide-java-and-dsl-developers) first. Then continue with step 2.
2. Run the downloaded Eclipse package by starting the ``eclipse`` executable.
3. Install the [ATL Transformation Language](https://marketplace.eclipse.org/content/atl) from the Eclipse Marketplace in the downloaded Eclipse package.
4. Clone the repository to your harddrive.
5. In the popup dialog, choose an arbitrary workspace location on your harddrive and hit the ``Launch`` button.
6. In the IDE, choose the menu entry ``File > Open Projects from File System...``.
7. In the popup dialog, select the folder of the cloned repository as ``Import Source`` and deselect the ``Example`` entry in the folder list.
8. Click the ``Finish`` button, wait until the importing has completed, and switch to the Eclipse workbench.
9. Wait for any possibly running background tasks, e.g., ``Workspace Build``, to finish.
10. In the Package Explorer, right click on the project ``de.fhdo.lemma.servicedsl`` and choose the menu entry ``Run As > Eclipse Application`` from the context menu. If a new popup dialog with several "Launch Configurations" appears, hit ``OK``. A new Eclipse runtime environment is started.
11. In the started Eclipse runtime environment, choose the menu entry ``File > Open Projects from File System...``.
12. In the popup dialog, select the folder of the cloned repository as ``Import Source`` and deselect all entries in the folder list, except the one for the ``Example``.
13. Click the ``Finish`` button and wait until the importing has completed.

The example models are now available in the Project Explorer of the Eclipse runtime environment under the project "Example". The folders "domain", "microservices", "operation", and "technology" contain the complete models of the case study as described in [3]. Further example models may be found in the repository folders ``Example-2`` and ``Example-3``. Simply execute step 11 repeatedly in order to import them into your running Eclipse instance with the LEMMA plugins.

## References
[1] F. Rademacher, J. Sorgalla, S. Sachweh, and A. Zündorf, "A model-driven workflow for distributed microservice development," in Proceedings of the 34th Symposium On Applied Computing (SAC). ACM, 2019.

[2] F. Rademacher, J. Sorgalla, S. Sachweh, and A. Zündorf, "Viewpoint-specific model-driven microservice development with interlinked modeling languages,” in Proceedings of the 13th International Conference on Service-Oriented System Engineering (SOSE). IEEE, 2019.

[3] F. Rademacher, S. Sachweh, and A. Zündorf, "Aspect-oriented Modeling of Technology Heterogeneity in Microservice Architecture," in Proceedings of the 3rd International Conference on Software Architecture (ICSA; previously WICSA). IEEE, 2019.
