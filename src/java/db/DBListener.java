package db;

import avaliacao.Disciplina;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DBListener implements ServletContextListener{
    private static final String CLASS_NAME = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:\\Users\\Victo\\Downloads\\poo.db"; 
    
    public static String exceptionMessage = null;
    
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(DB_URL);
    }
    
    @Override
    public void contextInitialized(ServletContextEvent sce){
        Connection conn = null;
        Statement stmt = null;
        
        try{
            Class.forName(CLASS_NAME);
            conn = getConnection();
            
            stmt = conn.createStatement();
            stmt.execute(Disciplina.getCreateStatement());
            
        } catch(Exception ex){
            exceptionMessage = ex.getLocalizedMessage();
        } finally {
            try{stmt.close();}catch(Exception ex1){}
            try{conn.close();}catch(Exception ex1){}
        }
    }
    
    
    @Override
    public void contextDestroyed(ServletContextEvent sce){
        
    }

}
