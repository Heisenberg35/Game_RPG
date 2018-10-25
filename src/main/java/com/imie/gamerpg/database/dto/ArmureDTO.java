/**
 * 
 */
package com.imie.gamerpg.database.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.imie.gamerpg.entity.armure.Armure;

/**
 * @author Fabrice
 *
 */
public class ArmureDTO implements DTO<Armure> {

	@Override
	public String javaToMySQL(Armure item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Armure mySQLToJava(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
