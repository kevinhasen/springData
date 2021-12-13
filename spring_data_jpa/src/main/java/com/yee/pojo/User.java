package com.yee.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: pojo
 * Description:
 * date: 2021/12/13 9:34
 *所有的注解都是使用JPA的规范提供的注解，
 * 所以在导入注解包的时候，一定要导入javax.persistence下的
 * @author Yee
 * @since JDK 1.8
 */

@Entity   //表示该类就是一个持久化对象，与数据库表建立的映射
@Table(name = "cst_customer")   //建立实体类和表的映射关系
public class User implements Serializable {


    @Id  //注解id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //主键策略自生长
    @Column(name = "cust_id")   //指定和表中cust_id字段的映射关系
    private Long custId;

    @Column(name = "cust_name")
    private String custName;

    @Column(name = "cust_source")
    private String custSource;

    @Column(name = "cust_industry")
    private String custIndustry;

    @Column(name = "cust_level")
    private String custLevel;

    @Column(name = "cust_address")
    private String custAddress;

    @Column(name = "cust_phone")
    private String custPhone;

    //配置客户和联系人的一对多关系
    //CascadeType.ALL:表示所有操作,增删改等
    @OneToMany(cascade = CascadeType.ALL)
    private Set<LinkMan> linkmans = new HashSet<>();

    public User() {
    }

    public User(Long custId, String custName, String custSource, String custIndustry, String custLevel, String custAddress, String custPhone) {
        this.custId = custId;
        this.custName = custName;
        this.custSource = custSource;
        this.custIndustry = custIndustry;
        this.custLevel = custLevel;
        this.custAddress = custAddress;
        this.custPhone = custPhone;
    }

    public Set<LinkMan> getLinkmans() {
        return linkmans;
    }

    public void setLinkmans(Set<LinkMan> linkmans) {
        this.linkmans = linkmans;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    @Override
    public String toString() {
        return "User{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custIndustry='" + custIndustry + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custAddress='" + custAddress + '\'' +
                ", custPhone='" + custPhone + '\'' +
                '}';
    }
}
