package com.imooc.oa.global;

import java.util.ArrayList;
import java.util.List;

public class Content {


    //员工的职位
    public static final String POST_STAFF = "员工";
    public static final String POST_PM = "客户经理";
    public static final String POST_GM = "总经理";
    public static final String POST_FINANCE = "财务";

    public static  List<String> getPost(){
        List<String> list = new ArrayList<String>();
        list.add(POST_FINANCE);
        list.add(POST_GM);
        list.add(POST_PM);
        list.add(POST_STAFF);
        return list;
    }



    //报销单的具体事项
    public static List<String> getItems(){
        List<String> list = new ArrayList<String>();
        list.add("交通");
        list.add("餐饮");
        list.add("住宿");
        list.add("交际");
        return list;
    }


    //报销单状态
    public static final String CLAIM_VOUCHER_CREATE = "新创建";
    public static final String CLAIM_VOUCHER_BACK = "打回";
    public static final String CLAIM_VOUCHER_REJECT = "拒绝";
    public static final String CLAIM_VOUCHER_APPROVED = "已审核";
    public static final String CLAIM_VOUCHER_SUBMIT = "已提交";
    public static final String CLAIM_VOUCHER_RECHECK = "待复审";
    public static final String CLAIM_VOUCHER_PAID = "已打款";
    public static final String CLAIM_VOUCHER_PASS = "已通过";



    public static final String DEAL_CREATE = "创建";
    public static final String DEAL_SUBMIT = "提交";
    public static final String DEAL_BACK = "打回";
    public static final String DEAL_REJECT = "拒绝";
    public static final String DEAL_RECHECK = "待复审";
    public static final String DEAL_PASS = "通过";
    public static final String DEAL_PAID = "打款";
    public static final String DEAL_APPROVED = "审核";

}
