package com.imie.gamerpg.database.contract;

public interface Contract {

	String getTable();
	String[] getFields();
	String getCreateTable();
	String getSelectFields();
	String getInsertFields();
	String getDropTable();
}
