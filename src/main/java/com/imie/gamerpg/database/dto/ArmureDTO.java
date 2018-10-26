/**
 * 
 */
package com.imie.gamerpg.database.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.imie.gamerpg.database.contract.ArmureContract;
import com.imie.gamerpg.entity.armure.Armure;
import com.imie.gamerpg.entity.armure.ArmureMixte;

/**
 * @author Fabrice
 *
 */
public class ArmureDTO implements DTO<Armure> {

	@Override
	public String javaToMySQL(Armure armure) {
		StringBuilder result = new StringBuilder();
		result.append("'" + armure.getNom() + "'");
		result.append(",");
		result.append("'" + armure.getPtsArmurePhysique() + "'");
		result.append(",");
		result.append("'" + armure.getPtsArmureMagique() + "'");
		return result.toString();
	}

	@Override
	public Armure mySQLToJava(ResultSet rs) throws SQLException {
		Armure armure = new ArmureMixte();
		armure.setId(rs.getInt(rs.findColumn(ArmureContract.FIELDS[0])));
		armure.setNom(rs.getString(rs.findColumn(ArmureContract.FIELDS[1])));
		armure.setPtsArmurePhysique(rs.getInt(rs.findColumn(ArmureContract.FIELDS[2])));
		armure.setPtsArmureMagique(rs.getInt(rs.findColumn(ArmureContract.FIELDS[3])));
		return armure;
	}

}
