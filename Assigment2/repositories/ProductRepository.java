import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class ProductRepository implements IProductRepository{
	 private IDBRepository dbrepo = new PostgresRepository();

	@Override
	public void add(Product entity) {
		try {
            String sql = "INSERT INTO Products(productid, Categories, mark, model,price) " +
                    "VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            stmt.setLong(1, entity.getProductid());
            //stmt.setString(2, entity.getCategoriess());
            stmt.setString(3, entity.getMark());
            stmt.setString(4, entity.getModel());
            stmt.setDouble(5, entity.getPrice());
            stmt.execute();
        } catch (SQLException ex) {
        }
	}

	@Override
	public void update(Product entity) {
		String sql = "UPDATE Products SET ";
        if (entity.getPrice() != 0)
            sql += "Price=?,";
        if (entity.getMark() != null)
            sql += "Mark=?,";
        if (entity.getModel() != null)
            sql += "Model=?,";

        sql = sql.substring(0, sql.length() - 1);
        sql += " WHERE Productid=?";

        try {
            PreparedStatement stmt = dbrepo.getConnection().prepareStatement(sql);
            int i = 1;
            if (entity.getPrice() != 0)
                sql += "Price=?,";
            if (entity.getMark() != null)
                sql += "Mark=?,";
            if (entity.getModel() != null)
                sql += "Model=?,";

            stmt.setString(i++, entity.getMark() + entity.getModel());

            stmt.execute();
        } catch (SQLException ex) {
        	
        }
		
		
	}

	@Override
	public Product getProductbyID(long id) {
		String sql = "SELECT * FROM Product WHERE id = " + id + " LIMIT 1";
		return queryOne(sql);
	}

	private Product queryOne(String sql) {
		 try {
	            Statement stmt = dbrepo.getConnection().createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            if (rs.next()) {
	                return new Product();
	            }
	        } catch (SQLException ex) {
	          
	        }
	        return null;
	}



}
		
	


