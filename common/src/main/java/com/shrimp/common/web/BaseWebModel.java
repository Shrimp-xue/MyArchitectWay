package com.shrimp.common.web;

import lombok.Data;

/**
 * @description: controller 层展示条件查询model
 * @author: shrimp
 * @date: Created in 2020-01-09 20:20
 * @version: 1.0
 */
@Data
public class BaseWebModel {
	
	private String queryJsonStr = "";
	private int nowPage = 1;
	private int pageShow = 0;
}
