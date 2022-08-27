package com.worldance.test.object.shop.impl;

import java.util.List;

import com.worldance.test.object.shop.ElectroincShopInterface;

public class ElectronicShop<T> implements ElectroincShopInterface<T> {

    protected T goods;

    protected List<T> goodsList;

    public ElectronicShop(T goods) {
        this.goods = goods;
    }

    public ElectronicShop(List<T> goodsList) {
        this.goodsList = goodsList;
    }

    /**
     * 增加商品
     *
     * @param goods
     */
    public void addGoods(T goods) {
        this.goodsList.add(goods);
    }

    /**
     * 获取第i个商品
     *
     * @param i
     * @return
     */
    public T getGoods(int i) {
        return this.goodsList.get(i);
    }

    public List<T> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<T> goodsList) {
        this.goodsList = goodsList;
    }

    public T getGoods() {
        return goods;
    }

    public void setGoods(T goods) {
        this.goods = goods;
    }

}
