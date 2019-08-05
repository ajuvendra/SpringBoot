package com.ajuvendra.restservices.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserBean, Integer>{
	Optional<UserBean> findByName(String name);
}
