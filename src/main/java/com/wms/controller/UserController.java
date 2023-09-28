package com.wms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wms.entity.User;
import com.wms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/user")
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
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(User::getName,user.getName());
        return userService.list(lambdaQueryWrapper);
    }
}

