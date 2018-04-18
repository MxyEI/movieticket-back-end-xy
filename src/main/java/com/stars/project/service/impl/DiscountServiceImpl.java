package com.stars.project.service.impl;

import com.stars.project.core.entity.*;
import com.stars.project.entity.Discount;
import com.stars.project.mapper.DiscountMapper;
import com.stars.project.service.DiscountService;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author : mxy
 * @Date : Created on 16:53 2018/3/20
 * @Description:
 * @Version : 1.0
 * @Modified By :
 **/
@Service("discountsService")
@Transactional(rollbackFor = Exception.class)
public class DiscountServiceImpl implements DiscountService {

    @Autowired(required = false)
    private DiscountMapper discountMapper;

    @Override
    public ResponseEntity insert(Discount model) {

        try {
            if(discountMapper.insertSelective(model) == 1){
                return new SuccessResponseEntity();
            }else {
                return new FailureResponseEntity();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorResponseEntity();
        }
    }

    @Override
    public ResponseEntity insertList(List<Discount> models) {
        return null;
    }

    @Override
    public ResponseEntity deleteById(Long id) {
        try {
            if(discountMapper.deleteByPrimaryKey(id) == 1){
                return new SuccessResponseEntity();
            }else {
                return new FailureResponseEntity();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorResponseEntity();
        }
    }

    @Override
    public ResponseEntity deleteByIds(String ids) {
        return null;
    }

    @Override
    public ResponseEntity update(Discount model) {
        try {
            if(discountMapper.updateByPrimaryKeySelective(model) == 1){
                return new SuccessResponseEntity();
            }else {
                return new FailureResponseEntity();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorResponseEntity();
        }
    }

    @Override
    public ResponseEntity selectOneById(Long id) {
        try {
            if(discountMapper.selectByPrimaryKey(id) != null){
                return new SuccessResponseEntity();
            }else {
                return new FailureResponseEntity();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ErrorResponseEntity();
        }
    }

    @Override
    public ResponseEntity selectListByMap(Map map, PageInfo pageInfo) throws TooManyResultsException {
        return null;
    }

    @Override
    public ResponseEntity selectByIds(String ids) {
        return null;
    }

    @Override
    public ResponseEntity selectAll() {
        return null;
    }
}
