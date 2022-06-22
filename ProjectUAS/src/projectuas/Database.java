/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectuas;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Khairiyah N Y M (222011626)
 */
public class Database implements Serializable{
    public static Database instance;
    public static boolean admin = false;
    private final String DB_TYPE = "mysql";
    private String DB_HOST;
    private final String DB_PORT = "3306";
    private String DB_NAME;
    private String DB_USER;
    private String DB_PASS;
    
    private Database(){
    }
    
    public static synchronized Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }
    
    public Connection getConnection(String dbHost, String dbName, String dbUsername, String dbPassword) throws SQLException {
        this.DB_HOST = dbHost;
        this.DB_NAME = dbName;
        this.DB_USER = dbUsername;
        this.DB_PASS = dbPassword;
        return
            DriverManager.getConnection("jdbc:"+DB_TYPE+"://"+DB_HOST+":"+
                                        DB_PORT+"/"+DB_NAME,DB_USER,DB_PASS);
    }
    
    public boolean login(String user, String pass) throws SQLException{
        Connection conn = getConnection(DB_HOST,DB_NAME,DB_USER,DB_PASS);
        try{
            String sql="SELECT * FROM login WHERE username=? AND password=md5(?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                JOptionPane.showMessageDialog(null, "Login berhasil!");
                return true;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Username/password salah!");
                return false;
            }
        } catch(SQLException ex){
            throw ex;
        } finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public void buatAkun(User user) throws SQLException{
        Connection conn = getConnection(DB_HOST,DB_NAME,DB_USER,DB_PASS);
        try{
            String sql="INSERT INTO login VALUES(?,md5(?))";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.executeUpdate();
        } catch(SQLException ex){
            throw ex;
        } finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public List<String> getListUser() throws SQLException{
        List<String> user = new ArrayList<>();
        Connection conn = getConnection(DB_HOST,DB_NAME,DB_USER,DB_PASS);
        try{
            String sql = "SELECT username FROM login";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                user.add(rs.getString("username"));
            }
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return user;
    }
    
    public void insertTaskPomodoro(PomodoroClass list) throws SQLException{
        Connection conn = getConnection(DB_HOST,DB_NAME,DB_USER,DB_PASS);
        try{
            String sql="INSERT INTO pomodoro VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, list.getTask().toString());
            pstmt.setString(2, list.getUser().toString());
            pstmt.executeUpdate();
        } catch(SQLException ex){
            throw ex;
        } finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public List<String> getListTaskPomodoro(String user) throws SQLException {
        List<String> task = new ArrayList<>();
        Connection conn = getConnection(DB_HOST,DB_NAME,DB_USER,DB_PASS);
        try{
            String sql = "SELECT * FROM pomodoro WHERE user=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                task.add(rs.getString("tugas"));
            }
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return task;
    }
    
    public void hapusTaskPomodoro(String tugas, String user) throws SQLException{
        Connection conn = getConnection(DB_HOST,DB_NAME,DB_USER,DB_PASS);
        try{
            String sql="DELETE FROM pomodoro WHERE tugas=? AND user=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tugas);
            pstmt.setString(2, user);
            pstmt.executeUpdate();
        } catch(SQLException ex){
            throw ex;
        } finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public void insertToDoList(ToDoListClass list) throws SQLException{
        Connection conn = getConnection(DB_HOST,DB_NAME,DB_USER,DB_PASS);
        try{
            String sql="INSERT INTO todolist VALUES(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, list.getTask().toString());
            pstmt.setString(2, list.getDeadline().toString());
            pstmt.setString(3, list.getNotes().toString());
            pstmt.setString(4, list.getUser().toString());
            pstmt.executeUpdate();
        } catch(SQLException ex){
            throw ex;
        } finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public void hapusToDoList(String Task, String user) throws SQLException{
        Connection conn = getConnection(DB_HOST,DB_NAME,DB_USER,DB_PASS);
        try{
            String sql="DELETE FROM todolist WHERE Task=? AND user=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Task);
            pstmt.setString(2, user);
            pstmt.executeUpdate();
        } catch(SQLException ex){
            throw ex;
        } finally{
            if(conn!=null){
                conn.close();
            }
        }
    }
    
    public List<ToDoListClass> getListTugas(String user) throws SQLException {
        List<ToDoListClass> tugas = new ArrayList<>();
        Connection conn = getConnection(DB_HOST,DB_NAME,DB_USER,DB_PASS);
        try{
            String sql = "SELECT * FROM todolist WHERE user=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                ToDoListClass t = new ToDoListClass();
                t.setTask(rs.getString("Task"));
                t.setDeadline(rs.getString("Deadline"));
                t.setNotes(rs.getString("Notes"));
                tugas.add(t);
            }
        }catch(SQLException ex){
            throw ex;
        } finally{
            if (conn!=null){
                conn.close();
            }
        }
        return tugas;
    }

}
