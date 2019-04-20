package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-03-23
*/
public class BSalary   implements Serializable{
	//工资表id
	private Integer salaryId ;
	//发放状态
	private Integer salaryStatus ;
	//员工id
	private Integer staffId ;
	//工资金额
	private BigDecimal salary ;
	//发放时间
	private Date createTime ;
	
	public BSalary() {
	}
	
	public Integer getSalaryId(){
		return  salaryId;
	}
	public void setSalaryId(Integer salaryId ){
		this.salaryId = salaryId;
	}
	
	public Integer getSalaryStatus(){
		return  salaryStatus;
	}
	public void setSalaryStatus(Integer salaryStatus ){
		this.salaryStatus = salaryStatus;
	}
	
	public Integer getStaffId(){
		return  staffId;
	}
	public void setStaffId(Integer staffId ){
		this.staffId = staffId;
	}
	
	public BigDecimal getSalary(){
		return  salary;
	}
	public void setSalary(BigDecimal salary ){
		this.salary = salary;
	}
	
	public Date getCreateTime(){
		return  createTime;
	}
	public void setCreateTime(Date createTime ){
		this.createTime = createTime;
	}
	
	
	

}
