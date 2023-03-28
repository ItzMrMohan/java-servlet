
import java.io.FileWriter;
import java.util.Properties;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author johns
 */
public class PropertyFile {
    
    public static void main(String[] args)throws Exception{  

    Properties p=new Properties();  
    p.setProperty("MS_SQL_URL","jdbc:sqlserver://localhost\\MSSQLSERVER;Database=Archi;portNumber=1433");  
    p.setProperty("MS_SQL_userName","root");  
    p.setProperty("MS_SQL_passWord","root");  

    p.store(new FileWriter("portNumbers.properties"),"Saved PortNumbers for Database connectivity");  
//String s = "nileshkemse@gmail.com";
//System.out.println(s.replaceAll("(?<=.{3}).(?=[^@]+@)", "*"));
}  
}  
