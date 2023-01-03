import hu.eteosf.digitalsignature.Document;
import hu.eteosf.digitalsignature.XmlDigitalSignatureException;
import hu.eteosf.digitalsignature.XmlDigitalSignatureImpl;
import hu.eteosf.digitalsignature.KeyStoreUtil;

import javax.xml.crypto.dsig.DigestMethod;
import javax.xml.crypto.dsig.SignatureMethod;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    private static byte[] signed;

    public static void main(String[] args) {

        XmlDigitalSignatureImpl xmlDigitalSignature = new XmlDigitalSignatureImpl();

        Document doc = new Document(KeyStoreUtil.Fpath,KeyStoreUtil.Fpath.getBytes());
        try {
           signed = xmlDigitalSignature.generateDetachedSignature(doc, DigestMethod.SHA512, SignatureMethod.RSA_SHA512);
        } catch (XmlDigitalSignatureException e) {
            throw new RuntimeException(e);
        }
        Path path = Paths.get("F:/Zami/xml-digital-signature-java/src/test/resources/output.xml");
        try {
            Files.write(path,signed);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
