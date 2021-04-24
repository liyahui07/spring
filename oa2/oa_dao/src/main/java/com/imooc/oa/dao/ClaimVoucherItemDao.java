package com.imooc.oa.dao;

import com.imooc.oa.entity.ClaimVoucherItem;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClaimVoucherItemDao {

    void insert(ClaimVoucherItem claimVoucherItem);
    void update(List<ClaimVoucherItem> claimVoucherItemList,Integer claimVoucherId);
    void delete(Integer id);
    List<ClaimVoucherItem> selectAll(Integer id);
}
