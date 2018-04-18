package com.stars.project.mapper;

import com.stars.project.entity.Cinema;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author : mxy
 * @Date : Created on 11:58 2018/3/8
 * @Description: 自定义时间解析器
 * @Version : 1.0
 * @Modified By :
 **/
@Mapper
public interface CinemaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Cinema record);

    int insertSelective(Cinema record);

    Cinema selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Cinema record);

    int updateByPrimaryKey(Cinema record);
}