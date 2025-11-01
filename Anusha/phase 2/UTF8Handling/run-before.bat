@echo off
echo Compiling and running UTF-8 Before Java 17 example...
echo.

javac UTF8Before.java
if %errorlevel% neq 0 (
    echo Compilation failed!
    pause
    exit /b 1
)

echo Compilation successful. Running...
echo.
java UTF8Before

echo.
echo Press any key to exit...
pause > nul