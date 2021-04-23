package com.roomio.miaosha.service;

import com.roomio.miaosha.dao.GoodsMapper;
import com.roomio.miaosha.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author biqiang
 * @version 2021/4/22
 * @Description:
 * @Copyright (C)2021, Pcitech
 */
@Service
public class GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    public List<GoodsVo> getGoodsVoList(){
        return goodsMapper.getGoodsVoList();
    }

}
