@echo off
echo Compiling and running GC After Java 17 example...
echo.

javac GCAfter.java
if %errorlevel% neq 0 (
    echo Compilation failed! Make sure you're using Java 17 or later.
    echo Check your Java version with: java -version
    pause
    exit /b 1
)

echo Compilation successful. Running with default GC...
echo.
java GCAfter

echo.
echo Running with ZGC (if available)...
echo.
java -XX:+UseZGC GCAfter

echo.
echo Press any key to exit...
pause > nul