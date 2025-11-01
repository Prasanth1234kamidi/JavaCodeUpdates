# Garbage Collection Improvements

## Overview
This demonstrates the evolution of garbage collection in Java, comparing traditional GC approaches with modern ZGC and other improvements in Java 17+.

## Key Improvements in Java 17+

### Before Java 17
- Stop-the-world pauses
- Pause times increase with heap size
- Limited scalability for large heaps
- Complex GC tuning required
- Unpredictable latencies

### After Java 17
- ZGC: Sub-10ms pauses regardless of heap size
- Concurrent collection (no stop-the-world)
- Support for heaps up to 16TB
- Simplified GC tuning
- Predictable performance

## Compilation and Execution

### Standard GC (Before):
```cmd
javac GCBefore.java
java GCBefore
```

### Modern GC (After):
```cmd
javac GCAfter.java
java GCAfter
```

### Running with ZGC:
```cmd
java -XX:+UseZGC GCAfter
```

### Running with G1GC (improved):
```cmd
java -XX:+UseG1GC GCAfter
```

## Features Demonstrated

### GCBefore.java
1. **Current GC Information**: Traditional GC algorithms
2. **Traditional GC Behavior**: Stop-the-world characteristics
3. **Memory Allocation**: Impact on performance
4. **GC Limitations**: Scalability and latency issues

### GCAfter.java
1. **Modern GC Information**: Available collectors in Java 17+
2. **ZGC Features**: Ultra-low latency characteristics
3. **Improved Memory Management**: Better efficiency
4. **Performance Benefits**: Latency and throughput improvements

## Garbage Collectors Comparison

| GC Algorithm | Pause Time | Heap Size | Throughput | Use Case |
|--------------|------------|-----------|------------|----------|
| Serial GC | 10-100ms | <100MB | Low | Small applications |
| Parallel GC | 10-1000ms | <8GB | High | Batch processing |
| G1GC | 1-100ms | <32GB | Good | General purpose |
| **ZGC** | **<10ms** | **8MB-16TB** | **Good** | **Low latency** |
| Shenandoah | <10ms | Any | Good | Low latency |

## ZGC Benefits

### Pause Times
- **Traditional GC**: Increases with heap size (10ms to 1000ms+)
- **ZGC**: Consistent <10ms regardless of heap size

### Scalability
- **Traditional GC**: Poor performance with large heaps
- **ZGC**: Linear scalability up to 16TB heaps

### Predictability
- **Traditional GC**: Unpredictable pause times
- **ZGC**: Consistent, predictable performance

## Running the Examples

1. **Standard GC demonstration**:
   ```cmd
   cd "d:\java code\GarbageCollection"
   javac GCBefore.java
   java GCBefore
   ```

2. **Modern GC demonstration**:
   ```cmd
   cd "d:\java code\GarbageCollection"
   javac GCAfter.java
   java GCAfter
   ```

3. **ZGC specific test**:
   ```cmd
   java -XX:+UseZGC -Xmx4g GCAfter
   ```

## Expected Output
- GC algorithm information
- Memory allocation patterns
- Pause time measurements
- Performance comparisons
- Latency improvements with modern GC

## JVM Flags for Modern GC

### ZGC:
```cmd
-XX:+UseZGC
-XX:+UnlockExperimentalVMOptions  # Not needed in Java 17+
```

### Shenandoah:
```cmd
-XX:+UseShenandoahGC
-XX:+UnlockExperimentalVMOptions  # May be needed
```

### G1GC (improved):
```cmd
-XX:+UseG1GC
-XX:MaxGCPauseMillis=200
```