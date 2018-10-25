/**
 * 
 */
package com.imie.gamerpg.database.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.imie.gamerpg.entity.arme.Arme;

/**
 * @author Fabrice
 *
 */
public class ArmeDTO implements DTO<Arme>{

	@Override
	public String javaToMySQL(Arme item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Arme mySQLToJava(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
