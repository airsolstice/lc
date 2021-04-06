package org.example.hos;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSAEncryptor {

    public RSAEncryptor() {
    }

    private RSAPrivateKey loadPrivateKey(String var1) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PKCS8EncodedKeySpec var2 = new PKCS8EncodedKeySpec(Base64.decode(var1, 0));
        return (RSAPrivateKey)KeyFactory.getInstance("RSA").generatePrivate(var2);
    }

    private RSAPublicKey loadPublicKey(String var1) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] var2 = Base64.decode(var1, 0);
        return (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(var2));
    }

    public byte[] decrypt(String var1, byte[] var2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        Cipher var3 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        var3.init(2, this.loadPrivateKey(var1));
        return var3.doFinal(var2);
    }

    public byte[] encrypt(String var1, byte[] var2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher var3 = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        var3.init(1, this.loadPublicKey(var1));
        return var3.doFinal(var2);
    }
}
