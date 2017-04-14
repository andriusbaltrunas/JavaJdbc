import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.sql.*;

/**
 * Created by andriusbaltrunas on 4/14/2017.
 */
public class JdbcUtils {
    private static final String URL = "jdbc:mysql://localhost:3306/kcs";
    private static final String NAME = "root";
    private static final String PSW = "MySQL";
    @Nullable
    public static Connection createConnection (){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, NAME, PSW);
        } catch (SQLException e) {
            System.out.println("Prisijungti nipavykti :P");
        }
        return connection;
    }
    public static void printStudents (@NotNull Connection connection) { //anotacija pasako kad objektas neturi buti null'as
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString(2) + " " + resultSet.getString(3)
                        + " " + resultSet.getString(4) + " " + resultSet.getString(5));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void printStudentsMarks (@NotNull Connection connection) { //anotacija pasako kad objektas neturi buti null'as
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student_mark");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getInt(2) + " " + resultSet.getString(3)
                        + " " + resultSet.getInt(4)+" "+resultSet.getDate(5));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void printStudentsAddress (@NotNull Connection connection) { //anotacija pasako kad objektas neturi buti null'as
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students_address");
            while (resultSet.next()){
                System.out.println(resultSet.getInt("id")+ " "+resultSet.getInt(2)+ " "+resultSet.getString(3)
                        +" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
