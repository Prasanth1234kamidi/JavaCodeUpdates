# Enhanced Pseudo-Random Number Generators (PRNG)

## Overview
This demonstrates the evolution of random number generation in Java, comparing traditional approaches (before Java 17) with the new enhanced RandomGenerator API (Java 17+).

## Key Improvements in Java 17

### Before Java 17
- Limited to `java.util.Random`, `ThreadLocalRandom`, and `SecureRandom`
- Single algorithm (Linear Congruential Generator for Random)
- No standardized interface for different generators
- Limited parallel processing support

### After Java 17
- New `RandomGenerator` interface
- Multiple high-quality algorithms (L32X64MixRandom, L64X128MixRandom, Xoshiro256PlusPlus, etc.)
- `SplittableGenerator` for parallel processing
- `JumpableGenerator` for skipping ahead in sequences
- `RandomGeneratorFactory` for algorithm discovery
- Better performance and statistical quality

## Compilation and Execution

### For Java 8-16 (Before):
```cmd
javac PRNGBefore.java
java PRNGBefore
```

### For Java 17+ (After):
```cmd
javac PRNGAfter.java
java PRNGAfter
```

## Features Demonstrated

### PRNGBefore.java
1. **Basic Random**: Traditional java.util.Random
2. **ThreadLocalRandom**: Better for concurrent applications
3. **SecureRandom**: Cryptographically secure random numbers
4. **Seeded Random**: Reproducible sequences
5. **Performance Comparison**: Speed comparison between generators

### PRNGAfter.java
1. **RandomGenerator Interface**: New unified interface
2. **Multiple Algorithms**: Various high-quality PRNG algorithms
3. **RandomGeneratorFactory**: Discovery and creation of generators
4. **SplittableGenerator**: For parallel processing
5. **JumpableGenerator**: Skip ahead in random sequences
6. **Stream Generation**: Generate streams of random numbers
7. **Algorithm Performance**: Compare different algorithm speeds

## Algorithm Comparison

| Algorithm | Period | Quality | Speed | Use Case |
|-----------|--------|---------|-------|----------|
| Random (LCG) | 2^48 | Poor | Fast | Legacy code |
| L32X64MixRandom | 2^96 | Good | Very Fast | General purpose |
| L64X128MixRandom | 2^192 | Excellent | Fast | High-quality needs |
| Xoshiro256PlusPlus | 2^256 | Excellent | Very Fast | Scientific computing |

## Running the Examples

1. **Compile and run Before example**:
   ```cmd
   cd "d:\java code\EnhancedPRNG"
   javac PRNGBefore.java
   java PRNGBefore
   ```

2. **Compile and run After example** (requires Java 17+):
   ```cmd
   cd "d:\java code\EnhancedPRNG"
   javac PRNGAfter.java
   java PRNGAfter
   ```

## Expected Output
- Random number samples from different generators
- Performance comparisons
- Algorithm availability and characteristics
- Demonstration of new Java 17 features like splitting and jumping