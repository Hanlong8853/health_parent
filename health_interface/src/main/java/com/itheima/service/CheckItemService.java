/**
 *  Copyright (C), 2015-2020
 * FileName: CheckItemService
 * Author: hanlong
 * Date: 2020/4/23 11:17 上午
 * Description:
 */
package com.itheima.service;

/** Copyright (C), 2015-2020 
 * FileName: CheckItemService 
 * Author: hanlong 
 * Date: 2020/4/23 11:17 上午 
 *Description: 
 */

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;

import java.util.List;

/**
 * 检查项服务接口
 */
public interface CheckItemService {
    public void add(CheckItem checkItem);

    //分页查询
    public PageResult pageQuery(QueryPageBean queryPageBean);

    //删除方法
    public void delete(Integer id);

    //编写
    public void edit(CheckItem checkItem);

    //根据Id 查询
    public CheckItem findById(Integer id);

    //查询全部
    public List<CheckItem> findAll();




}
