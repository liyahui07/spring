package com.imooc.oa.dao;

import com.imooc.oa.entity.DealRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealRecordDao {
    void insert(DealRecord dealRecord);
    List<DealRecord> selectAll(Integer id);
}
