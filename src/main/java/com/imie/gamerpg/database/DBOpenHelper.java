package com.imie.gamerpg.database;

import java.sql.Connection;
import java.sql.SQLException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DBOpenHelper {
	
	private Connection connection;

	/** Constructeur privé */
    private DBOpenHelper()
    {
    	MysqlDataSource dataSource = new MysqlDataSource();
    	dataSource.setUser("root");
		dataSource.setPassword("");
		dataSource.setServerName("127.0.0.1");
		dataSource.setDatabaseName("game_RPG");
		try {
			dataSource.setServerTimezone("UTC");
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
     
    /** Instance unique non préinitialisée */
    private static DBOpenHelper INSTANCE = null;
     
    /** Point d'accès pour l'instance unique du singleton */
    public static synchronized DBOpenHelper getInstance()
    {           
        if (INSTANCE == null)
        {   INSTANCE = new DBOpenHelper(); 
        }
        return INSTANCE;
    }

	/**
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}


}
