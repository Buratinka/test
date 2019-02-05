package app.connectionPool;

import app.exception.DataBaseException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool
{
    private static ConnectionPool connectionPool;
    private final DataSource dataSource;


    private ConnectionPool()throws NamingException
    {
        Context initialContext = new InitialContext();
        dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/Cinema");

    }

    public static synchronized ConnectionPool getInstance()
    {
        try
        {
//            if(connectionPool == null)
//            {
                connectionPool = new ConnectionPool();
           // }
        }
        catch(NamingException ex)
        {
            throw new DataBaseException();
        }

        return connectionPool;
    }


    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
