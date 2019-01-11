package com.example.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UserMapper;
import com.example.entity.User;

/**
 * Check if user's ID matches his/her name and password.
 * 
 * @author CSY
 *
 */
@RestController
@RequestMapping("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	UserMapper userMapper;

	public LoginService() {
		super();
	}

	@RequestMapping("/get")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@RequestMapping("/post")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type", "text/html; charset=utf-8");

		PrintWriter out = response.getWriter();
		String IDStr = request.getParameter("userId");
		int id = Integer.parseInt(IDStr);
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// get the user in our database
		User userInDB = userMapper.selectUserById(id);

		// check if id matches name and password
		// TODO may need a better verification way
		if (userInDB.getName().equals(username)
				&& userInDB.getPwd().equals(password))
			out.println("Login Successfully.");
		else
			out.println("Login Failed!");
	}
}