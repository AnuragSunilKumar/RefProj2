package com.devon.refferal.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devon.refferal.entites.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
