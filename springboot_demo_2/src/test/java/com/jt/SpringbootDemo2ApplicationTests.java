package com.jt;

import com.jt.mapper.DemoUserMapper;
import com.jt.pojo.DemoUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootDemo2ApplicationTests {

    //JDK动态代理对象
    @Autowired(required = false)
    private DemoUserMapper userMapper;

    @Test
    void contextLoads() {
        List<DemoUser> userList = userMapper.findAll();
        System.out.println(userList);
    }

    @Test
    public void testInsert(){
        DemoUser user = new DemoUser();
        user.setId(null).setName("大猩猩").setAge(25).setSex("男");
        userMapper.insertUser(user);
    }

    @Test
    public void testUpdate(){
        String nowName = "泰坦";
        String oldName = "大猩猩";
        Integer nowAge = 60;
        String nowSex = "猛男";
        userMapper.updateUser(nowName,oldName,nowAge,nowSex);
    }

    @Test
    public void testDelete(){
        userMapper.delUser("孙尚香D");
    }

    //测试MybatisPlus
    @Test
    public void testSelect(){
        List<DemoUser> list = userMapper.selectList(null);
        System.out.println(list);
    }
}
