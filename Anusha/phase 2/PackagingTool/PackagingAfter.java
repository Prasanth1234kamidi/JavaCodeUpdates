/**
 * Application Packaging After Java 17
 * Shows jpackage tool capabilities
 */
public class PackagingAfter {
    public static void main(String[] args) {
        System.out.println("=== Application Packaging After Java 17 ===\n");
        
        // 1. jpackage tool introduction
        demonstrateJPackage();
        
        // 2. Native packaging capabilities
        demonstrateNativePackaging();
        
        // 3. Platform-specific installers
        demonstratePlatformInstallers();
        
        // 4. Benefits and improvements
        demonstrateBenefits();
    }
    
    private static void demonstrateJPackage() {
        System.out.println("1. jpackage Tool (Java 14+, Production in Java 17):");
        System.out.println("  What is jpackage:");
        System.out.println("    ✓ Built-in packaging tool");
        System.out.println("    ✓ Creates native installers");
        System.out.println("    ✓ Bundles JRE with application");
        System.out.println("    ✓ Platform-specific packages");
        
        System.out.println("\n  Supported package formats:");
        System.out.println("    Windows: .exe, .msi");
        System.out.println("    macOS: .pkg, .dmg");
        System.out.println("    Linux: .deb, .rpm");
        
        System.out.println("\n  Basic jpackage command:");
        System.out.println("    jpackage --input input-dir \\");
        System.out.println("             --name MyApp \\");
        System.out.println("             --main-jar myapp.jar \\");
        System.out.println("             --main-class com.example.Main \\");
        System.out.println("             --type exe");
        System.out.println();
    }
    
    private static void demonstrateNativePackaging() {
        System.out.println("2. Native Packaging Capabilities:");
        
        System.out.println("  Self-contained applications:");
        System.out.println("    ✓ No Java installation required on target");
        System.out.println("    ✓ Bundled JRE (custom runtime)");
        System.out.println("    ✓ Native executable generation");
        System.out.println("    ✓ Desktop integration");
        
        System.out.println("\n  Example packaging commands:");
        
        System.out.println("\n  Windows Installer (.msi):");
        System.out.println("    jpackage --input dist \\");
        System.out.println("             --name \"My Java App\" \\");
        System.out.println("             --main-jar app.jar \\");
        System.out.println("             --main-class com.example.App \\");
        System.out.println("             --type msi \\");
        System.out.println("             --win-dir-chooser \\");
        System.out.println("             --win-shortcut \\");
        System.out.println("             --win-menu");
        
        System.out.println("\n  Application Image (runtime + app):");
        System.out.println("    jpackage --input dist \\");
        System.out.println("             --name MyApp \\");
        System.out.println("             --main-jar app.jar \\");
        System.out.println("             --main-class com.example.App \\");
        System.out.println("             --type app-image");
        System.out.println();
    }
    
    private static void demonstratePlatformInstallers() {
        System.out.println("3. Platform-Specific Installer Features:");
        
        System.out.println("  Windows Features:");
        System.out.println("    ✓ Start Menu integration");
        System.out.println("    ✓ Desktop shortcuts");
        System.out.println("    ✓ File associations");
        System.out.println("    ✓ Add/Remove Programs entry");
        System.out.println("    ✓ Windows Registry integration");
        
        System.out.println("\n  macOS Features:");
        System.out.println("    ✓ Applications folder integration");
        System.out.println("    ✓ Dock integration");
        System.out.println("    ✓ Code signing support");
        System.out.println("    ✓ Notarization ready");
        System.out.println("    ✓ Native look and feel");
        
        System.out.println("\n  Linux Features:");
        System.out.println("    ✓ Package manager integration");
        System.out.println("    ✓ Desktop environment integration");
        System.out.println("    ✓ System service support");
        System.out.println("    ✓ Dependency management");
        
        System.out.println("\n  Advanced jpackage options:");
        demonstrateAdvancedOptions();
    }
    
    private static void demonstrateAdvancedOptions() {
        System.out.println("  Custom JRE with jlink:");
        System.out.println("    # Create custom runtime");
        System.out.println("    jlink --add-modules java.base,java.desktop \\");
        System.out.println("          --output custom-jre \\");
        System.out.println("          --compress=2 \\");
        System.out.println("          --no-header-files \\");
        System.out.println("          --no-man-pages");
        
        System.out.println("\n    # Package with custom runtime");
        System.out.println("    jpackage --runtime-image custom-jre \\");
        System.out.println("             --input dist \\");
        System.out.println("             --name MyApp \\");
        System.out.println("             --main-jar app.jar");
        
        System.out.println("\n  Resource customization:");
        System.out.println("    --icon app-icon.ico          # Custom icon");
        System.out.println("    --app-version 1.0.0          # Version info");
        System.out.println("    --vendor \"My Company\"        # Vendor name");
        System.out.println("    --copyright \"© 2024\"         # Copyright");
        System.out.println("    --description \"My App\"       # Description");
    }
    
    private static void demonstrateBenefits() {
        System.out.println("\n4. Benefits of jpackage (Java 17+):");
        
        System.out.println("  User Benefits:");
        System.out.println("    ✓ No Java installation required");
        System.out.println("    ✓ Native installer experience");
        System.out.println("    ✓ Desktop integration");
        System.out.println("    ✓ Faster startup times");
        System.out.println("    ✓ Smaller memory footprint");
        
        System.out.println("\n  Developer Benefits:");
        System.out.println("    ✓ Built-in tool (no third-party dependencies)");
        System.out.println("    ✓ Cross-platform packaging");
        System.out.println("    ✓ Simplified distribution");
        System.out.println("    ✓ Professional deployment");
        System.out.println("    ✓ App store ready packages");
        
        System.out.println("\n  Technical Benefits:");
        System.out.println("    ✓ Custom JRE reduces size");
        System.out.println("    ✓ Better security (isolated runtime)");
        System.out.println("    ✓ Consistent user experience");
        System.out.println("    ✓ Easy updates and maintenance");
        
        // Show current environment info
        System.out.println("\n  Current Environment:");
        System.out.println("    Java Version: " + System.getProperty("java.version"));
        System.out.println("    jpackage available: " + isJPackageAvailable());
        System.out.println("    Platform: " + System.getProperty("os.name"));
        System.out.println("    Architecture: " + System.getProperty("os.arch"));
        
        demonstratePackagingWorkflow();
    }
    
    private static boolean isJPackageAvailable() {
        try {
            ProcessBuilder pb = new ProcessBuilder("jpackage", "--version");
            Process process = pb.start();
            return process.waitFor() == 0;
        } catch (Exception e) {
            return false;
        }
    }
    
    private static void demonstratePackagingWorkflow() {
        System.out.println("\n  Complete Packaging Workflow:");
        System.out.println("    1. Compile application:");
        System.out.println("       javac -d classes src/*.java");
        
        System.out.println("    2. Create JAR:");
        System.out.println("       jar --create --file app.jar --main-class Main -C classes .");
        
        System.out.println("    3. Create custom runtime (optional):");
        System.out.println("       jlink --add-modules java.base,java.desktop --output runtime");
        
        System.out.println("    4. Package application:");
        System.out.println("       jpackage --input . --name MyApp --main-jar app.jar --type exe");
        
        System.out.println("    5. Distribute installer:");
        System.out.println("       MyApp-1.0.exe (ready for distribution)");
        
        System.out.println("\n  Result: Professional, native installer ready for end users!");
    }
}