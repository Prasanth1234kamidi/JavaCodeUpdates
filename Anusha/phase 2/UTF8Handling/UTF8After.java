import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.net.URLEncoder;
import java.net.URLDecoder;

/**
 * UTF-8 Handling After Java 17
 * Shows improved UTF-8 string and file operations
 */
public class UTF8After {
    public static void main(String[] args) {
        System.out.println("=== UTF-8 Handling After Java 17 ===\n");
        
        // 1. Enhanced string operations
        demonstrateEnhancedStringOps();
        
        // 2. Improved file operations
        demonstrateImprovedFileOps();
        
        // 3. Better URL encoding
        demonstrateBetterURLEncoding();
        
        // 4. New UTF-8 methods
        demonstrateNewMethods();
        
        // 5. Advantages
        demonstrateAdvantages();
    }
    
    private static void demonstrateEnhancedStringOps() {
        System.out.println("1. Enhanced String Operations:");
        
        String text = "Enhanced 世界! 🚀 Café naïve résumé";
        System.out.println("  Original: " + text);
        
        // Cleaner UTF-8 operations (same as before but more explicit)
        byte[] utf8Bytes = text.getBytes(StandardCharsets.UTF_8);
        System.out.println("  UTF-8 bytes length: " + utf8Bytes.length);
        
        String decoded = new String(utf8Bytes, StandardCharsets.UTF_8);
        System.out.println("  Decoded: " + decoded);
        
        // Better string analysis
        System.out.println("  Character count: " + text.length());
        System.out.println("  Code point count: " + text.codePointCount(0, text.length()));
        
        // Unicode normalization (available in modern Java)
        System.out.println("  Normalized: " + java.text.Normalizer.normalize(text, java.text.Normalizer.Form.NFC));
        System.out.println();
    }
    
    private static void demonstrateImprovedFileOps() {
        System.out.println("2. Improved File Operations:");
        
        String content = "Improved UTF-8: 日本語 Español Français 🎯 математика";
        Path tempFile = Paths.get("temp_utf8_improved.txt");
        
        try {
            // Cleaner file operations (UTF-8 is more standard)
            Files.writeString(tempFile, content, StandardCharsets.UTF_8);
            System.out.println("  File written using Files.writeString()");
            
            // Read with Files.readString()
            String readContent = Files.readString(tempFile, StandardCharsets.UTF_8);
            System.out.println("  File content: " + readContent);
            
            // Multiple lines
            String multiLine = "Line 1: Hello 世界\nLine 2: Café ☕\nLine 3: 🌟 Star";
            Files.writeString(tempFile, multiLine, StandardCharsets.UTF_8);
            
            // Read all lines
            var lines = Files.readAllLines(tempFile, StandardCharsets.UTF_8);
            System.out.println("  Lines read:");
            for (int i = 0; i < lines.size(); i++) {
                System.out.println("    " + (i + 1) + ": " + lines.get(i));
            }
            
            // Stream operations
            System.out.println("  Stream processing:");
            Files.lines(tempFile, StandardCharsets.UTF_8)
                .filter(line -> line.contains("🌟"))
                .forEach(line -> System.out.println("    Found: " + line));
            
            // Cleanup
            Files.deleteIfExists(tempFile);
            
        } catch (IOException e) {
            System.out.println("  File operation error: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void demonstrateBetterURLEncoding() {
        System.out.println("3. Better URL Encoding (Java 10+):");
        
        String url = "Search: 世界 café 🔍";
        
        // No more UnsupportedEncodingException (Java 10+)
        String encoded = URLEncoder.encode(url, StandardCharsets.UTF_8);
        System.out.println("  Original: " + url);
        System.out.println("  Encoded: " + encoded);
        
        // Cleaner decoding
        String decoded = URLDecoder.decode(encoded, StandardCharsets.UTF_8);
        System.out.println("  Decoded: " + decoded);
        
        System.out.println("  Benefit: No checked exception handling needed!");
        System.out.println();
    }
    
    private static void demonstrateNewMethods() {
        System.out.println("4. Enhanced UTF-8 Methods:");
        
        String text = "Modern Java: 现代Java 🚀";
        
        // Better string handling
        System.out.println("  Text: " + text);
        System.out.println("  Is blank: " + text.isBlank());
        System.out.println("  Stripped: '" + text.strip() + "'");
        
        // Multi-line strings (Java 15+ Text Blocks)
        String multiLine = "Multi-line UTF-8:\n" +
                "Line 1: Hello 世界\n" +
                "Line 2: Café ☕\n" +
                "Line 3: 数学 Mathematics";
        
        System.out.println("  Text block:");
        System.out.println(multiLine);
        
        // Lines processing
        System.out.println("  Processing lines:");
        multiLine.lines()
            .filter(line -> !line.trim().isEmpty())
            .forEach(line -> System.out.println("    > " + line.trim()));
        
        System.out.println();
    }
    
    private static void demonstrateAdvantages() {
        System.out.println("5. Java 17+ UTF-8 Advantages:");
        
        System.out.println("  Improved APIs:");
        System.out.println("    ✓ Files.readString() / Files.writeString()");
        System.out.println("    ✓ URLEncoder/URLDecoder without exceptions");
        System.out.println("    ✓ Better String methods (strip, isBlank, lines)");
        System.out.println("    ✓ Text blocks for multi-line strings");
        
        System.out.println("  Better Performance:");
        System.out.println("    ✓ Optimized UTF-8 encoding/decoding");
        System.out.println("    ✓ Compact strings (Latin-1 vs UTF-16)");
        System.out.println("    ✓ Improved string concatenation");
        
        System.out.println("  Enhanced Security:");
        System.out.println("    ✓ UTF-8 as default in many contexts");
        System.out.println("    ✓ Better Unicode normalization");
        System.out.println("    ✓ Consistent charset handling");
        
        System.out.println("  Developer Experience:");
        System.out.println("    ✓ Less boilerplate code");
        System.out.println("    ✓ Fewer charset-related bugs");
        System.out.println("    ✓ More intuitive APIs");
        
        // Performance demonstration
        demonstratePerformance();
    }
    
    private static void demonstratePerformance() {
        System.out.println("\n  Performance Comparison:");
        
        String text = "Performance test: 性能测试 🚀".repeat(1000);
        int iterations = 10000;
        
        // String operations
        long start = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
            new String(bytes, StandardCharsets.UTF_8);
        }
        long time = System.nanoTime() - start;
        
        System.out.println("    UTF-8 encode/decode (10K ops): " + (time / 1_000_000) + " ms");
        
        // File operations
        Path tempFile = Paths.get("perf_test.txt");
        try {
            start = System.nanoTime();
            Files.writeString(tempFile, text, StandardCharsets.UTF_8);
            Files.readString(tempFile, StandardCharsets.UTF_8);
            time = System.nanoTime() - start;
            
            System.out.println("    File write/read: " + (time / 1_000_000) + " ms");
            Files.deleteIfExists(tempFile);
            
        } catch (IOException e) {
            System.out.println("    Performance test failed: " + e.getMessage());
        }
        
        System.out.println("\n  Modern Java provides better UTF-8 handling with:");
        System.out.println("    - Cleaner APIs");
        System.out.println("    - Better performance");
        System.out.println("    - Fewer encoding issues");
        System.out.println("    - More consistent behavior");
    }
}