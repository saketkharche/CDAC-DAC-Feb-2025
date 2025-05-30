// src/main/java/com/cdac/entities/Category.java

package com.cdac.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categories", uniqueConstraints = {
    jakarta.persistence.UniqueConstraint(columnNames = { "category_name" })
})
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "products")
public class Category extends BaseEntity {

    @Column(name = "category_name", nullable = false, length = 30)
    private String categoryName;

    @Column(name = "category_desc", length = 200)
    private String categoryDesc;

    // Bi-directional mapping
    @OneToMany(mappedBy = "category", cascade = jakarta.persistence.CascadeType.ALL, orphanRemoval = true)
    private List<Product> products = new ArrayList<>();

    // Constructor without id (id comes from BaseEntity)
    public Category(String categoryName, String categoryDesc) {
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
    }

    // Helper method to maintain bidirectional link
    public void addProduct(Product product) {
        products.add(product);
        product.setCategory(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setCategory(null);
    }

	public void setDescription(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setName(String string) {
		// TODO Auto-generated method stub
		
	}
}