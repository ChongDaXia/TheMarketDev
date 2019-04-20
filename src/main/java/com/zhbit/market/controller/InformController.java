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
import com.zhbit.market.entity.BInform;
import com.zhbit.market.entity.BJobOrder;
import com.zhbit.market.entity.BUser;
import com.zhbit.market.service.InformService;
import com.zhbit.market.service.UserService;

@Controller
@RequestMapping("/inform")
public class InformController {
	@Autowired
	private InformService informService;
	@Autowired
	private UserService userService;
	
	//通知管理（保存新通知表）
	@PostMapping("/home/addnewinform")
	public @ResponseBody Object saveNewInform(BInform inform,String userId,Integer sentUserId) {
		Map<String,Object> result=new HashMap<String,Object>();
		Integer theresult=informService.insertNewInform(inform);
		System.out.println("通知更新数："+theresult);
		if(theresult>0) {
			BInform informid=new BInform();
			informid.setTitle(inform.getTitle());
			informid.setContent(inform.getContent());
			List<BInform> informs=informService.getInfrom(informid);
			if(informs.size()!=0) {
				Integer theresult1=0;
				BJobOrder order=new BJobOrder();
				order.setSentUserId(sentUserId);
				order.setCreateTime(new java.sql.Date((new java.util.Date()).getTime()));
				order.setInformId(informs.get(0).getInformId());
				JSONArray json=JSONObject.parseArray(userId);
				for(int i=0;i<json.size();i++) {
					order.setUserId(json.getInteger(i));
					theresult1+=informService.insertNewJobOrder(order);
				}
				if(theresult1>0) {
					result.put("code",200);
					return result;
				}
				result.put("code",300);
				return result;
			}
		}
		result.put("code", 500);
		return result;
	}
	
	//获取所有通知信息
	@GetMapping("/home/getallinform")
	public @ResponseBody Object getAllInform(BInform inform) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BInform> theinform=informService.getInfrom(inform);
		if(theinform.size()!=0) {
			BInform[] informs=new BInform[theinform.size()];
			for(int i=0;i<theinform.size();i++) {
				informs[i]=theinform.get(i);
			}
			result.put("code", 200);
			result.put("informs", informs);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//获取所有通知单
	@GetMapping("/home/getalljoborder")
	public @ResponseBody Object getAllJobOrder(BJobOrder order) {
		Map<String,Object> result=new HashMap<String,Object>();
		if(order.getSentUserId()!=null) {
			List<BJobOrder> theorder=informService.getJobOrder(order);
			if(theorder.size()!=0) {
				List<BUser> users=new ArrayList<BUser>();
				for(int i=0;i<theorder.size();i++) {
					BUser user=new BUser();
					user.setUserId(theorder.get(i).getUserId());
					List<BUser> theuser=userService.getUser(user);
					if(theuser.size()!=0) {
						users.add(theuser.get(0));
					}
				}
				if(users.size()!=0) {
					result.put("code", 200);
					result.put("users",users);
					return result;
				}
			}
		}else {
			List<BJobOrder> theorder=informService.getJobOrder(order);
			if(theorder.size()!=0) {
				BUser user=new BUser();
				user.setUserId(theorder.get(0).getSentUserId());
				List<BUser> theuser=userService.getUser(user);
				if(theuser.size()!=0) {
					result.put("code", 200);
					result.put("users",theuser.get(0));
					return result;
				}
			}
		}
		result.put("code", 500);
		return result;
	}
	
	//通知列表
	//前端判断角色：管理员（sentUserId）/用户（userId）=>获取通知单
	//（管理员）通知单去重=>获取通知+时间
	@GetMapping("/home/getjoborderadmin")
	public @ResponseBody Object getJobOrderAdmin(BJobOrder order) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BJobOrder> theorder=informService.getJobOrder(order);
		if(theorder.size()!=0) {
			for(int i=0;i<theorder.size();i++) {
				for(int j=theorder.size()-1;j>i;j--) {
					if(theorder.get(i).getInformId().equals(theorder.get(j).getInformId())) {
						theorder.remove(j);
					}
				}
			}
			List<BInform> informs=new ArrayList<BInform>();
			for(int i=0;i<theorder.size();i++) {
				BInform theinformid=new BInform();
				theinformid.setInformId(theorder.get(i).getInformId());
				List<BInform> theinform=informService.getInfrom(theinformid);
				if(theinform.size()!=0) {
					informs.add(theinform.get(0));
				}
			}
			result.put("joborder", theorder);
			if(informs.size()!=0) {
				result.put("informs", informs);
				result.put("code", 200);
				return result;
			}else {
				result.put("code", 300);
				return result;
			}
		}
		result.put("code", 500);
		return result;
	}
	
}
