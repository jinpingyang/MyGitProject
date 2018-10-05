package com.yjp.springboot.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.yjp.springboot.bean.User;

@Repository//CrudRepository
public interface UserDao extends JpaRepository<User, Integer>,JpaSpecificationExecutor<User>  {

	public List<User>  findAll();
	
	@Query("from User where id=:id" )
	public User getUserJPQL(@Param("id")int id);
	
	@Query(value="select * from ts_user where id=:id",nativeQuery=true)
	public User userSQL(@Param("id")int id);
	
	@Query("select u from User u")
	public Page<User> userPage(Pageable pageable);

}
