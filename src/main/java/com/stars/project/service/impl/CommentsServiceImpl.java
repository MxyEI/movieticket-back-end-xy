package com.stars.project.service.impl;

import com.stars.project.core.entity.*;
import com.stars.project.entity.Comment;
import com.stars.project.mapper.CommentMapper;
import com.stars.project.service.CommentService;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


/**
 * Created by Mxy's CodeGenerator on 2017/12/29.
 */
@Service("commentService")
@Transactional(rollbackFor = Exception.class)
public class CommentsServiceImpl implements CommentService {

    @Autowired(required = false)
    private CommentMapper mapper;

    @Override
    public ResponseEntity insert(Comment model) {
        try {
            if(mapper.insertSelective(model) == 1){
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
    public ResponseEntity insertList(List<Comment> models) {
        return null;
    }

    @Override
    public ResponseEntity deleteById(Long id) {
        try {
            if(mapper.deleteByPrimaryKey(id) == 1){
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
    public ResponseEntity update(Comment model) {
        try {
            if(mapper.updateByPrimaryKeySelective(model) == 1){
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
            if(mapper.selectByPrimaryKey(id) != null){
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
