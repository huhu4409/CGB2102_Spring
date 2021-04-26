package com.jt.pojo;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class User {
    private Integer id;
    private String name;

    //为集合赋值
    private List list;
    private Set set;
    private Map map;
    private Properties p;//内部只能存储String类型的数据

    public User() {

    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Properties getP() {
        return p;
    }

    public void setP(Properties p) {
        this.p = p;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                ", set=" + set +
                ", map=" + map +
                ", p=" + p +
                '}';
    }
}
