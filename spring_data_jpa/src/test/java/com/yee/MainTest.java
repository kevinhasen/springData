package com.yee;

import com.yee.dao.UserDao;
import com.yee.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * ClassName: MainTest
 * Description:
 * date: 2021/12/13 10:02
 * 这里是简单查询
 *  目前使用的是boot2.2版本,大部分jpa使用了新的用法
 *  sort排序,分页,查询是否存在等都有更新
 * @author Yee
 * @since JDK 1.8
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MainTest {
    //注入dao层
    @Autowired
    private UserDao userDao;
    //根据ID查询用户
    @Test
    public void getOne(){
        User user = userDao.findById(1L).get();
        System.out.println(user);
    }

    //插入数据库,如果没有id表示保存
    @Test
    public void addUser(){
        User user = new User(null,"张三","测试","哈哈","嘻嘻","呵呵","手机号");
        userDao.save(user);
    }


    //更新用户,如果有id则表示更新
    @Test
    public void updateUser(){
        User user = new User(1L,"张三","测试","哈哈","嘻嘻","呵呵","手机号");
        userDao.save(user);
    }

    //删除用户
    @Test
    public void deleteUser(){
        userDao.deleteById(1L);
    }

    //查询所有
    @Test
    public void getUserList(){
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 新版排序不在使用new的方式构造sort
     * 构造器私有化,只能通过by方法获得sort实例
     */
    @Test
    public void userSort(){
        //通过id排序
        Sort custId = Sort.by(Sort.Direction.DESC, "custId");
        List<User> all = userDao.findAll(custId);
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 新版分页,不在使用new方法
     * 使用of方法获取实例
     */
    @Test
    public void pageUser(){
        //分页,第一个参数表示从哪页开始,第二个参数表示每页几条数据
        PageRequest request = PageRequest.of(0, 2);
        Page<User> all = userDao.findAll(request);
        System.out.println("总记录数:"+all.getTotalElements());
        System.out.println("总页数:"+all.getTotalPages());
        //分页的内容
        List<User> content = all.getContent();
        for (User user : content) {
            System.out.println(user);
        }
    }
    //查询总数量,所有用户的数量
    @Test
    public void getCount(){
        long count = userDao.count();
        System.out.println(count);
    }

    //查询是否存在该用户
    //新版查询需要加ById
    @Test
    public void existsUser(){
        boolean exists = userDao.existsById(4L);
        System.out.println("id为4的客户 是否存在："+exists);
    }

    //延迟加载,需要事务支持,否则报错
    @Test
    @Transactional
    public void testOne(){
        User one = userDao.getOne(4L);
        System.out.println(one);
    }
}
