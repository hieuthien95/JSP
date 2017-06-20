package dao;

import java.util.ArrayList;
import java.util.List;

import model.Product;

public interface ProductDAO {

	// thêm sản phẩm
	public void insertProduct(Product p);

	// lấy danh sách sản phẩm
	public List<Product> getListProduct();

	// lấy danh sách sản phẩm theo mã danh mục
	public List<Product> getListProductByCategory(int category_id);

	// lấy danh sách sản phẩm theo mã sản phẩm
	public Product getListProductByProductID(int product_id);
	
	// phân trang
	 public List<Product> getListProductByPages(List<Product> list, int start, int end);
}
