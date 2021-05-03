if exist "set_java_home.bat" (
    call set_java_home.bat
    call gradlew.bat clean install -Dorg.gradle.java.home="%JAVA_HOME%"
) else (
    call gradlew.bat clean install
)