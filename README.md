# JPA

jpa使用的是ORM规范,底层使用的是Hibernate实现

ORM（Object-Relational Mapping） 表示对象关系映射

ORM就是建立实体类和数据库表之间的关系，从而达到操作实体类就相当于操作数据库表的目的。

可以设置自动创建表

## 版本区别

在springboot2.0和2.2以上,代码有些区别

其中包括,mysql版本升级到8.0

必须在url中添加时区serverTimezone=Asia/Shanghai

驱动必须是cj驱动     com.mysql.cj.jdbc.Driver

jpa增删改等有些代码变化

需要启动类



## 入门小案例

接口是UserDao

pojo是User

测试类是MainTest



## JPQL复杂查询



常见的查询

User是实体类,?后面的数字表示参数索引

@Query默认表示查询

要执行增删改的操作，在@Query注解的下面添加：@Modifying



接口是UserDao

pojo是User

测试类是UserTest





## 一对多关系

级联操作指操作一个对象同时操作它的关联对象

CascadeType.ALL:表示所有
CascadeType.MERGE:表示更新
CascadeType.PERSIST:表示保存
  CascadeType.REMOVE：表示删除



接口是UserDao

pojo是User和LinkMan

测试类是CascadeTest



## 多对多关系

多对多的表关系建立靠的是中间表，其中用户表和中间表的关系是一对多，角色表和中间表的关系也是一对多

其中一方需要放弃配置权,否则会冲突,主键重复@ManyToMany(mappedBy = "roles")

接口是MasterDao

pojo是Role和Master

测试类是CascadeTest

