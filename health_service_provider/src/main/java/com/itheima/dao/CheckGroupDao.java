/**
 *  Copyright (C), 2015-2020
 * FileName: CheckGroupDao
 * Author: hanlong
 * Date: 2020/4/24 1:59 下午
 * Description:
 */
package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckGroup;

import java.util.List;
import java.util.Map;

/** Copyright (C), 2015-2020 
 * FileName: CheckGroupDao 
 * Author: hanlong 
 * Date: 2020/4/24 1:59 下午 
 *Description: 
 */
public interface CheckGroupDao {

    public void add(CheckGroup checkGroup);
    public void setCheckGroupAndCheckItem(Map map);
    public Page<CheckGroup> findByCondition(String queryString);
    public CheckGroup findById(Integer id);
    public List<Integer> findCheckItemIdsByCheckGroupId(Integer id);
    public void edit(CheckGroup checkGroup);
    public void deleteAssocication(Integer id);
    /**
     * 删除检查组
     * @param id
     */
    void delete(Integer id);

}
