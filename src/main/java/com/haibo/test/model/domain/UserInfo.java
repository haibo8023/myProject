package com.haibo.test.model.domain;

import lombok.Data;

import java.util.List;

/**
 * @author XD
 * @date 2018/9/4 8:36
 */
@Data
public class UserInfo {
    private Integer code;
    private Integer light_state;
    private List<RankInfo> ranks;
}
