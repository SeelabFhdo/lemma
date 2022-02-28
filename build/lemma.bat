@echo off
setlocal enableextensions enabledelayedexpansion

REM Utils
set modules=de.fhdo.lemma.eclipse.ui.utils
set modules=%modules%;de.fhdo.lemma.data.datadsl.metamodel
set modules=%modules%;de.fhdo.lemma.utils

REM Type Checker
set modules=%modules%;de.fhdo.lemma.technology.technologydsl.metamodel
set modules=%modules%;de.fhdo.lemma.typechecking

REM Languages
set modules=%modules%;de.fhdo.lemma.xtext.test.utils
set modules=%modules%;de.fhdo.lemma.data.datadsl.parent
set modules=%modules%;de.fhdo.lemma.technology.technologydsl.parent
set modules=%modules%;de.fhdo.lemma.servicedsl.parent
set modules=%modules%;de.fhdo.lemma.technology.mappingdsl.parent
set modules=%modules%;de.fhdo.lemma.operationdsl.parent

REM Transformations
set modules=%modules%;de.fhdo.lemma.intermediate.transformations.parent
set modules=%modules%;de.fhdo.lemma.data.avro.parent

REM Live Validation Framework
set modules=%modules%;de.fhdo.lemma.live_validation

REM UI Components
set modules=%modules%;de.fhdo.lemma.eclipse.ui.parent
set modules=%modules%;de.fhdo.lemma.data.datadsl.ui
set modules=%modules%;de.fhdo.lemma.data.datadsl.ui.tests
set modules=%modules%;de.fhdo.lemma.technology.technologydsl.ui
set modules=%modules%;de.fhdo.lemma.technology.technologydsl.ui.tests
set modules=%modules%;de.fhdo.lemma.servicedsl.ui
set modules=%modules%;de.fhdo.lemma.servicedsl.ui.tests
set modules=%modules%;de.fhdo.lemma.technology.mappingdsl.ui
set modules=%modules%;de.fhdo.lemma.technology.mappingdsl.ui.tests
set modules=%modules%;de.fhdo.lemma.operationdsl.ui
set modules=%modules%;de.fhdo.lemma.operationdsl.ui.tests
set modules=%modules%;de.fhdo.lemma.model_processing.eclipse.launcher.parent

REM OCL
set modules=%modules%;de.fhdo.lemma.ocl

REM Model Processing Framework
set modules=%modules%;de.fhdo.lemma.model_processing
set modules=%modules%;de.fhdo.lemma.model_processing.utils
set modules=%modules%;"examples\model-processing"

REM Code Generators
set modules=%modules%;"code generators\de.fhdo.lemma.ddd"
set modules=%modules%;"code generators\de.fhdo.lemma.msa"
set modules=%modules%;"code generators\de.fhdo.lemma.model_processing.code_generation.java_base"
set modules=%modules%;"code generators\de.fhdo.lemma.model_processing.code_generation.ddd"
set modules=%modules%;"code generators\de.fhdo.lemma.model_processing.code_generation.springcloud"
set modules=%modules%;"code generators\de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events"
set modules=%modules%;"code generators\de.fhdo.lemma.model_processing.code_generation.springcloud.cqrs"
set modules=%modules%;"code generators\de.fhdo.lemma.model_processing.code_generation.springcloud.kafka"
set modules=%modules%;"code generators\de.fhdo.lemma.model_processing.code_generation.container_base"
set modules=%modules%;"code generators\de.fhdo.lemma.model_processing.code_generation.mariadb"
set modules=%modules%;"code generators\de.fhdo.lemma.model_processing.code_generation.mongodb"
set modules=%modules%;"code generators\de.fhdo.lemma.model_processing.code_generation.springcloud.zuul"
set modules=%modules%;"code generators\de.fhdo.lemma.model_processing.code_generation.springcloud.eureka"

REM Analyzer
set modules=%modules%;de.fhdo.lemma.analyzer.lib
set modules=%modules%;de.fhdo.lemma.analyzer

REM Initialize colors for colorEcho
for /F "tokens=1,2 delims=#" %%a in ('"prompt #$H#$E# & echo on & for %%b in (1) do     rem"') do (
  set "DEL=%%a"
)

cd ..

set BUILD_ROOT=%cd%
set /a MODULE_COUNT=0
REM Determine module count
(for %%m in (%modules%) do (
    set /a MODULE_COUNT+=1
))
set /a CURRENT_MODULE_INDEX=1

(for %%m in (%modules%) do (
    call :do_build %%m !CURRENT_MODULE_INDEX! !MODULE_COUNT!
    if !ERRORLEVEL! GEQ 1 (
        exit /B !ERRORLEVEL!
    )
    set /a CURRENT_MODULE_INDEX+=1
))

call :notify "All modules built successfully!"

exit /B %ERRORLEVEL%

:do_build
    set MODULE=%~1
    set MODULE_FULL_PATH=%~dp1
    set MODULE_FULL_PATH=%MODULE_FULL_PATH:~0,-1%
    set MODULE_NAME=%~nx1
    for %%f in ("%MODULE_FULL_PATH%") do set MODULE_PATH=%%~nxf
    if "%MODULE%" == "%MODULE_NAME%" (
        set moduleStr=%MODULE%
    ) else (
        set moduleStr=%MODULE_NAME% in %MODULE_PATH%
    )
    call :colorEcho 5 ------------------------------------------------------------------------
    echo.
    call :colorEcho 5 "Building module %moduleStr% (%2 of %3)"
    echo.
    call :colorEcho 5 ------------------------------------------------------------------------
    echo.

    REM Builds can be customized with a separate "build.bat" script in the modules' root folders.
    REM Otherwise, Maven's "clean" and "install" tasks will be used by default to build modules.
    if exist "%MODULE%\build.bat" (
        cd %MODULE% & call build.bat
		set buildBatchErrorLevel=!ERRORLEVEL!
		cd %BUILD_ROOT%
		set ERRORLEVEL=!buildBatchErrorLevel!
    ) else (
        call mvn -f "%MODULE%\pom.xml" clean install
    )

    if %ERRORLEVEL% GEQ 1 (
        call :notify_error "Build of %moduleStr% (%2 of %3) unsuccessful!"
        exit /B 1
    ) else (
        call :notify "%moduleStr% (%2 of %3) successfully built"
        exit /B 0
    )

:notify
    call :colorEcho 2 %1
    echo.
    exit /B 0

:notify_error
    call :colorEcho c0 %1
    echo.
    exit /B 0

:colorEcho
    echo off
    <nul set /p ".=%DEL%" > "%~2"
    findstr /v /a:%1 /R "^$" "%~2" nul
    del "%~2" > nul 2>&1i
