/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.JOptionPane;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/**
 *
 * @author gbojan
 */
public class Client {
    private Socket sock;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private byte[] salt;
    private String username;
    private String password; 
    //private Utilities util;
    private File clientFile;
    private X509Certificate caCert;
    private PublicKey caPublicKey;
    private byte[] symmetricKey;
    private SecretKey secretKey;
    private KeyPair clientKey;
    private X509Certificate clientCert;
    private PrivateKey privKeyClient;
    private SecretKey newSecretKey;
    //private DatotekeFrame datoteke;
    private MessagingForm messaging;
    private File korisnickeDatoteke;
    
    public Client(){
        try{
        Security.addProvider(new BouncyCastleProvider());
        sock = new Socket("localhost",8888);
        }catch(Exception e){
            e.printStackTrace();
    }
}  
    
    public String login(String username, String password){
    String odg = "";
//    try{
//        clientFile = new File("klijenti"+File.separator+username);
//        korisnickeDatoteke = new File(clientFile.getPath()+File.separator+"Datoteke");
//        //System.out.println("Funkicja Login: " +salt);
//        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
//        SecretKey secretKey = secretKeyFactory.generateSecret(new PBEKeySpec(password.toCharArray(), salt, 1000, 256));
//        String hash = Base64.getEncoder().encodeToString(secretKey.getEncoded());
//        oos.writeObject("LOG#"+username+"#"+hash);
//        odg = (String)ois.readObject();
//       // System.out.println("Login: "+odg);
//        if("OK".equals(odg)){
//            oos.writeObject("hello");
//           File f = new File(clientFile+File.separator+username);
//           FileInputStream fisPriv = new FileInputStream(f);
//           DataInputStream dis = new DataInputStream(fisPriv);
//           byte[] privateKeyBytes = new byte[(int)f.length()];
//           dis.readFully(privateKeyBytes);
//           dis.close();
//           fisPriv.close();
//
//          PKCS8EncodedKeySpec spec = new  PKCS8EncodedKeySpec(privateKeyBytes);
//          KeyFactory kf = KeyFactory.getInstance("RSA");
//          privKeyClient = kf.generatePrivate(spec);
           
//            newSecretKey = (SecretKey)getEncryptedMessage(privKeyClient);
//           // System.out.println("NOVI TAJNI KLJUC "+newSecretKey);
//            sendEncryptedMessage("Saljem sertifikat",newSecretKey);
                       
//            System.out.println(sendCert(new File(clientFile+File.separator+"cert.crt"),newSecretKey));
//            String sertIspravan = (String)getEncryptedMessage(newSecretKey);
//            System.out.println(sertIspravan);
//            if("Sertifikat je ispravan!".equals(sertIspravan)){
//                CertificateFactory fact = CertificateFactory.getInstance("X.509");
//                FileInputStream is = new FileInputStream (new File(clientFile+File.separator+"server.crt"));
//                this.caCert = (X509Certificate) fact.generateCertificate(is);
                JOptionPane.showMessageDialog(null, "Uspjesno ste se ulogovali! \n Vas Sertifikat je ispravan!");
                messaging = new MessagingForm(this);
                messaging.setLocationRelativeTo(null);
                messaging.setDefaultCloseOperation(messaging.HIDE_ON_CLOSE);
               // messaging.setSize(800, 600);
                messaging.setVisible(true);
//                datoteke = new DatotekeFrame(this);
//                datoteke.setLocationRelativeTo(null);
//                datoteke.setDefaultCloseOperation(datoteke.HIDE_ON_CLOSE);
//                datoteke.setSize(550, 350);
//                datoteke.setVisible(true);
                /*FilesForm filesForm = new FilesForm();
                filesForm.setVisible(true);*/
//            }
        
//        }
//    }catch(Exception e){
//        e.printStackTrace();
//    }
    
    return(odg);
    }
    
    
}
