package com.postgre_sample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgre_sample.demo.model.UserInfo;

// JpaRepositoryを継承したインタフェースを作成し、DBを操作する
@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer> {
    
}
