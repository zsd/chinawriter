package bussiness.comm;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * MD5Encryption测试类.
 */
public class MD5EncryptionTest {

    @Test
    public void testEncoderByMd5() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String result = MD5Encryption.EncoderByMd5("123");
        System.out.println("123加密后的内容：" + result);
    }
}
