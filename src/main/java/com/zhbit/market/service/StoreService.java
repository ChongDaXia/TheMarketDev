package com.zhbit.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhbit.market.Dao.StoreDao;
import com.zhbit.market.entity.BRent;
import com.zhbit.market.entity.BStore;

@Service
public class StoreService {
	@Autowired
	StoreDao storeDao;
	
	//保存新门店信息
	public Integer insertNewStore(BStore store) {
		Integer result=storeDao.insertNewStore(store);
		return result;
	}
	
	//保存新租赁表信息
	public Integer insertNewRent(BRent rent) {
		Integer result=storeDao.insertNewRent(rent);
		return result;
	}
	
	//获取门店信息
	public List<BStore> getStore(BStore store){
		List<BStore> stores=storeDao.getStore(store);
		return stores;
	}
	
	//获取租赁表信息
	public List<BRent> getRent(BRent rent){
		List<BRent> rents=storeDao.getRent(rent);
		return rents;
	}
	
	//更新门店信息
	public Integer updateStore(BStore store) {
		Integer result=storeDao.updateStore(store);
		return result;
	}
	
	//更新租赁表
	public Integer updateRent(BRent rent) {
		Integer result=storeDao.updateRent(rent);
		return result;
	}
	
	//删除门店信息
	public Integer deleteStore(BStore store) {
		Integer result=storeDao.deleteStore(store);
		return result;
	}
	
	//删除租赁表
	public Integer deleteRent(BRent rent) {
		Integer result=storeDao.deleteRent(rent);
		return result;
	}
}
