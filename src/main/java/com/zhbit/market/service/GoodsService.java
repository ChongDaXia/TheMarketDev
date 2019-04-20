package com.zhbit.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhbit.market.Dao.GoodsDao;
import com.zhbit.market.entity.BGoods;
import com.zhbit.market.entity.BPurchase;
import com.zhbit.market.entity.BPurchasesItem;
import com.zhbit.market.entity.BSalesItem;
import com.zhbit.market.entity.BSalesSlip;
import com.zhbit.market.entity.BSupplier;

@Service
public class GoodsService {
	@Autowired
	GoodsDao goodsDao;
	
	//保存新商品信息
	public Integer insertNewGoods(BGoods goods) {
		Integer result=goodsDao.insertNewGoods(goods);
		return result;
	}
	
	//保存新供应商信息
	public Integer insertNewSupplier(BSupplier supplier) {
		Integer result=goodsDao.insertNewSupplier(supplier);
		return result;
	}
	
	//保存新采购单信息
	public Integer insertNewPurchase(BPurchase purchase) {
		Integer result=goodsDao.insertNewPurchase(purchase);
		return result;
	}
	
	//保存新采购项信息
	public Integer insertNewPurchaseItem(BPurchasesItem purchasesitem) {
		Integer result=goodsDao.insertNewPurchaseItem(purchasesitem);
		return result;
	}
	
	//保存新销售单信息
	public Integer insertNewSalesSlip(BSalesSlip salesslip) {
		Integer result=goodsDao.insertNewSalesSlip(salesslip);
		return result;
	}
	
	//保存新销售项信息
	public Integer insertNewSalesItem(BSalesItem salesitem) {
		Integer result=goodsDao.insertNewSalesItem(salesitem);
		return result;
	}
	
	//获取商品信息
	public List<BGoods> getGoods(BGoods goods){
		List<BGoods> thegoods=goodsDao.getGoods(goods);
		return thegoods;
	}
	
	//获取供应商信息
	public List<BSupplier> getSupplier(BSupplier supplier){
		List<BSupplier> thesupplier=goodsDao.getSupplier(supplier);
		return thesupplier;
	}
	
	//获取采购单
	public List<BPurchase> getPurchase(BPurchase purchase){
		List<BPurchase> thepurchase=goodsDao.getPurchase(purchase);
		return thepurchase;
	}
	
	//获取采购项
	public List<BPurchasesItem> getPurchasesItem(BPurchasesItem purchasesitem){
		List<BPurchasesItem> thepurchasesitem=goodsDao.getPurchasesItem(purchasesitem);
		return thepurchasesitem;
	}
	
	//获取销售单
	public List<BSalesSlip> getSalesSlip(BSalesSlip salesslip){
		List<BSalesSlip> thesalesslip=goodsDao.getSalesSlip(salesslip);
		return thesalesslip;
	}
	
	//获取销售项
	public List<BSalesItem> getSalesItem(BSalesItem salesitem){
		List<BSalesItem> thesalesitem=goodsDao.getSalesItem(salesitem);
		return thesalesitem;
	}
	
	//更新商品
	public Integer updateGoods(BGoods goods) {
		Integer result=goodsDao.updateGoods(goods);
		return result;
	}
	
	//更新供应商
	public Integer updateSupplier(BSupplier supplier) {
		Integer result=goodsDao.updateSupplier(supplier);
		return result;
	}
	
	//删除供应商
	public Integer deleteSupplier(BSupplier supplier) {
		Integer result=goodsDao.deleteSupplier(supplier);
		return result;
	}
}
