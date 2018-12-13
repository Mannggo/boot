package com.zhongd.bootapi.dto.response;

import lombok.Data;
import entity.BaseData;

import java.util.List;

/**
 * @author 谢仲东
 * @description
 * @since 22:17 星期四 2018/12/13
 */
@Data
public class QueryResponse extends BaseData {
    private List<String> dataList;
    private String remark;
}
