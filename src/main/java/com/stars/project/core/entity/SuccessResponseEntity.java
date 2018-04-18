package com.stars.project.core.entity;

import com.stars.project.core.enumeration.HttpCode;

/**

 * @类介绍 返回成功的实体
 */
public class SuccessResponseEntity extends ResponseEntity {

	public SuccessResponseEntity() {
		super(HttpCode.SUCCESS);
	}

	public SuccessResponseEntity(String msg) {
		super(HttpCode.SUCCESS, msg);
	}

	public SuccessResponseEntity(Object data) {
		super(HttpCode.SUCCESS,HttpCode.SUCCESS.getMessage(), data);
	}

	public SuccessResponseEntity(String msg,Object data) {
		super(HttpCode.SUCCESS,msg,data);
	}
}
