package com.yjp.springboot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.yjp.springboot.bean.User;

@Repository
public class UserDaoImpl {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<User> users(User user){
		StringBuilder sb = new StringBuilder();
		sb.append("select u from User u where 1=1");
		if(null != user && !StringUtils.isEmpty(user.getId())){
			sb.append(" and u.id = :id");
		}
		Query query = em.createQuery(sb.toString());
		if(null != user && !StringUtils.isEmpty(user.getId())){
			query.setParameter("id", user.getId());
		}
		return query.getResultList();
	}
	
	/**
	 * 执行原生态sql
	 * @return
	 */
	public List<User> sql(){
		//String slq="select new com.yjp.springboot.bean.User from ts_user";
		String sql="select * from ts_user";
		Query query = em.createNamedQuery(sql,User.class);
		return query.getResultList();
	}

}
