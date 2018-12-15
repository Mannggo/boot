package com.zhongd.bootapi.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import util.Md5SignUtils;

import java.util.UUID;

/**
 * @author 谢仲东 2018-12-15 16:41
 */
@Slf4j
public class SignTest {

    @Test
    public void testSign() {
        String appId = "8899";
        String randomStr = "135";
        String text = appId.concat(randomStr).concat("8848");
        log.info(text);
        log.info(randomStr);
        log.info(Md5SignUtils.encrypt(text));
    }
}
