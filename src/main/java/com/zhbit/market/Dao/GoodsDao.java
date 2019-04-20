package com.zhbit.market.Dao;

import java.util.List;

import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zhbit.market.entity.BGoods;
import com.zhbit.market.entity.BPurchase;
import com.zhbit.market.entity.BPurchasesItem;
import com.zhbit.market.entity.BSalesItem;
import com.zhbit.market.entity.BSalesSlip;
import com.zhbit.market.entity.BSupplier;

@Repository
public class GoodsDao {
	@Autowired
	SQLManager sqlManager;
	
	//插入新商品
	public Integer insertNewGoods(BGoods goods) {
		BGoods thegoods=new BGoods();
		thegoods.setName(goods.getName());
		thegoods.setAmount(goods.getAmount());
		thegoods.setSalesCount(goods.getSalesCount());
		Integer result=sqlManager.insertTemplate(thegoods,true);
		return result;
	}
	
	//插入新供应商
	public Integer insertNewSupplier(BSupplier supplier) {
		BSupplier thesupplier=new BSupplier();
		thesupplier.setName(supplier.getName());
		thesupplier.setContacts(supplier.getContacts());
		thesupplier.setMobileNo(supplier.getMobileNo());
		thesupplier.setAddress(supplier.getAddress());
		Integer result=sqlManager.insertTemplate(thesupplier,true);
		return result;
	}
	
	//插入新采购单
	public Integer insertNewPurchase(BPurchase purchase) {
		BPurchase thepurchase=new BPurchase();
		thepurchase.setStaffId(purchase.getStaffId());
		thepurchase.setSupplierId(purchase.getSupplierId());
		thepurchase.setCreateTime(purchase.getCreateTime());
		thepurchase.setTotalPrice(purchase.getTotalPrice());
		Integer result=sqlManager.insertTemplate(thepurchase,true);
		return result;
	}
	
	//插入新采购项
	public Integer insertNewPurchaseItem(BPurchasesItem purchasesitem) {
		BPurchasesItem thepurchasesitem=new BPurchasesItem();
		thepurchasesitem.setPurchaseId(purchasesitem.getPurchaseId());
		thepurchasesitem.setGoodsId(purchasesitem.getGoodsId());
		thepurchasesitem.setAmount(purchasesitem.getAmount());
		thepurchasesitem.setPrice(purchasesitem.getPrice());
		Integer result=sqlManager.insertTemplate(thepurchasesitem,true);
		return result;
	}
	
	//插入新销售单
	public Integer insertNewSalesSlip(BSalesSlip salesslip) {
		BSalesSlip thesalesslip=new BSalesSlip();
		thesalesslip.setStaffId(salesslip.getStaffId());
		thesalesslip.setMemberId(salesslip.getMemberId());
		thesalesslip.setCreateTime(salesslip.getCreateTime());
		thesalesslip.setTotalPrice(salesslip.getTotalPrice());
		Integer result=sqlManager.insertTemplate(thesalesslip,true);
		return result;
	}
	
	//插入新销售项
	public Integer insertNewSalesItem(BSalesItem salesitem) {
		BSalesItem thesalesitem=new BSalesItem();
		thesalesitem.setSalesSlipId(salesitem.getSalesSlipId());
		thesalesitem.setGoodsId(salesitem.getGoodsId());
		thesalesitem.setAmount(salesitem.getAmount());
		thesalesitem.setPrice(salesitem.getPrice());
		Integer result=sqlManager.insertTemplate(thesalesitem,true);
		return result;
	}
	
	//获取商品
	public List<BGoods> getGoods(BGoods goods){
		BGoods thegoods=new BGoods();
		thegoods.setGoodsId(goods.getGoodsId());
		thegoods.setName(goods.getName());
		thegoods.setAmount(goods.getAmount());
		thegoods.setSalesCount(goods.getSalesCount());
		List<BGoods> goodss=sqlManager.select("bGoods.selectGoods", BGoods.class,thegoods);
		return goodss;
	}
	
	//获取供应商
	public List<BSupplier> getSupplier(BSupplier supplier){
		BSupplier thesupplier=new BSupplier();
		thesupplier.setSupplierId(supplier.getSupplierId());
		thesupplier.setName(supplier.getName());
		thesupplier.setContacts(supplier.getContacts());
		thesupplier.setMobileNo(supplier.getMobileNo());
		thesupplier.setAddress(supplier.getAddress());
		List<BSupplier> suppliers=sqlManager.select("bGoods.selectSupplier", BSupplier.class,thesupplier);
		return suppliers;
	}
	
	//获取采购单
	public List<BPurchase> getPurchase(BPurchase purchase){
		BPurchase thepurchase=new BPurchase();
		thepurchase.setPurchaseId(purchase.getPurchaseId());
		thepurchase.setStaffId(purchase.getStaffId());
		thepurchase.setSupplierId(purchase.getSupplierId());
		thepurchase.setCreateTime(purchase.getCreateTime());
		thepurchase.setTotalPrice(purchase.getTotalPrice());
		List<BPurchase> purchases=sqlManager.select("bGoods.selectPurchase", BPurchase.class,thepurchase);
		return purchases;
	}
	
	//获取采购项
	public List<BPurchasesItem> getPurchasesItem(BPurchasesItem purchasesitem){
		BPurchasesItem thepurchasesitem=new BPurchasesItem();
		thepurchasesitem.setPurchasesItemId(purchasesitem.getPurchasesItemId());
		thepurchasesitem.setPurchaseId(purchasesitem.getPurchaseId());
		thepurchasesitem.setGoodsId(purchasesitem.getGoodsId());
		thepurchasesitem.setAmount(purchasesitem.getAmount());
		thepurchasesitem.setPrice(purchasesitem.getPrice());
		List<BPurchasesItem> items=sqlManager.select("bGoods.selectPurchaseItem", BPurchasesItem.class,thepurchasesitem);
		return items;
	}
	
	//获取销售单
	public List<BSalesSlip> getSalesSlip(BSalesSlip salesslip){
		BSalesSlip thesalesslip=new BSalesSlip();
		thesalesslip.setSalesSlipId(salesslip.getSalesSlipId());
		thesalesslip.setStaffId(salesslip.getStaffId());
		thesalesslip.setMemberId(salesslip.getMemberId());
		thesalesslip.setCreateTime(salesslip.getCreateTime());
		thesalesslip.setTotalPrice(salesslip.getTotalPrice());
		List<BSalesSlip> slips=sqlManager.select("bGoods.selectSalesSlip", BSalesSlip.class,thesalesslip);
		return slips;
	}
	
	//获取销售项
	public List<BSalesItem> getSalesItem(BSalesItem salesitem){
		BSalesItem thesalesitem=new BSalesItem();
		thesalesitem.setSalesItemId(salesitem.getSalesItemId());
		thesalesitem.setSalesSlipId(salesitem.getSalesSlipId());
		thesalesitem.setGoodsId(salesitem.getGoodsId());
		thesalesitem.setAmount(salesitem.getAmount());
		thesalesitem.setPrice(salesitem.getPrice());
		List<BSalesItem> items=sqlManager.select("bGoods.selectSalesItem", BSalesItem.class,thesalesitem);
		return items;
	}
	
	//更新商品
	public Integer updateGoods(BGoods goods) {
		BGoods thegoods=new BGoods();
		thegoods.setGoodsId(goods.getGoodsId());
		thegoods.setName(goods.getName());
		thegoods.setAmount(goods.getAmount());
		thegoods.setSalesCount(goods.getSalesCount());
		Integer result=sqlManager.updateTemplateById(thegoods);
		return result;
	}
	
	//更新供应商
	public Integer updateSupplier(BSupplier supplier) {
		BSupplier thesupplier=new BSupplier();
		thesupplier.setSupplierId(supplier.getSupplierId());
		thesupplier.setName(supplier.getName());
		thesupplier.setContacts(supplier.getContacts());
		thesupplier.setMobileNo(supplier.getMobileNo());
		thesupplier.setAddress(supplier.getAddress());
		Integer result=sqlManager.updateTemplateById(thesupplier);
		return result;
	}
	
	//删除供应商
	public Integer deleteSupplier(BSupplier supplier) {
		BSupplier thesupplier=new BSupplier();
		thesupplier.setSupplierId(supplier.getSupplierId());
		Integer result=sqlManager.update("bGoods.deleteSupplier",thesupplier);
		return result;
	}
}
