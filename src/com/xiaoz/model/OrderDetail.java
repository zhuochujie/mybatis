package com.xiaoz.model;

/**
 * 订单详情
 */
public class OrderDetail {
    private Integer id;
    private Integer itemsId;
    private Integer itemsNum;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", items_id=" + itemsId +
                ", items_num=" + itemsNum +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemsId() {
        return itemsId;
    }

    public void setItemsId(Integer itemsId) {
        this.itemsId = itemsId;
    }

    public Integer getItemsNum() {
        return itemsNum;
    }

    public void setItemsNum(Integer itemsNum) {
        this.itemsNum = itemsNum;
    }
}
