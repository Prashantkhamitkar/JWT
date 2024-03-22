package com.security.app.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.app.model.Appuser;

@Repository
public interface Userdao extends JpaRepository<Appuser, Long>{
Optional<Appuser> findByEmail(String email);
//here i am using optional then it may be null also
}
