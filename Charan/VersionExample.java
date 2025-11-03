public class VersionExample {
    public static void main(String[] args) {
        Runtime.Version version = Runtime.version();

        System.out.println("===== Java Version Details =====");
        System.out.println("Feature  : " + version.feature());   // Major version, e.g., 10, 17, 21
        System.out.println("Interim  : " + version.interim());   // Reserved (usually 0)
        System.out.println("Update   : " + version.update());    // Security update number
        System.out.println("Patch    : " + version.patch());     // Patch number
        System.out.println("Full Version String : " + version);  // e.g., 17.0.9+11
    }
}
