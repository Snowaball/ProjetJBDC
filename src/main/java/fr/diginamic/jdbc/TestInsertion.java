package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.Statement;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.dao.FournisseurDao;

public class TestInsertion {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FournisseurDao.Insert("La Maison de la peinture");
	}
	
	

}


