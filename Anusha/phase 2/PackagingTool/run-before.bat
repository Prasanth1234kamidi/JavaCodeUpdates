@echo off
echo Compiling and running Packaging Before Java 17 example...
echo.

javac PackagingBefore.java
if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b 1
)

echo Compilation successful. Running...
echo.
java PackagingBefore

echo.
echo Press any key to exit...
pause > nul