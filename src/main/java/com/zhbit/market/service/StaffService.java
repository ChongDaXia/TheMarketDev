package com.zhbit.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhbit.market.Dao.StaffDao;
import com.zhbit.market.entity.BSalary;
import com.zhbit.market.entity.BStaff;
import com.zhbit.market.entity.BTakeOffice;

@Service
public class StaffService {
	@Autowired
	StaffDao staffDao;
	
	//保存新员工信息
	public Integer insertNewStaff(BStaff staff) {
		Integer result=staffDao.insertNewStaff(staff);
		return result;
	}
	
	//保存新任职表信息
	public Integer insertNewTakeOffice(BTakeOffice office) {
		Integer result=staffDao.insertNewTakeOffice(office);
		return result;
	}
	
	//获取员工信息
	public List<BStaff> getStaff(BStaff staff){
		List<BStaff> staffs=staffDao.getStaff(staff);
		return staffs;
	}
	
	//获取任职表信息
	public List<BTakeOffice> getTakeOffice(BTakeOffice office){
		List<BTakeOffice> offices=staffDao.getTakeOffice(office);
		return offices;
	}
	
	//更新员工表
	public Integer updateStaff(BStaff staff){
		Integer staffs=staffDao.updateStaff(staff);
		return staffs;
	}
	
	//更新任职表
	public Integer updateTakeOffice(BTakeOffice office) {
		Integer offices=staffDao.updateTakeOffice(office);
		return offices;
	}
	
	//保存工资表
	public Integer insertNewSalary(BSalary salary) {
		Integer salarys=staffDao.insertNewSalary(salary);
		return salarys;
	}
	
	//更新工资表
	public Integer updateSalary(BSalary salary) {
		Integer salarys=staffDao.updateSalary(salary);
		return salarys;
	}
	
	//获取工资表
	public List<BSalary> getSalary(BSalary salary){
		List<BSalary> salarys=staffDao.getSalary(salary);
		return salarys;
	}
}
