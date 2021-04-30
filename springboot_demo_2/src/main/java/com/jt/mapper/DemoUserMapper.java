package com.jt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.DemoUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper //将mapper接口交给容器管理
/*注意事项：baseMapper必须添加泛型对象，*/
public interface DemoUserMapper extends BaseMapper<DemoUser> {
    List<DemoUser> findAll();
    void insertUser(DemoUser user);
    void updateUser(String nowName,String oldName,Integer nowAge,String nowSex);
    void delUser(String name);
}
