package com.zhbit.market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhbit.market.Dao.PaymentDao;
import com.zhbit.market.entity.BPayment;
import com.zhbit.market.entity.BPaymentSlip;

@Service
public class PaymentService {
	@Autowired
	PaymentDao paymentDao;
	
	//保存新费用信息
	public Integer insertNewPayment(BPayment payment) {
		Integer result=paymentDao.insertNewPayment(payment);
		return result;
	}
	
	//保存新缴费单信息
	public Integer insertNewPaymentSlip(BPaymentSlip paymentslip) {
		Integer result=paymentDao.insertNewPaymentSlip(paymentslip);
		return result;
	}
	
	//获取费用信息
	public List<BPayment> getPayment(BPayment payment){
		List<BPayment> payments=paymentDao.getPayment(payment);
		return payments;
	}
	
	//获取缴费单信息
	public List<BPaymentSlip> getPaymentSlip(BPaymentSlip paymentslip){
		List<BPaymentSlip> paymentslips=paymentDao.getPaymentSlip(paymentslip);
		return paymentslips;
	}
}
