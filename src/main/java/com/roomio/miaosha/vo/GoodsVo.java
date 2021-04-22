package com.roomio.miaosha.vo;

import com.roomio.miaosha.domain.Goods;

import java.util.Date;

/**
 * @author biqiang
 * @version 2021/4/22
 * @Description:
 * @Copyright (C)2021, Pcitech
 */
public class GoodsVo extends Goods {
    private Integer stockCount;

    private Date startDate;

    private Date endDate;

    public Integer getStockCount() {
        return stockCount;
    }

    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
