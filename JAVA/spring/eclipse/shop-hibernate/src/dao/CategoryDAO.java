package dao;

import java.util.List;

import model.Category;

public interface CategoryDAO {
	
	// thêm danh mục
	public void insertCategory(Category c);
	
	// lấy những danh mục là danh mục cha
	public List<Category> getCategoryByParent();
	
	
	// lấy những danh mục là danh mục con
	public List<Category> getCategoryByChildren(int parent);
}
