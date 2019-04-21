selectGoods
===
*获取商品表
select * from b_goods where 1=1
@if(!isEmpty(goodsId)){
and goods_id=#goodsId#
@}
@if(!isEmpty(name)){
and name=#name#
@}
@if(!isEmpty(amount)){
and amount=#amount#
@}
@if(!isEmpty(salesCount)){
and sales_count=#salesCount#
@}

selectSupplier
===
*获取供应商表
select * from b_supplier where 1=1
@if(!isEmpty(supplierId)){
and supplier_id=#supplierId#
@}
@if(!isEmpty(name)){
and name=#name#
@}
@if(!isEmpty(contacts)){
and contacts=#contacts#
@}
@if(!isEmpty(mobileNo)){
and mobile_no=#mobileNo#
@}
@if(!isEmpty(address)){
and address=#address#
@}

selectPurchase
===
*获取采购单
select * from b_purchase where 1=1
@if(!isEmpty(purchaseId)){
and purchase_id=#purchaseId#
@}
@if(!isEmpty(staffId)){
and staff_id=#staffId#
@}
@if(!isEmpty(supplierId)){
and supplier_id=#supplierId#
@}
@if(!isEmpty(createTime)){
and create_time=#createTime#
@}
@if(!isEmpty(totalPrice)){
and total_price=#totalPrice#
@}

selectPurchaseItem
===
*获取采购商品项
select * from b_purchases_item where 1=1
@if(!isEmpty(purchasesItemId)){
and purchases_item_id=#purchasesItemId#
@}
@if(!isEmpty(purchaseId)){
and purchase_id=#purchaseId#
@}
@if(!isEmpty(goodsId)){
and goods_id=#goodsId#
@}
@if(!isEmpty(amount)){
and amount=#amount#
@}
@if(!isEmpty(price)){
and price=#price#
@}

selectSalesSlip
===
*获取销售单
select * from b_sales_slip where 1=1
@if(!isEmpty(salesSlipId)){
and sales_slip_id=#salesSlipId#
@}
@if(!isEmpty(staffId)){
and staff_id=#staffId#
@}
@if(!isEmpty(memberId)){
and member_id=#memberId#
@}
@if(!isEmpty(createTime)){
and create_time=#createTime#
@}
@if(!isEmpty(totalPrice)){
and total_price=#totalPrice#
@}

selectSalesItem
===
*获取销售单
select * from b_sales_item where 1=1
@if(!isEmpty(salesItemId)){
and sales_item_id=#salesItemId#
@}
@if(!isEmpty(salesSlipId)){
and sales_slip_id=#salesSlipId#
@}
@if(!isEmpty(goodsId)){
and goods_id=#goodsId#
@}
@if(!isEmpty(amount)){
and amount=#amount#
@}
@if(!isEmpty(price)){
and price=#price#
@}

deleteSupplier
===
*删除供应商
delete from b_supplier where 1=1
@if(!isEmpty(supplierId)){
and supplier_id=#supplierId#
@}