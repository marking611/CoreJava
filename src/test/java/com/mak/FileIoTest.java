package com.mak;

import org.junit.Test;

import java.io.*;

/**
 * Created by makai on 2017/10/12.
 */
public class FileIoTest {
    private String 十to十六(int i) {
        return Integer.toHexString(i);
    }

    private int 十六to十(String s) {
        return Integer.parseInt(s, 16);
    }

    private byte[] fileToByte(String filepath) throws Exception {
        FileInputStream fs = new FileInputStream(filepath);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int ch;
        while ((ch = fs.read()) != -1) {
            byteArrayOutputStream.write(ch);
        }
        byte[] data = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return data;
    }

    public String byteTo十六(byte[] data) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(Integer.toHexString(data[i]));
        }
        return sb.toString();
    }

    private byte[] 十六toByte(String hexString) {
        hexString = hexString.toLowerCase();
        final byte[] byteArray = new byte[hexString.length() / 2];
        int k = 0;
        for (int i = 0; i < byteArray.length; i++) {//因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
            byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
            byte low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
            byteArray[i] = (byte) (high << 4 | low);
            k += 2;
        }
        return byteArray;
    }


    public void toFile(byte[] data, String filename) {
        File file = new File(filename);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test() {
        String s = "0x504B0304140008000800024973460000000000000000000000000B0000006D61696E646F632E786D6C9D52CD4EDB4010BEF729829B2B5EAFF367836D04A4890890D206907A8A36F69A6C62EF5ADE25064EA8EAA55525C4A9127D859EAB1E685FA6058E7D858E0D21015155EA1E76E7DBFD6676E69B71568EE2A834A1A96482BB1AD60DAD44B92F02C60F5CED50858B96B6E23D7302E11FC694AB12D0B95C3A1AAA3872B5A152C912425996E9594517E901C2B66DA3E255F39C2415094D15A3F2DE3E2E71125357DBA60123AD881C689EF1683968CAF5EECDF9104F85534C4554F3C2B10C96C371492E07E1F8440611805FDF3EDC5CBCFB7DF9F9E6FBC5F5971FD71FDF5F7FFA0AF0EAF2F4EAEC7C06CFCEE73F7E147F5A7E3F221C523E192EFAFCAF79FA822BE0CEAC120B5CEDCEEE6310662082E35B25FFADE17F17F5F3F42DE405B9E5BFC17197C0CC820439CD8852C41FE6C549E4390F91A4298C06E3A1F01C3118515FB1C08306DDDB4E4A439AC2C0D01E53D4BBAB05DBA68EEB960E7B0DC117129AAD504C1847DBB0E923993C77D043D77CC276881A7ABA8E72BA48519BAAA6F00B8F40AC242425B1BBB7B7D17471D5AC37CC8669D66A8D7A19381B4DE9562A76D5CAC1161B00C7C4E5D67ECE35CCF2EA767F07CA10818BAD1CEC8A84153E46F194B2C93A51C035CA4C766906E77AA7DFDB5B5B5FDD2D6E33E81F3F8CA2B24F788F4C683325A182FB8848D5125140D382D6E9BDE8F5365E7601ACC976B2BF19BEDA6CF311C63BA3EEB05B19CBD75BE19BAE7162D53AFBF166BDC26DA3353C1ED8DDC9A0B365B61770C3361A26AE1AD6C26D8575AB6A99183B68AA0D8C259B10450B2D9E527BC9326682E753394777D07C3BD174A4BD3F504B0708AF4367CE5002000003040000504B0304140008000800024973460000000000000000000000000D000000726576657273696F6E2E786D6CCD54BB4E0241143DB1319058DA4883D6CAEE8AF80085102DB41013B1F2457459C0000B61177C34C6848FA0F213FC103BFEC4CAD2F5CC0C8FB09020892666B23377CEB98F337327FBE56117293CA08A0AC268C142030EEE50838D3DACC040043AD730191B26F13C591B45C936E1A280357A6D729742120B0832A3CB2C37F4B670CCD5664481B6435C7904E8335ACB21E3C7FA7A8E585354533A4C2216B3BA9CCFE859E52AD875F2066254A3232A356DD3DBC016E244639C37E823323459613C6F1FCD30772F67E925F326399B7ADC21D66A370E8BAB64B41FA8366654BD436F9D739CB3506DCCAAFAFAF5E4FDF2C3AF5BA13EE5DA842EF4FB634AC4957D777BFD19C526F547782DE302FB38409A274DD3F6C7099F5BF9921E9943BD3D515BE428917751E7B9358E7B3922FCA29C6BAC55242AEE480C8DB1C25FC4ABCA7524738B9D8EB724CF56EF63A5F971";
        toFile(十六toByte(s), "K:\\cf\\a.zip");
    }
}
