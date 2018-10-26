/**
 * 
 */
package com.imie.gamerpg.database.contract;

/**
 * @author Fabrice
 *
 */
public class ArmureContract implements Contract{

	public static final String TABLE = "armure";
	public static final String[] FIELDS = {"id","nom","ptsArmureMagique","ptsArmurePhysique"};
	public static final String CREATE_TABLE =
			"CREATE TABLE " + TABLE + "(" +
					FIELDS[0] + " INT " + " NOT NULL " + " PRIMARY KEY AUTO_INCREMENT " + ","+
					FIELDS[1] + " VARCHAR(255) " + " NOT NULL " + "," +
					FIELDS[2] + " INT " + " NOT NULL " + "," +
					FIELDS[3] + " INT " + " NOT NULL " +
			")";
	public static final String SELECT_FIELDS = 
			FIELDS[0] + "," + FIELDS[1] + "," + FIELDS[2] + "," + FIELDS[3];

	@Override
	public String getTable() {
		return TABLE;
	}

	@Override
	public String[] getFields() {
		return FIELDS;
	}

	@Override
	public String getCreateTable() {
		return CREATE_TABLE;
	}

	@Override
	public String getSelectFields() {
		return SELECT_FIELDS;
	}

	@Override
	public String getInsertFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDropTable() {
		// TODO Auto-generated method stub
		return null;
	}

}
