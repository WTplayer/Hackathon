package Control;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import DAO.InfosDAOImpl;
import Entites.Erreur;

public class ControlErreur {
	private  InfosDAOImpl dao = new InfosDAOImpl();
	
	public ArrayList<Erreur> readErrors() throws Exception{
		return dao.read();
	}
	
	public ArrayList<Erreur> findDCI(String dci) throws Exception{
		//ArrayList<Erreur> test = dao.read();
		return dao.findDCI(dci);
	}
	public ArrayList<Erreur> findATC(String atc) throws Exception{
		return dao.findATC(atc);
	}

	public ArrayList<LinkedHashMap<Integer,Erreur>> findName(String name) throws Exception{
		LinkedHashMap<Integer,Erreur> erreursPro = dao.findNamePro(name);
		LinkedHashMap<Integer,Erreur> erreursAutres = dao.findNameAutre(name);
		ArrayList<LinkedHashMap<Integer,Erreur>> erreurs = new  ArrayList<LinkedHashMap<Integer,Erreur>>();
		erreurs.add(erreursPro);
		erreurs.add(erreursAutres);
		return erreurs; 
	}
	
	public String getName(String cip) throws Exception{
		return dao.getNameCip(cip);
	}
}
