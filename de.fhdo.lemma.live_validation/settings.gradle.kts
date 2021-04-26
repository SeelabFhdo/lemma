rootProject.name = "de.fhdo.lemma.live_validation"
include("util")
include("model")
include("protocol")
include("client")
include("server")
project(":util").name = "${rootProject.name}.util"
project(":model").name = "${rootProject.name}.model"
project(":protocol").name = "${rootProject.name}.protocol"
project(":client").name = "${rootProject.name}.client"
project(":server").name = "${rootProject.name}.server"