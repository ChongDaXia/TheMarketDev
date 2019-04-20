package com.zhbit.market.entity;
import java.io.Serializable;
import java.math.*;
import java.util.Date;
import java.sql.Timestamp;

/*
* 
* gen by beetlsql 2019-03-23
*/
public class BGoods   implements Serializable{
	//商品id
	private Integer goodsId ;
	//库存数量
	private Integer amount ;
	//已售数量
	private Integer salesCount ;
	//名称
	private String name ;
	
	public BGoods() {
	}
	
	public Integer getGoodsId(){
		return  goodsId;
	}
	public void setGoodsId(Integer goodsId ){
		this.goodsId = goodsId;
	}
	
	public Integer getAmount(){
		return  amount;
	}
	public void setAmount(Integer amount ){
		this.amount = amount;
	}
	
	public Integer getSalesCount(){
		return  salesCount;
	}
	public void setSalesCount(Integer salesCount ){
		this.salesCount = salesCount;
	}
	
	public String getName(){
		return  name;
	}
	public void setName(String name ){
		this.name = name;
	}
	
	
	

}
