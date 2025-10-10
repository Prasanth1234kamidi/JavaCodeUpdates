package kemApi;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import javax.crypto.KEM;

public class KemExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();

        // 2. Create KEM instance
        KEM kem = KEM.getInstance("RSA-KEM");

        // 3. Encapsulate (sender side) → produce shared secret + encapsulated key
        KEM.Encapsulated enc = kem.newEncapsulator(kp.getPublic()).encapsulate();

        byte[] secretKeySender = enc.key().getEncoded();  // Sender’s shared secret
        byte[] encapsulatedKey = enc.encapsulation();     // Encrypted form

        // 4. Decapsulate (receiver side) → recover the same shared secret
        byte[] secretKeyReceiver = kem.newDecapsulator(kp.getPrivate())
                                      .decapsulate(encapsulatedKey)
                                      .getEncoded();

        // Both sender and receiver now share the SAME symmetric key
        System.out.println("Keys match? " + java.util.Arrays.equals(secretKeySender, secretKeyReceiver));

	}

}
