import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by andriusbaltrunas on 4/14/2017.
 */
public class Uzduotis12 {

    //1.1.2. Atnaujinkite ?raš? student? lentel?je kurio id yra 1.

    public static void main(String[] args){
        Connection connection = JdbcUtils.createConnection();
        if (connection != null){
            try {
                Statement statement = connection.createStatement();
                statement.executeUpdate("UPDATE students SET NAME = 'Petras',surname = 'Petraitis' WHERE id = 1");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
