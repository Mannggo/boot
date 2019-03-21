package com.zhongd.websocket.dto;

import lombok.Data;

import java.util.List;

/**
 * @author 谢仲东
 * @date 2019/3/20 14:05
 */
@Data
public class MessageDTO {

    private String toId;

    private String fromId;

    /**
     * 消息分组
     */
    private List<String> groups;

    /**
     * 消息类型
     * @see com.zhongd.websocket.enums.MessageTypeEnums
     */
    private Integer type;
}
