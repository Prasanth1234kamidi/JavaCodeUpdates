@echo off
echo Compiling and running UTF-8 After Java 17 example...
echo.

javac UTF8After.java
if %errorlevel% neq 0 (
    echo Compilation failed! Make sure you're using Java 17 or later.
    echo Check your Java version with: java -version
    pause
    exit /b 1
)

echo Compilation successful. Running...
echo.
java UTF8After

echo.
echo Press any key to exit...
pause > nul