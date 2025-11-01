@echo off
echo Compiling and running PRNG After Java 17 example...
echo.

javac PRNGAfter.java
if %errorlevel% neq 0 (
    echo Compilation failed! Make sure you're using Java 17 or later.
    echo Check your Java version with: java -version
    pause
    exit /b 1
)

echo Compilation successful. Running...
echo.
java PRNGAfter

echo.
echo Press any key to exit...
pause > nul