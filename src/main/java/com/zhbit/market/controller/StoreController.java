package com.zhbit.market.controller;

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
	
	//门店管理（保存新门店）
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
		Integer theresult=storeService.insertNewRent(rent);
		System.out.println("更新数："+theresult);
		if(theresult>0) {
			result.put("code",200);
			return result;
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
			BRent[] rents=new BRent[thestore.size()];
			for(int i=0;i<thestore.size();i++) {
				if(!thestore.get(i).getRentStatus().equals(0)) {
					BRent therent=new BRent();
					therent.setStoreId(thestore.get(i).getStoreId());
					List<BRent> therents=storeService.getRent(therent);
					if(therents.size()!=0) {
						rents[i]=therents.get(0);
					}
				}
			}
			if(rents[0]!=null) {
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
				if(getStore.size()!=0) {
					Integer theresult=storeService.deleteStore(store);
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
