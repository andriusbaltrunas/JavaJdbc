import java.sql.*;

/**
 * Created by andriusbaltrunas on 4/14/2017.
 */
public class ConnectToDatabase {

    public static void main(String[] args) {
            Connection connection = JdbcUtils.createConnection();
        try {
            if (connection != null){
                System.out.println("Connected");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from students");
                //statement.executeUpdate("UPDATE students set name='Petras' where id =1") //atnaujinti irasa
                //statement.execute("DELETE from students where id =1"); // irasu istrinimui
                //statement.execute("insert into students(name, surname, phone, email) values('Andrsiu', 'Balt', ....)");// naujo iraso idejimas i students lentele
                // while reikalingas tik tada kai norime atvaizduoti visus irasus is lenteles!!!!
                while (resultSet.next()){
                    System.out.println(resultSet.getInt("id")); // id yra stulpelio vardas students lentoje
                    System.out.println(resultSet.getString(2)); // 2 yra stulpelio indeksas,
                    System.out.println(resultSet.getString("surname"));
                    System.out.println(resultSet.getString("phone"));
                    System.out.println(resultSet.getString("email"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
