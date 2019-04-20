package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-03-23
*/
public class BInform   implements Serializable{
	//消息表id
	private Integer informId ;
	//内容
	private String content ;
	//标题
	private String title ;
	
	public BInform() {
	}
	
	public Integer getInformId(){
		return  informId;
	}
	public void setInformId(Integer informId ){
		this.informId = informId;
	}
	
	public String getContent(){
		return  content;
	}
	public void setContent(String content ){
		this.content = content;
	}
	
	public String getTitle(){
		return  title;
	}
	public void setTitle(String title ){
		this.title = title;
	}
	
	
	

}
