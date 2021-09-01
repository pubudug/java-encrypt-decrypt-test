import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Base64;

public class Decrypt {
    public static void main(String[] args) throws IOException, KeyStoreException,
            CertificateException, NoSuchAlgorithmException, InvalidKeyException, UnrecoverableKeyException, NoSuchPaddingException, BadPaddingException, IllegalBlockSizeException {

        KeyStore serverKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());

        FileInputStream stream = new FileInputStream("./server-keystore");
        serverKeyStore.load(stream, "changeit".toCharArray());

        Key key = serverKeyStore.getKey("server", "changeit".toCharArray());
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        cipher.init(Cipher.DECRYPT_MODE, key);
        System.out.println(new String(cipher.doFinal(Base64.getDecoder().decode("E+xAck78julGgpZFPSJQ8BlMuFGuAEv4SlwT/qwnhx3B+m39qhxFiNTfoFonO1pV4Nv0YLu+KDHHzR473RPrINuwQV6IZ8jb8B47bGBkuG+FVXsMAqIEFf26YVnQXjRcpJcOgFYDM0HY7/6HMra5w0hSU18gH2U889HwHR35vd6oLqH1HkFKtvki50WpvwTmpuRhA2IL0w2onjMHu7mnN0aEJ5rMGV6FpFXYQMbwSBMVBXVdVMdInudCbBEuyl7z8mr2h345c5s4PzK2u2z5gQeaonpCKqvdq96lfJympsArhUAMlCG81BcHbDHP3UKyaqKJAFZy/i290iKykWR9dw=="))));
    }
}
