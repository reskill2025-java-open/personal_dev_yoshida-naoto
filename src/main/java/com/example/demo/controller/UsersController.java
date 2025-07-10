package com.example.demo.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;

@Controller
public class UsersController {

	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	// ログイン画面を表示
	@GetMapping({ "/", "/login", "/logout" })
	public String index(
			@RequestParam(name = "error", defaultValue = "") String error,
			Model model) {
		// セッション情報を全てクリアする
		session.invalidate();
		// エラーパラメータのチェック
		if (error.equals("notLoggedIn")) {
			model.addAttribute("message", "ログイン情報を入力してください");
		}

		return "login";
	}

	@PostMapping("/login")
	public String login(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "password", defaultValue = "") String password,
			Model model) {
		// 名前とパスワードが空の場合にエラーとする
		if (password.equals("") && name.equals("")) {
			model.addAttribute("message", "名前を入力してください");
			model.addAttribute("passmessage", "パスワードを入力してください");
			return "login";
		}

		// 名前が空の場合にエラーとする
		if (name.equals("")) {
			model.addAttribute("message", "名前を入力してください");
			return "login";
		}

		//名前とパスワードがデータベースと一致しなかった場合エラーとする

		// パスワードが空の場合にエラーとする
		if (password.equals("")) {
			model.addAttribute("passmessage", "パスワードを入力してください");
			//名前とパスワードがデータベースと一致しなかった場合エラーとするS

			return "login";
		}
		// セッション管理されたアカウント情報に名前をセット
		account.setName(name);
		account.setName(password);

		// 「/drink」へのリダイレクト
		return "redirect:/drinkpremiere";
	}

	@GetMapping("/account")
	public String account() {
		return "account";
	}

	@PostMapping("/account")
	public String newAccount(
			@RequestParam(name = "name", defaultValue = "") String name,
			@RequestParam(name = "password", defaultValue = "") String password,
			@RequestParam(name = "rank", defaultValue = "false") Boolean rank,
			Model model) {
		// 名前とパスワードが空の場合にエラーとする
		//		if (password.equals("") && name.equals("")) {
		//			model.addAttribute("message", "名前を入力してください");
		//			model.addAttribute("passmessage", "パスワードを入力してください");
		//			return "account";
		//		}
		boolean error = false;
		// 名前が空の場合にエラーとする
		if (name.equals("")) {
			model.addAttribute("message", "名前を入力してください");
			error = true;
		}

		//名前とパスワードがデータベースと一致しなかった場合エラーとする

		// パスワードが空の場合にエラーとする
		if (password.equals("")) {
			model.addAttribute("passmessage", "パスワードを入力してください");
			//名前とパスワードがデータベースと一致しなかった場合エラーとするS

			error = true;
		}

		if (rank == false) {
			model.addAttribute("rankmessage", "チェックを入れて下さい");
			error = true;
		}
		if (error == true) {
			return "account";
		} else {

			// セッション管理されたアカウント情報に名前をセット
			account.setName(name);
			account.setName(password);

			// 「/drink」へのリダイレクト
			return "redirect:/drinkpremiere";
		}
	}
}
