/**
 *  Copyright (C), 2015-2020
 * FileName: CheckItemServiceImpl
 * Author: hanlong
 * Date: 2020/4/23 11:23 上午
 * Description:
 */
package com.itheima.service.impl;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/** Copyright (C), 2015-2020 
 * FileName: CheckItemServiceImpl 
 * Author: hanlong 
 * Date: 2020/4/23 11:23 上午 
 *Description:  检查服务项
 */
@Service(interfaceClass = CheckItemService.class)
@Transactional
public class CheckItemServiceImpl implements CheckItemService {
    @Autowired
    private CheckItemDao checkItemDao; //新增
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem); }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();
        //完成分页查询，基于Mybatis 框架提供的分页组手插件完成
        PageHelper.startPage(currentPage,pageSize);
        //select * from t_checkitem limt 0 10
        Page<CheckItem> page = checkItemDao.selectByCondition(queryString);
        long total = page.getTotal();
        List<CheckItem> rows = page.getResult();
        return new PageResult(total,rows);
    }
    //删除
    @Override
    public void delete(Integer id) throws RuntimeException{
        //查询当前检查项是否和检查组关联
        long count = checkItemDao.findCountByCheckItemId(id);
        if(count>0){
            //当前检查项被引用，不能删除
            throw new RuntimeException("当前检查项被引用，不能删除");
        }
        checkItemDao.deleteById(id);
    }

    @Override
    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);

    }
    @Override
    public CheckItem findById(Integer id) {
       return checkItemDao.findById(id);
    }

    @Override
    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }
}
