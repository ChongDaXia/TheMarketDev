selectPayment
===
*获取费用表
select * from b_payment where 1=1
@if(!isEmpty(paymentId)){
and payment_id=#paymentId#
@}
@if(!isEmpty(title)){
and title=#title#
@}
@if(!isEmpty(content)){
and content=#content#
@}
@if(!isEmpty(sum)){
and sum=#sum#
@}
@if(!isEmpty(style)){
and style=#style#
@}

selectPaymentSlip
===
*获取缴费单
select * from b_payment_slip where 1=1
@if(!isEmpty(paymentSlipId)){
and payment_slip_id=#paymentSlipId#
@}
@if(!isEmpty(userId)){
and user_id=#userId#
@}
@if(!isEmpty(createTime)){
and create_time=#createTime#
@}
@if(!isEmpty(paymentId)){
and payment_id=#paymentId#
@}
@if(!isEmpty(paymentSlipStatus)){
and payment_slip_status=#paymentSlipStatus#
@}
@if(!isEmpty(updateTime)){
and update_time=#updateTime#
@}