package com.CMSBackend.CMS.respository;

import com.CMSBackend.CMS.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
