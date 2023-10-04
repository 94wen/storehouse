# storehouse
mybatis-plus分页设置

1.添加拦截器

```java
@Configuration
public class MyBatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor(){
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //指定数据库类型DbType.MYSQL
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }
}
```

2.封装参数，设置页码，页条数

```java
@Data
public class QueryPageParam {
    //默认
    private static int PAGE_SIZE=3;
    private static int PAGE_NUM=1;
    
    private int pageSize=PAGE_SIZE;
    private int pageNum=PAGE_NUM;
    
    private HashMap param;

```

3.UserController.java

```java
@PostMapping("/listPage")
    public List<User> listPage(@RequestBody QueryPageParam query){
        //获取数据
        HashMap param = query.getParam();
        String name = (String)param.get("name");

        Page<User> page = new Page<>();
        //设置当前页
        page.setCurrent(query.getPageNum());
        //设置一页显示条数
        page.setPages(query.getPageSize());
        //LambdaQueryWrapper是Mybatis-plus框架中的一个查询构造器
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //执行分页查询
        userMapper.selectPage(page, lambdaQueryWrapper);
        ////打印执行结果
        System.out.println("当前页码值："+result.getCurrent());
        System.out.println("每页显示数："+result.getSize());
        System.out.println("总页数："+result.getPages());
        System.out.println("总条数："+result.getTotal());
        //System.out.println("当前页数据："+result.getRecords());
        return result.getRecords();
    }
```



