/**
 * 
 */
package com.imie.gamerpg.database.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.imie.gamerpg.database.contract.ArmeContract;
import com.imie.gamerpg.entity.arme.Arme;
import com.imie.gamerpg.entity.arme.ArmeMixte;

/**
 * @author Fabrice
 *
 */
public class ArmeDTO implements DTO<Arme> {

	@Override
	public String javaToMySQL(Arme arme) {
		StringBuilder result = new StringBuilder();
		result.append("'" + arme.getNom() + "'");
		result.append(",");
		result.append("'" + arme.getPtsAttaquePhysique() + "'");
		result.append(",");
		result.append("'" + arme.getPtsAttaqueMagique() + "'");
		result.append(",");
		result.append("'" + arme.getPtsAction() + "'");
		return result.toString();
	}

	@Override
	public Arme mySQLToJava(ResultSet rs) throws SQLException {
		Arme arme = new ArmeMixte();
		arme.setId(rs.getInt(rs.findColumn(ArmeContract.FIELDS[0])));
		arme.setNom(rs.getString(rs.findColumn(ArmeContract.FIELDS[1])));
		arme.setPtsAttaquePhysique(rs.getInt(rs.findColumn(ArmeContract.FIELDS[2])));
		arme.setPtsAttaqueMagique(rs.getInt(rs.findColumn(ArmeContract.FIELDS[3])));
		arme.setPtsAction(rs.getInt(rs.findColumn(ArmeContract.FIELDS[4])));
		return arme;
	}

}
