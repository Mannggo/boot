package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 谢仲东
 * @description 异常信息枚举
 * @since 21:54 星期四 2018/12/13
 */
@Getter
@AllArgsConstructor
public enum ExceptionMsg {
    PARAM_ERROR("参数错误","1001"),
    SIGN_ERROR("验签失败", "1002"),
    SYSTEM_ERROR("系统异常", "1003");
    private String msg;
    private String code;

}
