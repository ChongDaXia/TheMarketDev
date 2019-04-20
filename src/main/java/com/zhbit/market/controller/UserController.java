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
import com.zhbit.market.entity.BUser;
import com.zhbit.market.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	//登录界面（用户登录）
	@PostMapping("/login")
	public @ResponseBody Object loginUser(BUser user) {
		Map<String,Object> result=new HashMap<String,Object>();
		//通过用户名和密码获取用户
		List<BUser> getUser=userService.getUser(user);
		if(getUser.size()!=0) {
			String role=getUser.get(0).getRole();
			if(user.getRole().equals(role)) {
				result.put("code", 200);
				result.put("userId",getUser.get(0).getUserId());
				result.put("role",getUser.get(0).getRole());
				return result;
			}else {
				result.put("code", 300);
				return result;
			}
		}
		result.put("code", 500);
		return result;
	}
	
	//更新用户信息
	@PostMapping("/home/updateUser")
	public @ResponseBody Object savePersonalInfo(BUser user) {
		Map<String,Object> result=new HashMap<String,Object>();
		//修改基本信息
		Integer theresult=userService.saveUser(user);
		if(theresult>0) {
			result.put("code",200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//保存新用户
	@PostMapping("/home/addnewuser")
	public @ResponseBody Object saveNewUser(BUser user) {
		Map<String,Object> result=new HashMap<String,Object>();
		Integer theresult=userService.insertNewUser(user);
		if(theresult>0) {
			result.put("code",200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//获取所有用户
	@GetMapping("/home/getAllUser")
	public @ResponseBody Object getAllUser(BUser user) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BUser> getUser=userService.getUser(user);
		if(getUser.size()!=0) {
			BUser[] users=new BUser[getUser.size()];
			for(int i=0;i<getUser.size();i++) {
				users[i]=getUser.get(i);
			}
			result.put("code", 200);
			result.put("users",users);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//获取单个用户
	@GetMapping("/home/getOnceUser")
	public @ResponseBody Object getOnceUser(BUser user) {
	Map<String,Object> result=new HashMap<String,Object>();
	List<BUser> getUser=userService.getUser(user);
	if(getUser.size()!=0) {
		BUser users=new BUser();
		users=getUser.get(0);
		result.put("code", 200);
		result.put("users",users);
		return result;
	}
	result.put("code", 500);
	return result;
	}
	
	//删除用户
	@GetMapping("/home/deleteOnceUser")
	public @ResponseBody Object deleteOnceUser(String userId) {
		Map<String,Object> result=new HashMap<String,Object>();
		JSONArray json=JSONObject.parseArray(userId);
		Integer allsum=0;
		if(json.size()!=0) {
			for(int i=0;i<json.size();i++) {
				BUser user=new BUser();
				user.setUserId(json.getInteger(i));
				List<BUser> getUser=userService.getUser(user);
				if(getUser.size()!=0) {
					Integer theresult=userService.deleteUser(user);
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
