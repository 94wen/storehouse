package com.wms;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wms.entity.User;
import com.wms.mapper.UserMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author wen
 * @Data 2023/9/28 19:54
 */
@SpringBootTest
public class MybatisPlusPageTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage(){
        //1.创建QueryWrapper对象
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //2.创建分页查询对象,指定当前页和每页显示条数
        Page<User> page = new Page<User>(1,3);
        //3.执行分页查询
        userMapper.selectPage(page, null);
        //4.查看分页查询的结果
        System.out.println("当前页码值："+page.getCurrent());
        System.out.println("每页显示数："+page.getSize());
        System.out.println("总页数："+page.getPages());
        System.out.println("总条数："+page.getTotal());
        System.out.println("当前页数据："+page.getRecords());
        System.out.println(page);
    }

}
