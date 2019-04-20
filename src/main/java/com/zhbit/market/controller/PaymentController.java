package com.zhbit.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zhbit.market.service.PaymentService;

@Controller
@RequestMapping("/payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
}
