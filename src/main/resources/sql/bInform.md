selectInform
===
*获取通知表
select * from b_inform where 1=1
@if(!isEmpty(informId)){
and inform_id=#informId#
@}
@if(!isEmpty(title)){
and title=#title#
@}
@if(!isEmpty(content)){
and content=#content#
@}


selectJobOrder
===
*获取通知单
select * from b_job_order where 1=1
@if(!isEmpty(jobOrderId)){
and job_order_id=#jobOrderId#
@}
@if(!isEmpty(sentUserId)){
and sent_user_id=#sentUserId#
@}
@if(!isEmpty(userId)){
and user_id=#userId#
@}
@if(!isEmpty(createTime)){
and create_time=#createTime#
@}
@if(!isEmpty(informId)){
and inform_id=#informId#
@}