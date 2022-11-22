<h1 align="center">LEMMA</h1>

<div align="center">
  <strong>A Language Ecosystem for Modeling Microservice Architecture</strong>
</div>
<div align="center">
  Facilitating the design :memo: development :wrench: and deployment :ship: of complex microservice architectures<br/> with Model-driven Engineering
</div>

<br />

<div align="center">
  <!-- Version -->
  <a href="https://img.shields.io/github/tag/SeelabFhdo/lemma?label=version">
    <img src="https://img.shields.io/github/tag/SeelabFhdo/lemma?label=version&style=flat-square"
      alt="Version" />
  </a>
  <!-- Build -->
  <a href="https://build.seelab.fh-dortmund.de/job/SeelabFhdo/job/lemma/job/main/">
    <img src="https://build.seelab.fh-dortmund.de/buildStatus/icon?job=SeelabFhdo%2Flemma%2Fmain&style=flat-square"
      alt="Build" />
  </a>
  <!-- Eclipse -->
  <a href="https://img.shields.io/badge/eclipse-%3E%3D%202021--03-green">
    <img src="https://img.shields.io/badge/eclipse-%3E%3D%202021--03-green?style=flat-square"
      alt="Eclipse" />
  </a>
  <!-- License -->
  <a href="(https://img.shields.io/github/license/SeelabFhdo/lemma">
    <img src="https://img.shields.io/github/license/SeelabFhdo/lemma?style=flat-square"
      alt="Standard" />
  </a>
</div>

<div align="center">
  <sub>Built with ❤︎ by
  <a href="https://github.com/frademacher">Florian Rademacher</a> and
  <a href="https://github.com/SeelabFhdo/lemma/graphs/contributors">
    contributors
  </a>
</div>

## Table of Contents
- [Features](#features)
- [Installation](#installation)
- [Examples](#examples)
- [Documentation](#documentation)
- [Changelog](#changelog)
- [Science](#science)
- [Contributors](#contributors)
- [License](#license)

## Features
- **model-driven:** abstract the complexity of microservice architectures with the power of [Model-driven Engineering](https://en.wikipedia.org/wiki/Model-driven_engineering)
- **collaborative:** provide concern-oriented, integrated modeling languages for stakeholder groups of microservice architectures ranging from domain experts to microservice developers and operators
- **practice-oriented:** aligned to the requirements of real-world microservice architectures including distributed development, DevOps-based teams, and technology heterogeneity
- **broad applicability:** LEMMA has been used for, e.g., (i) the translation of [domain-driven microservice designs into implementations](https://ieeexplore.ieee.org/document/9226287); (ii) [architecture recovery and quality attribute analysis](https://link.springer.com/chapter/10.1007/978-3-030-49418-6_21); and (iii) [microservice code generation](https://link.springer.com/chapter/10.1007/978-3-030-31646-4_7)
- **IDE support:** thanks to the [Eclipse ecosystem](https://www.eclipse.org) LEMMA comes with dedicated editors including syntax highlighting, code completion, and as-you-type validation
- **designed for extensibility:** interested in extending LEMMA with your own super cool framework for microservice development or deployment? drop us an [e-mail](mailto:florian.rademacher@fh-dortmund.de)

## Installation
LEMMA works with any Eclipse version greater or equal 2021-03, and can be installed using a dedicated Eclipse updatesite or a set of Eclipse dropins.

### Updatesite
You can install LEMMA from a running Eclipse instance via the following Eclipse updatesite: [https://microservices.fh-dortmund.de/lemma/](https://microservices.fh-dortmund.de/lemma/).

### Dropins
As an alternative to the Eclipse updatesite, you may also download the LEMMA Eclipse plugins for its latest release as a set of Eclipse dropins. You can find these dropins as an asset of [LEMMA's latest release on GitHub](https://github.com/SeelabFhdo/lemma/releases). However, in this case you will also need to manually install the Eclipse plugins for the [ATL Transformation Language and EMFTVM](https://www.eclipse.org/atl/) version 4.5 or greater. The corresponding Eclipse updatesite is available here: [https://download.eclipse.org/mmt/atl/updates/releases/](https://download.eclipse.org/mmt/atl/updates/releases/).

## Examples
We provide several examples for using LEMMA to describe coherent (parts of) microservice architectures including their domain data, microservice APIs, and operation. You can find these examples on GitHub:
- [Charging Station Management Example](https://github.com/SeelabFhdo/lemma/tree/main/examples/charging-station-management)
- [Parking Space Example](https://github.com/SeelabFhdo/lemma/tree/main/examples/parking-spaces)
- [E-Vehicle Charging Example](https://github.com/SeelabFhdo/lemma/tree/main/examples/e-vehicle-charging)
- [Food to Go Example](https://github.com/SeelabFhdo/lemma/tree/main/examples/food-to-go)
- [Insurance Company Example](https://github.com/SeelabFhdo/lemma/tree/main/examples/insurance-company)

## Documentation
The LEMMA documentation can be found at [https://seelabfhdo.github.io/lemma-docs](https://seelabfhdo.github.io/lemma-docs). The documentation is currently work in progress but will receive updates on a regular basis. For example, it already contains a comprehensive installation guideline and a quick tour!

## Changelog
For information about the current version of LEMMA please refer to its [Changelog](https://github.com/SeelabFhdo/lemma/blob/main/CHANGELOG.md).

## Science
LEMMA has its roots in Software Engineering research, and more specifically in the Software Architecture and Model-driven Engineering research communities. Thus, there are several papers that concern LEMMA's design and its application:

### 2022
- Rademacher, Florian ["A Language Ecosystem for Modeling Microservice Architecture."](https://kobra.uni-kassel.de/handle/123456789/14176) PhD Thesis. Department of Electrical Engineering and Computer Science, University of Kassel.
- Rademacher, Florian, et al. ["Towards an Extensible Approach for Generative Microservice Development and Deployment Using LEMMA."](https://link.springer.com/chapter/10.1007/978-3-031-15116-3_12) Software Architecture (ECSA 2021). Springer, 2022.
- Giallorenzo, Saverio, et al. ["Model-Driven Generation of Microservice Interfaces: From LEMMA Domain Models to Jolie APIs."](https://link.springer.com/chapter/10.1007/978-3-031-08143-9_13) Coordination Models and Languages (COORDINATION 2022). Springer, 2021. 276-284.

### 2021
- Giallorenzo, Saverio, et al. ["Jolie and LEMMA: Model-Driven Engineering and Programming Languages Meet on Microservices."](https://link.springer.com/chapter/10.1007/978-3-030-78142-2_17) Coordination Models and Languages (COORDINATION 2021). Springer, 2021. 276-284.
- Rademacher, Florian, et al. ["Towards Holistic Modeling of Microservice Architectures Using LEMMA."](http://ceur-ws.org/Vol-2978/mde4sa-paper2.pdf) Companion Proceedings of the 15th European Conference on Software Architecture 2021. CEUR-WS, 2021.
- Sorgalla, Jonas, et al. ["Applying Model-Driven Engineering to Stimulate the Adoption of DevOps Processes in Small and Medium-Sized Development Organizations."](https://link.springer.com/article/10.1007/s42979-021-00825-z) SN Computer Science. Springer, 2021.

### 2020
- Rademacher, Florian, et al. ["Graphical and textual model-driven microservice development."](https://link.springer.com/chapter/10.1007/978-3-030-31646-4_7) Microservices. Springer, 2020. 147-179.
- Rademacher, Florian, Sabine Sachweh, and Albert Zündorf. ["Deriving Microservice Code from Underspecified Domain Models Using DevOps-Enabled Modeling Languages and Model Transformations."](https://ieeexplore.ieee.org/abstract/document/9226287) 2020 46th Euromicro Conference on Software Engineering and Advanced Applications (SEAA). IEEE, 2020.
- Rademacher, Florian, Sabine Sachweh, and Albert Zündorf. ["A Modeling Method for Systematic Architecture Reconstruction of Microservice-Based Software Systems."](https://link.springer.com/chapter/10.1007/978-3-030-49418-6_21) Enterprise, Business-Process and Information Systems Modeling. Springer, 2020. 311-326.
- Sorgalla, Jonas, et al. ["Modeling microservice architecture: a comparative experiment towards the effectiveness of two approaches."](https://dl.acm.org/doi/abs/10.1145/3341105.3374065) Proceedings of the 35th Annual ACM Symposium on Applied Computing. 2020.
- Sorgalla, Jonas, et al. ["Model-driven Development of Microservice Architecture: An Experiment on the Quality in Use of a UML-and a DSL-based Approach."](https://kobra.uni-kassel.de/handle/123456789/11912) (2020).
- Sorgalla, Jonas, Sabine Sachweh, and Albert Zündorf. ["Exploring the Microservice Development Process in Small and Medium-Sized Organizations"](https://link.springer.com/chapter/10.1007/978-3-030-64148-1_28) Product-Focused Software Process Improvement. Springer, 2020. 453-460.

### 2019
- Rademacher, Florian, Sabine Sachweh, and Albert Zündorf. ["Aspect-oriented modeling of technology heterogeneity in microservice architecture."](https://ieeexplore.ieee.org/abstract/document/8703913) 2019 IEEE International Conference on Software Architecture (ICSA). IEEE, 2019.
- Rademacher, Florian, et al. ["A model-driven workflow for distributed microservice development."](https://dl.acm.org/doi/abs/10.1145/3297280.3300182) Proceedings of the 34th ACM/SIGAPP Symposium on Applied Computing. 2019.
- Rademacher, Florian, et al. ["Microservice architecture and model-driven development: yet singles, soon married (?)."](https://dl.acm.org/doi/abs/10.1145/3234152.3234193) Proceedings of the 19th International Conference on Agile Software Development: Companion. 2018.

### 2018
- Rademacher, Florian, Jonas Sorgalla, and Sabine Sachweh. ["Challenges of domain-driven microservice design: a model-driven perspective."](https://ieeexplore.ieee.org/abstract/document/8354426) IEEE Software 35.3 (2018): 36-43.
- Sorgalla, Jonas, et al. ["Collaborative model-driven software engineering and microservice architecture: a perfect match?."](https://dl.acm.org/doi/abs/10.1145/3234152.3234194) Proceedings of the 19th International Conference on Agile Software Development: Companion. 2018.

### 2017
- Rademacher, Florian, Sabine Sachweh, and Albert Zündorf. ["Differences between model-driven development of service-oriented and microservice architecture."](https://ieeexplore.ieee.org/abstract/document/7958454) 2017 IEEE International Conference on Software Architecture Workshops (ICSAW). IEEE, 2017.
- Rademacher, Florian, Sabine Sachweh, and Albert Zündorf. ["Towards a UML profile for domain-driven design of microservice architectures."](https://link.springer.com/chapter/10.1007/978-3-319-74781-1_17) International Conference on Software Engineering and Formal Methods. Springer, 2017.

## Contributors
Kudos to all LEMMA contributors :tada::tada::tada:

<a href="https://github.com/SeelabFhdo/lemma/graphs/contributors">
    <img src="https://contributors-img.web.app/image?repo=SeelabFhdo/lemma" />
</a>

## License
[MIT](https://github.com/SeelabFhdo/lemma/blob/main/LICENSE)