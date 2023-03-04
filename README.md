# java-newrelic-buildpack
Spring boot example app with new relic build pack integration


# How to reproduce the issue

Run following maven goal to build the spring boot docker image
```bash
mvn spring-boot:build-image
```
You should see following error log in your console.
```text
[INFO] --- spring-boot:3.0.4:build-image (default-cli) @ java-newrelic-buildpack ---
[INFO] Building image 'docker.io/library/java-newrelic-buildpack:0.0.1-SNAPSHOT'
[INFO]
[INFO]  > Pulling builder image 'docker.io/paketobuildpacks/builder:base' 100%
[INFO]  > Pulled builder image 'paketobuildpacks/builder@sha256:96a0c8fbf85a3205cf8b1073382b6f54f57c7a2a776b59a336ae0db4380908b8'
[INFO]  > Pulling run image 'docker.io/paketobuildpacks/run:base-cnb' 100%
[INFO]  > Pulled run image 'paketobuildpacks/run@sha256:dec5146cd16049064246308ee633ab451ccb8c8e7e0ec595727ea12d3719a006'
[INFO]  > Pulling buildpack image 'gcr.io/paketo-buildpacks/java:latest' 100%
[INFO]  > Pulled buildpack image 'gcr.io/paketo-buildpacks/java@sha256:c9a201f0df1460cd2c32e4d05b470c5ce4eef153dfc384a937ebbbc18913f7ef'
[INFO]  > Pulling buildpack image 'gcr.io/paketo-buildpacks/new-relic:latest' 100%
[INFO]  > Pulled buildpack image 'gcr.io/paketo-buildpacks/new-relic@sha256:c7abff91a770aeb6a384095afdcaae88cf7ab3dbbe0a5627031433469eebcd7f'
[INFO]  > Executing lifecycle version v0.16.0
[INFO]  > Using build cache volume 'pack-cache-c854ec95a5c6.build'
[INFO]
[INFO]  > Running creator
[INFO]     [creator]     ===> ANALYZING
[INFO]     [creator]     Restoring data for SBOM from previous image
[INFO]     [creator]     ===> DETECTING
[INFO]     [creator]     8 of 27 buildpacks participating
[INFO]     [creator]     paketo-buildpacks/ca-certificates   3.6.0
[INFO]     [creator]     paketo-buildpacks/bellsoft-liberica 9.11.0
[INFO]     [creator]     paketo-buildpacks/node-engine       1.2.1
[INFO]     [creator]     paketo-buildpacks/syft              1.25.0
[INFO]     [creator]     paketo-buildpacks/executable-jar    6.6.1
[INFO]     [creator]     paketo-buildpacks/dist-zip          5.5.1
[INFO]     [creator]     paketo-buildpacks/spring-boot       5.23.0
[INFO]     [creator]     paketo-buildpacks/new-relic         5.7.0
[INFO]     [creator]     ===> RESTORING
[INFO]     [creator]     Restoring metadata for "paketo-buildpacks/ca-certificates:helper" from app image
[INFO]     [creator]     Restoring metadata for "paketo-buildpacks/bellsoft-liberica:jre" from app image
[INFO]     [creator]     Restoring metadata for "paketo-buildpacks/bellsoft-liberica:helper" from app image
[INFO]     [creator]     Restoring metadata for "paketo-buildpacks/bellsoft-liberica:java-security-properties" from app image
[INFO]     [creator]     Restoring metadata for "paketo-buildpacks/syft:syft" from cache
[INFO]     [creator]     Restoring metadata for "paketo-buildpacks/spring-boot:web-application-type" from app image
[INFO]     [creator]     Restoring metadata for "paketo-buildpacks/new-relic:helper" from app image
[INFO]     [creator]     Restoring metadata for "paketo-buildpacks/new-relic:new-relic-java" from app image
[INFO]     [creator]     Restoring data for "paketo-buildpacks/syft:syft" from cache
[INFO]     [creator]     Restoring data for SBOM from cache
[INFO]     [creator]     ===> BUILDING
[INFO]     [creator]
[INFO]     [creator]     Paketo Buildpack for CA Certificates 3.6.0
[INFO]     [creator]       https://github.com/paketo-buildpacks/ca-certificates
[INFO]     [creator]       Launch Helper: Contributing to layer
[INFO]     [creator]         Creating /layers/paketo-buildpacks_ca-certificates/helper/exec.d/ca-certificates-helper
[INFO]     [creator]
[INFO]     [creator]     Paketo Buildpack for BellSoft Liberica 9.11.0
[INFO]     [creator]       https://github.com/paketo-buildpacks/bellsoft-liberica
[INFO]     [creator]       Build Configuration:
[INFO]     [creator]         $BP_JVM_JLINK_ARGS           --no-man-pages --no-header-files --strip-debug --compress=1  configure custom link arguments (--output must be omitted)
[INFO]     [creator]         $BP_JVM_JLINK_ENABLED        false                                                        enables running jlink tool to generate custom JRE
[INFO]     [creator]         $BP_JVM_TYPE                 JRE                                                          the JVM type - JDK or JRE
[INFO]     [creator]         $BP_JVM_VERSION              17.*                                                         the Java version
[INFO]     [creator]       Launch Configuration:
[INFO]     [creator]         $BPL_DEBUG_ENABLED           false                                                        enables Java remote debugging support
[INFO]     [creator]         $BPL_DEBUG_PORT              8000                                                         configure the remote debugging port
[INFO]     [creator]         $BPL_DEBUG_SUSPEND           false                                                        configure whether to suspend execution until a debugger has attached
[INFO]     [creator]         $BPL_HEAP_DUMP_PATH                                                                       write heap dumps on error to this path
[INFO]     [creator]         $BPL_JAVA_NMT_ENABLED        true                                                         enables Java Native Memory Tracking (NMT)
[INFO]     [creator]         $BPL_JAVA_NMT_LEVEL          summary                                                      configure level of NMT, summary or detail
[INFO]     [creator]         $BPL_JFR_ARGS                                                                             configure custom Java Flight Recording (JFR) arguments
[INFO]     [creator]         $BPL_JFR_ENABLED             false                                                        enables Java Flight Recording (JFR)
[INFO]     [creator]         $BPL_JMX_ENABLED             false                                                        enables Java Management Extensions (JMX)
[INFO]     [creator]         $BPL_JMX_PORT                5000                                                         configure the JMX port
[INFO]     [creator]         $BPL_JVM_HEAD_ROOM           0                                                            the headroom in memory calculation
[INFO]     [creator]         $BPL_JVM_LOADED_CLASS_COUNT  35% of classes                                               the number of loaded classes in memory calculation
[INFO]     [creator]         $BPL_JVM_THREAD_COUNT        250                                                          the number of threads in memory calculation
[INFO]     [creator]         $JAVA_TOOL_OPTIONS                                                                        the JVM launch flags
[INFO]     [creator]         Using Java version 17.* from BP_JVM_VERSION
[INFO]     [creator]       BellSoft Liberica JRE 17.0.6: Reusing cached layer
[INFO]     [creator]       Launch Helper: Contributing to layer
[INFO]     [creator]         Creating /layers/paketo-buildpacks_bellsoft-liberica/helper/exec.d/active-processor-count
[INFO]     [creator]         Creating /layers/paketo-buildpacks_bellsoft-liberica/helper/exec.d/java-opts
[INFO]     [creator]         Creating /layers/paketo-buildpacks_bellsoft-liberica/helper/exec.d/jvm-heap
[INFO]     [creator]         Creating /layers/paketo-buildpacks_bellsoft-liberica/helper/exec.d/link-local-dns
[INFO]     [creator]         Creating /layers/paketo-buildpacks_bellsoft-liberica/helper/exec.d/memory-calculator
[INFO]     [creator]         Creating /layers/paketo-buildpacks_bellsoft-liberica/helper/exec.d/security-providers-configurer
[INFO]     [creator]         Creating /layers/paketo-buildpacks_bellsoft-liberica/helper/exec.d/jmx
[INFO]     [creator]         Creating /layers/paketo-buildpacks_bellsoft-liberica/helper/exec.d/jfr
[INFO]     [creator]         Creating /layers/paketo-buildpacks_bellsoft-liberica/helper/exec.d/security-providers-classpath-9
[INFO]     [creator]         Creating /layers/paketo-buildpacks_bellsoft-liberica/helper/exec.d/debug-9
[INFO]     [creator]         Creating /layers/paketo-buildpacks_bellsoft-liberica/helper/exec.d/nmt
[INFO]     [creator]         Creating /layers/paketo-buildpacks_bellsoft-liberica/helper/exec.d/openssl-certificate-loader
[INFO]     [creator]       Java Security Properties: Contributing to layer
[INFO]     [creator]         Writing env.launch/JAVA_SECURITY_PROPERTIES.default
[INFO]     [creator]         Writing env.launch/JAVA_TOOL_OPTIONS.append
[INFO]     [creator]         Writing env.launch/JAVA_TOOL_OPTIONS.delim
[INFO]     [creator]     Paketo Buildpack for Node Engine 1.2.1
[INFO]     [creator]       Resolving Node Engine version
[INFO]     [creator]         Candidate version sources (in priority order):
[INFO]     [creator]           <unknown> -> ""
[INFO]     [creator]
[INFO]     [creator]         Selected Node Engine version (using <unknown>): 18.14.1
[INFO]     [creator]
[INFO]     [creator]       Executing build process
[INFO]     [creator]         Installing Node Engine 18.14.1
[INFO]     [creator]           Completed in 7.958s
[INFO]     [creator]
[INFO]     [creator]       Generating SBOM for /layers/paketo-buildpacks_node-engine/node
[INFO]     [creator]           Completed in 0s
[INFO]     [creator]
[INFO]     [creator]       Configuring build environment
[INFO]     [creator]         NODE_ENV     -> "production"
[INFO]     [creator]         NODE_HOME    -> "/layers/paketo-buildpacks_node-engine/node"
[INFO]     [creator]         NODE_OPTIONS -> "--use-openssl-ca"
[INFO]     [creator]         NODE_VERBOSE -> "false"
[INFO]     [creator]
[INFO]     [creator]       Configuring launch environment
[INFO]     [creator]         NODE_ENV     -> "production"
[INFO]     [creator]         NODE_HOME    -> "/layers/paketo-buildpacks_node-engine/node"
[INFO]     [creator]         NODE_OPTIONS -> "--use-openssl-ca"
[INFO]     [creator]         NODE_VERBOSE -> "false"
[INFO]     [creator]
[INFO]     [creator]         Writing exec.d/0-optimize-memory
[INFO]     [creator]           Calculates available memory based on container limits at launch time.
[INFO]     [creator]           Made available in the MEMORY_AVAILABLE environment variable.
[INFO]     [creator]
[INFO]     [creator]
[INFO]     [creator]     Paketo Buildpack for Syft 1.25.0
[INFO]     [creator]       https://github.com/paketo-buildpacks/syft
[INFO]     [creator]         Downloading from https://github.com/anchore/syft/releases/download/v0.73.0/syft_0.73.0_linux_amd64.tar.gz
[INFO]     [creator]         Verifying checksum
[INFO]     [creator]         Writing env.build/SYFT_CHECK_FOR_APP_UPDATE.default
[INFO]     [creator]
[INFO]     [creator]     Paketo Buildpack for Executable JAR 6.6.1
[INFO]     [creator]       https://github.com/paketo-buildpacks/executable-jar
[INFO]     [creator]       Class Path: Contributing to layer
[INFO]     [creator]         Writing env/CLASSPATH.delim
[INFO]     [creator]         Writing env/CLASSPATH.prepend
[INFO]     [creator]       Process types:
[INFO]     [creator]         executable-jar: java org.springframework.boot.loader.JarLauncher (direct)
[INFO]     [creator]         task:           java org.springframework.boot.loader.JarLauncher (direct)
[INFO]     [creator]         web:            java org.springframework.boot.loader.JarLauncher (direct)
[INFO]     [creator]
[INFO]     [creator]     Paketo Buildpack for Spring Boot 5.23.0
[INFO]     [creator]       https://github.com/paketo-buildpacks/spring-boot
[INFO]     [creator]       Build Configuration:
[INFO]     [creator]         $BP_SPRING_CLOUD_BINDINGS_DISABLED   true   whether to contribute Spring Boot cloud bindings support
[INFO]     [creator]       Launch Configuration:
[INFO]     [creator]         $BPL_SPRING_CLOUD_BINDINGS_DISABLED  false  whether to auto-configure Spring Boot environment properties from bindings
[INFO]     [creator]         $BPL_SPRING_CLOUD_BINDINGS_ENABLED   true   Deprecated - whether to auto-configure Spring Boot environment properties from bindings
[INFO]     [creator]       Creating slices from layers index
[INFO]     [creator]         dependencies (17.6 MB)
[INFO]     [creator]         spring-boot-loader (269.4 KB)
[INFO]     [creator]         snapshot-dependencies (0.0 B)
[INFO]     [creator]         application (38.0 KB)
[INFO]     [creator]       Web Application Type: Contributing to layer
[INFO]     [creator]         Non-web application detected
[INFO]     [creator]         Writing env.launch/BPL_JVM_THREAD_COUNT.default
[INFO]     [creator]       4 application slices
[INFO]     [creator]       Image labels:
[INFO]     [creator]         org.opencontainers.image.title
[INFO]     [creator]         org.opencontainers.image.version
[INFO]     [creator]         org.springframework.boot.version
[INFO]     [creator]     Warning: BOM table is deprecated in this buildpack api version, though it remains supported for backwards compatibility. Buildpack authors should write BOM information to <layer>.sbom.<ext>, launch.sbom.<ext>, or build.sbom.<ext>.
[INFO]     [creator]
[INFO]     [creator]     Paketo Buildpack for New Relic 5.7.0
[INFO]     [creator]       https://github.com/paketo-buildpacks/new-relic
[INFO]     [creator]       Build Configuration:
[INFO]     [creator]         $BP_NEW_RELIC_EXT_SHA256      the SHA256 hash of the New Relic extensions archive
[INFO]     [creator]         $BP_NEW_RELIC_EXT_STRIP    0  the number of directory components to strip from the New Relic extensions archive
[INFO]     [creator]         $BP_NEW_RELIC_EXT_URI         the download location of the New Relic extensions
[INFO]     [creator]         $BP_NEW_RELIC_EXT_VERSION     the version of the New Relic extensions
[INFO]     [creator]       New Relic NodeJS Agent 9.10.2: Contributing to layer
[INFO]     [creator]         Downloading from https://registry.npmjs.org/newrelic/-/newrelic-9.10.2.tgz
[INFO]     [creator]         Verifying checksum
[INFO]     [creator]         Installing to /layers/paketo-buildpacks_new-relic/new-relic-nodejs
[#########.........] | idealTree:protobufjs: timing idealTree:node_modules/prot

[INFO]     [creator]     added 66 packages in 10s
[INFO]     [creator]
[INFO]     [creator]     3 packages are looking for funding
[INFO]     [creator]       run `npm fund` for details
[INFO]     [creator]     npm notice
[INFO]     [creator]     npm notice New minor version of npm available! 9.3.1 -> 9.6.0
[INFO]     [creator]     npm notice Changelog: https://github.com/npm/cli/releases/tag/v9.6.0
[INFO]     [creator]     npm notice Run npm install -g npm@9.6.0 to update!
[INFO]     [creator]     npm notice
[INFO]     [creator]     unable to invoke layer creator
[INFO]     [creator]     unable to read contents of /workspace/server.js
[INFO]     [creator]     open /workspace/server.js: no such file or directory
[INFO]     [creator]     ERROR: failed to build: exit status 1
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  50.150 s
[INFO] Finished at: 2023-03-04T16:30:50-05:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.springframework.boot:spring-boot-maven-plugin:3.0.4:build-image (default-cli) on project java-newrelic-buildpack: Execution default-cli of goal org.springframework.boot:spring-boot-maven-plugin:3.0.4:build-image failed: Builder lifecycle 'creator' failed with status code 51 -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/PluginExecutionException
```

# Temporary Workaround
If you force the java buildpack version to 8.9.0, the build succeeds and docker image is created.
```xml
    <buildpacks>
        <buildpack>gcr.io/paketo-buildpacks/java:8.9.0</buildpack>
        <buildpack>gcr.io/paketo-buildpacks/new-relic</buildpack>
    </buildpacks>
```

```text
[INFO] --- spring-boot:3.0.4:build-image (default-cli) @ java-newrelic-buildpack ---
[INFO] Building image 'docker.io/library/java-newrelic-buildpack:0.0.1-SNAPSHOT'
[INFO]
[INFO]  > Pulling builder image 'docker.io/paketobuildpacks/builder:base' 100%
[INFO]  > Pulled builder image 'paketobuildpacks/builder@sha256:96a0c8fbf85a3205cf8b1073382b6f54f57c7a2a776b59a336ae0db4380908b8'
[INFO]  > Pulling run image 'docker.io/paketobuildpacks/run:base-cnb' 100%
[INFO]  > Pulled run image 'paketobuildpacks/run@sha256:dec5146cd16049064246308ee633ab451ccb8c8e7e0ec595727ea12d3719a006'
[INFO]  > Pulling buildpack image 'gcr.io/paketo-buildpacks/java:8.9.0' 100%
[INFO]  > Pulled buildpack image 'gcr.io/paketo-buildpacks/java@sha256:fc1c6fba46b582f63b13490b89e50e93c95ce08142a8737f4a6b70c826c995de'
[INFO]  > Pulling buildpack image 'gcr.io/paketo-buildpacks/new-relic:latest' 100%
[INFO]  > Pulled buildpack image 'gcr.io/paketo-buildpacks/new-relic@sha256:c7abff91a770aeb6a384095afdcaae88cf7ab3dbbe0a5627031433469eebcd7f'
[INFO]  > Executing lifecycle version v0.16.0
[INFO]  > Using build cache volume 'pack-cache-c854ec95a5c6.build'
[INFO]
[INFO]  > Running creator
[INFO]     [creator]     ===> ANALYZING
[INFO]     [creator]     Restoring data for SBOM from previous image
[INFO]     [creator]     ===> DETECTING
[INFO]     [creator]     7 of 25 buildpacks participating
[INFO]     [creator]     paketo-buildpacks/ca-certificates   3.5.1
[INFO]     [creator]     paketo-buildpacks/bellsoft-liberica 9.10.3
[INFO]     [creator]     paketo-buildpacks/syft              1.24.2
[INFO]     [creator]     paketo-buildpacks/executable-jar    6.6.0
[INFO]     [creator]     paketo-buildpacks/dist-zip          5.5.0
[INFO]     [creator]     paketo-buildpacks/spring-boot       5.22.1
[INFO]     [creator]     paketo-buildpacks/new-relic         5.7.0
[INFO]     [creator]     ===> RESTORING
[INFO]     [creator]     Restoring metadata for "paketo-buildpacks/ca-certificates:helper" from app image
[INFO]     [creator]     Restoring metadata for "paketo-buildpacks/bellsoft-liberica:helper" from app image
[INFO]     [creator]     Restoring metadata for "paketo-buildpacks/bellsoft-liberica:java-security-properties" from app image
[INFO]     [creator]     Restoring metadata for "paketo-buildpacks/bellsoft-liberica:jre" from app image
[INFO]     [creator]     Restoring metadata for "paketo-buildpacks/syft:syft" from cache
[INFO]     [creator]     Restoring metadata for "paketo-buildpacks/spring-boot:web-application-type" from app image
[INFO]     [creator]     Restoring metadata for "paketo-buildpacks/new-relic:helper" from app image
[INFO]     [creator]     Restoring metadata for "paketo-buildpacks/new-relic:new-relic-java" from app image
[INFO]     [creator]     Restoring data for "paketo-buildpacks/syft:syft" from cache
[INFO]     [creator]     Restoring data for SBOM from cache
[INFO]     [creator]     ===> BUILDING
[INFO]     [creator]
[INFO]     [creator]     Paketo Buildpack for CA Certificates 3.5.1
[INFO]     [creator]       https://github.com/paketo-buildpacks/ca-certificates
[INFO]     [creator]       Launch Helper: Reusing cached layer
[INFO]     [creator]
[INFO]     [creator]     Paketo Buildpack for BellSoft Liberica 9.10.3
[INFO]     [creator]       https://github.com/paketo-buildpacks/bellsoft-liberica
[INFO]     [creator]       Build Configuration:
[INFO]     [creator]         $BP_JVM_JLINK_ARGS           --no-man-pages --no-header-files --strip-debug --compress=1  configure custom link arguments (--output must be omitted)
[INFO]     [creator]         $BP_JVM_JLINK_ENABLED        false                                                        enables running jlink tool to generate custom JRE
[INFO]     [creator]         $BP_JVM_TYPE                 JRE                                                          the JVM type - JDK or JRE
[INFO]     [creator]         $BP_JVM_VERSION              17.*                                                         the Java version
[INFO]     [creator]       Launch Configuration:
[INFO]     [creator]         $BPL_DEBUG_ENABLED           false                                                        enables Java remote debugging support
[INFO]     [creator]         $BPL_DEBUG_PORT              8000                                                         configure the remote debugging port
[INFO]     [creator]         $BPL_DEBUG_SUSPEND           false                                                        configure whether to suspend execution until a debugger has attached
[INFO]     [creator]         $BPL_HEAP_DUMP_PATH                                                                       write heap dumps on error to this path
[INFO]     [creator]         $BPL_JAVA_NMT_ENABLED        true                                                         enables Java Native Memory Tracking (NMT)
[INFO]     [creator]         $BPL_JAVA_NMT_LEVEL          summary                                                      configure level of NMT, summary or detail
[INFO]     [creator]         $BPL_JFR_ARGS                                                                             configure custom Java Flight Recording (JFR) arguments
[INFO]     [creator]         $BPL_JFR_ENABLED             false                                                        enables Java Flight Recording (JFR)
[INFO]     [creator]         $BPL_JMX_ENABLED             false                                                        enables Java Management Extensions (JMX)
[INFO]     [creator]         $BPL_JMX_PORT                5000                                                         configure the JMX port
[INFO]     [creator]         $BPL_JVM_HEAD_ROOM           0                                                            the headroom in memory calculation
[INFO]     [creator]         $BPL_JVM_LOADED_CLASS_COUNT  35% of classes                                               the number of loaded classes in memory calculation
[INFO]     [creator]         $BPL_JVM_THREAD_COUNT        250                                                          the number of threads in memory calculation
[INFO]     [creator]         $JAVA_TOOL_OPTIONS                                                                        the JVM launch flags
[INFO]     [creator]         Using Java version 17.* from BP_JVM_VERSION
[INFO]     [creator]       BellSoft Liberica JRE 17.0.6: Reusing cached layer
[INFO]     [creator]       Launch Helper: Reusing cached layer
[INFO]     [creator]       Java Security Properties: Reusing cached layer
[INFO]     [creator]
[INFO]     [creator]     Paketo Buildpack for Syft 1.24.2
[INFO]     [creator]       https://github.com/paketo-buildpacks/syft
[INFO]     [creator]
[INFO]     [creator]     Paketo Buildpack for Executable JAR 6.6.0
[INFO]     [creator]       https://github.com/paketo-buildpacks/executable-jar
[INFO]     [creator]       Class Path: Contributing to layer
[INFO]     [creator]         Writing env/CLASSPATH.delim
[INFO]     [creator]         Writing env/CLASSPATH.prepend
[INFO]     [creator]       Process types:
[INFO]     [creator]         executable-jar: java org.springframework.boot.loader.JarLauncher (direct)
[INFO]     [creator]         task:           java org.springframework.boot.loader.JarLauncher (direct)
[INFO]     [creator]         web:            java org.springframework.boot.loader.JarLauncher (direct)
[INFO]     [creator]
[INFO]     [creator]     Paketo Buildpack for Spring Boot 5.22.1
[INFO]     [creator]       https://github.com/paketo-buildpacks/spring-boot
[INFO]     [creator]       Build Configuration:
[INFO]     [creator]         $BP_SPRING_CLOUD_BINDINGS_DISABLED   true   whether to contribute Spring Boot cloud bindings support
[INFO]     [creator]       Launch Configuration:
[INFO]     [creator]         $BPL_SPRING_CLOUD_BINDINGS_DISABLED  false  whether to auto-configure Spring Boot environment properties from bindings
[INFO]     [creator]         $BPL_SPRING_CLOUD_BINDINGS_ENABLED   true   Deprecated - whether to auto-configure Spring Boot environment properties from bindings
[INFO]     [creator]       Creating slices from layers index
[INFO]     [creator]         dependencies (17.6 MB)
[INFO]     [creator]         spring-boot-loader (269.4 KB)
[INFO]     [creator]         snapshot-dependencies (0.0 B)
[INFO]     [creator]         application (38.0 KB)
[INFO]     [creator]       Web Application Type: Contributing to layer
[INFO]     [creator]         Non-web application detected
[INFO]     [creator]         Writing env.launch/BPL_JVM_THREAD_COUNT.default
[INFO]     [creator]       4 application slices
[INFO]     [creator]       Image labels:
[INFO]     [creator]         org.opencontainers.image.title
[INFO]     [creator]         org.opencontainers.image.version
[INFO]     [creator]         org.springframework.boot.version
[INFO]     [creator]     Warning: BOM table is deprecated in this buildpack api version, though it remains supported for backwards compatibility. Buildpack authors should write BOM information to <layer>.sbom.<ext>, launch.sbom.<ext>, or build.sbom.<ext>.
[INFO]     [creator]
[INFO]     [creator]     Paketo Buildpack for New Relic 5.7.0
[INFO]     [creator]       https://github.com/paketo-buildpacks/new-relic
[INFO]     [creator]       Build Configuration:
[INFO]     [creator]         $BP_NEW_RELIC_EXT_SHA256      the SHA256 hash of the New Relic extensions archive
[INFO]     [creator]         $BP_NEW_RELIC_EXT_STRIP    0  the number of directory components to strip from the New Relic extensions archive
[INFO]     [creator]         $BP_NEW_RELIC_EXT_URI         the download location of the New Relic extensions
[INFO]     [creator]         $BP_NEW_RELIC_EXT_VERSION     the version of the New Relic extensions
[INFO]     [creator]       New Relic Java Agent 7.11.1: Reusing cached layer
[INFO]     [creator]       Launch Helper: Reusing cached layer
[INFO]     [creator]     ===> EXPORTING
[INFO]     [creator]     Reusing layer 'paketo-buildpacks/ca-certificates:helper'
[INFO]     [creator]     Reusing layer 'paketo-buildpacks/bellsoft-liberica:helper'
[INFO]     [creator]     Reusing layer 'paketo-buildpacks/bellsoft-liberica:java-security-properties'
[INFO]     [creator]     Reusing layer 'paketo-buildpacks/bellsoft-liberica:jre'
[INFO]     [creator]     Reusing layer 'paketo-buildpacks/executable-jar:classpath'
[INFO]     [creator]     Reusing layer 'paketo-buildpacks/spring-boot:web-application-type'
[INFO]     [creator]     Reusing layer 'paketo-buildpacks/new-relic:helper'
[INFO]     [creator]     Reusing layer 'paketo-buildpacks/new-relic:new-relic-java'
[INFO]     [creator]     Reusing layer 'buildpacksio/lifecycle:launch.sbom'
[INFO]     [creator]     Reusing 4/5 app layer(s)
[INFO]     [creator]     Adding 1/5 app layer(s)
[INFO]     [creator]     Reusing layer 'buildpacksio/lifecycle:launcher'
[INFO]     [creator]     Reusing layer 'buildpacksio/lifecycle:config'
[INFO]     [creator]     Reusing layer 'buildpacksio/lifecycle:process-types'
[INFO]     [creator]     Adding label 'io.buildpacks.lifecycle.metadata'
[INFO]     [creator]     Adding label 'io.buildpacks.build.metadata'
[INFO]     [creator]     Adding label 'io.buildpacks.project.metadata'
[INFO]     [creator]     Adding label 'org.opencontainers.image.title'
[INFO]     [creator]     Adding label 'org.opencontainers.image.version'
[INFO]     [creator]     Adding label 'org.springframework.boot.version'
[INFO]     [creator]     Setting default process type 'web'
[INFO]     [creator]     Saving docker.io/library/java-newrelic-buildpack:0.0.1-SNAPSHOT...
[INFO]     [creator]     *** Images (61ecda7a5c50):
[INFO]     [creator]           docker.io/library/java-newrelic-buildpack:0.0.1-SNAPSHOT
[INFO]     [creator]     Reusing cache layer 'paketo-buildpacks/syft:syft'
[INFO]     [creator]     Reusing cache layer 'buildpacksio/lifecycle:cache.sbom'
[INFO]
[INFO] Successfully built image 'docker.io/library/java-newrelic-buildpack:0.0.1-SNAPSHOT'
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  29.826 s
[INFO] Finished at: 2023-03-04T16:34:00-05:00
[INFO] ------------------------------------------------------------------------
```

