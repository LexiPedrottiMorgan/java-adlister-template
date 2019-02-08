import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.mysql.cj.jdbc.Driver;


public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config){
        try {
            DriverManager.registerDriver(new Driver());
//            config = new Config();
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUsername(),
                    config.getPassword()
                );
            } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> ads = new ArrayList<>();
        String query = "SELECT * FROM ads";
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                ads.add(createAdFromResults(rs));
            }
            return ads;

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public Ad createAdFromResults(ResultSet rs){
        try {
            return new Ad (
                 rs.getInt("id"),
                 rs.getString("title"),
                 rs.getString("description")
            );

        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public Long insert(Ad ads) {
        String query = "INSERT INTO ads(user_id,title, description) VALUES (1, 'sample title' , 'sample description')";
        try {
            System.out.println(connection.createStatement());
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                System.out.println("Inserted a new record! New id: " + rs.getLong(1));
            }


        } catch(SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//    closes the class:
    }
