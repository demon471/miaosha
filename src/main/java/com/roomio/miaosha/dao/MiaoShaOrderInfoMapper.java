package com.roomio.miaosha.dao;

import com.roomio.miaosha.domain.MiaoShaOrderInfo;

public interface MiaoShaOrderInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MiaoShaOrderInfo record);

    int insertSelective(MiaoShaOrderInfo record);

    MiaoShaOrderInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MiaoShaOrderInfo record);

    int updateByPrimaryKey(MiaoShaOrderInfo record);
}