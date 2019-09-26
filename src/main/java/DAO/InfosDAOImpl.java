package DAO;

import java.sql.*;
import java.util.ArrayList;


import DataBase.Database;

public class InfosDAOImpl implements CrudDAO<String> {

	Connection c;
	@Override
	public void create(String object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(String object, int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String find(String object) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> read() throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs ;
		ArrayList<String> array = new ArrayList<String>();
		
		try {
			c = Database.getConnection();
			String request = "Select * from infos";
			ps = c.prepareStatement(request);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String res = rs.getString("id");
				array.add(res);
			}
			
			rs.close();
			ps.close();
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return array;
	}

}
