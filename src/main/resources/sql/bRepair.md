selectRepair
===
*获取维修表
select * from b_repair where 1=1
@if(!isEmpty(repairId)){
and repair_id=#repairId#
@}
@if(!isEmpty(title)){
and title=#title#
@}
@if(!isEmpty(content)){
and content=#content#
@}
@if(!isEmpty(style)){
and style=#style#
@}

selectRepairOrder
===
*获取维修单
select * from b_repair_order where 1=1
@if(!isEmpty(repairOrderId)){
and repair_order_id=#repairOrderId#
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
@if(!isEmpty(repairId)){
and repair_id=#repairId#
@}