selectUser
===
*查询用户信息，如果不为空的话
select * from b_user where 1=1
@if(!isEmpty(userId)){
and user_id=#userId#
@}
@if(!isEmpty(userName)){
and user_name=#userName#
@}
@if(!isEmpty(password)){
and password=#password#
@}
@if(!isEmpty(role)){
and role=#role#
@}
@if(!isEmpty(name)){
and name=#name#
@}
@if(!isEmpty(mobileNo)){
and mobile_no=#mobileNo#
@}
@if(!isEmpty(idcardNo)){
and idcard_no=#idcardNo#
@}

deleteUser
===
*删除用户
delete from b_user where 1=1
@if(!isEmpty(userId)){
and user_id=#userId#
@}