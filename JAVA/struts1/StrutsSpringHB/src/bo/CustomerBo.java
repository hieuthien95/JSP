package bo;

import java.util.List;

import bean.Customer;
import dao.CustomerDao;

public class CustomerBo {
	CustomerDao customerDao;

	public CustomerBo() {
		this.customerDao = new CustomerDao();
	}

	public CustomerBo(CustomerDao customerDao) {
		super();
		this.customerDao = customerDao;
	}

	public List<Customer> getAllCustomer() {
		return customerDao.getAllCustomer();
	}
	
	public List<Customer> getAllCustomerTemplate() {
		return customerDao.getAllCustomerTemplate();
	}

	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
}
