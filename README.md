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
  <a href="https://build.seelab.fh-dortmund.de/job/SeelabFhdo/job/lemma/job/master/">
    <img src="https://build.seelab.fh-dortmund.de/buildStatus/icon?job=SeelabFhdo%2Flemma%2Fmaster&style=flat-square"
      alt="Build" />
  </a>
  <!-- Eclipse -->
  <a href="https://img.shields.io/badge/eclipse-%3E%3D%202020--03-green">
    <img src="https://img.shields.io/badge/eclipse-%3E%3D%202020--03-green?style=flat-square"
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
- [Changelog](#changelog)
- [Science](#science)
- [Contributors](#contributors)
- [License](#license)

## Features
- **model-driven:** abstract the complexity of microservice architectures with the power of [Model-driven Engineering](https://en.wikipedia.org/wiki/Model-driven_engineering)
- **collaborative:** provide concern-oriented, integrated modeling languages for stakeholder groups of microservice architectures ranging from domain experts to microservice developers and operators
- **practice-oriented:** aligned to the requirements of real-world microservice architectures including distributed development, DevOps-based teams, and technology heterogeneity
- **broad applicability:** LEMMA has been used to translate [domain-driven microservice designs into implementations](https://ieeexplore.ieee.org/document/9226287), [architecture recovery and quality attribute analysis](https://link.springer.com/chapter/10.1007/978-3-030-49418-6_21), and [microservice code generation](https://link.springer.com/chapter/10.1007/978-3-030-31646-4_7)
- **IDE support:** thanks to the [Eclipse ecosystem](https://www.eclipse.org) LEMMA comes with dedicated editors including syntax highlighting, code completion, and as-you-type validation
- **designed for extensibility:** interested in extending LEMMA with your own super cool framework for microservice development or deployment? drop us an [e-mail](mailto:florian.rademacher@fh-dortmund.de)

## Installation
LEMMA works with any Eclipse version greater or equal 2020-03. However, your Eclipse installation must meet the following [prerequisites](#prerequisites). If it does, you can either install LEMMA's latest release from its Eclipse updatesite or as a set of dropins.

### Prerequisites
- Optional: To leverage LEMMA's model processors, LEMMA requires the installation of the Eclipse plugins for the [ATL Transformation Language and EMFTVM](https://www.eclipse.org/atl/). You may install `ATL/EMFTVM`, e.g., from the [Eclipse Marketplace](https://marketplace.eclipse.org/content/atlemftvm).

### Updatesite
You can install LEMMA from a running Eclipse instance via the following Eclipse updatesite: https://microservices.fh-dortmund.de/lemma/.

### Dropins
As an alternative to the Eclipse updatesite, you may also download the LEMMA Eclipse plugins for its latest release as a set of Eclipse dropins. You can find these dropins as an asset of [LEMMA's latest release on GitHub](https://github.com/SeelabFhdo/lemma/releases).

## Examples
We provide three examples in the form of a set of LEMMA models that describe coherent microservice architectures including their domain data, microservice APIs, and their operation. You can find the modeling examples on GitHub:
- [Parking Space Example](https://github.com/SeelabFhdo/lemma/tree/master/examples/parking-spaces)
- [E-Vehicle Charging Example](https://github.com/SeelabFhdo/lemma/tree/master/examples/e-vehicle-charging)
- [Insurance Company Example](https://github.com/SeelabFhdo/lemma/tree/master/examples/insurance-company)

We are also currently working on a comprehensive documentation for LEMMA not only including the application of its modeling languages but also the usage and development of custom model processors. Stay tuned! :guitar:

## Changelog
For information about the current version of LEMMA please refer to its [Changelog](https://github.com/SeelabFhdo/lemma/blob/master/CHANGELOG.md).

## Science
LEMMA has its roots in Software Engineering research, and more specifically in the Software Architecture and Model-driven Engineering research communities. Thus, there are several papers that concern LEMMA's design and its application:

### 2020
- Rademacher, Florian, et al. ["Graphical and textual model-driven microservice development."](https://link.springer.com/chapter/10.1007/978-3-030-31646-4_7) Microservices. Springer, Cham, 2020. 147-179.
- Rademacher, Florian, Sabine Sachweh, and Albert Zündorf. ["Deriving Microservice Code from Underspecified Domain Models Using DevOps-Enabled Modeling Languages and Model Transformations."](https://ieeexplore.ieee.org/abstract/document/9226287) 2020 46th Euromicro Conference on Software Engineering and Advanced Applications (SEAA). IEEE, 2020.
- Rademacher, Florian, Sabine Sachweh, and Albert Zündorf. ["A Modeling Method for Systematic Architecture Reconstruction of Microservice-Based Software Systems."](https://link.springer.com/chapter/10.1007/978-3-030-49418-6_21) Enterprise, Business-Process and Information Systems Modeling. Springer, Cham, 2020. 311-326.
- Sorgalla, Jonas, et al. ["Modeling microservice architecture: a comparative experiment towards the effectiveness of two approaches."](https://dl.acm.org/doi/abs/10.1145/3341105.3374065) Proceedings of the 35th Annual ACM Symposium on Applied Computing. 2020.
- Sorgalla, Jonas, et al. ["Model-driven Development of Microservice Architecture: An Experiment on the Quality in Use of a UML-and a DSL-based Approach."](https://kobra.uni-kassel.de/handle/123456789/11912) (2020).

### 2019
- Rademacher, Florian, Sabine Sachweh, and Albert Zündorf. ["Aspect-oriented modeling of technology heterogeneity in microservice architecture."](https://ieeexplore.ieee.org/abstract/document/8703913) 2019 IEEE International Conference on Software Architecture (ICSA). IEEE, 2019.
- Rademacher, Florian, et al. ["A model-driven workflow for distributed microservice development."](https://dl.acm.org/doi/abs/10.1145/3297280.3300182) Proceedings of the 34th ACM/SIGAPP Symposium on Applied Computing. 2019.
- Rademacher, Florian, et al. ["Microservice architecture and model-driven development: yet singles, soon married (?)."](https://dl.acm.org/doi/abs/10.1145/3234152.3234193) Proceedings of the 19th International Conference on Agile Software Development: Companion. 2018.

### 2018
- Rademacher, Florian, Jonas Sorgalla, and Sabine Sachweh. ["Challenges of domain-driven microservice design: a model-driven perspective."](https://ieeexplore.ieee.org/abstract/document/8354426) IEEE Software 35.3 (2018): 36-43.
- Sorgalla, Jonas, et al. ["Collaborative model-driven software engineering and microservice architecture: a perfect match?."](https://dl.acm.org/doi/abs/10.1145/3234152.3234194) Proceedings of the 19th International Conference on Agile Software Development: Companion. 2018.

### 2017
- Rademacher, Florian, Sabine Sachweh, and Albert Zündorf. ["Differences between model-driven development of service-oriented and microservice architecture."](https://ieeexplore.ieee.org/abstract/document/7958454) 2017 IEEE International Conference on Software Architecture Workshops (ICSAW). IEEE, 2017.
- Rademacher, Florian, Sabine Sachweh, and Albert Zündorf. ["Towards a UML profile for domain-driven design of microservice architectures."](https://link.springer.com/chapter/10.1007/978-3-319-74781-1_17) International Conference on Software Engineering and Formal Methods. Springer, Cham, 2017.

## Contributors
Kudos to all LEMMA contributors :tada::tada::tada:

<a href="https://github.com/SeelabFhdo/lemma/graphs/contributors">
    <img src="https://contributors-img.web.app/image?repo=SeelabFhdo/lemma" />
</a>

## License
[MIT](https://github.com/SeelabFhdo/lemma/blob/master/LICENSE)
