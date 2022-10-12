package com.pzx.pojo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author panzhixin
 * @date 2022/10/11
 * @description
 */

public class Cart {

    private Map<Integer,CartItem> items=new HashMap<Integer,CartItem>();

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    public Integer getTotalCount() {
        Integer totalCount=0;
        for(Map.Entry<Integer,CartItem> entry:items.entrySet()){
            totalCount+=entry.getValue().getCount();
        }
        return totalCount;
    }


    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice=new BigDecimal(0);
        for(Map.Entry<Integer,CartItem>entry:items.entrySet()){
            totalPrice=totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    //添加商品项
    public void addItem(CartItem cartItem){
        CartItem item=items.get(cartItem.getId());
        if(item==null){
            items.put(cartItem.getId(),cartItem);
        }else{
            item.setCount(item.getCount()+1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }
    //删除商品项
    public void deleteItem(Integer id){
        items.remove(id);
    }
    //添加商品项
    public void clear(){
        items.clear();
    }
    //添加商品项
    public void updateItem(Integer id,Integer count){
        CartItem item = items.get(id);
        if(item!=null){
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));

        }
    }
}