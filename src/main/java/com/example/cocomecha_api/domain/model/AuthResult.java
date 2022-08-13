package com.example.cocomecha_api.domain.model;

// import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * クライアントに返却する認証結果クラス
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthResult {
	/** ユーザ*/
	private Integer userid;
}
