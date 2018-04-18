package com.stars.project.service.impl;

import com.stars.project.core.entity.*;
import com.stars.project.entity.Movie;
import com.stars.project.mapper.MovieMapper;
import com.stars.project.service.MovieService;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by Mxy's CodeGenerator on 2017/12/29.
 */
@Service("movieService")
@Transactional(rollbackFor = Exception.class)
public class MovieServiceImpl implements MovieService {

    @Autowired(required = false)
    private MovieMapper movieMapper;

    @Override
    public ResponseEntity insert(Movie model) {

        try {
            if(movieMapper.insertSelective( model) ==1){
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
    public ResponseEntity insertList(List<Movie> models) {
        return null;
    }

    @Override
    public ResponseEntity deleteById(Long id) {
        try {
            if(movieMapper.deleteByPrimaryKey(id) ==1){
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
    public ResponseEntity update(Movie model) {
        try {
            if(movieMapper.updateByPrimaryKeySelective(model) ==1){
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
            if(movieMapper.selectByPrimaryKey(id) != null){
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
