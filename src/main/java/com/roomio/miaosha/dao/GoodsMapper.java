package com.roomio.miaosha.dao;

import com.roomio.miaosha.domain.Goods;
import com.roomio.miaosha.vo.GoodsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {

    List<GoodsVo>  getGoodsVoList();

    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    GoodsVo getGoodVoById(Integer id);
}