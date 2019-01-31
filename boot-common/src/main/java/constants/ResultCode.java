package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 谢仲东
 * @description
 * @since 23:11 星期一 2018/12/17
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

    SYS_ERROR("-1", "系统异常"),
    SERVICE_ERROR("-2", "网络断了吧？"),
    LOGIN_ERROR("401", "登录超时"),
    AUTH_ERROR("403", "权限不足"),
    SUCCESS("0", "成功");

    private String code;
    private String defaultMsg;

}
