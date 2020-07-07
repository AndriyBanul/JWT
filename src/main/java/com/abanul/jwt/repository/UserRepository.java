package com.abanul.jwt.repository;

import com.abanul.jwt.domain.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserTable, Long>{
    UserTable findByUsername(String username);
}