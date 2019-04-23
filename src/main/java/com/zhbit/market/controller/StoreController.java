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
import com.zhbit.market.entity.BRent;
import com.zhbit.market.entity.BStore;
import com.zhbit.market.service.StoreService;

@Controller
@RequestMapping("/store")
public class StoreController {
	@Autowired
	private StoreService storeService;
	
	//保存新门店
	@PostMapping("/home/addnewstore")
	public @ResponseBody Object saveNewStore(BStore store) {
		Map<String,Object> result=new HashMap<String,Object>();
		Integer theresult=storeService.insertNewStore(store);
		System.out.println("更新数："+theresult);
		if(theresult>0) {
			result.put("code",200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//保存新租赁表
	@PostMapping("/home/addnewrent")
	public @ResponseBody Object saveNewRent(BRent rent) {
		Map<String,Object> result=new HashMap<String,Object>();
		rent.setCreateTime(new java.sql.Date((new java.util.Date()).getTime()));
		Integer theresult=storeService.insertNewRent(rent);
		if(theresult>0) {
			BStore store=new BStore();
			store.setStoreId(rent.getStoreId());
			store.setRentStatus(1);
			Integer thestore=storeService.updateStore(store);
			if(thestore>0) {
				result.put("code",200);
				return result;
			}
		}
		result.put("code", 500);
		return result;
	}
	
	//获取全部门店
	@GetMapping("/home/getAllStore")
	public @ResponseBody Object getAllStore(BStore store) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BStore> thestore=storeService.getStore(store);
		if(thestore.size()!=0) {
			BStore[] stores=new BStore[thestore.size()];
			for(int i=0;i<thestore.size();i++) {
				stores[i]=thestore.get(i);
			}
			result.put("code", 200);
			result.put("stores",stores);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//获取一个门店
	@GetMapping("/home/getOneStore")
	public @ResponseBody Object getOneStore(BStore store) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BStore> thestore=storeService.getStore(store);
		if(thestore.size()!=0) {
			result.put("code", 200);
			result.put("store",thestore.get(0));
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//获取全部租赁表
	@GetMapping("/home/getAllRent")
	public @ResponseBody Object getAllRent(BRent rent) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BRent> therent=storeService.getRent(rent);
		if(therent.size()!=0) {
			BRent[] rents=new BRent[therent.size()];
			for(int i=0;i<therent.size();i++) {
				rents[i]=therent.get(i);
			}
			result.put("code", 200);
			result.put("rents",rents);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//获取一个租赁表
	@GetMapping("/home/getOneRent")
	public @ResponseBody Object getOneRent(BRent rent) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BRent> therent=storeService.getRent(rent);
		if(therent.size()!=0) {
			result.put("rent",therent.get(0));
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//店铺租金
	@GetMapping("/home/getStoreRent")
	public @ResponseBody Object getStoreRent(BStore store) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BStore> thestore=storeService.getStore(store);
		if(thestore.size()!=0) {
			result.put("stores", thestore);
			List<BRent> rents=new ArrayList<BRent>();
			for(int i=0;i<thestore.size();i++) {
				if(!thestore.get(i).getRentStatus().equals(0)) {
					BRent therent=new BRent();
					therent.setStoreId(thestore.get(i).getStoreId());
					List<BRent> therents=storeService.getRent(therent);
					if(therents.size()!=0) {
						rents.add(therents.get(0));
					}
				}
			}
			if(rents.size()!=0) {
				result.put("code", 200);
				result.put("rents", rents);
				return result;
			}else {
				result.put("code", 300);
				return result;
			}
		}
		result.put("code", 500);
		return result;
	}
	
	//更新门店信息
	@PostMapping("/home/updateStore")
	public @ResponseBody Object updateStore(BStore store) {
		Map<String,Object> result=new HashMap<String,Object>();
		Integer theresult=storeService.updateStore(store);
		if(theresult>0) {
			result.put("code",200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//更新租赁表信息
	@PostMapping("/home/updateRent")
	public @ResponseBody Object updateRent(BRent rent) {
		Map<String,Object> result=new HashMap<String,Object>();
		rent.setCreateTime(new java.sql.Date((new java.util.Date()).getTime()));
		Integer theresult=storeService.updateRent(rent);
		if(theresult>0) {
			result.put("code",200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//删除门店
	@GetMapping("/home/deleteOneStore")
	public @ResponseBody Object deleteOneStore(String storeId) {
		Map<String,Object> result=new HashMap<String,Object>();
		JSONArray json=JSONObject.parseArray(storeId);
		Integer allsum=0;
		if(json.size()!=0) {
			for(int i=0;i<json.size();i++) {
				BStore store=new BStore();
				store.setStoreId(json.getInteger(i));
				List<BStore> getStore=storeService.getStore(store);
				System.out.println("店铺第一次查询："+getStore.size());
				if(getStore.size()!=0) {
					System.out.println("状态："+getStore.get(0).getRentStatus());
					if(getStore.get(0).getRentStatus()==1) {
						BRent rent=new BRent();
						rent.setStoreId(getStore.get(0).getStoreId());
						List<BRent> selectrent=storeService.getRent(rent);
						System.out.println("租赁第二次查询："+selectrent.size());
						if(selectrent.size()!=0) {
							Integer therent=storeService.deleteRent(rent);
							System.out.println("租赁第一次删除："+therent);
						}
					}
					Integer theresult=storeService.deleteStore(store);
					System.out.println("店铺第二次删除："+theresult);
					if(theresult>0) {
						allsum++;
					}
				}
			}
			if(allsum==json.size()) {
				result.put("code", 200);
				return result;
			}
		}
		result.put("code", 500);
		return result;
	}
	
	//删除租赁表
	@GetMapping("/home/deleteRent")
	public @ResponseBody Object deleteRent(BRent rent) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BRent> rents=storeService.getRent(rent);
		if(rents.size()!=0) {
			Integer therent=storeService.deleteRent(rent);
			if(therent>0) {
				BStore store=new BStore();
				store.setStoreId(rent.getStoreId());
				store.setRentStatus(0);
				Integer thestore=storeService.updateStore(store);
				if(thestore>0) {
					result.put("code", 200);
					return result;
				}
			}
		}
		result.put("code", 500);
		return result;
	}
}
