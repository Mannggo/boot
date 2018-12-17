package entity;

import constants.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author 谢仲东
 * @description
 * @since 23:10 星期一 2018/12/17
 */
@Data
@AllArgsConstructor
public class Result {

    private String code;
    private String msg;
    private Object data;

    public static Result success(Object data) {
        Result result = success();
        result.setData(data);
        return result;
    }

    public static Result success() {
        return new Result(ResultCode.SUCCESS.getCode(),
                ResultCode.SUCCESS.getDefaultMsg(), null);
    }

    public static Result serviceError() {
        return new Result(ResultCode.SERVICE_ERROR.getCode(),
                ResultCode.SERVICE_ERROR.getDefaultMsg(), null);
    }

    public static Result serviceError(String msg) {
        return new Result(ResultCode.SERVICE_ERROR.getCode(),
                msg, null);
    }
}