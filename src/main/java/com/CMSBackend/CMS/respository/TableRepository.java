package com.CMSBackend.CMS.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.CMSBackend.CMS.model.Category;
import com.CMSBackend.CMS.model.Table;

public interface TableRepository extends CrudRepository<Table, Long>  {

	@Query("SELECT p FROM Table p WHERE p.TableName=?1")
	Table findByName(String tableName);
	
	@Query(value = "SELECT cms.table.id, cms.table.table_name, "
            + "IFNULL(SUM(CASE WHEN cms.orders.status != 2 THEN cms.orders.total_price ELSE 0 END), 0) AS total "
            + "FROM cms.table "
            + "LEFT JOIN cms.orders ON cms.orders.table_id = cms.table.id "
            + "GROUP BY cms.table.id, cms.table.table_name", 
            nativeQuery = true)
	List<Object[]> getTablesWithTotalPrice();
}
