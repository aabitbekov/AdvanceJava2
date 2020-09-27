
public interface IProductRepository  extends IEntityRepository<Product>  {
	Product getProductbyID(long id);
}
