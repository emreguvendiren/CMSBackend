package com.CMSBackend.CMS.respository;

import org.springframework.data.repository.CrudRepository;

import com.CMSBackend.CMS.model.Category;
import com.CMSBackend.CMS.model.Table;

public interface TableRepository extends CrudRepository<Table, Long>  {

}
