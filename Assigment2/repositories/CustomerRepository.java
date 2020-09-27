import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


class CustomerRepository implements ICustomerRepository {
	 private IDBRepository dbrepo = new PostgresRepository();

	@Override
	public void add(Customer entity) {
		try {
            String sql = "INSERT INTO Customer(fname, lname, username, password) " +
                    "VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setString(1, entity.getFname());
            stmt.setString(2, entity.getLname());
            stmt.setString(3, entity.getUsername());
            stmt.setString(4, entity.getPassword());
            stmt.execute();
        } catch (SQLException ex) {
        }
		
	}

	@Override
	public void update(Customer entity) {
		String sql = "UPDATE Customer SET ";
        if (entity.getFname() != null)
            sql += "fname=?,";
        if (entity.getLname() != null)
            sql += "lname=?,";
        if (entity.getPassword() != null)
            sql += "password=?,";

        sql = sql.substring(0, sql.length() - 1);
        sql += " WHERE username=?";

        try {
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            int i = 1;
            if (entity.getFname() != null)
                stmt.setString(i++, entity.getFname());
            if (entity.getLname() != null)
                stmt.setString(i++, entity.getLname());
            if (entity.getPassword() != null)
                stmt.setString(i++, entity.getPassword());
            stmt.setString(i++, entity.getUsername());

            stmt.execute();
        } catch (SQLException ex) {
        	
        }
		
	}
 
	 public Customer queryOne(String sql) {
	        try {
	            Statement stmt = dbrepo.getConnection().createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            if (rs.next()) {
	                return new Customer();
	            }
	        } catch (SQLException ex) {
	          
	        }
	        return null;
	    }


	@Override
	public Customer getCustomerByID(long id) {
		String sql = "SELECT * FROM Customer WHERE id = " + id + " LIMIT 1";
        return queryOne(sql);
	}
}

