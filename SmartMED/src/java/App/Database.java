package App;

import java.sql.*;

public final class Database
{
    private Connection Connect = null;

    public Database()
    {
    }

    public Database(String url, String user, String pass)
    {
        Connect(url, user, pass);
    }

    public void Connect(String url, String user, String pass)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://" + url, user, pass);
            System.out.println("Connected to the database.");
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            System.err.println("Unable to connect to the database: " + ex);
        }
    }

    public void SetAutoCommit(boolean autoCommit)
    {
        try
        {
            Connect.setAutoCommit(autoCommit);
        }
        catch (SQLException ex)
        {
            System.err.println("Cannot set AutoCommit = " + autoCommit + " :" + ex.getMessage());
        }
    }

    public void Rollback()
    {
        try
        {
            Connect.rollback();
        }
        catch (SQLException ex)
        {
            System.err.println("Cannot rollback: " + ex.getMessage());
        }
    }

    public void Commit()
    {
        try
        {
            Connect.commit();
        }
        catch (SQLException ex)
        {
            System.err.println("Cannot commit: " + ex.getMessage());
        }
    }

    public void Execute(PreparedStatement stmt) throws SQLException
    {
        stmt.executeUpdate();
    }

    public void ExecuteQuery(String query) throws SQLException
    {
        Statement stmt = Connect.createStatement();
        stmt.execute(query);
        //System.out.println("Query was executed.");
    }

    public ResultSet Select(String query) throws SQLException
    {
        Statement stmt = Connect.createStatement();
        return stmt.executeQuery(query);
    }

    public PreparedStatement PrepareStatement(String query) throws SQLException
    {
        return Connect.prepareStatement(query);
    }

    public void Close()
    {
        try
        {
            if (Connect != null)
            {
                System.out.println("The database has been closed.");
                Connect.close();
            }
        }
        catch (Exception ex)
        {
            System.err.println(ex);
        }
    }
}
