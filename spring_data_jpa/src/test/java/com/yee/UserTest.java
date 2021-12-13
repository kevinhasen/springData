package com.yee;

import com.yee.dao.UserDao;
import com.yee.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName: UserTest
 * Description:
 * date: 2021/12/13 11:31
 * 复杂查询
 * @author Yee
 * @since JDK 1.8
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserTest {

    @Autowired
    private UserDao userDao;

    //查询所有
    @Test
    public void getUserList(){
        List<User> users = userDao.findAllUser();
        for (User user : users) {
            System.out.println(user);
        }
    }
    //根据用户名查询
    @Test
    public void testUserNameLike(){
        String custName = "三";
        List<User> userLike = userDao.findCustNameLike(custName);
        for (User user : userLike) {
            System.out.println(user);
        }
    }

    //模糊查询，同时按照客户所属行业匹配查询
    @Test
    public void testCustNameAndCustIndustry(){
        String custName = "三";
        String custIndustry = "好";
        List<User> list;
        list = userDao.findCustNameLikeAndCustIndustry(custName,custIndustry);
        for (User user : list) {
            System.out.println(user);
        }
    }

    //更新地址
    @Test
    @Transactional   //增删改操作事务是必须的
    @Rollback(false)   //事务不回滚
    public void testUpdate(){
        String custAddress = "更新地址";
        Long custId = 2L;
        userDao.updateUserCustAddress(custAddress,custId);
    }




    //根据方法名进行查询
    @Test
    public void testFindByCustName(){
        String custName = "张三";
        List<User> names = userDao.findByCustName(custName);
        for (User user : names) {
            System.out.println(user);
        }
    }

    //模糊查询客户姓名
    @Test
    public void testFindByCustNameLike(){
        String custName = "%三%";
        List<User> names = userDao.findByCustNameLike(custName);
        for (User user : names) {
            System.out.println(user);
        }
    }

    //用户模糊查询和所属行业
    @Test
    public void testNameAndCustIndustroy(){
        String custName = "%三%";
        String custIndustry = "好学";
        List<User> list = userDao.findByCustNameLikeAndCustIndustry(custName,custIndustry);
        for (User user : list) {
            System.out.println(user);
        }
    }
}
