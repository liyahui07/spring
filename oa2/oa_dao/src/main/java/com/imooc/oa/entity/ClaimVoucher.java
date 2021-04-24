package com.imooc.oa.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ClaimVoucher {
    private Integer id;
    private String cause;
    private String createSn;
    private Date createTime;
    private String nextDealSn;
    private Double totalAmount;
    private String status;
    private Employee creator;
    private Employee approve;
}
