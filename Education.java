package tests;
import java.sql.Connection;  
import java.sql.DriverManager; 
import java.sql.*;

public class Education {
    String user;
    String passwd;
    String myDriver = "com.mysql.cj.jdbc.Driver";

    public String createConnection(){
        String dbName = "education";
        String dbUserName = "developer";
        String dbPassword = "";
        String connectionString = "jdbc:mysql://localhost:3308/" + dbName + "?user=" + dbUserName + "&password=" + dbPassword + "&useUnicode=true&characterEncoding=UTF-8";
        return connectionString;

    }

    private void runQuery()throws Exception{
        Class.forName(myDriver);
        Connection conn = DriverManager.getConnection(createConnection());
        String query = "SELECT institution.name AS \"INSTITUTION NAME\", course.name AS \"COURSE NAME\",COUNT(*) AS \"NUMBER OF STUDENTS\""+
        " FROM student"+
        " JOIN course ON course.courseid = student.course"+
        " JOIN institution ON course.institution = institution.institutionid"+
        " GROUP BY course";
        System.out.println(query);

        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery(query);

        while(rst.next())  
          System.out.println(rst.getString(1)+"\t"+rst.getString(2)+"\t"+rst.getInt(3));  
      
        conn.close();
    }

    public static void main(String[] args) {
        Education edu = new Education();
        try {
            edu.runQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
