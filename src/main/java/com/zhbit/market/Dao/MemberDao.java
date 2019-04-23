package com.zhbit.market.Dao;

import java.util.List;

import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zhbit.market.entity.BMember;

@Repository
public class MemberDao {
	@Autowired
	SQLManager sqlManager;
	
	//插入新会员
	public Integer insertNewMember(BMember member) {
		BMember themember=new BMember();
		themember.setName(member.getName());
		themember.setSex(member.getSex());
		themember.setMobileNo(member.getMobileNo());
		themember.setIntegration(member.getIntegration());
		themember.setUserId(member.getUserId());
		Integer result=sqlManager.insertTemplate(themember,true);
		return result;
	}
	
	//更新会员
	public Integer updateMember(BMember member) {
		BMember themember=new BMember();
		themember.setMemberId(member.getMemberId());
		themember.setName(member.getName());
		themember.setSex(member.getSex());
		themember.setMobileNo(member.getMobileNo());
		themember.setIntegration(member.getIntegration());
		themember.setUserId(member.getUserId());
		Integer result=sqlManager.updateTemplateById(themember);
		return result;
	}
	
	//获取会员
	public List<BMember> getMember(BMember member){
		BMember themember=new BMember();
		themember.setMemberId(member.getMemberId());
		themember.setName(member.getName());
		themember.setSex(member.getSex());
		themember.setMobileNo(member.getMobileNo());
		themember.setIntegration(member.getIntegration());
		themember.setUserId(member.getUserId());
		List<BMember> result=sqlManager.select("bMember.selectMember",BMember.class,themember);
		return result;
	}
}
