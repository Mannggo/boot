import org.junit.Test;
import util.AesUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author 谢仲东 2018-12-05 11:55
 */
public class AesTest {

    @Test
    public void aesTest () throws UnsupportedEncodingException {
        String text = "ab6846a4s16d5f132asd1f65w4er6t5132sa1g32d1xc3vb13as24fdg6a4e65fg13asd21fg3adf21g321sd32fg13dasf1gttab6846a4s16d5f132asd1f65w4er6t5132sa1g32d1xc3vb13as24fdg6a4e65fg13asd21fg3adf21g321sd32fg13dasf1gttab6846a4s16d5f132asd1f65w4er6t5132sa1g32d1xc3vb13as24fdg6a4e65fg13asd21fg3adf21g321sd32fg13dasf1gtt    ";
        String pk = "bug";
        byte[] es = AesUtils.encrypt(text, pk);
        String e = AesUtils.toHexString(es);
        System.out.println(e);

        String ea = new String(AesUtils.decrypt(es, "ccd"), "utf-8");
        System.out.println(ea);
    }
}
