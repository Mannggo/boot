import org.junit.Test;
import util.AesUtils;
import util.LyyPaymentAesUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * @author 谢仲东 2018-12-05 11:55
 */
public class AesTest {

    @Test
    public void aesTest () throws UnsupportedEncodingException {
        HashMap<String, String> data = new HashMap<String, String>();
        data.put("arg1", "one");
        data.put("arg2", "two");
        data.put("arg3", "three");
        data.put("arg4", URLEncoder.encode("https://lll.com?abc=222&123=222", "utf-8"));
        String secret = "zhongd";
        String ct = LyyPaymentAesUtils.encrypt(data, secret);
        System.out.println(ct);
        System.out.println(LyyPaymentAesUtils.decrypt(ct, secret));
    }

    @Test
    public void aa() {
        System.out.println(System.currentTimeMillis());
    }
}
