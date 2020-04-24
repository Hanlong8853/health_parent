/**
 *  Copyright (C), 2015-2020
 * FileName: CheckItemController
 * Author: hanlong
 * Date: 2020/4/23 11:14 上午
 * Description:
 */
package com.itheima.controller;

/** Copyright (C), 2015-2020 
 * FileName: CheckItemController 
 * Author: hanlong 
 * Date: 2020/4/23 11:14 上午 
 *Description: 
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConstant;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 体检检查项管理
 */
@RestController
@RequestMapping("/checkitem")
public class CheckItemController {

    @Reference
    private CheckItemService checkItemService;

    //新增
    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem){
        try { checkItemService.add(checkItem);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,MessageConstant.ADD_CHECKITEM_FAIL);
        }
        return new Result(true,MessageConstant.ADD_CHECKITEM_SUCCESS);
    }

    //检查项分页查询
    @RequestMapping("/findPage")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean){
        PageResult pageResult = checkItemService.pageQuery(queryPageBean);
        return pageResult;
    }

    //删除检查项
    @RequestMapping("/delete")
    public Result delete(Integer id){
        try {
            checkItemService.delete(id);
        }catch (RuntimeException e)
        {
            return new Result(false,e.getMessage());
        }catch (Exception e)
        {
            return new Result(false, MessageConstant.DELETE_CHECKITEM_FAIL);
        }
        return new Result(true,MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }

    //编辑检查项
    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckItem checkItem){
        try{
            checkItemService.edit(checkItem);
        }catch (Exception e){
            e.printStackTrace();
            //服务调用失败
            return new Result(false, MessageConstant.EDIT_CHECKITEM_FAIL);
        }
        return  new Result(true, MessageConstant.EDIT_CHECKITEM_SUCCESS);
    }

    @RequestMapping("/findById")
    public Result findById(Integer id){
        try{
            CheckItem checkItem = checkItemService.findById(id);
            return  new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItem);
        }catch (Exception e){
            e.printStackTrace();
            //服务调用失败
            return new Result(false, MessageConstant.QUERY_CHECKITEM_FAIL);
        }
    }

    //查询全部  新增检查组中的检查项 显示全部

    @RequestMapping("/findAll") public Result findAll(){
    List<CheckItem> checkItemList = checkItemService.findAll(); if(checkItemList != null && checkItemList.size() > 0){
        Result result = new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS);
        result.setData(checkItemList);
        return result;
    }
     return new Result(false,MessageConstant.QUERY_CHECKITEM_FAIL); }


}
