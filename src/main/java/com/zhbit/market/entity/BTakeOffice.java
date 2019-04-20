package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-04-14
*/
public class BTakeOffice   implements Serializable{
	//任职表id
	private Integer takeOfficeId ;
	//员工id
	private Integer staffId ;
	//用户id
	private Integer userId ;
	//岗位
	private String post ;
	//工资
	private BigDecimal wages ;
	//聘任时间
	private Date createTime ;
	
	public BTakeOffice() {
	}
	
	public Integer getTakeOfficeId(){
		return  takeOfficeId;
	}
	public void setTakeOfficeId(Integer takeOfficeId ){
		this.takeOfficeId = takeOfficeId;
	}
	
	public Integer getStaffId(){
		return  staffId;
	}
	public void setStaffId(Integer staffId ){
		this.staffId = staffId;
	}
	
	public Integer getUserId(){
		return  userId;
	}
	public void setUserId(Integer userId ){
		this.userId = userId;
	}
	
	public String getPost(){
		return  post;
	}
	public void setPost(String post ){
		this.post = post;
	}
	
	public BigDecimal getWages(){
		return  wages;
	}
	public void setWages(BigDecimal wages ){
		this.wages = wages;
	}
	
	public Date getCreateTime(){
		return  createTime;
	}
	public void setCreateTime(Date createTime ){
		this.createTime = createTime;
	}
	
	
	

}
