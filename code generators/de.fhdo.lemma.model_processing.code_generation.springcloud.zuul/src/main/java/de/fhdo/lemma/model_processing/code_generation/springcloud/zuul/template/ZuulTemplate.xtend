package de.fhdo.lemma.model_processing.code_generation.springcloud.zuul.template

import de.fhdo.lemma.operation.intermediate.IntermediateInfrastructureNode
import java.io.File

/**
 * Template class for generating operation node specific components.
 *
 * @author <a href="mailto:philip.wizenty@fh-dortmund.de">Philip Wizenty</a>
 */
class ZuulTemplate {
    /**
     * Kubernetes Deployment template for generating a Zuul deployment.
     */
    static def String getKubernetesDeploymentForZuul(IntermediateInfrastructureNode node)'''
        apiVersion: apps/v1
        kind: Deployment
        metadata:
          creationTimestamp: null
          labels:
            app: «node.name.toLowerCase»
          name: «node.name.toLowerCase»
        spec:
          replicas: 1
          selector:
            matchLabels:
              app: «node.name.toLowerCase»
          strategy: {}
          template:
            metadata:
              creationTimestamp: null
              labels:
                app: «node.name.toLowerCase»
            spec:
              containers:
              - image: «node.name.toLowerCase»
                imagePullPolicy: "Never"
                name: «node.name.toLowerCase»
                resources: {}
        status: {}
        ---
        apiVersion: v1
        kind: Service
        metadata:
          creationTimestamp: null
          labels:
            app: «node.name.toLowerCase»
          name: «node.name.toLowerCase»
        spec:
          ports:
          «FOR property : node.defaultValues»
            «IF(property.technologySpecificProperty.name.toLowerCase == "port")»
                  - name: "«property.value»"
                    port: «property.value»
                    targetPort: «property.value»
            «ENDIF»
          «ENDFOR»
          selector:
            app: «node.name.toLowerCase»
          type: ClusterIP
        status:
          loadBalancer: {}
    '''

    /**
     * Create Docker-Compose component for Zuul
     */
    static def String getDockerComposeForZuul(IntermediateInfrastructureNode node)'''
        «node.name.toLowerCase»:
          image: «node.name.toLowerCase»
          build: «node.name.toLowerCase + File.separator»
          container_name: «node.name.toLowerCase»
          «FOR property : node.defaultValues»
            «IF(property.technologySpecificProperty.name.toLowerCase == "port")»
                ports:
                  - "«property.value»:«property.value»"
          «ENDIF»
        «ENDFOR»
          networks:
            - default-network
    '''

    /**
     * Create a Spring-based application main class for Zuul in Kotlin
     */
    static def String generateZuulApplicationFileInKotlin(IntermediateInfrastructureNode node)'''
        «FOR property : node.defaultValues»
            «IF property.technologySpecificProperty.name.toLowerCase == "mavengroupid"»
                package «property.value.toLowerCase»
            «ENDIF»
        «ENDFOR»

        import org.springframework.boot.autoconfigure.SpringBootApplication
        import org.springframework.boot.runApplication
        import org.springframework.cloud.netflix.eureka.EnableEurekaClient
        import org.springframework.cloud.netflix.zuul.EnableZuulProxy

        @SpringBootApplication
        @EnableZuulProxy
        @EnableEurekaClient

        class «node.name.toFirstUpper»Application
        fun main(args: Array<String>) {
            runApplication<«node.name.toFirstUpper»Application>(*args)
        }
    '''

    /**
     * Create a Spring-based application main class for Zuul in Java
     */
    static def String generateZuulApplicationFileInJava(IntermediateInfrastructureNode node)'''
        «FOR property : node.defaultValues»
            «IF property.technologySpecificProperty.name.toLowerCase == "mavengroupid"»
                package «property.value.toLowerCase»;
            «ENDIF»
        «ENDFOR»

        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
        import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

        @SpringBootApplication
        @EnableEurekaServer
        @EnableEurekaClient
        public class «node.name.toFirstUpper»Application {
            public static void main(String[] args) {
                SpringApplication.run(«node.name.toFirstUpper»Application.class, args);
            }
        }
    '''

    /**
     * Create a Maven pom.xml file for Zuul and Kotlin
     */
    static def String generatePOMFileForKotlin(IntermediateInfrastructureNode node) '''
        <?xml version="1.0" encoding="UTF-8"?>
        <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
            <modelVersion>4.0.0</modelVersion>
            <parent>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-parent</artifactId>
                <version>2.2.4.RELEASE</version>
                <relativePath/> <!-- lookup parent from repository -->
            </parent>

        «FOR property : node.defaultValues»
            «IF property.technologySpecificProperty.name.toLowerCase == "mavengroupid"»
                «""»    <groupId>«property.value.toLowerCase»</groupId>
            «ENDIF»
        «ENDFOR»
        «FOR property : node.defaultValues»
            «IF property.technologySpecificProperty.name.toLowerCase == "mavenartifactid"»
                «""»    <artifactId>«property.value.toLowerCase»</artifactId>
            «ENDIF»
        «ENDFOR»
        «FOR property : node.defaultValues»
            «IF property.technologySpecificProperty.name.toLowerCase == "mavenversion"»
                «""»    <version>«property.value.toLowerCase»</version>
            «ENDIF»
        «ENDFOR»
        «FOR property : node.defaultValues»
            «IF property.technologySpecificProperty.name.toLowerCase == "mavenname"»
                «""»    <name>«property.value.toLowerCase»</name>
            «ENDIF»
        «ENDFOR»

            <properties>
                <java.version>11</java.version>
                <kotlin.version>1.3.61</kotlin.version>
                <spring-cloud.version>Hoxton.SR1</spring-cloud.version>
            </properties>

            <dependencies>
                <dependency>
                    <groupId>org.jetbrains.kotlin</groupId>
                    <artifactId>kotlin-reflect</artifactId>
                </dependency>
                <dependency>
                    <groupId>org.jetbrains.kotlin</groupId>
                    <artifactId>kotlin-stdlib-jdk8</artifactId>
                </dependency>
                <dependency>
                    <groupId>org.springframework.cloud</groupId>
                    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
                </dependency>
                <dependency>
                    <groupId>org.springframework.cloud</groupId>
                    <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
                </dependency>
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-test</artifactId>
                    <scope>test</scope>
                    <exclusions>
                        <exclusion>
                            <groupId>org.junit.vintage</groupId>
                            <artifactId>junit-vintage-engine</artifactId>
                        </exclusion>
                    </exclusions>
                </dependency>
            </dependencies>

            <dependencyManagement>
                <dependencies>
                    <dependency>
                        <groupId>org.springframework.cloud</groupId>
                        <artifactId>spring-cloud-dependencies</artifactId>
                        <version>${spring-cloud.version}</version>
                        <type>pom</type>
                        <scope>import</scope>
                    </dependency>
                </dependencies>
            </dependencyManagement>

            <build>
                <sourceDirectory>${project.basedir}/src/main/kotlin</sourceDirectory>
                <plugins>
                    <plugin>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-maven-plugin</artifactId>
                    </plugin>
                    <plugin>
                        <groupId>org.jetbrains.kotlin</groupId>
                        <artifactId>kotlin-maven-plugin</artifactId>
                        <configuration>
                            <args>
                                <arg>-Xjsr305=strict</arg>
                            </args>
                            <compilerPlugins>
                                <plugin>spring</plugin>
                            </compilerPlugins>
                        </configuration>
                        <dependencies>
                            <dependency>
                                <groupId>org.jetbrains.kotlin</groupId>
                                <artifactId>kotlin-maven-allopen</artifactId>
                                <version>${kotlin.version}</version>
                            </dependency>
                        </dependencies>
                    </plugin>
                </plugins>
            </build>

        </project>
    '''

    /**
     * Create a Maven pom.xml file for Zuul and Java
     */
    static def String generatePOMFileForJava(IntermediateInfrastructureNode node) '''
        <?xml version="1.0" encoding="UTF-8"?>
        <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                 xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
            <modelVersion>4.0.0</modelVersion>
            <parent>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-parent</artifactId>
                <version>2.2.4.RELEASE</version>
                <relativePath/> <!-- lookup parent from repository -->
            </parent>

        «FOR property : node.defaultValues»
            «IF property.technologySpecificProperty.name.toLowerCase == "mavengroupid"»
                «""»    <groupId>«property.value.toLowerCase»</groupId>
            «ENDIF»
        «ENDFOR»
        «FOR property : node.defaultValues»
            «IF property.technologySpecificProperty.name.toLowerCase == "mavenartifactid"»
                «""»    <artifactId>«property.value.toLowerCase»</artifactId>
            «ENDIF»
        «ENDFOR»
        «FOR property : node.defaultValues»
            «IF property.technologySpecificProperty.name.toLowerCase == "mavenversion"»
                «""»    <version>«property.value.toLowerCase»</version>
            «ENDIF»
        «ENDFOR»
        «FOR property : node.defaultValues»
            «IF property.technologySpecificProperty.name.toLowerCase == "mavenname"»
                «""»    <name>«property.value.toLowerCase»</name>
            «ENDIF»
        «ENDFOR»

            <properties>
                <java.version>11</java.version>
                <spring-cloud.version>Hoxton.SR3</spring-cloud.version>
                <maven.compiler.plugin.version>3.8.1</maven.compiler.plugin.version>
                <maven.compiler.source>11</maven.compiler.source>
                <maven.compiler.target>11</maven.compiler.target>
            </properties>

            <dependencies>
                <dependency>
                    <groupId>org.springframework.cloud</groupId>
                    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
                </dependency>
                <dependency>
                    <groupId>org.springframework.cloud</groupId>
                    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
                </dependency>
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-test</artifactId>
                    <scope>test</scope>
                    <exclusions>
                        <exclusion>
                            <groupId>org.junit.vintage</groupId>
                            <artifactId>junit-vintage-engine</artifactId>
                        </exclusion>
                    </exclusions>
                </dependency>
            </dependencies>

            <dependencyManagement>
                <dependencies>
                    <dependency>
                        <groupId>org.springframework.cloud</groupId>
                        <artifactId>spring-cloud-dependencies</artifactId>
                        <version>${spring-cloud.version}</version>
                        <type>pom</type>
                        <scope>import</scope>
                    </dependency>
                </dependencies>
            </dependencyManagement>

            <build>
                <plugins>
                    <plugin>
                        <groupId>org.apache.maven.plugins</groupId>
                        <artifactId>maven-compiler-plugin</artifactId>
                        <version>${maven.compiler.plugin.version}</version>
                    </plugin>
                    <plugin>
                        <groupId>org.springframework.boot</groupId>
                        <artifactId>spring-boot-maven-plugin</artifactId>
                    </plugin>
                </plugins>
            </build>

        </project>
    '''

    /**
     * Create application.properties file for Zuul
     */
    static def String generateApplicationPropertyFile(IntermediateInfrastructureNode node)'''
        spring.application.name=«node.name»
        «FOR property : node.defaultValues»
            «IF(property.technologySpecificProperty.name.toLowerCase == "port")»
                server.port=«property.value»
            «ENDIF»
            «IF(property.technologySpecificProperty.name.toLowerCase == "eurekauri")»
                eureka.client.serviceUrl.defaultZone=${EUREKA_URI:«property.value.toLowerCase»/eureka}
                eureka.instance.preferIpAddress=true
                eureka.client.registerWithEureka=true
                eureka.client.fetchRegistry=true
            «ENDIF»
        «ENDFOR»

        ribbon.ReadTimeout = 60000
        zuul.sensitive-headers=Cookie,Set-Cookie

        # Routes
        «FOR usedByNode : node.usedByNodes»
            zuul.routes.«usedByNode.name.toLowerCase».path=/«usedByNode.name.toUpperCase»/**
            zuul.routes.«usedByNode.name.toLowerCase»=«usedByNode.name.toUpperCase»
            zuul.routes.«usedByNode.name.toLowerCase».strip-prefix=true
        «ENDFOR»
    '''
}