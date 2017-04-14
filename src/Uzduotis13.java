import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by andriusbaltrunas on 4/14/2017.
 */
//Ištrinkite student? pažymius kurie mažesni nei 5
public class Uzduotis13 {
    public static void main(String[] args) {
        Connection connection = JdbcUtils.createConnection();
        if (connection!=null){
            System.out.println("Duomenys pries pakeitima");
            JdbcUtils.printStudentsMarks(connection);
            try {
                Statement statement = connection.createStatement();
                statement.execute("DELETE FROM student_mark WHERE mark<5");
                System.out.println("Pakeisti duomenys");
                JdbcUtils.printStudentsMarks(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }
}
