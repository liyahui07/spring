package com.imooc.oa.biz.impl;

import com.imooc.oa.biz.ClaimVoucherBiz;
import com.imooc.oa.dao.ClaimVoucherDao;
import com.imooc.oa.dao.ClaimVoucherItemDao;
import com.imooc.oa.dao.DealRecordDao;
import com.imooc.oa.entity.ClaimVoucher;
import com.imooc.oa.entity.ClaimVoucherItem;
import com.imooc.oa.entity.DealRecord;
import com.imooc.oa.global.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClaimVoucherBizImpl implements ClaimVoucherBiz {

    @Autowired
    ClaimVoucherDao claimVoucherDao;
    @Autowired
    ClaimVoucherItemDao claimVoucherItemDao;
    @Autowired
    DealRecordDao dealRecordDao;


    public void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {
        claimVoucher.setCreateTime(new Date());
        claimVoucher.setNextDealSn(claimVoucher.getCreateSn());
        claimVoucher.setStatus(Content.CLAIM_VOUCHER_CREATE);
        claimVoucherDao.insert(claimVoucher);

        for (ClaimVoucherItem c :
                items) {
            claimVoucherItemDao.insert(c);
        }
    }

    public ClaimVoucher getClaimVoucher(Integer id) {
        return claimVoucherDao.selectOne(id);
    }

    public List<ClaimVoucherItem> getCVItem(Integer cvid) {
        return null;
    }

    public List<DealRecord> getRecord(Integer cvid) {
        return null;
    }


}
