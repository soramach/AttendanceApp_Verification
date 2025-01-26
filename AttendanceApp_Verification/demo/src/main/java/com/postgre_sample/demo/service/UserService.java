package com.postgre_sample.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgre_sample.demo.model.UserInfo;
import com.postgre_sample.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
    
    // 特定のアノテーションを付与したクラスのインスタンスを使用可能にする(依存性注入・DI) 
    @Autowired
    UserRepository repository;

	// データベースよりフォーラム(掲示板)の一覧を取得
	public List<UserInfo> findAll() {
		System.out.println("find All");
		return repository.findAll();
	}

	// データベースに値を登録
	public void insert(UserInfo userInfo) {
		repository.save(userInfo);
	}
}
