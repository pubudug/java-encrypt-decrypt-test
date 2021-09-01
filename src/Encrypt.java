import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;


public class Encrypt {
    public static void main(String[] args) throws CertificateException, NoSuchAlgorithmException, IOException,
            IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, BadPaddingException {
        FileInputStream fis = new FileInputStream("./server.cer");
        CertificateFactory cf = CertificateFactory.getInstance("X509");
        X509Certificate crt = (X509Certificate) cf.generateCertificate(fis);

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, crt);


        System.out.println(Base64.getEncoder().encodeToString(cipher.doFinal("Encrypt this".getBytes())));
    }
}
