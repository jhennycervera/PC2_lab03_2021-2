/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.musicalstore.mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import pe.edu.pucp.musicalstore.config.DBManager;
import pe.edu.pucp.musicalstore.dao.GuitarraDAO;
import productos.Instrumento;
import productos.cuerda.Guitarra;

/**
 *
 * Autor : Jhenny Cervera Vargas 20182841
 */
public class GuitarraMySQL implements GuitarraDAO{

      
    private Connection con;
    private CallableStatement cs;
    private PreparedStatement ps;
    private ResultSet rs;
    
//    @Override
//    public int insertar(Guitarra guitarra) {
//     
//       int resultado = 0;     
//       try{
//            con = DBManager.getInstance().getConnection();
//            String sql = "INSERT INTO instrumento(fid_marca, nombre, color, tipo_madera,"
//                    + "precio) VALUES (?,?,?, ?, ?)";
//           
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, guitarra.getMarca().getIdMarca());
//            ps.setString(2, guitarra.getNombre());
//            ps.setString(3, guitarra.getColor());
//            ps.setString(4, guitarra.getTipoMadera());
//            ps.setDouble(5, guitarra.getPrecio());
//            
//            ps.executeUpdate();
//            sql = "SELECT @@last_insert_id as id";
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery();
//            rs.next();
//            guitarra.setIdInstrumento(rs.getInt("id")); //id es el seudonimo que le di en el sql anterior
//            sql = "INSERT INTO guitarra(id_guitarra,cant_pastillas,"
//                    + "tremolo,activo) "
//                    + "VALUES(?,?,?,?);";
//            ps = con.prepareStatement(sql);
//            ps.setInt(1, guitarra.getIdInstrumento()); 
//            ps.setInt(2, guitarra.getCantPastillas()); 
//            ps.setBoolean(3, guitarra.isTremolo()); 
//            ps.setBoolean(4, true); 
//            
//            
//            resultado = ps.executeUpdate();
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }finally{
//            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
//        }
//        return resultado;
//    }

    @Override
    public int insertar(Guitarra guitarra) {
        int resultado = 0; 
        try{
            con = DBManager.getInstance().getConnection();
            cs = con.prepareCall("{call INSERTAR_GUITARRA(?,?,?,?,?,?,?,?)}");
            cs.registerOutParameter("_id_instrumento", java.sql.Types.INTEGER);
            cs.setInt("_fid_marca", guitarra.getMarca().getIdMarca());
            cs.setString("_nombre",guitarra.getNombre());
            cs.setString("_color",guitarra.getColor());
            cs.setString("_tipo_madera",guitarra.getTipoMadera());
            cs.setDouble("_precio",guitarra.getPrecio()); 
            cs.setInt("_cant_pastillas",guitarra.getCantPastillas()); 
            cs.setBoolean("_tremolo",guitarra.isTremolo()); 
            cs.executeUpdate();
            guitarra.setIdInstrumento(cs.getInt("_id_instrumento"));
            resultado = 1;
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{con.close();}catch(Exception ex){System.out.println(ex.getMessage());}
        }

        return resultado;
        
    }

}

