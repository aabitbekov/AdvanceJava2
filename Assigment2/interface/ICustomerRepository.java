
public interface ICustomerRepository extends IEntityRepository<Customer> {
	Customer getCustomerByID(long id);
}
