package com.zhbit.market.Dao;

import java.util.List;
import org.beetl.sql.core.SQLManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.zhbit.market.entity.BPayment;
import com.zhbit.market.entity.BPaymentSlip;

@Repository
public class PaymentDao {
	@Autowired
	SQLManager sqlManager;
	
	//插入新费用表
	public Integer insertNewPayment(BPayment payment) {
		BPayment thepayment=new BPayment();
		thepayment.setTitle(payment.getTitle());
		thepayment.setContent(payment.getContent());
		thepayment.setSum(payment.getSum());
		thepayment.setStyle(payment.getStyle());
		Integer result=sqlManager.insertTemplate(thepayment,true);
		return result;
	}
	
	//插入新缴费单
	public Integer insertNewPaymentSlip(BPaymentSlip paymentslip) {
		BPaymentSlip thepaymentslip=new BPaymentSlip();
		thepaymentslip.setUserId(paymentslip.getUserId());
		thepaymentslip.setPaymentId(paymentslip.getPaymentId());
		thepaymentslip.setCreateTime(paymentslip.getCreateTime());
		thepaymentslip.setPaymentSlipStatus(paymentslip.getPaymentSlipStatus());
		thepaymentslip.setUpdateTime(paymentslip.getUpdateTime());
		Integer result=sqlManager.insertTemplate(thepaymentslip,true);
		return result;
	}
	
	//获取费用表
	public List<BPayment> getPayment(BPayment payment){
		BPayment thepayment=new BPayment();
		thepayment.setPaymentId(payment.getPaymentId());
		thepayment.setTitle(payment.getTitle());
		thepayment.setContent(payment.getContent());
		thepayment.setSum(payment.getSum());
		thepayment.setStyle(payment.getStyle());
		List<BPayment> payments=sqlManager.select("bPayment.selectPayment", BPayment.class,thepayment);
		return payments;
	}
	
	//获取缴费单
	public List<BPaymentSlip> getPaymentSlip(BPaymentSlip paymentslip){
		BPaymentSlip thepaymentslip=new BPaymentSlip();
		thepaymentslip.setPaymentSlipId(paymentslip.getPaymentSlipId());
		thepaymentslip.setUserId(paymentslip.getUserId());
		thepaymentslip.setPaymentId(paymentslip.getPaymentId());
		thepaymentslip.setCreateTime(paymentslip.getCreateTime());
		thepaymentslip.setPaymentSlipStatus(paymentslip.getPaymentSlipStatus());
		thepaymentslip.setUpdateTime(paymentslip.getUpdateTime());
		List<BPaymentSlip> paymentslips=sqlManager.select("bPayment.selectPaymentSlip", BPaymentSlip.class,thepaymentslip);
		return paymentslips;
	}
}
