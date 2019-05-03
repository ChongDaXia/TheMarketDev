package com.zhbit.market.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.zhbit.market.entity.BSalary;
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
	
	//插入工资表
	@PostMapping("/home/saveSalary")
	public @ResponseBody Object saveSalary(BSalary salary) {
		Map<String,Object> result=new HashMap<String,Object>();
		salary.setCreateTime(new java.sql.Date((new java.util.Date()).getTime()));
		Integer salarys=staffService.insertNewSalary(salary);
		if(salarys>0) {
			result.put("code", 200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//更新工资表状态
	@PostMapping("/home/updateSalary")
	public @ResponseBody Object updateSalary(BSalary salary,String Time) throws ParseException {
		Map<String,Object> result=new HashMap<String,Object>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("获取员工工资单");
		List<BSalary> thes=staffService.getSalary(salary);
		if(thes.size()!=0) {
			for(int i=0;i<thes.size();i++) {
				String temptime=sdf.format(thes.get(i).getCreateTime());
				if(Time.equals(temptime)) {
					salary.setSalaryId(thes.get(i).getSalaryId());
//					salary.setCreateTime(new java.sql.Date((new java.util.Date()).getTime()));
					salary.setSalaryStatus(1);
					System.out.println("修改员工工资单状态");
					Integer theresult=staffService.updateSalary(salary);
					if(theresult>0) {
						result.put("code", 200);
						return result;
					}
				}
			}
		}
		result.put("code", 500);
		return result;
	}
	
	//获取工资表
	@GetMapping("/home/getSalary")
	public @ResponseBody Object getSalary(BTakeOffice office) {
		Map<String,Object> result=new HashMap<String,Object>();
		System.out.println("获取店铺的员工");
		List<BTakeOffice> theallstaff=staffService.getTakeOffice(office);
		if(theallstaff.size()!=0) {
			List<BStaff> staffs=new ArrayList<BStaff>();
			List<BSalary> salarys=new ArrayList<BSalary>();
			//（一个雇主有多个员工）每一个员工
			for(int i=0;i<theallstaff.size();i++) {
				//员工id+员工表=员工姓名
				BStaff thestaff=new BStaff();
				thestaff.setStaffId(theallstaff.get(i).getStaffId());
				System.out.println("获取员工信息");
				List<BStaff> thestaffresulet=staffService.getStaff(thestaff);
				if(thestaffresulet.size()!=0) {
					staffs.add(thestaffresulet.get(0));
				}
				// 员工id+工资表=工资表id
				BSalary salary=new BSalary();
				salary.setStaffId(theallstaff.get(i).getStaffId());
				System.out.println("获取员工薪资信息");
				List<BSalary> thesalarys=staffService.getSalary(salary);
				if(thesalarys.size()!=0) {
					for(int j=0;j<thesalarys.size();j++) {
						salarys.add(thesalarys.get(j));
					}
				}
			}
			//任职表
			result.put("offices", theallstaff);
			//员工信息
			result.put("staffs", staffs);
			//薪资信息
			result.put("salarys", salarys);
			result.put("code", 200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
}
