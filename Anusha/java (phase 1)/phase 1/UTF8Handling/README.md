# UTF-8 Handling Improvements

## Overview
This demonstrates the evolution of UTF-8 string and file handling in Java, comparing traditional approaches with modern Java 17+ improvements.

## Key Improvements in Java 17+

### Before Java 17
- Manual charset specification required
- URLEncoder/URLDecoder throw checked exceptions
- Verbose file operations
- Risk of platform-dependent charset issues
- More boilerplate code

### After Java 17
- Cleaner APIs (Files.readString/writeString)
- URLEncoder/URLDecoder without exceptions (Java 10+)
- Better String methods (strip, isBlank, lines)
- Text blocks for multi-line strings (Java 15+)
- Improved performance and consistency

## Compilation and Execution

### For Java 8-16 (Before):
```cmd
javac UTF8Before.java
java UTF8Before
```

### For Java 17+ (After):
```cmd
javac UTF8After.java
java UTF8After
```

## Features Demonstrated

### UTF8Before.java
1. **String Encoding/Decoding**: Manual UTF-8 operations
2. **File Operations**: Explicit charset specification required
3. **URL Encoding**: Checked exceptions handling
4. **Limitations**: Platform-dependent issues and verbose code

### UTF8After.java
1. **Enhanced String Operations**: Better Unicode handling
2. **Improved File Operations**: Files.readString/writeString
3. **Better URL Encoding**: No checked exceptions
4. **New Methods**: Text blocks, strip(), isBlank(), lines()
5. **Performance**: Optimized UTF-8 operations

## Key Improvements

| Feature | Before Java 17 | After Java 17 | Benefit |
|---------|----------------|---------------|---------|
| File I/O | Files.write(path, bytes, charset) | Files.writeString(path, string, charset) | Cleaner API |
| URL Encoding | try-catch required | Direct method call | No exceptions |
| String Methods | Limited | strip(), isBlank(), lines() | More functionality |
| Multi-line | String concatenation | Text blocks | Better readability |
| Performance | Standard | Optimized UTF-8 | Faster operations |

## Running the Examples

1. **Compile and run Before example**:
   ```cmd
   cd "d:\java code\UTF8Handling"
   javac UTF8Before.java
   java UTF8Before
   ```

2. **Compile and run After example**:
   ```cmd
   cd "d:\java code\UTF8Handling"
   javac UTF8After.java
   java UTF8After
   ```

## Expected Output
- UTF-8 encoding/decoding demonstrations
- File operations with Unicode content
- URL encoding examples
- Performance comparisons
- Modern Java string handling features