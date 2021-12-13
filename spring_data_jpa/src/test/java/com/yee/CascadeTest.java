package com.yee;

import com.yee.dao.MasterDao;
import com.yee.dao.UserDao;
import com.yee.pojo.LinkMan;
import com.yee.pojo.Master;
import com.yee.pojo.Role;
import com.yee.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * ClassName: CascadeTest
 * Description:
 * date: 2021/12/13 18:19
 * 测试级联操作
 * 增删改必须开启事务
 * 并且设置不回滚
 * @author Yee
 * @since JDK 1.8
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CascadeTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private MasterDao masterDao;

    /**
     * 存储用户的同时,会一起把联系人存储进去
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testAdd(){
        User user = new User();
        user.setCustName("我是用户名");
        user.setCustLevel("VIP");
        LinkMan linkMan = new LinkMan();
        linkMan.setLkmName("我是联系人");
        //由于是级联保存,所以需要互相存储
        linkMan.setUser(user);
        user.getLinkmans().add(linkMan);
        userDao.save(user);
    }

    /**
     * 级联删除
     */
    @Test
    @Transactional
    @Rollback(false)
    public void testDelete(){
        Optional<User> optional = userDao.findById(5L);
        //先判断有没有,有就获取,否则就是null,直接用如果是没有会报异常
        User user = optional.isPresent() ? optional.get() : null;
        userDao.delete(user);
    }


    //测试级联添加（保存一个用户的同时保存用户的关联角色）
    @Test
    @Transactional
    @Rollback(false)
    public void testCasCade(){
        Master master = new Master();
        master.setUserName("小王");
        Role role = new Role();
        role.setRoleName("java程序员");

        //配置用户和角色的关系
        master.getRoles().add(role);
        role.getUsers().add(master);
        masterDao.save(master);
    }

    //删除id为1的用户，同时删除他的关联对象
    @Test
    @Transactional
    @Rollback(false)
    public void testRemove(){
        //查询1号用户
        Master master = masterDao.findById(1L).get();
        masterDao.delete(master);
    }
}
