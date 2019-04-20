package com.zhbit.market.Dao;

import java.util.List;

import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhbit.market.entity.BInform;
import com.zhbit.market.entity.BJobOrder;

@Repository
public class InformDao {
	@Autowired
	SQLManager sqlManager;
	
	//插入新通知表
	public Integer insertNewInform(BInform inform) {
		BInform theinform=new BInform();
		theinform.setTitle(inform.getTitle());
		theinform.setContent(inform.getContent());
		Integer result=sqlManager.insertTemplate(theinform,true);
		return result;
	}
	
	//获取通知表
	public List<BInform> getInfrom(BInform inform){
		BInform theinform=new BInform();
		theinform.setInformId(inform.getInformId());
		theinform.setTitle(inform.getTitle());
		theinform.setContent(inform.getContent());
		List<BInform> informs=sqlManager.select("bInform.selectInform", BInform.class,theinform);
		return informs;
	}
	
	//插入新通知单
	public Integer insertNewJobOrder(BJobOrder order) {
		BJobOrder theorder=new BJobOrder();
		theorder.setSentUserId(order.getSentUserId());
		theorder.setUserId(order.getUserId());
		theorder.setCreateTime(order.getCreateTime());
		theorder.setInformId(order.getInformId());
		Integer result=sqlManager.insertTemplate(theorder,true);
		return result;
	}
	
	//获取通知单
	public List<BJobOrder> getJobOrder(BJobOrder order){
		BJobOrder theorder=new BJobOrder();
		theorder.setJobOrderId(order.getJobOrderId());
		theorder.setSentUserId(order.getSentUserId());
		theorder.setUserId(order.getUserId());
		theorder.setCreateTime(order.getCreateTime());
		theorder.setInformId(order.getInformId());
		List<BJobOrder> orders=sqlManager.select("bInform.selectJobOrder", BJobOrder.class,theorder);
		return orders;
	}
}
