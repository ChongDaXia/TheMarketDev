selectMember
===
*获取会员信息
select * from b_member where 1=1
@if(!isEmpty(memberId)){
and member_id=#memberId#
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
@if(!isEmpty(integration)){
and integration=#integration#
@}
@if(!isEmpty(userId)){
and user_id=#userId#
@}