import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.util.Enumeration;

public class ListRootCertificates {
    public static void main(String[] args) {
        try {
            String cacertsPath = System.getProperty("java.home") + "/lib/security/cacerts";
            System.out.println("Reading certificates from: " + cacertsPath);

            KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
            keystore.load(new FileInputStream(cacertsPath), "changeit".toCharArray());

            Enumeration<String> aliases = keystore.aliases();
            int count = 0;

            while (aliases.hasMoreElements()) {
                String alias = aliases.nextElement();
                Certificate cert = keystore.getCertificate(alias);
                if (cert != null) {
                    count++;
                    System.out.println(count + ". Alias: " + alias);
                    System.out.println("   Type: " + cert.getType());
                }
            }

            System.out.println("\nTotal Trusted Certificates: " + count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

