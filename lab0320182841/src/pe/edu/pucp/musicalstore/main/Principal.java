/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.pucp.musicalstore.main;
import pe.edu.pucp.musicalstore.dao.GuitarraDAO;
import pe.edu.pucp.musicalstore.mysql.GuitarraMySQL;
import productos.cuerda.Guitarra;
import productos.importadoras.Marca;

public class Principal {

    public static void main(String[] args) {
         
//        Marca marca1 = new Marca(1,"Fender");
//        Marca marca2 = new Marca(2,"Gibson");
//        Guitarra guitarra1 = new Guitarra("Squier",marca1,"Roja","Maple",3, true,710.00);
//        Guitarra guitarra2 = new Guitarra("Less Paul",marca2,"Vintage","Caoba",4, false,234.00);
//        
//        //Creamos un dao de conexion 
//        GuitarraDAO daoGuitarra = new GuitarraMySQL();
//        int resultado =daoGuitarra.insertar(guitarra1);
//        if(resultado == 1)
//            System.out.println("Se ha insertado correctamente la Guitarra");
//        else
//            System.out.println("Ha ocurrido un error al momento de insertar  Guitarra");
//        
//        resultado =daoGuitarra.insertar(guitarra2);
//        if(resultado == 1)
//            System.out.println("Se ha insertado correctamente la Guitarra");
//        else
//            System.out.println("Ha ocurrido un error al momento de insertar  Guitarra");


        Marca marca1 = new Marca(1,"Fender");
        Marca marca2 = new Marca(2,"Gibson");
        Guitarra guitarra1 = new Guitarra("Guitarra1",marca1,"Roja","Maple",3, true,1000.00);
        Guitarra guitarra2 = new Guitarra("Guitarra2",marca2,"Vintage","Caoba",4, true,2900.00);
        
        //Creamos un dao de conexion 
        GuitarraDAO daoGuitarra = new GuitarraMySQL();
        int resultado =daoGuitarra.insertar(guitarra1);
        if(resultado == 1)
            System.out.println("Se ha insertado correctamente la Guitarra");
        else
            System.out.println("Ha ocurrido un error al momento de insertar  Guitarra");
        
        resultado =daoGuitarra.insertar(guitarra2);
        if(resultado == 1)
            System.out.println("Se ha insertado correctamente la Guitarra");
        else
            System.out.println("Ha ocurrido un error al momento de insertar  Guitarra");
        
    }
    
}
