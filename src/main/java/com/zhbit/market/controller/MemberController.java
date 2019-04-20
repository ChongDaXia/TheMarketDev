package com.zhbit.market.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	//管理（保存新）
	@PostMapping("/home/addnewmember")
	public @ResponseBody Object saveNew(BMember member) {
		Map<String,Object> result=new HashMap<String,Object>();
		Integer theresult=memberService.insertNewMember(member);
		System.out.println("更新数："+theresult);
		if(theresult>0) {
			result.put("code",200);
			return result;
		}
		result.put("code", 500);
		return result;
	}
}
