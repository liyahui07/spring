package com.imooc.oa.dao;

import com.imooc.oa.entity.ClaimVoucher;
import com.imooc.oa.entity.ClaimVoucherItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimVoucherDao {
    void insert(ClaimVoucher claimVoucher);
    void update(ClaimVoucher claimVoucher);
    void delete(Integer id);
    ClaimVoucher selectOne(Integer id);
    List<ClaimVoucher> selectAllC(String csn);
    List<ClaimVoucher> selectAllH(String hsn);
}
