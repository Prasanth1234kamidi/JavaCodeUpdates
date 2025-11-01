@echo off
echo ========================================
echo Java 17 Features Demonstration
echo ========================================
echo.

echo 1. Enhanced PRNG
cd EnhancedPRNG
call run-before.bat
call run-after.bat
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
echo 4. Foreign Function & Memory API (requires special flags)
cd ForeignFunctionMemory
javac FFMBefore.java && java FFMBefore
echo Note: FFMAfter requires --add-modules jdk.incubator.foreign --enable-native-access=ALL-UNNAMED
cd ..

echo.
echo 5. Vector API (requires special flags)
cd VectorAPI
javac VectorBefore.java && java VectorBefore
echo Note: VectorAfter requires --add-modules jdk.incubator.vector
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
echo ========================================
echo All examples completed!
echo ========================================
pause