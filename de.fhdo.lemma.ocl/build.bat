REM The Gradle "clean" and "install" tasks need to be executed separatedly,
REM because of the com.diffplug.p2.asmaven plugin. Otherwise, the
REM "extractEclipseDependencies" step will fail.
call gradlew.bat clean & call gradlew.bat install
