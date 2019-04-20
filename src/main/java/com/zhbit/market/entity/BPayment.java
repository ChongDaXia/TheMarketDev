package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-03-23
*/
public class BPayment   implements Serializable{
	//费用id
	private Integer paymentId ;
	//描述
	private String content ;
	//类型
	private String style ;
	//金额
	private BigDecimal sum ;
	//标题
	private String title ;
	
	public BPayment() {
	}
	
	public Integer getPaymentId(){
		return  paymentId;
	}
	public void setPaymentId(Integer paymentId ){
		this.paymentId = paymentId;
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
	
	public BigDecimal getSum(){
		return  sum;
	}
	public void setSum(BigDecimal sum ){
		this.sum = sum;
	}
	
	public String getTitle(){
		return  title;
	}
	public void setTitle(String title ){
		this.title = title;
	}
	
	
	

}
