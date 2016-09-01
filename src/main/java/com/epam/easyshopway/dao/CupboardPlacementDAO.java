package com.epam.easyshopway.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.epam.easyshopway.dao.transformer.Transformer;
import com.epam.easyshopway.model.CupboardPlacement;
import com.epam.easyshopway.model.User;

public class CupboardPlacementDAO extends AbstractDAO<CupboardPlacement>{
	private final String SELECT_ALL = "SELECT * FROM cupboard_placement;";
	private final String SELECT_BY_ID = "SELCT * FROM cpboard_placement WHERE id = ?;";
	private final String INSERT = "INSERT INTO cupboard_placement (map_id, cupboard_id, x_start, y_start, x_end, y_end) VALUES (?, ?, ?, ?, ?, ?);";
	private final String UPDATE = "UPDATE cupboard_placement SET map_id = ?, cupboard_id = ?, x_start = ?, y_start = ?, x_end = ?, y_end = ?; ";	
	
	@Override
	public int insert(CupboardPlacement el) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(INSERT);
		statement.setInt(1, el.getMapId());
		statement.setInt(2, el.getCupboardId());
		statement.setInt(3, el.getxStart());
		statement.setInt(4, el.getyStart());
		statement.setInt(5, el.getxEnd());
		statement.setInt(6, el.getyEnd());
		return statement.executeUpdate();	
	}
	
	@Override
	public int update(Integer id, CupboardPlacement el) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(UPDATE);
		statement.setInt(1, el.getMapId());
		statement.setInt(2, el.getCupboardId());
		statement.setInt(3, el.getxStart());
		statement.setInt(4, el.getyStart());
		statement.setInt(5, el.getxEnd());
		statement.setInt(6, el.getyEnd());
		int result = statement.executeUpdate();
		statement.close();
		return result;
	}
	
	@Override
	public int delete(Integer id) throws SQLException {
		return 0;
	}
	
	@Override
	public List<CupboardPlacement> getAll() throws SQLException, IllegalAccessException, InstantiationException {
		PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
		ResultSet resultSet = statement.executeQuery(SELECT_ALL);
		statement.close();
		return new Transformer<CupboardPlacement>(CupboardPlacement.class).fromRStoCollection(resultSet);
	}
	
	@Override
	public CupboardPlacement getById(Integer id) throws SQLException, IllegalAccessException, InstantiationException {
		PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
		statement.setInt(1, id);
		ResultSet resultSet = statement.executeQuery();
		statement.close();
		List<CupboardPlacement> cupboardPlacements = new Transformer<CupboardPlacement>(CupboardPlacement.class).fromRStoCollection(resultSet);
		if (cupboardPlacements.size() > 0)
			return cupboardPlacements.iterator().next();
		else
			return null;
	}
}
