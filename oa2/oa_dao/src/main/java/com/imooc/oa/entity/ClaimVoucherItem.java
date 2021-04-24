package com.imooc.oa.entity;

import lombok.Data;

@Data
public class ClaimVoucherItem {
    private Integer id;
    private Integer claimVoucherId;
    private String item;
    private String amount;
    private String comment;
}
