package laljipackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class student {
    
public void createdatabase(){

 // 1. Driver Load ---> Automatically in new
        // version------------------------------------------------------------

        // 2. Connection
        // establish---------------------------------------------------------------------------------------

        try {

            String url = "jdbc:mysql://localhost:3306/";
            String username = "root";
            String password = "Ritikesh.java";

            Connection conn = DriverManager.getConnection(url, username, password);

            // 3. Create
            // Statement----------------------------------------------------------------------------------------------

            Statement stm = conn.createStatement();

            // 4. Execute
            // query-------------------------------------------------------------------------------------------------

            String query = "create database laljicoded";

            stm.execute(query);

            System.out.println("connected successfully");

            // 5. Onnection close
            // ---------------------------------------------------------------------------------------------

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

public void createtable() {

     try {

            String url = "jdbc:mysql://localhost:3306/laljicoded";
            String username = "root";
            String password = "Ritikesh.java";

            Connection conn = DriverManager.getConnection(url, username, password);

            // 3. Create
            // Statement----------------------------------------------------------------------------------------------

            Statement stm = conn.createStatement();

            // 4. Execute
            // query-------------------------------------------------------------------------------------------------

            String query = "create table students (sid int(3), name varchar(40), email varchar(40))";

            stm.execute(query);

            System.out.println("create table successfully");

            // 5. Onnection close
            // ---------------------------------------------------------------------------------------------

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }




}

public void createdata() {

 try {

            String url = "jdbc:mysql://localhost:3306/";
            String db="laljicoded";
            String username = "root";
            String password = "Ritikesh.java";

            Connection conn = DriverManager.getConnection(url+db, username, password);

            // 3. Create
            // Statement----------------------------------------------------------------------------------------------

            /*
                Statement stm = conn.createStatement();
             String query = "INSERT into students values(100,'Lalji','lalji5029@gmail.com')";
            stm.execute(query);

            */ 


            String query = "INSERT into students values(?,?,?)";
            PreparedStatement pstm=conn.prepareStatement(query);
            pstm.setInt(1, 102);
            pstm.setString(2, "Gulshan");
            pstm.setString(3, "gk62265@gmail.com");

            pstm.execute();




            System.out.println("data inserted successfully");

            // 5. Onnection close
            // ------------------------------------------------------------------

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


}

public void readdata() {


try {

            String url = "jdbc:mysql://localhost:3306/";
            String db="laljicoded";
            String username = "root";
            String password = "Ritikesh.java";

            Connection conn = DriverManager.getConnection(url+db, username, password);

            // 3. Create
            // Statement----------------------------------------------------------------------------------------------

            
                
             String query = "SELECT * from students";
             Statement stm = conn.createStatement();
            ResultSet rs= stm.executeQuery(query);

            while (rs.next()) 
            {

                System.out.println("Id = "+rs.getInt(1));
                System.out.println("Name = "+rs.getString(2));
                System.out.println("E-mail = "+rs.getString(3));
                
            }

            


           



            System.out.println("data read successfully "+ rs);

            // 5. Onnection close
            // ------------------------------------------------------------------

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }




}

public void updatedata() {

    try {

            String url = "jdbc:mysql://localhost:3306/";
            String db="laljicoded";
            String username = "root";
            String password = "Ritikesh.java";

            Connection conn = DriverManager.getConnection(url+db, username, password);

            // 3. Create
            // Statement----------------------------------------------------------------------------------------------

            /*
                Statement stm = conn.createStatement();
             String query = "INSERT into students values(100,'Lalji','lalji5029@gmail.com')";
            stm.execute(query);

            */ 


            String query = "UPDATE students set sid=? where name=? ";
            PreparedStatement pstm=conn.prepareStatement(query);
            pstm.setInt(1, 105);
            pstm.setString(2, "LalJi");
            

            pstm.execute();




            System.out.println("data updated successfully");

            // 5. Onnection close
            // ------------------------------------------------------------------

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }





}

public void deletedata() {



    try {

            String url = "jdbc:mysql://localhost:3306/";
            String db="laljicoded";
            String username = "root";
            String password = "Ritikesh.java";

            Connection conn = DriverManager.getConnection(url+db, username, password);

            // 3. Create
            // Statement----------------------------------------------------------------------------------------------

            /*
                Statement stm = conn.createStatement();
             String query = "INSERT into students values(100,'Lalji','lalji5029@gmail.com')";
            stm.execute(query);

            */ 


            String query = "DELETE FROM students where sid=?  ";
            PreparedStatement pstm=conn.prepareStatement(query);
            pstm.setInt(1, 102);
            
            

            pstm.execute();




            System.out.println("data deleted successfully");

            // 5. Onnection close
            // ------------------------------------------------------------------

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }







}

}
