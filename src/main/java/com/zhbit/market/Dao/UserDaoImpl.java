package com.zhbit.market.Dao;

import java.util.List;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zhbit.market.entity.BUser;

@Repository
public class UserDaoImpl {
	@Autowired
	SQLManager sqlManager;
	
	//获取用户
	public List<BUser> getUser(BUser user) { 
		BUser theuser=new BUser();
		theuser.setUserId(user.getUserId());
		theuser.setUserName(user.getUserName());
		theuser.setPassword(user.getPassword());
		theuser.setRole(user.getRole());
		theuser.setName(user.getName());
		theuser.setMobileNo(user.getMobileNo());
		theuser.setIdcardNo(user.getIdcardNo());
		List<BUser> users=sqlManager.select("bUser.selectUser", BUser.class,theuser);
		return users;
	}
	
	//更新用户
	public Integer saveUser(BUser user) {
		BUser theuser=new BUser();
		theuser.setUserId(user.getUserId());
		theuser.setUserName(user.getUserName());
		theuser.setName(user.getName());
		theuser.setMobileNo(user.getMobileNo());
		theuser.setIdcardNo(user.getIdcardNo());
		theuser.setPassword(user.getPassword());
		theuser.setRole(user.getRole());
		Integer result=sqlManager.updateTemplateById(theuser);
		return result;
	}
	
	//插入新用户
	public Integer insertNewUser(BUser user) {
		BUser theuser=new BUser();
		theuser.setUserName(user.getUserName());
		theuser.setPassword(user.getPassword());
		theuser.setRole(user.getRole());
		theuser.setName(user.getName());
		theuser.setMobileNo(user.getMobileNo());
		theuser.setIdcardNo(user.getIdcardNo());
		Integer result=sqlManager.insertTemplate(theuser,true);
		return result;
	}
	
	//删除用户
	public Integer deleteUser(BUser user) {
		BUser theuser=new BUser();
		theuser.setUserId(user.getUserId());
		Integer result=sqlManager.update("bUser.deleteUser", theuser);
		return result;
	}
}
