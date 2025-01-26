package com.postgre_sample.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.postgre_sample.demo.model.UserInfo;
import com.postgre_sample.demo.service.UserService;


@Controller
public class UserController {

    // 特定のアノテーションを付与したクラスのインスタンスを使用可能にする(依存性注入・DI) 
    @Autowired
    UserService service;

	// トップページを表示する
	// HTTPリクエストのGETメソッドのためのアノテーション
    @GetMapping("/")
    public String top(Model model) {
		// Viewに値を渡すために使用
		// 第１引数：Viewで使用する変数、第２引数：Viewに渡したい値
		model.addAttribute("userInfo", new UserInfo());
		
        List<UserInfo> userList = service.findAll();
		model.addAttribute("userList", userList);
		
		// Viewのファイル名（templatesフォルダ）
		return "top";
    }

	// データベースへの登録処理（API的な）
	// HTTPリクエストのPOSTメソッドのためのアノテーション
	@PostMapping("/create")

	// ModelAttributeは、Viewから値を受け取るためのアノテーション
	public String saveForum(@ModelAttribute UserInfo userInfo, Model model) {
		// serviceクラスのinsertメソッドを呼び出し、DBに値を登録
		service.insert(userInfo);
		
		// Viewのファイル名（templatesフォルダ）
		return "result";
	}
}
