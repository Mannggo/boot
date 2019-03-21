package com.zhongd.websocket.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 消息类型
 * @author 谢仲东
 * @date 2019/3/20 14:33
 */
@AllArgsConstructor
@Getter
public enum MessageTypeEnums {

    /**
     * 文本
     */
    TEXT(1),
    /**
     * 图片
     */
    PICTURE(2);

    private Integer type;
}
