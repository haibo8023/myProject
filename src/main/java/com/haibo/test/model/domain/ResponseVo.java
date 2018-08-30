package com.haibo.test.model.domain;

import lombok.Data;

import java.util.List;

/**
 * @author XD
 * @date 2018/8/23 12:46
 */
@Data
public class ResponseVo {
    private List<CityInfo> ranks;
    private Integer code;

}
