package com.zhbit.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhbit.market.Dao.UserDaoImpl;
import com.zhbit.market.entity.BUser;

@Service
public class UserService {
	@Autowired
	UserDaoImpl userDaoImpl;
	
	//获取用户（登录）
	public List<BUser> getUser(BUser user){
		List<BUser> users=userDaoImpl.getUser(user);
		return users;
	}
	
	//保存用户(基本信息、修改密码）
	public Integer saveUser(BUser user) {
		Integer result=userDaoImpl.saveUser(user);
		return result;
	}
	
	//插入新用户（添加用户）
	public Integer insertNewUser(BUser user) {
		Integer result=userDaoImpl.insertNewUser(user);
		return result;
	}
	
	//删除用户
	public Integer deleteUser(BUser user) {
		Integer result=userDaoImpl.deleteUser(user);
		return result;
	}
}
