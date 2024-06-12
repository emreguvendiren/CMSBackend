package com.CMSBackend.CMS.service;

import com.CMSBackend.CMS.dto.OrderDto;
import com.CMSBackend.CMS.dto.ResultDto;
import com.CMSBackend.CMS.enums.OrderStatus;
import com.CMSBackend.CMS.model.Orders;
import com.CMSBackend.CMS.model.Product;
import com.CMSBackend.CMS.model.Table;
import com.CMSBackend.CMS.respository.OrdersRepository;
import com.CMSBackend.CMS.respository.ProductRepository;
import com.CMSBackend.CMS.respository.TableRepository;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private TableRepository tableRepository;
    @Autowired
    private ProductRepository productRepository;

    public ResultDto CreateOrder(List<OrderDto> orderDtos){

        try {
            Table table = tableRepository.findById(orderDtos.get(0).getTableId()).get();
            for(OrderDto dto : orderDtos){

                Product product = productRepository.findById(dto.getProductId()).get();
                Orders order = new Orders();
                order.setTable(table);
                order.setProduct(product);
                order.setStatus(OrderStatus.Oluşturuldu);
                order.setQuantity(dto.getQuantity());
                order.setTotalPrice(dto.getTotalPrice());
                ordersRepository.save(order);


            }
            return new ResultDto(true,200,"Siparis Basariyla Olusturuldu");

        }
        catch (Exception e){
            return new ResultDto(false,500,"Siparis Olusturulurken Hata Olustu");
        }

    }
}
