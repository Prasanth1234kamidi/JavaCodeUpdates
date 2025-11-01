@echo off
echo Compiling and running PRNG Before Java 17 example...
echo.

javac PRNGBefore.java
if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b 1
)

echo Compilation successful. Running...
echo.
java PRNGBefore

echo.
echo Press any key to exit...
pause > nul