package com.imooc.oa.biz;


import com.imooc.oa.dao.ClaimVoucherDao;
import com.imooc.oa.entity.ClaimVoucher;
import com.imooc.oa.entity.ClaimVoucherItem;
import com.imooc.oa.entity.DealRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ClaimVoucherBiz {

    void save(ClaimVoucher claimVoucher,List<ClaimVoucherItem> items);

    ClaimVoucher getClaimVoucher(Integer id);
    List<ClaimVoucherItem> getCVItem(Integer cvid);
    List<DealRecord> getRecord(Integer cvid);
    List<ClaimVoucher> getForSelf(String sn);
    List<ClaimVoucher> getForDeal(String sn);
    void update(ClaimVoucher claimVoucher,List<ClaimVoucherItem> items);


}
