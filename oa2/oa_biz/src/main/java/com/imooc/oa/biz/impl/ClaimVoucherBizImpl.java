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
        return claimVoucherItemDao.selectAll(cvid);
    }

    public List<DealRecord> getRecord(Integer cvid) {
        return dealRecordDao.selectAll(cvid);
    }

    public List<ClaimVoucher> getForSelf(String sn) {
        return claimVoucherDao.selectAllC(sn);
    }

    public List<ClaimVoucher> getForDeal(String sn) {
        return claimVoucherDao.selectAllH(sn);
    }

    public void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items) {
        claimVoucherDao.update(claimVoucher);
        List<ClaimVoucherItem> old = claimVoucherItemDao.selectAll(claimVoucher.getId());
        for (ClaimVoucherItem claimVoucherItem :
             items) {
            boolean flag = false;
            int id = 0;
            for (ClaimVoucherItem c :
                    old) {
                if (c.getId() == claimVoucherItem.getId()) {
                    flag = true;
                    id = c.getId();
                    break;
                }
                }
            if (flag){
                claimVoucherItemDao.delete(id);
            }
        }
        for (ClaimVoucherItem c :
                items) {
            if (c.getId() > 0 && c.getId() != null) {
                claimVoucherItemDao.update(c);
            }else {
                claimVoucherItemDao.insert(c);
            }
            }

    }


}
