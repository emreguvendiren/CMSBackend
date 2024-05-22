package com.CMSBackend.CMS.respository;

import com.CMSBackend.CMS.model.Category;
import com.CMSBackend.CMS.model.Product;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {

	@Query("select p from Product p where p.category = ?1")
	List<Product> findByCategoryId(Category category);
}
