package entity;

import constants.ExceptionMsg;
import constants.ReturnEnum;
import lombok.Data;

/**
 * @author 谢仲东
 * @description
 * @since 21:40 星期四 2018/12/13
 */
@Data
public class BaseResponse<T extends BaseData> {

    private String rtMsg;
    private String rtCode;
    private String errCode;
    private String sign;
    private String randomStr;
    private T data;

    public static BaseResponse success(BaseData o) {
        BaseResponse b = success();
        b.setData(o);
        return b;
    }

    public static BaseResponse success() {
        BaseResponse b = new BaseResponse();
        b.setRtMsg(ReturnEnum.SUCCESS.getRtMsg());
        b.setRtCode(ReturnEnum.SUCCESS.getRtCode());
        return b;
    }

    public static BaseResponse systemError() {
        BaseResponse b = new BaseResponse();
        b.setRtMsg(ReturnEnum.FAIL.getRtMsg());
        b.setRtCode(ReturnEnum.FAIL.getRtCode());
        b.setErrCode(ExceptionMsg.SYSTEM_ERROR.getCode());
        return b;
    }

    public static BaseResponse fail(String msg, String errCode) {
        BaseResponse b = new BaseResponse();
        b.setRtMsg(msg);
        b.setRtCode(ReturnEnum.FAIL.getRtCode());
        b.setErrCode(errCode);
        return b;
    }
}
