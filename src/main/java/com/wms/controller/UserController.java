package com.wms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.common.QueryPageParam;
import com.wms.common.Result;
import com.wms.entity.User;
import com.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author wen
 * @since 2023-09-20
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    //新增
    @PostMapping("/save")
    public boolean save(@RequestBody User user){
        return userService.save(user);
    }
    //修改
    @PostMapping("/update")
    public boolean updateById(@RequestBody User user){
        return userService.updateById(user);
    }
    //新增或修改
    @PostMapping("/soru")
    public boolean soru(@RequestBody User user){
        return userService.saveOrUpdate(user);
    }
    //根据id删除
    @GetMapping("/delete")
    public boolean deleteById(Integer id){
        return userService.removeById(id);
    }
    //查询
    @PostMapping("/select")
    public List<User> listP(@RequestBody User user){
        return userService.list();
    }
    //分页查询
    @PostMapping("/listPage")
    public List<User> listPage( @RequestBody QueryPageParam query){

        HashMap param = query.getParam();
        String name = (String)param.get("name");
        System.out.println(name);

        Page<User> page = new Page();
        //设置当前页
        page.setCurrent(query.getPageNum());
          //设置一页显示条数
        page.setPages(query.getPageSize());

        //LambdaQueryWrapper是Mybatis-plus框架中的一个查询构造器
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(name) && !"null".equals(name)){
            lambdaQueryWrapper.like(User::getName,name);
        }
        //查询执行
        IPage result = userService.page(page,lambdaQueryWrapper);
        //打印执行结果
        System.out.println("当前页码值："+result.getCurrent());
        System.out.println("每页显示数："+result.getSize());
        System.out.println("总页数："+result.getPages());
        System.out.println("总条数："+result.getTotal());
        //System.out.println("当前页数据："+result.getRecords());
        return result.getRecords();
    }
    @PostMapping("/listPage2")
    public Result listPage2(@RequestBody QueryPageParam query){

        HashMap param = query.getParam();
        String name = (String)param.get("name");
        String sex = (String)param.get("sex");
        //传的name
        System.out.println(param);
        System.out.println(name);

        Page<User> page = new Page();
        //设置当前页
        page.setCurrent(query.getPageNum());
        System.out.println(query.getPageNum());
        //设置一页显示条数
        page.setSize(query.getPageSize());
        System.out.println(query.getPageSize());

        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(name) && !"null".equals(name)){
            lambdaQueryWrapper.like(User::getName,name);
        }
        if (StringUtils.isNotBlank(sex)){
            lambdaQueryWrapper.eq(User::getSex,sex);
        }
        //查询执行
        IPage result = userService.page(page,lambdaQueryWrapper);
        System.out.println("当前页码值："+result.getCurrent());
        System.out.println("每页显示数："+result.getSize());
        System.out.println("总页数："+result.getPages());
        System.out.println("总条数："+result.getTotal());
        //System.out.println("当前页数据："+result.getRecords());
        return Result.suc(result.getTotal(),result.getRecords());
    }
}

