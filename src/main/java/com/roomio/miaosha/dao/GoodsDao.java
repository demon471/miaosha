package com.roomio.miaosha.dao;

import com.roomio.miaosha.vo.GoodsVo;
import org.apache.ibatis.annotations.Select;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface GoodsDao {

    @Select("SELECT g.*,mg.stock_count,mg.end_date,mg.start_date from miaosha_goods mg LEFT JOIN goods g on mg.goods_id=g.id ")
    public List<GoodsVo> getGoodsVoList();
}