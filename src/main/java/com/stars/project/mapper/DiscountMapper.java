package com.stars.project.mapper;

import com.stars.project.entity.Discount;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DiscountMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Discount record);

    int insertSelective(Discount record);

    Discount selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Discount record);

    int updateByPrimaryKey(Discount record);
}