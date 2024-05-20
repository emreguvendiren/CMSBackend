package com.CMSBackend.CMS.respository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.CMSBackend.CMS.model.Category;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    @Query("select p from Category p where p.name = ?1")
    List<Category> findByName(String name);
}
