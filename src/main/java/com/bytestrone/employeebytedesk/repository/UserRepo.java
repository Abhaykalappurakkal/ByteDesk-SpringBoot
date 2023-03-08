package com.bytestrone.employeebytedesk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bytestrone.employeebytedesk.model.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, String> {
	UserModel findByUserId(String userId);

	Optional<UserModel> findByUserName(String username);
}
