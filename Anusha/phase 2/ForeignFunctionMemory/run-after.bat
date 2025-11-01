@echo off
echo Compiling and running FFM After Java 17+ example...
echo.

javac --enable-preview --release 21 FFMAfter.java
if %errorlevel% neq 0 (
    echo Compilation failed! Make sure you're using Java 21 or later.
    echo Check your Java version with: java -version
    pause
    exit /b 1
)

echo Compilation successful. Running...
echo.
java --enable-preview --enable-native-access=ALL-UNNAMED FFMAfter

echo.
echo Press any key to exit...
pause > nul