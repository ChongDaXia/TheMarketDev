selectStore
===
*获取门店表
select * from b_store where 1=1
@if(!isEmpty(storeId)){
and store_id=#storeId#
@}
@if(!isEmpty(storeNo)){
and store_no=#storeNo#
@}
@if(!isEmpty(address)){
and address=#address#
@}
@if(!isEmpty(area)){
and area=#area#
@}
@if(!isEmpty(rentStatus)){
and rent_status=#rentStatus#
@}

selectRent
===
*获取租赁表
select * from b_rent where 1=1
@if(!isEmpty(rentId)){
and rent_id=#rentId#
@}
@if(!isEmpty(storeId)){
and store_id=#storeId#
@}
@if(!isEmpty(userId)){
and user_id=#userId#
@}
@if(!isEmpty(createTime)){
and create_time=#createTime#
@}
@if(!isEmpty(rent)){
and rent=#rent#
@}

deleteStore
===
*删除门店
delete from b_store where 1=1
@if(!isEmpty(storeId)){
and store_id=#storeId#
@}
@if(!isEmpty(storeNo)){
and store_no=#storeNo#
@}
@if(!isEmpty(address)){
and address=#address#
@}
@if(!isEmpty(area)){
and area=#area#
@}
@if(!isEmpty(rentStatus)){
and rent_status=#rentStatus#
@}