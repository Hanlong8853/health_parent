/**
 *  Copyright (C), 2015-2020
 * FileName: CheckItemDao
 * Author: hanlong
 * Date: 2020/4/23 11:26 上午
 * Description:
 */
package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;

import java.util.List;

/** Copyright (C), 2015-2020 
 * FileName: CheckItemDao 
 * Author: hanlong 
 * Date: 2020/4/23 11:26 上午 
 *Description: 持久层Dao接口
 */
public interface CheckItemDao {
    public void add(CheckItem checkItem);
    public Page<CheckItem> selectByCondition(String queryString);
    public long findCountByCheckItemId(Integer id);
    public void deleteById(Integer id);
    public void edit(CheckItem checkItem);
    public CheckItem findById(Integer id);
    public List<CheckItem> findAll();




}
