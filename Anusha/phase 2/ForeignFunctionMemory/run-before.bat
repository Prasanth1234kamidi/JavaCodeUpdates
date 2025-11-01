@echo off
echo Compiling and running FFM Before Java 17 example...
echo.

javac FFMBefore.java
if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b 1
)

echo Compilation successful. Running...
echo.
java FFMBefore

echo.
echo Press any key to exit...
pause > nul