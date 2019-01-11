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
 * Receive data from front-end interactive page. Create an entity and store it
 * in the database.
 * 
 * @author CSY
 *
 */
@RestController
@RequestMapping("/RegisterService")
public class RegisterService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	UserMapper userMapper;

	public RegisterService() {
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

		// TODO: check if ID has been occupied
		String IDStr = request.getParameter("userId");
		int id = Integer.parseInt(IDStr);
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		PrintWriter out = response.getWriter();
		// username and password cannot be empty
		if (password != null && !password.isEmpty() && username != null
				&& !username.isEmpty()) {
			out.println("Register Successfully.");

			User u = new User();
			u.setId(id);
			u.setName(username);
			u.setPwd(password);
			userMapper.addUser(u);
		} else {
			out.println("Register Failed!");
		}
	}
}