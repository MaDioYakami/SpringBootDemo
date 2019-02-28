package com.springboot.demo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;


public class JavaSHA {
    private static String src = "object-oriente"; // 需要加密的原始字符串

    public static void main(String[] args) throws NoSuchAlgorithmException {

        System.out.println("原始字符串：" + src);

        jdkSHA1();
        bouncyCastleSHA1();
        commonsCodecSAH1();
        System.out.println();

        bouncyCastleSHA224();
        System.out.println();
        jdkSHA256();

        bouncyCastleSHA256();
    }

    /**
     * JDK实现sha-1
     */
    public static void jdkSHA1() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("sha");// sha1算法传入参数为sha
        byte[] sha1Bytes = md.digest(src.getBytes());
        System.out.println("JDK SHA-1:\t" + Hex.encodeHexString(sha1Bytes));
    }

    /**
     * JDK实现sha-256
     */
    public static void jdkSHA256() throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("sha-256");
        md.update(src.getBytes());
        System.out.println("JDK SHA-256:\t" + org.bouncycastle.util.encoders.Hex.toHexString(md.digest()));
    }

    /**
     * Bouncy Castle实现sha-1
     */
    public static void bouncyCastleSHA1() {

        Digest digest = new SHA1Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] sha1Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(sha1Bytes, 0);
        System.out.println("bc SHA-1:\t" + org.bouncycastle.util.encoders.Hex.toHexString(sha1Bytes));
    }

    /**
     * Bouncy Castle实现sha-224
     */
    public static void bouncyCastleSHA224() {

        Digest digest = new SHA224Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] sha224Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(sha224Bytes, 0);
        System.out.println("bc SHA-224:\t" + org.bouncycastle.util.encoders.Hex.toHexString(sha224Bytes));
    }

    /**
     * Bouncy Castle实现sha-256
     */
    public static void bouncyCastleSHA256() {
        Digest digest = new SHA256Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] sha256Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(sha256Bytes, 0);
        System.out.println("bc SHA-256:\t" + org.bouncycastle.util.encoders.Hex.toHexString(sha256Bytes));
    }

    /**
     * Commons Codec实现sha-1
     */
    public static void commonsCodecSAH1() {

        System.out.println("cc SHA-1:\t" + DigestUtils.sha1Hex(src.getBytes()));

        /* 采用下面的方式更加方便 */
//        System.out.println("cc SHA-1:\t" + DigestUtils.sha1Hex(src));

    }


}
