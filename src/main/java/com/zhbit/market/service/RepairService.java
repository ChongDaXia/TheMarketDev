package com.zhbit.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhbit.market.Dao.RepairDao;
import com.zhbit.market.entity.BRepair;
import com.zhbit.market.entity.BRepairOrder;

@Service
public class RepairService {
	@Autowired
	RepairDao repairDao;
	
	//保存新维修信息
	public Integer insertNewRepair(BRepair repair) {
		Integer result=repairDao.insertNewRepair(repair);
		return result;
	}
	
	//获取维修表
	public List<BRepair> getRepair(BRepair repair){
		List<BRepair> repairs=repairDao.getRepair(repair);
		return repairs;
	}
	
	//保存新维修单信息
	public Integer insertNewRepairOrder(BRepairOrder order) {
		Integer result=repairDao.insertNewRepairOrder(order);
		return result;
	}
	
	//获取维修单信息
	public List<BRepairOrder> getRepairOrder(BRepairOrder order){
		List<BRepairOrder> orders=repairDao.getRepairOrder(order);
		return orders;
	}
}
