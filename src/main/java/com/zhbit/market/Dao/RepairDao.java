package com.zhbit.market.Dao;

import java.util.List;

import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zhbit.market.entity.BRepair;
import com.zhbit.market.entity.BRepairOrder;
import com.zhbit.market.entity.BUser;

@Repository
public class RepairDao {
	@Autowired
	SQLManager sqlManager;
	
	//插入新维修表
	public Integer insertNewRepair(BRepair repair) {
		BRepair therepair=new BRepair();
		therepair.setTitle(repair.getTitle());
		therepair.setContent(repair.getContent());
		therepair.setStyle(repair.getStyle());
		Integer result=sqlManager.insertTemplate(therepair,true);
		return result;
	}
	
	//获取维修表
	public List<BRepair> getRepair(BRepair repair){
		BRepair therepair=new BRepair();
		therepair.setRepairId(repair.getRepairId());
		therepair.setTitle(repair.getTitle());
		therepair.setContent(repair.getContent());
		therepair.setStyle(repair.getStyle());
		List<BRepair> repairs=sqlManager.select("bRepair.selectRepair",BRepair.class,therepair);
		return repairs;
	}
	
	//插入新维修单表
	public Integer insertNewRepairOrder(BRepairOrder order) {
		BRepairOrder theorder=new BRepairOrder();
		theorder.setSentUserId(order.getSentUserId());
		theorder.setUserId(order.getUserId());
		theorder.setCreateTime(order.getCreateTime());
		theorder.setRepairId(order.getRepairId());
		Integer result=sqlManager.insertTemplate(theorder,true);
		return result;
	}
	
	//获取维修单
	public List<BRepairOrder> getRepairOrder(BRepairOrder order){
		BRepairOrder theorder=new BRepairOrder();
		theorder.setRepairOrderId(order.getRepairOrderId());
		theorder.setSentUserId(order.getSentUserId());
		theorder.setUserId(order.getUserId());
		theorder.setCreateTime(order.getCreateTime());
		theorder.setRepairId(order.getRepairId());
		List<BRepairOrder> orders=sqlManager.select("bRepair.selectRepairOrder", BRepairOrder.class,theorder);
		return orders;
	}
}
