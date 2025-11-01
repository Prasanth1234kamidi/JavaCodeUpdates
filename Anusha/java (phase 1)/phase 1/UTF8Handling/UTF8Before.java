import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

/**
 * UTF-8 Handling Before Java 17
 * Shows traditional UTF-8 string and file operations
 */
public class UTF8Before {
    public static void main(String[] args) {
        System.out.println("=== UTF-8 Handling Before Java 17 ===\n");
        
        // 1. String encoding/decoding
        demonstrateStringEncoding();
        
        // 2. File operations with UTF-8
        demonstrateFileOperations();
        
        // 3. URL encoding
        demonstrateURLEncoding();
        
        // 4. Limitations
        demonstrateLimitations();
    }
    
    private static void demonstrateStringEncoding() {
        System.out.println("1. String Encoding/Decoding:");
        
        String text = "Hello 世界! 🌍 Café";
        System.out.println("  Original: " + text);
        
        try {
            // Manual UTF-8 encoding
            byte[] utf8Bytes = text.getBytes(StandardCharsets.UTF_8);
            System.out.println("  UTF-8 bytes length: " + utf8Bytes.length);
            
            // Manual UTF-8 decoding
            String decoded = new String(utf8Bytes, StandardCharsets.UTF_8);
            System.out.println("  Decoded: " + decoded);
            
            // Show byte representation
            System.out.print("  Bytes: ");
            for (int i = 0; i < Math.min(utf8Bytes.length, 20); i++) {
                System.out.printf("%02X ", utf8Bytes[i] & 0xFF);
            }
            if (utf8Bytes.length > 20) System.out.print("...");
            System.out.println();
            
        } catch (Exception e) {
            System.out.println("  Error: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void demonstrateFileOperations() {
        System.out.println("2. File Operations with UTF-8:");
        
        String content = "UTF-8 Content: 日本語 Español Français 🎉";
        Path tempFile = Paths.get("temp_utf8.txt");
        
        try {
            // Write UTF-8 file (manual charset specification)
            Files.write(tempFile, content.getBytes(StandardCharsets.UTF_8));
            System.out.println("  File written with UTF-8 encoding");
            
            // Read UTF-8 file (manual charset specification)
            byte[] fileBytes = Files.readAllBytes(tempFile);
            String readContent = new String(fileBytes, StandardCharsets.UTF_8);
            System.out.println("  File content: " + readContent);
            
            // Using BufferedWriter/Reader (manual charset)
            try (BufferedWriter writer = Files.newBufferedWriter(tempFile, StandardCharsets.UTF_8)) {
                writer.write("Manual UTF-8: 中文 العربية русский");
            }
            
            try (BufferedReader reader = Files.newBufferedReader(tempFile, StandardCharsets.UTF_8)) {
                String line = reader.readLine();
                System.out.println("  BufferedReader: " + line);
            }
            
            // Cleanup
            Files.deleteIfExists(tempFile);
            
        } catch (IOException e) {
            System.out.println("  File operation error: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void demonstrateURLEncoding() {
        System.out.println("3. URL Encoding (Manual UTF-8):");
        
        String url = "Hello 世界";
        try {
            // Manual URL encoding with UTF-8
            String encoded = java.net.URLEncoder.encode(url, StandardCharsets.UTF_8.name());
            System.out.println("  Original: " + url);
            System.out.println("  Encoded: " + encoded);
            
            // Manual URL decoding
            String decoded = java.net.URLDecoder.decode(encoded, StandardCharsets.UTF_8.name());
            System.out.println("  Decoded: " + decoded);
            
        } catch (UnsupportedEncodingException e) {
            System.out.println("  URL encoding error: " + e.getMessage());
        }
        System.out.println();
    }
    
    private static void demonstrateLimitations() {
        System.out.println("4. Limitations Before Java 17:");
        System.out.println("  - Must explicitly specify StandardCharsets.UTF_8");
        System.out.println("  - URLEncoder.encode() throws UnsupportedEncodingException");
        System.out.println("  - No direct UTF-8 string methods");
        System.out.println("  - Verbose file operations requiring charset specification");
        System.out.println("  - Risk of using platform default charset accidentally");
        System.out.println("  - More boilerplate code for UTF-8 operations");
        System.out.println();
        
        // Show platform default charset issue
        System.out.println("Platform Issues:");
        System.out.println("  Default charset: " + java.nio.charset.Charset.defaultCharset());
        System.out.println("  File encoding: " + System.getProperty("file.encoding"));
        
        // Demonstrate the problem
        String text = "Problematic: café";
        byte[] defaultBytes = text.getBytes(); // Uses platform default!
        byte[] utf8Bytes = text.getBytes(StandardCharsets.UTF_8);
        
        System.out.println("  Default encoding bytes: " + defaultBytes.length);
        System.out.println("  UTF-8 encoding bytes: " + utf8Bytes.length);
        System.out.println("  Risk: Platform-dependent behavior!");
    }
}