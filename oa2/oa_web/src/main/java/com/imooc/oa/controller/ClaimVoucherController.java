package com.imooc.oa.controller;

import com.imooc.oa.biz.ClaimVoucherBiz;
import com.imooc.oa.dao.ClaimVoucherDao;
import com.imooc.oa.dto.ClaimVoucherInfo;
import com.imooc.oa.entity.ClaimVoucher;
import com.imooc.oa.entity.Employee;
import com.imooc.oa.global.Content;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/claim_voucher")
public class ClaimVoucherController {

    @Autowired
    ClaimVoucherBiz claimVoucherBiz;




    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
       map.put("claimVoucherInfo",new ClaimVoucherInfo());
       map.put("item", Content.getItems());
       return "claim_voucher_add";
    }

    @RequestMapping("/add")
    public String add(HttpSession session,ClaimVoucherInfo claimVoucherInfo){
        Employee employee = (Employee)session.getAttribute("employee");
        claimVoucherInfo.getClaimVoucher().setCreator(employee);
        claimVoucherBiz.save(claimVoucherInfo.getClaimVoucher(),claimVoucherInfo.getItems());
        return "redirect:detail?id" + claimVoucherInfo.getClaimVoucher().getId();
    }

    @RequestMapping("/detail")
    public String detail(Integer id,Map<String,Object> map){
        map.put("claimVoucher",claimVoucherBiz.getClaimVoucher(id));
        map.put("claimVoucherItem",claimVoucherBiz.getCVItem(id));
        map.put("record",claimVoucherBiz.getRecord(id));
        return "claim_voucher_detail";
    }

    @RequestMapping("/self")
    public String self(HttpSession session,Map<String,Object> map){
        Employee employee = (Employee)session.getAttribute("employee");
        map.put("self",claimVoucherBiz.getForSelf(employee.getSn()));
        return "claim_voucher_self";
    }

    @RequestMapping("/deal")
    public String deal(HttpSession session,Map<String,Object> map){
        Employee employee = (Employee)session.getAttribute("employee");
        map.put("deal",claimVoucherBiz.getForDeal(employee.getSn()));
        return "claim_voucher_deal";
    }

    @RequestMapping("/to_update")
    public String toUpdate(Integer id, Map<String,Object> map){
        map.put("item",Content.getItems());
        ClaimVoucherInfo claimVoucherInfo = new ClaimVoucherInfo();
        claimVoucherInfo.setClaimVoucher(claimVoucherBiz.getClaimVoucher(id));
        claimVoucherInfo.setItems(claimVoucherBiz.getCVItem(id));
        map.put("info",claimVoucherInfo);
        return "claim_voucher_update";
    }

    @RequestMapping("/update")
    public String update(ClaimVoucherInfo info){
        claimVoucherBiz.update(info.getClaimVoucher(),info.getItems());
        return "redirect:deal";
    }


}
