selectStaff
===
*获取员工表
select * from b_staff where 1=1
@if(!isEmpty(staffId)){
and staff_id=#staffId#
@}
@if(!isEmpty(name)){
and name=#name#
@}
@if(!isEmpty(sex)){
and sex=#sex#
@}
@if(!isEmpty(mobileNo)){
and mobile_no=#mobileNo#
@}
@if(!isEmpty(idcardNo)){
and idcard_no=#idcardNo#
@}

selectTakeOffice
===
*获取任职表
select * from b_take_office where 1=1
@if(!isEmpty(userId)){
and user_id=#userId#
@}
@if(!isEmpty(staffId)){
and staff_id=#staffId#
@}
@if(!isEmpty(createTime)){
and create_time=#createTime#
@}
@if(!isEmpty(wages)){
and wages=#wages#
@}
@if(!isEmpty(post)){
and post=#post#
@}