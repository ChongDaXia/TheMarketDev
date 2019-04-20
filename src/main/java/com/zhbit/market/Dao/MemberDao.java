package com.zhbit.market.Dao;

import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhbit.market.entity.BMember;

@Repository
public class MemberDao {
	@Autowired
	SQLManager sqlManager;
	
	//插入新门店
	public Integer insertNewMember(BMember member) {
		BMember themember=new BMember();
		themember.setName(member.getName());
		themember.setSex(member.getSex());
		themember.setMobileNo(member.getMobileNo());
		themember.setIntegration(member.getIntegration());
		Integer result=sqlManager.insertTemplate(themember,true);
		return result;
	}
}
