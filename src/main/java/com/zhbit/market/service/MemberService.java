package com.zhbit.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhbit.market.Dao.MemberDao;
import com.zhbit.market.entity.BMember;

@Service
public class MemberService {
	@Autowired
	MemberDao memberDao;
	
	//保存新会员信息
	public Integer insertNewMember(BMember member) {
		Integer result=memberDao.insertNewMember(member);
		return result;
	}
	
	//更新会员信息
	public Integer updateMember(BMember member) {
		Integer result=memberDao.updateMember(member);
		return result;
	}
	
	//获取会员信息
	public List<BMember> getMember(BMember member){
		List<BMember> result=memberDao.getMember(member);
		return result;
	}
}
