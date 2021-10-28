package com.devon.refferal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devon.refferal.entites.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

	
	
}
