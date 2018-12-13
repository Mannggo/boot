package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author 谢仲东 2018-12-06 8:49
 */
public class LyyPaymentAesUtils {

    public static String encrypt(HashMap<String, String> data, String secret) {
        List<String> keys = new ArrayList<String>(data.keySet());
        Collections.sort(keys);
        StringBuilder resp = new StringBuilder();
        for(String key : keys){
            resp.append(key).append("=").append(data.get(key));
            resp.append("&");
        }
        resp.setLength(resp.length() - 1);
        return AesUtils.toHexString(AesUtils.encrypt(resp.toString(), secret));
    }


    public static String decrypt(String ciphertext, String secret) {
        String resp = new String(AesUtils.decrypt(AesUtils.toByteArray(ciphertext), secret));
        return resp;
    }

}
