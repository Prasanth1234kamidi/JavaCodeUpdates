@echo off
echo ========================================
echo Java 17 Features Comprehensive Demo
echo ========================================
echo.

echo 1. Enhanced PRNG
cd EnhancedPRNG
javac PRNGBefore.java && java PRNGBefore
javac PRNGAfter.java && java PRNGAfter
cd ..

echo.
echo 2. macOS Rendering Pipeline
cd MacOSRendering
javac RenderingBefore.java && java RenderingBefore
javac RenderingAfter.java && java RenderingAfter
cd ..

echo.
echo 3. Deprecations and Removals
cd DeprecationsRemovals
javac DeprecationsBefore.java && java DeprecationsBefore
javac DeprecationsAfter.java && java DeprecationsAfter
cd ..

echo.
echo 4. Foreign Function & Memory API
cd ForeignFunctionMemory
javac FFMBefore.java && java FFMBefore
javac --enable-preview --release 21 FFMAfter.java
java --enable-preview --enable-native-access=ALL-UNNAMED FFMAfter
cd ..

echo.
echo 5. Vector API
cd VectorAPI
javac VectorBefore.java && java VectorBefore
javac --add-modules jdk.incubator.vector VectorAfter.java
java --add-modules jdk.incubator.vector VectorAfter
cd ..

echo.
echo 6. Context-Specific Deserialization Filters
cd DeserializationFilters
javac FiltersBefore.java && java FiltersBefore
javac FiltersAfter.java && java FiltersAfter
cd ..

echo.
echo 7. Strong Encapsulation of JDK Internals
cd StrongEncapsulation
javac EncapsulationBefore.java && java EncapsulationBefore
javac EncapsulationAfter.java && java EncapsulationAfter
cd ..

echo.
echo 8. UTF-8 String and File Handling
cd UTF8Handling
javac UTF8Before.java && java UTF8Before
javac UTF8After.java && java UTF8After
cd ..

echo.
echo 9. Garbage Collection Improvements
cd GarbageCollection
javac GCBefore.java && java GCBefore
javac GCAfter.java && java GCAfter
cd ..

echo.
echo 10. Packaging Tool (jpackage)
cd PackagingTool
javac PackagingBefore.java && java PackagingBefore
javac PackagingAfter.java && java PackagingAfter
cd ..

echo.
echo 11. Helpful NullPointerException Messages
cd HelpfulNPE
javac NPEBefore.java && java NPEBefore
javac NPEAfter.java && java NPEAfter
cd ..

echo.
echo 12. Hidden Classes
cd HiddenClasses
javac HiddenBefore.java && java HiddenBefore
javac HiddenAfter.java && java HiddenAfter
cd ..

echo.
echo ========================================
echo All 12 Java 17 Features Completed!
echo 24 Examples (12 Before + 12 After)
echo ========================================
pause