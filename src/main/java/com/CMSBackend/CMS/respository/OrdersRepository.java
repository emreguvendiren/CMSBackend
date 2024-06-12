package com.CMSBackend.CMS.respository;

import com.CMSBackend.CMS.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends CrudRepository<Orders,Long> {

}
