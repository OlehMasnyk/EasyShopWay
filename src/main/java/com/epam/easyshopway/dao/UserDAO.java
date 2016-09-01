package com.epam.easyshopway.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import com.epam.easyshopway.dao.transformer.Transformer;
import com.epam.easyshopway.model.User;

public class UserDAO extends AbstractDAO<User> {
	private final String INSERT = "INSERT INTO user (first_name, last_name, email, password, date_of_birth, active, role ) VALUES(?, ?, ?, ?, ?, ?, ?);";
	private final String SELECT_ALL = "SELECT * FROM user WHERE active = 1;";
	private final String SELECT_BY_ID = "SELECT * FROM user WHERE id = ?;";
	private final String SELECT_BY_EMAIL = "SELECT * FROM user WHERE email LIKE ?;";
	private final String UPDATE = "UPDATE user SET first_name = ?, last_name = ?, email = ?, password = ?, date_of_birth = ?, active = ?, role = ? WHERE id = ?;";
	private final String DELETE = "UPDATE user SET active = 0 WHERE id = ?;";

	public UserDAO() {
		super();
	}
	
	@Deprecated
	public int insert(User user) throws SQLException{
		//stub. 
		return 0;
	}

	public User insertUser(User user) throws SQLException, InstantiationException, IllegalAccessException {
		PreparedStatement statement = connection.prepareStatement(INSERT);
		statement.setString(1, user.getFirstName());
		statement.setString(2, user.getLastName());
		statement.setString(3, user.getEmail());
		statement.setString(4, user.getPassword());
		statement.setDate(5, user.getDateOfBirth());
		statement.setBoolean(6, user.isActive());
		statement.setString(7, user.getRole());
		statement.executeUpdate();
		statement.close();
		return getByEmail(user.getEmail());
	}

	@Override
	public List<User> getAll() throws SQLException, IllegalAccessException, InstantiationException {
		PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
		ResultSet resultSet = statement.executeQuery(SELECT_ALL);
		statement.close();
		return new Transformer<User>(User.class).fromRStoCollection(resultSet);

	}
	
	@Override
	public User getById (Integer id) throws SQLException, IllegalAccessException, InstantiationException {
		PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		statement.close();
		List<User> users = new Transformer<User>(User.class).fromRStoCollection(resultSet);
		if (users.size() > 0)
			return users.iterator().next();
		else
			return null;
	}
	
	
	public User getByEmail (String email) throws SQLException, IllegalAccessException, InstantiationException {
		PreparedStatement statement = connection.prepareStatement(SELECT_BY_EMAIL);
		statement.setString(1, email);
		ResultSet resultSet = statement.executeQuery();
		statement.close();
		List<User> users = new Transformer<User>(User.class).fromRStoCollection(resultSet);
		if (users.size() > 0)
			return users.iterator().next();
		else
			return null;
	}

	@Override
	public int update (Integer userId, User user) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(UPDATE);
		statement.setString(1, user.getFirstName());
		statement.setString(2, user.getLastName());
		statement.setString(3, user.getEmail());
		statement.setString(4, user.getPassword());
		statement.setDate(5, user.getDateOfBirth());
		statement.setBoolean(6, user.isActive());
		statement.setString(7, user.getRole());
		statement.setInt(8, userId);
		int result = statement.executeUpdate();
		statement.close();
		return result;
	}

	@Override
	public int delete(Integer id) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(DELETE);
		statement.setInt(1, id);
		int result = statement.executeUpdate();
		statement.close();
		return result;
	}
}