package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 谢仲东
 * @description 返回状态码
 * @since 22:24 星期四 2018/12/13
 */
@Getter
@AllArgsConstructor
public enum  ReturnEnum {
    SUCCESS("S", "成功"), FAIL("F", "失败");
    private String rtCode;
    private String rtMsg;
}
