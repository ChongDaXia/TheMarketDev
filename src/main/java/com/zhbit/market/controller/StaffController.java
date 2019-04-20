package com.zhbit.market.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhbit.market.entity.BStaff;
import com.zhbit.market.entity.BTakeOffice;
import com.zhbit.market.service.StaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {
	@Autowired
	private StaffService staffService;
	
	//保存新员工信息
	@PostMapping("/home/addnewstaff")
	public @ResponseBody Object saveNewStaff(BStaff staff,BTakeOffice office) {
		Map<String,Object> result=new HashMap<String,Object>();
		Integer theresult=staffService.insertNewStaff(staff);
		if(theresult>0) {
			List<BStaff> thestaff=staffService.getStaff(staff);
			if(thestaff.size()!=0) {
				office.setStaffId(thestaff.get(0).getStaffId());
				office.setCreateTime(new java.sql.Date((new java.util.Date()).getTime()));
				Integer theoffice=staffService.insertNewTakeOffice(office);
				if(theoffice>0) {
					result.put("code",200);
					return result;
				}
			}
		}
		result.put("code", 500);
		return result;
	}
	
	//获取所有员工信息
	@GetMapping("/home/getAllStaff")
	public @ResponseBody Object getAllStaff(BTakeOffice office) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BTakeOffice> theoffice=staffService.getTakeOffice(office);
		if(theoffice.size()!=0) {
			result.put("offices", theoffice);
			List<BStaff> staffs=new ArrayList<BStaff>();
			for(int i=0;i<theoffice.size();i++) {
				BStaff thestaff=new BStaff();
				thestaff.setStaffId(theoffice.get(i).getStaffId());
				List<BStaff> staffresult=staffService.getStaff(thestaff);
				if(staffresult.size()!=0) {
					staffs.add(staffresult.get(0));
				}
			}
			if(staffs.size()!=0) {
				result.put("staffs", staffs);
				result.put("code", 200);
				return result;
			}
		}
		result.put("code", 500);
		return result;
	}
	
	//更新员工信息
	@PostMapping("/home/updatestaff")
	public @ResponseBody Object updateStaff(BStaff staff) {
		Map<String,Object> result=new HashMap<String,Object>();
		Integer thestaff=staffService.updateStaff(staff);
		if(thestaff>0) {
			result.put("code", 200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//更新员工任职表
	@PostMapping("/home/updatetakeoffice")
	public @ResponseBody Object updatetakeoffice(BTakeOffice office) {
		Map<String,Object> result=new HashMap<String,Object>();
		Integer theoffice=staffService.updateTakeOffice(office);
		if(theoffice>0) {
			result.put("code", 200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//选择采购员
	@GetMapping("/home/selectPurchaseStaff")
	public @ResponseBody Object selectPurchaseStaff(BTakeOffice office) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BTakeOffice> staff=staffService.getTakeOffice(office);
		if(staff.size()!=0) {
			result.put("staff", staff);
			result.put("code", 200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
}
