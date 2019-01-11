package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.example.entity.User;

/**
 * Similar to providing an Interface. Specify the operations on which table.
 * 
 * @author CSY
 *
 */
@Mapper
public interface UserMapper {
	/**
	 * Search user by his/her ID
	 * 
	 * @param id
	 * @return User
	 */
	@Select("select * from user where id=#{id}")
	public User selectUserById(int id);

	/**
	 * Search user by his/her name
	 * 
	 * @param name
	 * @return User
	 */
	@Select("select * from user where name=#{name}")
	public List<User> selectUserByName(String name);

	/**
	 * Add a new user and set his/her ID, name and address
	 * 
	 * @param user
	 */
	@Insert("insert into user (id,name,password,address) values(#{id},#{password},#{name},#{address})")
	public void addUser(User user);

	/**
	 * Delete a user by his/her ID
	 * 
	 * @param id
	 */
	@Delete("delete from user where id=#{id}")
	public void deleteUser(int id);

	/**
	 * Update information of a user
	 * 
	 * @param user
	 */
	@Update("update user set name=#{name},address=#{address}")
	public void updateUser(User user);
}
