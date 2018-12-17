package exception;

import constants.ExceptionMsg;
import lombok.Getter;

/**
 * @author 谢仲东
 * @description 参数异常
 * @since 21:05 星期四 2018/12/13
 */
@Getter
public class ParamException extends RuntimeException{
    private String msg;
    private String code;

    public ParamException(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    public ParamException() {
        this.code = ExceptionMsg.PARAM_ERROR.getCode();
        this.msg = ExceptionMsg.PARAM_ERROR.getMsg();
    }
}
