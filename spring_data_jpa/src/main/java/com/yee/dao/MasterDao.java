package com.yee.dao;

import com.yee.pojo.Master;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName: MasterDao
 * Description:
 * date: 2021/12/13 19:25
 *
 * @author Yee
 * @since JDK 1.8
 */
public interface MasterDao extends JpaRepository<Master,Long> {
}
