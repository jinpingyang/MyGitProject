package com.yjp.springboot.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.yjp.springboot.bean.PageInfo;
import com.yjp.springboot.bean.User;
import com.yjp.springboot.dao.UserDao;
import com.yjp.springboot.dao.UserDaoImpl;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserDaoImpl userDaoImpl;

	
//	@Transactional(propagation = Propagation .REQUIRES_NEW)
	public User save(User user){
		return userDao.save(user);
	}
	
	public List<User> findAll(){
		return userDao.findAll();
	}
	
	public User findById(int id){
		Optional<User> user=userDao.findById(id);
		if(user.isPresent())
			return user.get();
		return null;
	}
	
	public User getUserJPQL(int id){
		return userDao.getUserJPQL(id);
	}
	
	public User userSQL(int id){
		return userDao.userSQL(id);
	}
	
	public List<User> user(User user){
		return userDaoImpl.users(user);
	}
	
	public Page<User> search(User user,PageInfo pi){
		Pageable pageable = PageRequest.of(pi.getPage()-1, pi.getLimt(), Sort.Direction.ASC, pi.getSort());
		return	userDao.findAll(pageable);
	}
	
	public Page<User> userPage(PageInfo pi){
		Pageable pageable = PageRequest.of(pi.getPage()-1, pi.getLimt(), Sort.Direction.ASC, pi.getSort());
		return userDao.userPage(pageable);
	}
	
	public Page<User> findBookCriteria(User user,PageInfo pi){
		Pageable pageable = PageRequest.of(pi.getPage()-1, pi.getLimt(), Sort.Direction.ASC, pi.getSort());
		return userDao.findAll(new Specification<User>() {
			
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<Predicate>();
//				Join<User, Department> join=root.join("department",JoinType.LEFT);
//				list.add(criteriaBuilder.equal(join.get("code"), "1"));
				if(null != user && !StringUtils.isEmpty(user.getId()))
					list.add(criteriaBuilder.equal(root.get("id").as(Integer.class), user.getId()));
				if(null != user && !StringUtils.isEmpty(user.getName()))
					list.add(criteriaBuilder.equal(root.get("name").as(String.class), user.getName()));
				 Predicate[] p = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(p));
			}
		},pageable);
	}
}
