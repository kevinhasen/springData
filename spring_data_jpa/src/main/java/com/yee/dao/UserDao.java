package com.yee.dao;

import com.yee.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * ClassName: UserDao
 * Description:
 * date: 2021/12/13 10:53
 *  实现JpaRepository,jpa的一个规范
 * 第一个参数是实体类,第二个参数是id的类型
 * 可以自己添加复杂查询方法
 * 还有一种是根据方法名进行查询
 * findBy 属性名(首字母大写)  查询关键字(首字母大写) 多条件查询关键字(首字母大写)
 * 查询关键字:Like Between Equal等
 * 多条件查询关键字  And  Or等
 * @author Yee
 * @since JDK 1.8
 */
public interface UserDao extends JpaRepository<User,Long> {
    //查询所有,默认使用jpql语句
    @Query("from User")
    public List<User> findAllUser();

    //根据名字查询,新版不能直接like,concat是连接符,数字表示参数索引
    @Query("from User where custName like concat('%',?1,'%') ")
    public List<User> findCustNameLike(String custName);

//    根据多个条件进行查询
    //模糊查询，同时按照客户所属行业匹配查询
    @Query("from User where custName like concat('%',?1,'%') and custIndustry like concat('%',?2,'%') ")
    public List<User> findCustNameLikeAndCustIndustry(String custName,String custIndustry);

    //更新,@Query默认表示查询，如果要执行增删改的操作，在@Query注解的下面添加：@Modifying
    @Query("update User set custAddress = ?1 where custId = ?2 ")
    @Modifying
    public void updateUserCustAddress(String custAddress,Long custId);

    //方法命名规则查询
    //基本查询,按名称查询
    public List<User> findByCustName(String custName);

    // 客户名称模糊
    public List<User> findByCustNameLike(String custName);

    // 多条件查询,保证第1个参数就是方法命名的第一个字段
    public List<User> findByCustNameLikeAndCustIndustry(String custName,String custIndustry);

}
