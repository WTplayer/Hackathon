package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import DataBase.Database;
import Entites.Erreur;

public class InfosDAOImpl implements CrudDAO<Erreur> {

	Connection c;
	
	@Override
	public ArrayList<Erreur> read() throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = null;
		ResultSet rs ;
		ArrayList<Erreur> array = new ArrayList<Erreur>();
		
		try {
			c = Database.getConnection();
			String request = "Select * from infos";
			ps = c.prepareStatement(request);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Erreur erreur = new Erreur();
				erreur.mapErreur(rs);
				array.add(erreur);
			}
			
			rs.close();
			ps.close();
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return array;
	}

	@Override
	public void create(Erreur object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Erreur object) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Erreur object, int id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Erreur find(Erreur object) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs ;
		Erreur res = new Erreur();
		
		try {
			c = Database.getConnection();
			String request = "Select * from infos where id=?";
			ps = c.prepareStatement(request);
			ps.setInt(1, object.getId());
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				res.mapErreur(rs);
				
			}
			
			rs.close();
			ps.close();
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public ArrayList<Erreur> findDCI(String dci) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs ;
		ArrayList<Erreur> array = new ArrayList<Erreur>();
		
		try {
			c = Database.getConnection();
			String request = "Select * from infos where DCI = ?";
			ps = c.prepareStatement(request);
			ps.setString(1, dci);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Erreur res = new Erreur();
				res.mapErreur(rs);
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
	
	public ArrayList<Erreur> findATC(String atc) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs ;
		ArrayList<Erreur> array = new ArrayList<Erreur>();
		
		try {
			c = Database.getConnection();
			String request = "Select * from infos where codeATC=?";
			ps = c.prepareStatement(request);
			ps.setString(1, atc);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Erreur res = new Erreur();
				res.mapErreur(rs);
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

	public LinkedHashMap<Integer,Erreur> findNamePro(String name) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs ;
		LinkedHashMap<Integer,Erreur> array = new LinkedHashMap<Integer,Erreur>();
		
		
		try {
			c = Database.getConnection();
			String request = "Select distinct denomination,count(*) as nb,initialErreur,natureErreur,causeErreur"
					+ " from infos where denomination like ? "
					+ "and professionTransmissionSource <> 'Autre' "
					+ "and professionTransmissionSource <> 'NR' "
					+ "group by denomination,initialErreur,natureErreur,causeErreur "
					+ "order by nb";
			System.out.println(request);
			ps = c.prepareStatement(request);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Erreur res = new Erreur();
				res.setDenomination( rs.getString("denomination") );
				res.setInitialErreur(rs.getString("initialErreur"));
				res.setNatureErreur(rs.getString("natureErreur"));
				res.setCauseErreur(rs.getString("causeErreur"));
				
				//res.mapErreur(rs);
				
				array.put(rs.getInt("nb"),res);	
			}
			
			rs.close();
			ps.close();
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return array;
	}
	
	public LinkedHashMap<Integer,Erreur> findNameAutre(String name) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs ;
		LinkedHashMap<Integer,Erreur> array = new LinkedHashMap<Integer,Erreur>();
		
		
		try {
			c = Database.getConnection();
			String request = "Select distinct denomination,count(*) as nb,initialErreur,natureErreur,causeErreur"
					+ " from infos where denomination like ? "
					+ "and ( professionTransmissionSource = 'Autre' "
					+ "or professionTransmissionSource = 'NR' ) "
					+ "group by denomination,initialErreur,natureErreur,causeErreur "
					+ "order by nb";
			System.out.println(request);
			ps = c.prepareStatement(request);
			ps.setString(1, name);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Erreur res = new Erreur();
				res.setDenomination( rs.getString("denomination") );
				res.setInitialErreur(rs.getString("initialErreur"));
				res.setNatureErreur(rs.getString("natureErreur"));
				res.setCauseErreur(rs.getString("causeErreur"));
				
				//res.mapErreur(rs);
				
				array.put(rs.getInt("nb"),res);	
			}
			
			rs.close();
			ps.close();
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return array;
	}

	public String getNameCip(String cip) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs ;
		String res = new String();
		
		try {
			c = Database.getConnection();
			String request = "Select NOM from CIS_CIP CC left join CIS_NOM CN on CC.id = CN.CIS where CC.CIP=?";
			ps = c.prepareStatement(request);
			ps.setString(1, cip);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				res = rs.getString("NOM");
				
			}
			
			rs.close();
			ps.close();
			c.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
