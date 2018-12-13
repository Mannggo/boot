package entity;

import lombok.Data;

/**
 * @author 谢仲东
 * @description
 * @since 22:12 星期四 2018/12/13
 */
@Data
public class BaseRequest<T extends BaseData> {
    private String appId;
    private String sign;
    private String randomStr;
    private T data;
}
