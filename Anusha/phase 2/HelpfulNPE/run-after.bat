@echo off
echo Compiling and running Helpful NPE After Java 17 example...
echo.

javac NPEAfter.java
if %errorlevel% neq 0 (
    echo Compilation failed! Make sure you're using Java 17 or later.
    pause
    exit /b 1
)

echo Running with enhanced NPE messages...
echo.
java -XX:+ShowCodeDetailsInExceptionMessages NPEAfter

echo.
echo Press any key to exit...
pause > nul