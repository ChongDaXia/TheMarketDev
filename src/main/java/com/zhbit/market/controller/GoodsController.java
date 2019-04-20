package com.zhbit.market.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zhbit.market.entity.BGoods;
import com.zhbit.market.entity.BPurchase;
import com.zhbit.market.entity.BPurchasesItem;
import com.zhbit.market.entity.BStaff;
import com.zhbit.market.entity.BSupplier;
import com.zhbit.market.entity.BTakeOffice;
import com.zhbit.market.entity.BUser;
import com.zhbit.market.service.GoodsService;
import com.zhbit.market.service.StaffService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private StaffService staffService;
	
	//商品管理（保存新商品）
	@PostMapping("/home/addnewgoods")
	public @ResponseBody Object saveNewGoods(BGoods goods) {
		Map<String,Object> result=new HashMap<String,Object>();
		Integer theresult=goodsService.insertNewGoods(goods);
		System.out.println("更新数："+theresult);
		if(theresult>0) {
			result.put("code",200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//获取所有商品
	@GetMapping("/home/getallgoods")
	public @ResponseBody Object getAllGoods(BGoods goods) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BGoods> getgoods=goodsService.getGoods(goods);
		if(getgoods.size()!=0) {
			BGoods[] goodss=new BGoods[getgoods.size()];
			for(int i=0;i<getgoods.size();i++) {
				goodss[i]=getgoods.get(i);
			}
			result.put("code", 200);
			result.put("goodss",goodss);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//获取单个商品
	@GetMapping("/home/getonegoods")
	public @ResponseBody Object getOneGoods(BGoods goods) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BGoods> getgoods=goodsService.getGoods(goods);
		if(getgoods.size()!=0) {
			result.put("code", 200);
			result.put("goodss",getgoods.get(0));
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//更新商品信息
	@PostMapping("/home/updategoods")
	public @ResponseBody Object updateGoods(BGoods goods) {
		Map<String,Object> result=new HashMap<String,Object>();
		Integer theresult=goodsService.updateGoods(goods);
		System.out.println("更新数："+theresult);
		if(theresult>0) {
			result.put("code",200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//获取所有供应商
	@GetMapping("/home/getallsupplier")
	public @ResponseBody Object getAllSupplier(BSupplier supplier) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BSupplier> getsupplier=goodsService.getSupplier(supplier);
		if(getsupplier.size()!=0) {
			BSupplier[] suppliers=new BSupplier[getsupplier.size()];
			for(int i=0;i<getsupplier.size();i++) {
				suppliers[i]=getsupplier.get(i);
			}
			result.put("code", 200);
			result.put("suppliers",suppliers);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//获取一个供应商信息
	@GetMapping("/home/getonesupplier")
	public @ResponseBody Object getOneSupplier(BSupplier supplier) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BSupplier> getsupplier=goodsService.getSupplier(supplier);
		if(getsupplier.size()!=0) {
			result.put("code", 200);
			result.put("suppliers",getsupplier.get(0));
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//保存供应商信息
	@PostMapping("/home/addnewsupplier")
	public @ResponseBody Object saveNewSupplier(BSupplier supplier) {
		Map<String,Object> result=new HashMap<String,Object>();
		Integer theresult=goodsService.insertNewSupplier(supplier);
		System.out.println("更新数："+theresult);
		if(theresult>0) {
			result.put("code",200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//更新供应商信息
	@PostMapping("/home/updatesupplier")
	public @ResponseBody Object updateSupplier(BSupplier supplier) {
		Map<String,Object> result=new HashMap<String,Object>();
		Integer theresult=goodsService.updateSupplier(supplier);
		System.out.println("更新数："+theresult);
		if(theresult>0) {
			result.put("code",200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//插入采购商品项信息
	@PostMapping("/home/addnewpurchasesitem")
	public @ResponseBody Object addNewPurchasesItem(BPurchasesItem item) {
		Map<String,Object> result=new HashMap<String,Object>();
		Integer theresult=goodsService.insertNewPurchaseItem(item);
		System.out.println("更新数："+theresult);
		if(theresult>0) {
			result.put("code",200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//插入采购单信息
	@PostMapping("/home/addnewpurchase")
	public @ResponseBody Object addNewPurchase(BPurchase purchase) {
		Map<String,Object> result=new HashMap<String,Object>();
		Integer theresult=goodsService.insertNewPurchase(purchase);
		System.out.println("更新数："+theresult);
		if(theresult>0) {
			result.put("code",200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//选择商品
	//【雇主id】
	//【雇主id+任职表=所有员工id】
	//【每一个员工id+采购单=采购单id】
	//【采购单id+采购项=商品id】
	//【商品id去重】
	@GetMapping("/home/selectGoods")
	public @ResponseBody Object selectGoods(BTakeOffice office) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BGoods> allgoods=new ArrayList();
		int k=0;
		//雇主id+任职表=所有员工id
		List<BTakeOffice> theallstaff=staffService.getTakeOffice(office);
		if(theallstaff.size()!=0) {
			BStaff[] staffs=new BStaff[theallstaff.size()];
			//（一个雇主有多个员工）每一个员工
			for(int i=0;i<theallstaff.size();i++) {
				//员工id+员工表=员工姓名
				BStaff thestaff=new BStaff();
				thestaff.setStaffId(theallstaff.get(i).getStaffId());
				List<BStaff> thestaffresulet=staffService.getStaff(thestaff);
				if(thestaffresulet.size()!=0) {
					staffs[i]=thestaffresulet.get(0);
				}
				//员工id+采购单=采购单id
				BPurchase purchase=new BPurchase();
				purchase.setStaffId(theallstaff.get(i).getStaffId());
				List<BPurchase> thepurchase=goodsService.getPurchase(purchase);
				if(thepurchase.size()!=0) {
					for(int j=0;j<thepurchase.size();j++) {
						BPurchasesItem purchaseitem=new BPurchasesItem();
						purchaseitem.setPurchaseId(thepurchase.get(j).getPurchaseId());
						//采购单id+采购项表=商品id
						List<BPurchasesItem> thepurshaseitem=goodsService.getPurchasesItem(purchaseitem);
						if(thepurshaseitem.size()!=0) {
							for(int t=0;t<thepurshaseitem.size();t++) {
								BGoods thegoods=new BGoods();
								thegoods.setGoodsId(thepurshaseitem.get(t).getGoodsId());
								List<BGoods> goods=goodsService.getGoods(thegoods);
								if(goods.size()!=0) {
									//获取商品名称
									allgoods.add(goods.get(0));
								}
							}
						}
					}
				}
			}
			result.put("allstaff", theallstaff);
			result.put("allstaffname", staffs);
			for(int z=0;z<k;z++) {
				for(int y=k-1;y>z;y--) {
					if(allgoods.get(z).getGoodsId().equals(allgoods.get(y).getGoodsId())){
						allgoods.remove(y);
					}
				}
			}
			if(allgoods.size()!=0) {
				result.put("allgoods", allgoods);
				result.put("code", 200);
				return result;
			}
			result.put("code", 300);
			return result;
		}
		//没有员工
		result.put("code", 500);
		return result;
	}	
	
	//删除供应商
	@GetMapping("/home/deleteSupplier")
	public @ResponseBody Object deleteSupplier(String supplierId) {
		Map<String,Object> result=new HashMap<String,Object>();
		JSONArray json=JSONObject.parseArray(supplierId);
		Integer allsum=0;
		if(json.size()!=0) {
			for(int i=0;i<json.size();i++) {
				BSupplier supplier=new BSupplier();
				supplier.setSupplierId(json.getInteger(i));
				List<BSupplier> getSupplier=goodsService.getSupplier(supplier);
				if(getSupplier.size()!=0) {
					Integer theresult=goodsService.deleteSupplier(supplier);
					allsum++;
				}
			}
			if(allsum==json.size()) {
				result.put("code", 200);
				return result;
			}
			result.put("code", 300);
			return result;
		}
		result.put("code", 500);
		return result;
	}
}
