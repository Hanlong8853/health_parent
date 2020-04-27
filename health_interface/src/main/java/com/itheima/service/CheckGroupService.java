/**
 *  Copyright (C), 2015-2020
 * FileName: CheckGroupService
 * Author: hanlong
 * Date: 2020/4/24 2:15 下午
 * Description:
 */
package com.itheima.service;

import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckGroup;

import java.util.List;

/** Copyright (C), 2015-2020 
 * FileName: CheckGroupService 
 * Author: hanlong 
 * Date: 2020/4/24 2:15 下午 
 *Description: 
 */
public interface CheckGroupService {
    public void add(CheckGroup checkGroup, Integer[] checkitemIds);
    public PageResult pageQuery(QueryPageBean queryPageBean);
    public CheckGroup findById(Integer id);
    public List<Integer> findCheckItemIdsByCheckGroupId(Integer id);
    public void edit(CheckGroup checkGroup, Integer[] checkitemIds);
    /**
     * 删除检查组
     * @param id
     */
    void delete(Integer id)throws Exception;

    /**
     * 查询全部检查组
     * @return
     */
    List<CheckGroup> findAll();


}
