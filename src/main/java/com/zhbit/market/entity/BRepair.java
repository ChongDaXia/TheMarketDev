package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-03-23
*/
public class BRepair   implements Serializable{
	//维修表id
	private Integer repairId ;
	//描述
	private String content ;
	//类型
	private String style ;
	//标题
	private String title ;
	
	public BRepair() {
	}
	
	public Integer getRepairId(){
		return  repairId;
	}
	public void setRepairId(Integer repairId ){
		this.repairId = repairId;
	}
	
	public String getContent(){
		return  content;
	}
	public void setContent(String content ){
		this.content = content;
	}
	
	public String getStyle(){
		return  style;
	}
	public void setStyle(String style ){
		this.style = style;
	}
	
	public String getTitle(){
		return  title;
	}
	public void setTitle(String title ){
		this.title = title;
	}
	
	
	

}
