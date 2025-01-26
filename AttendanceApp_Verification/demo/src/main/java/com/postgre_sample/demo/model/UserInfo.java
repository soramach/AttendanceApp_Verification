package com.postgre_sample.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

// setter, getter, toString, equals, hashcodeを自動生成してくれる
@Data

// JPAのエンティティであることを示す
@Entity

// エンティティに対応するテーブル名を指名
@Table(name = "userinfo")

public class UserInfo {

	// エンティティの主キーを指定するアノテーション
	@Id
	// オートインクリメント＋自動採番
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// カラム名 ＝ userId
	@Column(name = "userid")
	private Integer userId;

	// カラム名 = userName
	@Column(name = "username")
	private String userName;

	// カラム名 = userBody
	@Column(name = "userbody")
	private String userBody;
}
