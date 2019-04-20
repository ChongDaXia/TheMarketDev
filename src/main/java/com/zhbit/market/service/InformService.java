package com.zhbit.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhbit.market.Dao.InformDao;
import com.zhbit.market.entity.BInform;
import com.zhbit.market.entity.BJobOrder;

@Service
public class InformService {
	@Autowired
	InformDao informDao;
	
	//保存新通知信息
	public Integer insertNewInform(BInform inform) {
		Integer result=informDao.insertNewInform(inform);
		return result;
	}
	
	//获取通知表
	public List<BInform> getInfrom(BInform inform){
		List<BInform> informs=informDao.getInfrom(inform);
		return informs;
	}
	
	//保存新通知单信息
	public Integer insertNewJobOrder(BJobOrder order) {
		Integer result=informDao.insertNewJobOrder(order);
		return result;
	}
	
	//获取通知单
	public List<BJobOrder> getJobOrder(BJobOrder order){
		List<BJobOrder> orders=informDao.getJobOrder(order);
		return orders;
	}
}
