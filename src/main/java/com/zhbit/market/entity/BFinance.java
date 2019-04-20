package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-03-23
*/
public class BFinance   implements Serializable{
	//财务表id
	private Integer financeId ;
	//收支状态
	private Integer financeStatus ;
	//内容
	private String content ;
	//类型
	private String style ;
	//金额
	private BigDecimal sum ;
	//标题
	private String title ;
	//创建时间
	private Date createTime ;
	
	public BFinance() {
	}
	
	public Integer getFinanceId(){
		return  financeId;
	}
	public void setFinanceId(Integer financeId ){
		this.financeId = financeId;
	}
	
	public Integer getFinanceStatus(){
		return  financeStatus;
	}
	public void setFinanceStatus(Integer financeStatus ){
		this.financeStatus = financeStatus;
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
	
	public Date getCreateTime(){
		return  createTime;
	}
	public void setCreateTime(Date createTime ){
		this.createTime = createTime;
	}
	
	
	

}
