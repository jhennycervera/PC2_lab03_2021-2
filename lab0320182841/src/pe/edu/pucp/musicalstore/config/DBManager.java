/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.musicalstore.config;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * Autor : Jhenny Cervera Vargas 20182841
 */
public class DBManager {

    private static DBManager dbManager;
    private String url = "jdbc:mysql://claselp220212.cbg6tblxdv7z.us-east-1.rds.amazonaws.com:3306/inf28220212";
    private String user = "root";
    private String password = "LP2INF20212";
    private Connection con;
    
    public Connection getConnection(){
        try{
            //Registrar el driver de conexion
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Establecer la conexion
            con = DriverManager.getConnection(url,user,password);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return con;
    }
    
    private synchronized static void createInstance(){
        if(dbManager == null){
            dbManager = new DBManager();
        }
    }
    
    public static DBManager getInstance(){
        if(dbManager == null)
            createInstance();
        return dbManager;
    }   
}
