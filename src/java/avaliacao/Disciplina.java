/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao;

import db.DBListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class Disciplina {
    private int id;
    private String nome;
    private String ementa;
    private int ciclo;
    private int nota;

    public Disciplina(int id, String nome, String ementa, int ciclo, int nota) {
        this.id = id;
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    public static ArrayList<Disciplina> getList() throws Exception{
        ArrayList<Disciplina> minhasDisciplinas = new ArrayList<>();
        
        Connection conn = null;
        Statement stmt = null;
        ResultSet result = null;
        
        Exception methodException = null;
        
        try{
            conn = DBListener.getConnection();
            stmt = conn.createStatement();
            result = stmt.executeQuery("SELECT * FROM disciplinas");
            
            while(result.next()){
                minhasDisciplinas.add(new Disciplina(
                        result.getInt("id"),
                        result.getString("nome"),
                        result.getString("ementa"),
                        result.getInt("ciclo"),
                        result.getInt("nota"))
                );
            }
        } catch(Exception ex){
            methodException = ex;
        } finally{
            try{ result.close();}catch(Exception ex1){}
            try{ stmt.close();}catch(Exception ex1){}
            try{ conn.close();}catch(Exception ex1){}
        }
        
        if( methodException != null ) throw methodException;
         
        return minhasDisciplinas;
    }
    
    public static void insert(String nome, String ementa, int ciclo) throws Exception{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        Exception methodException = null;
        
        try{
            conn = DBListener.getConnection();
            stmt = conn.prepareStatement("INSERT INTO disciplinas(nome, ementa, ciclo) values(?,?,?)");
            
            stmt.setString(1, nome);
            stmt.setString(2, ementa);
            stmt.setInt(3, ciclo);
            
            stmt.execute();
        } catch(Exception ex){
            methodException = ex;
        } finally{
            try{ stmt.close();}catch(Exception ex1){}
            try{ conn.close();}catch(Exception ex1){}
        }
        
        if( methodException != null ) throw methodException;
        
    }
    
    public static void update(int nota, int id) throws Exception{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        Exception methodException = null;
        
        try{
            conn = DBListener.getConnection();
            stmt = conn.prepareStatement("UPDATE disciplinas SET nota=? WHERE id=?");
            
            stmt.setInt(1, nota);
            stmt.setInt(2, id);
            
            stmt.execute();
        } catch(Exception ex){
            methodException = ex;
        } finally{
            try{ stmt.close();}catch(Exception ex1){}
            try{ conn.close();}catch(Exception ex1){}
        }
        
        if( methodException != null ) throw methodException;
        
    }
    
    public static void delete(int id) throws Exception{
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        Exception methodException = null;
        
        try{
            conn = DBListener.getConnection();
            stmt = conn.prepareStatement("DELETE FROM disciplinas WHERE id=?");
            
            stmt.setInt(1, id);
            
            stmt.execute();
        } catch(Exception ex){
            methodException = ex;
        } finally{
            try{ stmt.close();}catch(Exception ex1){}
            try{ conn.close();}catch(Exception ex1){}
        }
        
        if( methodException != null ) throw methodException;
        
    }
    
    public static String getCreateStatement(){
        return "CREATE TABLE IF NOT EXISTS disciplinas("
                + "id INTEGER PRIMARY KEY,"
                + "nome VARCHAR(50) NOT NULL,"
                + "ementa VARCHAR(200) NOT NULL,"
                + "ciclo INTEGER NOT NULL,"
                + "nota INTEGER DEFAULT 0"
            + ")";
    }
}

