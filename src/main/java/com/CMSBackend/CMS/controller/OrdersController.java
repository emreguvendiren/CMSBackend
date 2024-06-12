package com.CMSBackend.CMS.controller;

import com.CMSBackend.CMS.dto.OrderDto;
import com.CMSBackend.CMS.dto.ResultDto;
import com.CMSBackend.CMS.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping("/create")
    public ResultDto CreateOrder(@RequestBody List<OrderDto> dtos){
        return ordersService.CreateOrder(dtos);
    }

}
