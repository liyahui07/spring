package com.imooc.oa.entity;

import lombok.Data;

import java.util.Date;

@Data
public class DealRecord {
    private Integer id;
    private Integer claimVoucherId;
    private String dealSn;
    private Date dealTime;
    private String dealWay;
    private String dealRest;
    private String comment;
    private Employee dealer;
}
