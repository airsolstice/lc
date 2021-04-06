package org.example.hos;

public class Sign {

    public static void main(String[] args) {
        System.out.println(getPublicKeySignature("Ax12345678"));
    }

    public static String getPublicKeySignature(String var0) {
        try {
            String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDULnkXFuE3vTaJU3VfK2PIK89ksYASAM3BfBhur+Uj0vBI3+a0J8d4Lox7dbHBCVXll+H/VmQ2aXbfbOUi7xJcMSHehdP5nNS7KFeE1HBt0JJXqHPksTaE0Z2CbMb6EO4D1BefLJmpaPleU3db6+tkDcFoCK7d3yQ2lSY3V7f6IQIDAQAB";
            var0 = Base64.encodeToString((new RSAEncryptor()).encrypt(publicKey, var0.getBytes()), 0).replaceAll("\\n", "");
            return var0;
        } catch (Exception var1) {
            return null;
        }
    }
}
