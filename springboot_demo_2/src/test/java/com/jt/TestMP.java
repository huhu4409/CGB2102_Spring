package com.jt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.mapper.DemoUserMapper;
import com.jt.pojo.DemoUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class TestMP {
    @Autowired
    private DemoUserMapper userMapper;

    @Test
    public void insert(){
        DemoUser user = new DemoUser();
        user.setName("浩南哥").setSex("男").setAge(40);
        userMapper.insert(user);
    }

    /*测试更新操作修改id=231的数据name="中午吃什么" age = 18
    * 原则：根据对象中不为null的属性当做set条件
    * 如果是byId的操作，则id必须赋值，并且id当做唯一where条件*/
    @Test
    public void update(){
        DemoUser user = new DemoUser();
        user.setName("中午吃什么").setAge(18).setId(231);
        userMapper.updateById(user);
    }

    /*1.查询id为21的用户
    * 2.查询name="白骨精" sex=女 的用户 list
    * 知识点：1.queryWrapper  条件构造器 拼接where条件的
    *        2.原则：根据对象中不为null的属性拼接sql语句
    * */
    @Test
    public void testSelect(){
        //1.根据id查询
        DemoUser user = userMapper.selectById(22);
        System.out.println(user);
        //2.根据属性查询
        DemoUser user1 = new DemoUser();
        user1.setName("白骨精").setSex("女");
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>(user1);
        List<DemoUser> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    public void testSelect1(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 18).eq("sex", "女");
        List<DemoUser> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    public void testSelect2(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeLeft("name", "精");
        List<DemoUser> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    public void testSelect3(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sex", "男")
                .orderByDesc("id");
        List<DemoUser> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    public void testSelect4(){
        //数组使用包装类型
        Integer[] ids ={1,3,5,6,7};
        //需要将数组转化为集合
        List idList = Arrays.asList(ids);
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        //queryWrapper.in("id", ids);
        queryWrapper.in("id", idList);  //根据list查询 list集合功能丰富，数组必须包装
        List<DemoUser> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    public void testSelect5(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        String name = "白骨精";
        int age = 18;
        boolean flag = name!=null && "".equals(name);
        queryWrapper.eq(StringUtils.hasLength(name),"name",name)
                .eq(age > 0, "age",age);
        List<DemoUser> userList = userMapper.selectList(queryWrapper);
        System.out.println(userList);
    }

    @Test
    public void testSelect6(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sex", "男");
        List<Object> objs = userMapper.selectObjs(queryWrapper);
        System.out.println(objs);
    }

    @Test
    public void testSelect7(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","sex");
        List<DemoUser> objs = userMapper.selectList(queryWrapper);
        System.out.println(objs);
    }

    @Test
    public void testSelect8(){
        QueryWrapper<DemoUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","sex");
        List<Map<String, Object>> mapList = userMapper.selectMaps(queryWrapper);
        System.out.println(mapList);
    }

    @Test
    public void testUpdate(){
        DemoUser user = new DemoUser();
        user.setName("晚上吃什么").setSex("其他");
        UpdateWrapper<DemoUser> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", "中午吃什么");
        userMapper.update(user, updateWrapper);
    }
}
