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

import com.zhbit.market.entity.BMember;
import com.zhbit.market.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	//保存新会员
	@PostMapping("/home/addnewmember")
	public @ResponseBody Object saveNew(BMember member) {
		Map<String,Object> result=new HashMap<String,Object>();
		Integer theresult=memberService.insertNewMember(member);
		if(theresult>0) {
			result.put("code",200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//获取所有会员信息
	@GetMapping("/home/getAllMember")
	public @ResponseBody Object getAllMember(BMember member) {
		Map<String,Object> result=new HashMap<String,Object>();
		List<BMember> themember=memberService.getMember(member);
		if(themember.size()!=0) {
			result.put("members", themember);
			result.put("code", 200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
	
	//修改会员信息
	@PostMapping("/home/updatemember")
	public @ResponseBody Object updateMember(BMember member) {
		Map<String,Object> result=new HashMap<String,Object>();
		Integer theresult=memberService.updateMember(member);
		if(theresult>0) {
			result.put("code",200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
}
