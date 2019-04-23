package com.zhbit.market.Dao;

import java.util.List;

import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhbit.market.entity.BRent;
import com.zhbit.market.entity.BStore;

@Repository
public class StoreDao {
	@Autowired
	SQLManager sqlManager;
	
	//插入新门店
	public Integer insertNewStore(BStore store) {
		BStore thestore=new BStore();
		thestore.setStoreNo(store.getStoreNo());
		thestore.setAddress(store.getAddress());
		thestore.setArea(store.getArea());
		thestore.setRentStatus(store.getRentStatus());
		Integer result=sqlManager.insertTemplate(thestore,true);
		return result;
	}
	
	//插入新租赁表
	public Integer insertNewRent(BRent rent) {
		BRent therent=new BRent();
		therent.setUserId(rent.getUserId());
		therent.setStoreId(rent.getStoreId());
		therent.setCreateTime(rent.getCreateTime());
		therent.setRent(rent.getRent());
		Integer result=sqlManager.insertTemplate(therent,true);
		return result;
	}
	
	//获取门店
	public List<BStore> getStore(BStore store){
		BStore thestore=new BStore();
		thestore.setStoreId(store.getStoreId());
		thestore.setStoreNo(store.getStoreNo());
		thestore.setAddress(store.getAddress());
		thestore.setArea(store.getArea());
		thestore.setRentStatus(store.getRentStatus());
		List<BStore> stores=sqlManager.select("bStore.selectStore", BStore.class,thestore);
		return stores;
	}
	
	//获取租赁表
	public List<BRent> getRent(BRent rent){
		BRent therent=new BRent();
		therent.setRentId(rent.getRentId());
		therent.setUserId(rent.getUserId());
		therent.setStoreId(rent.getStoreId());
		therent.setCreateTime(rent.getCreateTime());
		therent.setRent(rent.getRent());
		List<BRent> rents=sqlManager.select("bStore.selectRent", BRent.class,therent);
		return rents;
	}
	
	//更新门店信息
	public Integer updateStore(BStore store) {
		BStore thestore=new BStore();
		thestore.setStoreId(store.getStoreId());
		thestore.setStoreNo(store.getStoreNo());
		thestore.setAddress(store.getAddress());
		thestore.setArea(store.getArea());
		thestore.setRentStatus(store.getRentStatus());
		Integer result=sqlManager.updateTemplateById(thestore);
		return result;
	}
	
	// 更新租赁表
	public Integer updateRent(BRent rent) {
		BRent therent=new BRent();
		therent.setRentId(rent.getRentId());
		therent.setUserId(rent.getUserId());
		therent.setStoreId(rent.getStoreId());
		therent.setCreateTime(rent.getCreateTime());
		therent.setRent(rent.getRent());
		Integer result=sqlManager.updateTemplateById(therent);
		return result;
	}
	
	//删除门店
	public Integer deleteStore(BStore store){
		BStore thestore=new BStore();
		thestore.setStoreId(store.getStoreId());
		Integer result=sqlManager.update("bStore.deleteStore", thestore);
		return result;
	}
	
	//删除租赁表
	public Integer deleteRent(BRent rent){
		BRent therent=new BRent();
		therent.setRentId(rent.getRentId());
		therent.setStoreId(rent.getStoreId());
		Integer result=sqlManager.update("bStore.deleteRent", therent);
		return result;
	}
}
