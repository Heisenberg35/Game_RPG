/**
 * 
 */
package com.imie.gamerpg.database.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.imie.gamerpg.database.DBItem;
import com.imie.gamerpg.database.DBOpenHelper;
import com.imie.gamerpg.database.contract.ArmeContract;
import com.imie.gamerpg.database.contract.ArmureContract;
import com.imie.gamerpg.database.contract.Contract;
import com.imie.gamerpg.database.dto.DTO;
import com.imie.gamerpg.entity.arme.Arme;
import com.imie.gamerpg.entity.arme.ArmeMagique;
import com.imie.gamerpg.entity.arme.ArmeMixte;
import com.imie.gamerpg.entity.arme.ArmePhysique;
import com.imie.gamerpg.entity.armure.ArmureMagique;
import com.imie.gamerpg.entity.armure.ArmureMixte;
import com.imie.gamerpg.entity.armure.ArmurePhysique;

/**
 * @author Fabrice
 *
 */
public class DAOManager<T extends DBItem> {

	public DAOManager() {

		ArrayList<String> tablesNames = new ArrayList<String>();
		tablesNames.add(ArmeContract.TABLE);
		tablesNames.add(ArmureContract.TABLE);

		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<String> realTablesNames = new ArrayList<String>();

		try {
			stmt = DBOpenHelper.getInstance().getConnection().createStatement();
			rs = stmt.executeQuery("SHOW TABLES");
			while (rs.next()) {
				realTablesNames.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (!realTablesNames.containsAll(tablesNames)) {
			ArmeContract arme = new ArmeContract();
			ArmureContract armure = new ArmureContract();

			String sql = new ArmeContract().getCreateTable();
			try {
				stmt = DBOpenHelper.getInstance().getConnection().createStatement();
				stmt.executeUpdate(sql);
				insertArmes(arme);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			String sql2 = new ArmureContract().getCreateTable();
			try {
				stmt = DBOpenHelper.getInstance().getConnection().createStatement();
				stmt.executeUpdate(sql2);
				insertArmures(armure);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * 
	 * @param contract
	 * @param dto
	 * @return
	 */
	public ArrayList<T> selectAll(Contract contract, DTO<T> dto) {
		ArrayList<T> result = new ArrayList<T>();

		StringBuilder request = new StringBuilder();
		request.append("SELECT ");
		request.append(contract.getSelectFields());
		request.append(" FROM ");
		request.append(contract.getTable());

		Statement stmt = null;

		ResultSet rs;
		try {
			stmt = DBOpenHelper.getInstance().getConnection().createStatement();
			rs = stmt.executeQuery(request.toString());
			while (rs.next()) {
				result.add(dto.mySQLToJava(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	/**
	 * 
	 * @param contract
	 */
	public void insertArmes(Contract contract) {
		Arme armePhysique = new ArmePhysique("Cuillère", 1, 0, 3);
		Arme armePhysique2 = new ArmePhysique("Katana", 3, 0, 2);
		Arme armePhysique3 = new ArmePhysique("Pistolet", 5, 0, 3);
		Arme armePhysique4 = new ArmePhysique("Lance roquette", 10, 0, 6);

		Arme armeMagique = new ArmeMagique("Baguette", 0, 1, 3);
		Arme armeMagique2 = new ArmeMagique("Bâton de feu", 0, 3, 2);
		Arme armeMagique3 = new ArmeMagique("Livre de magie noire", 0, 5, 3);
		Arme armeMagique4 = new ArmeMagique("Regard pétrifiant", 0, 10, 6);

		Arme armeMixte = new ArmeMixte("Fenêtre", 1, 1, 3);
		Arme armeMixte2 = new ArmeMixte("Hamburger BK", 2, 1, 2);
		Arme armeMixte3 = new ArmeMixte("Café", 1, 4, 3);
		Arme armeMixte4 = new ArmeMixte("Flamberge", 5, 5, 6);
		Arme armeMixte5 = new ArmeMixte("Loli", 9999, 9999, 1);

		String sql = "INSERT INTO " + contract.getTable() + " (" + contract.getInsertFields() + ") " + " VALUES "
				+ "(?,?,?,?),(?,?,?,?),(?,?,?,?),(?,?,?,?),(?,?,?,?),(?,?,?,?),(?,?,?,?),(?,?,?,?),(?,?,?,?),(?,?,?,?),(?,?,?,?),(?,?,?,?),(?,?,?,?)";
		PreparedStatement statement = null;

		try {
			statement = DBOpenHelper.getInstance().getConnection().prepareStatement(sql);

			statement.setString(1, armePhysique.getNom());
			statement.setInt(2, armePhysique.getPtsAttaquePhysique());
			statement.setInt(3, armePhysique.getPtsAttaqueMagique());
			statement.setInt(4, armePhysique.getPtsAction());
			statement.setString(5, armePhysique2.getNom());
			statement.setInt(6, armePhysique2.getPtsAttaquePhysique());
			statement.setInt(7, armePhysique2.getPtsAttaqueMagique());
			statement.setInt(8, armePhysique2.getPtsAction());
			statement.setString(9, armePhysique3.getNom());
			statement.setInt(10, armePhysique3.getPtsAttaquePhysique());
			statement.setInt(11, armePhysique3.getPtsAttaqueMagique());
			statement.setInt(12, armePhysique3.getPtsAction());
			statement.setString(13, armePhysique4.getNom());
			statement.setInt(14, armePhysique4.getPtsAttaquePhysique());
			statement.setInt(15, armePhysique4.getPtsAttaqueMagique());
			statement.setInt(16, armePhysique4.getPtsAction());
			statement.setString(17, armeMagique.getNom());
			statement.setInt(18, armeMagique.getPtsAttaquePhysique());
			statement.setInt(19, armeMagique.getPtsAttaqueMagique());
			statement.setInt(20, armeMagique.getPtsAction());
			statement.setString(21, armeMagique2.getNom());
			statement.setInt(22, armeMagique2.getPtsAttaquePhysique());
			statement.setInt(23, armeMagique2.getPtsAttaqueMagique());
			statement.setInt(24, armeMagique2.getPtsAction());
			statement.setString(25, armeMagique3.getNom());
			statement.setInt(26, armeMagique3.getPtsAttaquePhysique());
			statement.setInt(27, armeMagique3.getPtsAttaqueMagique());
			statement.setInt(28, armeMagique3.getPtsAction());
			statement.setString(29, armeMagique4.getNom());
			statement.setInt(30, armeMagique4.getPtsAttaquePhysique());
			statement.setInt(31, armeMagique4.getPtsAttaqueMagique());
			statement.setInt(32, armeMagique4.getPtsAction());
			statement.setString(33, armeMixte.getNom());
			statement.setInt(34, armeMixte.getPtsAttaquePhysique());
			statement.setInt(35, armeMixte.getPtsAttaqueMagique());
			statement.setInt(36, armeMixte.getPtsAction());
			statement.setString(37, armeMixte2.getNom());
			statement.setInt(38, armeMixte2.getPtsAttaquePhysique());
			statement.setInt(39, armeMixte2.getPtsAttaqueMagique());
			statement.setInt(40, armeMixte2.getPtsAction());
			statement.setString(41, armeMixte3.getNom());
			statement.setInt(42, armeMixte3.getPtsAttaquePhysique());
			statement.setInt(43, armeMixte3.getPtsAttaqueMagique());
			statement.setInt(44, armeMixte3.getPtsAction());
			statement.setString(45, armeMixte4.getNom());
			statement.setInt(46, armeMixte4.getPtsAttaquePhysique());
			statement.setInt(47, armeMixte4.getPtsAttaqueMagique());
			statement.setInt(48, armeMixte4.getPtsAction());
			statement.setString(49, armeMixte5.getNom());
			statement.setInt(50, armeMixte5.getPtsAttaquePhysique());
			statement.setInt(51, armeMixte5.getPtsAttaqueMagique());
			statement.setInt(52, armeMixte5.getPtsAction());

			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public void insertArmures(Contract contract) {
		ArmurePhysique armurePhysique = new ArmurePhysique("Slip", 1, 0);
		ArmurePhysique armurePhysique2 = new ArmurePhysique("Armure en cuir", 3, 0);
		ArmurePhysique armurePhysique3 = new ArmurePhysique("Armure en plaque", 5, 0);
		ArmurePhysique armurePhysique4 = new ArmurePhysique("Armure en mithril", 7, 0);
		
		ArmureMagique armureMagique = new ArmureMagique("Lunettes", 0, 1);
		ArmureMagique armureMagique2 = new ArmureMagique("Toge magique", 0, 3);
		ArmureMagique armureMagique3 = new ArmureMagique("Veste de bonne qualité", 0, 5);
		ArmureMagique armureMagique4 = new ArmureMagique("Robe enchantée", 0, 7);
		
		ArmureMixte armureMixte = new ArmureMixte("Choixpeau", 1, 1);
		ArmureMixte armureMixte2 = new ArmureMixte("Cotte de maille enchantée", 1, 2);
		ArmureMixte armureMixte3 = new ArmureMixte("Armure de flamme", 3, 2);
		ArmureMixte armureMixte4 = new ArmureMixte("Barbe magique", 4, 3);
		
		String sql = "INSERT INTO " + contract.getTable() + " (" + contract.getInsertFields() + ") " + " VALUES "
				+ "(?,?,?),(?,?,?),(?,?,?),(?,?,?),(?,?,?),(?,?,?),(?,?,?),(?,?,?),(?,?,?),(?,?,?),(?,?,?),(?,?,?)";
		PreparedStatement statement = null;
		
		try {
			statement = DBOpenHelper.getInstance().getConnection().prepareStatement(sql);
			
			statement.setString(1, armurePhysique.getNom());
			statement.setInt(2, armurePhysique.getPtsArmurePhysique());
			statement.setInt(3, armurePhysique.getPtsArmureMagique());
			statement.setString(4, armurePhysique2.getNom());
			statement.setInt(5, armurePhysique2.getPtsArmurePhysique());
			statement.setInt(6, armurePhysique2.getPtsArmureMagique());
			statement.setString(7, armurePhysique3.getNom());
			statement.setInt(8, armurePhysique3.getPtsArmurePhysique());
			statement.setInt(9, armurePhysique3.getPtsArmureMagique());
			statement.setString(10, armurePhysique4.getNom());
			statement.setInt(11, armurePhysique4.getPtsArmurePhysique());
			statement.setInt(12, armurePhysique4.getPtsArmureMagique());
			statement.setString(13, armureMagique.getNom());
			statement.setInt(14, armureMagique.getPtsArmurePhysique());
			statement.setInt(15, armureMagique.getPtsArmureMagique());
			statement.setString(16, armureMagique2.getNom());
			statement.setInt(17, armureMagique2.getPtsArmurePhysique());
			statement.setInt(18, armureMagique2.getPtsArmureMagique());
			statement.setString(19, armureMagique3.getNom());
			statement.setInt(20, armureMagique3.getPtsArmurePhysique());
			statement.setInt(21, armureMagique3.getPtsArmureMagique());
			statement.setString(22, armureMagique4.getNom());
			statement.setInt(23, armureMagique4.getPtsArmurePhysique());
			statement.setInt(24, armureMagique4.getPtsArmureMagique());
			statement.setString(25, armureMixte.getNom());
			statement.setInt(26, armureMixte.getPtsArmurePhysique());
			statement.setInt(27, armureMixte.getPtsArmureMagique());
			statement.setString(28, armureMixte2.getNom());
			statement.setInt(29, armureMixte2.getPtsArmurePhysique());
			statement.setInt(30, armureMixte2.getPtsArmureMagique());
			statement.setString(31, armureMixte3.getNom());
			statement.setInt(32, armureMixte3.getPtsArmurePhysique());
			statement.setInt(33, armureMixte3.getPtsArmureMagique());
			statement.setString(34, armureMixte4.getNom());
			statement.setInt(35, armureMixte4.getPtsArmurePhysique());
			statement.setInt(36, armureMixte4.getPtsArmureMagique());
			
			statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	}
}