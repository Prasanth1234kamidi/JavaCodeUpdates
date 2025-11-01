# Java 17 Features & Core Concepts

This repository demonstrates Java 17 features with before/after code examples and covers essential Java concepts.

## 📁 Project Structure

### Java 17 Features
- **[records/](./records/)** - Records (finalized) - Compact data classes
- **[sealed-classes/](./sealed-classes/)** - Sealed Classes (finalized) - Controlled inheritance
- **[pattern-matching/](./pattern-matching/)** - Enhanced Pattern Matching - instanceof improvements
- **[switch-expressions/](./switch-expressions/)** - Switch Expressions (stable) - Expression-based switch
- **[encapsulation/](./encapsulation/)** - JDK Internals Encapsulation - Security improvements
- **[virtual-threads/](./virtual-threads/)** - Virtual Threads (preview) - Lightweight concurrency

### Core Java Concepts
- **[multithreading-concurrency/](./multithreading-concurrency/)** - Concurrent programming patterns
- **[jvm-memory/](./jvm-memory/)** - JVM internals and memory management

## 🚀 Key Java 17 Improvements

### Language Features
- **Records**: Eliminate boilerplate for data classes
- **Sealed Classes**: Control inheritance hierarchies
- **Pattern Matching**: Cleaner instanceof checks
- **Switch Expressions**: More concise and safer switch logic

### Runtime Improvements
- **Virtual Threads**: Massive scalability for concurrent applications
- **Enhanced GC**: Better garbage collection performance
- **Security**: Stronger encapsulation of internal APIs

### Performance Benefits
- Faster startup times
- Reduced memory footprint
- Better throughput for concurrent applications
- Improved garbage collection efficiency

## 📖 How to Use

Each folder contains:
- `README.md` - Explanation of the feature/concept
- `Before*.java` - Traditional approach (pre-Java 17)
- `After*.java` - Modern approach (Java 17+)

## 🔧 Running the Examples

```bash
# Compile Java 17 code
javac --enable-preview --source 17 *.java

# Run with preview features (for virtual threads in Java 17)
java --enable-preview ClassName
```

## 📚 Learning Path

1. Start with **Records** - understand modern data classes
2. Explore **Sealed Classes** - learn controlled inheritance
3. Practice **Pattern Matching** - cleaner type checking
4. Master **Switch Expressions** - functional-style switching
5. Understand **Virtual Threads** - scalable concurrency
6. Study **Multithreading** - concurrent programming patterns
7. Learn **JVM & Memory** - performance optimization

## 🎯 Benefits of Java 17

- **Developer Productivity**: Less boilerplate, cleaner code
- **Performance**: Better runtime characteristics
- **Security**: Stronger encapsulation and safety
- **Scalability**: Virtual threads enable massive concurrency
- **Maintainability**: Clearer intent and safer patterns