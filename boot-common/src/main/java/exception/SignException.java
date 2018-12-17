package exception;

import lombok.Getter;

/**
 * @author 谢仲东
 * @description 签名异常
 * @since 22:43 星期四 2018/12/13
 */
@Getter
public class SignException extends RuntimeException {

    private String code;
    private String msg;

    public SignException() {
        this.code = "SIGN_CHECK_FAIL";
        this.msg = "验签失败";
    }
}
