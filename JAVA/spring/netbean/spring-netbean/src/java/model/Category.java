package model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author TUNGDUONG
 */
@Entity(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryID = 0;
    private String categoryName;
    private long categoryParent;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "categoryID")
    private List<Product> listProduct;

    public Category() {
    }

    public Category(long categoryID, String categoryName, long categoryParent) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.categoryParent = categoryParent;
    }

    public long getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public long getCategoryParent() {
        return categoryParent;
    }

    public List<Product> getListProduct() {
        return listProduct;
    }

    public void setCategoryID(long categoryID) {
        this.categoryID = categoryID;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public void setCategoryParent(long categoryParent) {
        this.categoryParent = categoryParent;
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @Override
    public String toString() {
        return "Category{" + "categoryID=" + categoryID + ", categoryName=" + categoryName + ", categoryParent=" + categoryParent + ", listProduct=" + listProduct + '}';
    }

}
