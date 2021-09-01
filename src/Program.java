import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Base64;

public class Program {
    public static void main(String[] args) throws IOException, KeyStoreException,
            CertificateException, NoSuchAlgorithmException, InvalidKeyException,
            UnrecoverableKeyException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {
        if (args.length != 3) {
            System.out.println("Usage\n" +
                    "java Program.class <keystore-file> <key-alias> <ciphertext>");
        }

        KeyStore serverKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());

        FileInputStream stream = new FileInputStream(args[0]);
        char[] password = System.console().readPassword("Keystore password: ");
        serverKeyStore.load(stream, password);

        Key key = serverKeyStore.getKey(args[1], password);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        cipher.init(Cipher.DECRYPT_MODE, key);
        System.out.println(new String(cipher.doFinal(Base64.getDecoder().decode(args[2]))));
    }
}
