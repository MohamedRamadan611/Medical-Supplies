package com.MedicalSuppliesSystem.MedicalSupplies.business.services.interfaces;

import com.MedicalSuppliesSystem.MedicalSupplies.dto.OrderDto;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.SearchParPojo;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService {
    void createOrder(OrderDto orderDto);

    List<OrderDto> findOrders(SearchParPojo searchParPojo , Pageable pageable);

    List<OrderDto> findAllOrders();
}
