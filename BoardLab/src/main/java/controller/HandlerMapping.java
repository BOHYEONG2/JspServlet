package controller;

import java.util.HashMap;
import java.util.Map;

import controller.user.InsertUserController;
import controller.user.LoginController;
import controller.user.LogoutController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/insertUser.do", new InsertUserController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
	}
	public Controller getController(String path) {
		return mappings.get(path);   // hashmap 을 가지고 있어서 리턴하면 위에 로그인이나 로그아웃이 반환됨
	}
}
