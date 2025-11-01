@echo off
echo Compiling and running GC Before Java 17 example...
echo.

javac GCBefore.java
if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b 1
)

echo Compilation successful. Running with default GC...
echo.
java GCBefore

echo.
echo Press any key to exit...
pause > nul