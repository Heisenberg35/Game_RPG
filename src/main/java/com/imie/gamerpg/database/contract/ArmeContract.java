/**
 * 
 */
package com.imie.gamerpg.database.contract;

/**
 * @author Fabrice
 *
 */
public class ArmeContract implements Contract{
	
	public static final String TABLE = "arme";
	public static final String[] FIELDS = {"id","nom","ptsAttaquePhysique","ptsAttaqueMagique","ptsAction"};
	public static final String CREATE_TABLE =
			"CREATE TABLE " + TABLE + "(" +
					FIELDS[0] + " INT " + " NOT NULL " + " PRIMARY KEY AUTO_INCREMENT " + ","+
					FIELDS[1] + " VARCHAR(255) " + " NOT NULL " + "," +
					FIELDS[2] + " INT " + " NOT NULL " + "," +
					FIELDS[3] + " INT " + " NOT NULL " + "," +
					FIELDS[4] + " INT " + " NOT NULL " +
			")";
	public static final String SELECT_FIELDS = 
			FIELDS[0] + "," + FIELDS[1] + "," + FIELDS[2] + "," + FIELDS[3] + "," + FIELDS[4];
	public static final String INSERT_FIELDS = FIELDS[1] + "," + FIELDS[2] + "," + FIELDS[3] + "," + FIELDS[4];

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
		return INSERT_FIELDS;
	}

}
