package com.zhbit.market.Dao;

import java.util.List;

import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhbit.market.entity.BStaff;
import com.zhbit.market.entity.BTakeOffice;

@Repository
public class StaffDao {
	@Autowired
	SQLManager sqlManager;
	
	//插入新员工
	public Integer insertNewStaff(BStaff staff) {
		BStaff thestaff=new BStaff();
		thestaff.setName(staff.getName());
		thestaff.setSex(staff.getSex());
		thestaff.setMobileNo(staff.getMobileNo());
		thestaff.setIdcardNo(staff.getIdcardNo());
		Integer result=sqlManager.insertTemplate(thestaff,true);
		return result;
	}
	
	//插入新任职表
	public Integer insertNewTakeOffice(BTakeOffice office) {
		BTakeOffice theoffice=new BTakeOffice();
		theoffice.setUserId(office.getUserId());
		theoffice.setStaffId(office.getStaffId());
		theoffice.setCreateTime(office.getCreateTime());
		theoffice.setWages(office.getWages());
		theoffice.setPost(office.getPost());
		Integer result=sqlManager.insertTemplate(theoffice);
		return result;
	}
	
	//获取员工
	public List<BStaff> getStaff(BStaff staff){
		BStaff thestaff=new BStaff();
		thestaff.setStaffId(staff.getStaffId());
		thestaff.setName(staff.getName());
		thestaff.setSex(staff.getSex());
		thestaff.setMobileNo(staff.getMobileNo());
		thestaff.setIdcardNo(staff.getIdcardNo());
		List<BStaff> staffs=sqlManager.select("bStaff.selectStaff", BStaff.class,thestaff);
		return staffs;
	}
	
	//获取任职表
	public List<BTakeOffice> getTakeOffice(BTakeOffice office){
		BTakeOffice theoffice=new BTakeOffice();
		theoffice.setTakeOfficeId(office.getTakeOfficeId());
		theoffice.setUserId(office.getUserId());
		theoffice.setStaffId(office.getStaffId());
		theoffice.setCreateTime(office.getCreateTime());
		theoffice.setWages(office.getWages());
		theoffice.setPost(office.getPost());
		List<BTakeOffice> offices=sqlManager.select("bStaff.selectTakeOffice", BTakeOffice.class,theoffice);
		return offices;
	}
	
	//更新员工表
	public Integer updateStaff(BStaff staff){
		BStaff thestaff=new BStaff();
		thestaff.setStaffId(staff.getStaffId());
		thestaff.setName(staff.getName());
		thestaff.setSex(staff.getSex());
		thestaff.setMobileNo(staff.getMobileNo());
		thestaff.setIdcardNo(staff.getIdcardNo());
		Integer staffs=sqlManager.updateTemplateById(thestaff);
		return staffs;
	}
	
	//更新任职表
	public Integer updateTakeOffice(BTakeOffice office) {
		BTakeOffice theoffice=new BTakeOffice();
		theoffice.setTakeOfficeId(office.getTakeOfficeId());
		theoffice.setUserId(office.getUserId());
		theoffice.setStaffId(office.getStaffId());
		theoffice.setCreateTime(office.getCreateTime());
		theoffice.setWages(office.getWages());
		theoffice.setPost(office.getPost());
		Integer offices=sqlManager.updateTemplateById(theoffice);
		return offices;
	}
}
