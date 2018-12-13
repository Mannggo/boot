package com.zhongd.bootapi.dto.request;

import lombok.Data;
import entity.BaseData;

/**
 * @author 谢仲东
 * @description
 * @since 22:15 星期四 2018/12/13
 */
@Data
public class QueryParam extends BaseData {
    private String queryString;
    private String queryType;
}
