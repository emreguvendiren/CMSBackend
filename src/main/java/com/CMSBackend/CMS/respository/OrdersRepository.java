package com.CMSBackend.CMS.respository;

import com.CMSBackend.CMS.enums.OrderStatus;
import com.CMSBackend.CMS.model.Orders;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders,Long> {
	
	@Query("Select p From Orders p where p.table.id=?1 and p.status!=?2")
	public List<Orders> findOrdersByTableId(Long tableId,OrderStatus status);
	
}
