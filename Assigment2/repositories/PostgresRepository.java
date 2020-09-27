import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresRepository implements IDBRepository {

	@Override
	public Connection getConnection() {
		String connStr = "jdbc:postgresql://localhost:5432/myapp";
        try {
			return DriverManager.getConnection(connStr, "postgres", "almazik555");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
