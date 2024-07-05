package com.MedicalSuppliesSystem.MedicalSupplies.business.services.implentation;

import com.MedicalSuppliesSystem.MedicalSupplies.business.repository.CustomerRepository;
import com.MedicalSuppliesSystem.MedicalSupplies.business.repository.ItemRepository;
import com.MedicalSuppliesSystem.MedicalSupplies.business.repository.OrderRepository;
import com.MedicalSuppliesSystem.MedicalSupplies.business.repository.StockRepository;
import com.MedicalSuppliesSystem.MedicalSupplies.business.services.interfaces.IOrderService;
import com.MedicalSuppliesSystem.MedicalSupplies.dto.CustomerDto;
import com.MedicalSuppliesSystem.MedicalSupplies.dto.MappingClass;
import com.MedicalSuppliesSystem.MedicalSupplies.dto.BaseOrderDto;
import com.MedicalSuppliesSystem.MedicalSupplies.dto.OrderDto;
import com.MedicalSuppliesSystem.MedicalSupplies.exception.BusinessException;
import com.MedicalSuppliesSystem.MedicalSupplies.model.*;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.FilterPojo;
import com.MedicalSuppliesSystem.MedicalSupplies.pojos.SearchParPojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements IOrderService {
    Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private MappingClass mappingClass;
    @Override
    @Transactional
    public void createOrder(BaseOrderDto baseOrderDto) {
        try {
            logger.info("start preparing order to save to DB");
            validateStockItem(baseOrderDto);
            Order order = new Order();
            order.setOrderType(baseOrderDto.getOrderType());
            order.setOrderAddress(baseOrderDto.getOrderAddress());
            order.setDiscount(baseOrderDto.getDiscount());
            order.setOrderCreationDate(new Date());
/*            Customer customer = checkCustomerExistOrNew(orderDto.getCustomerno());
            if(customer != null)
                order.setCustomerno(customer);
            else*/
            order.setCustomerno(checkCustomerExistOrNew(baseOrderDto.getCustomerno()));
            order.getCustomerno().setCustomerCreationDate(new Date());
            logger.info("customer in order is {} " , order.getCustomerno().toString());
            order.setOrderPrice(BigDecimal.ZERO);
            order.setAmount(BigDecimal.ZERO);
            logger.info("order saved in DB without Details");
            orderRepository.save(order);
            logger.info("preparing order details to set in order");
            List<OrderDetails> orderDetails = baseOrderDto.getOrderDetails().stream().map(orderDetailsDto -> {
                Item item = itemRepository.findById(orderDetailsDto.getItemno()).orElseThrow(() -> new BusinessException("this item isn't found"));
                OrderDetails orderDetails1 = new OrderDetails();
                orderDetails1.setOrderno(order.getOrderNo());
                orderDetails1.setItemno(item.getItemno());
                orderDetails1.setItemPrice(item.getItemPrice());
                orderDetails1.setItemQuantity(orderDetailsDto.getItemQuantity());
                orderDetails1.setInventoryBranch(orderDetailsDto.getInventoryBranch());
                order.setOrderPrice(order.getOrderPrice().add(item.getItemPrice().multiply(new BigDecimal(orderDetailsDto.getItemQuantity()))));
                logger.info("order price is {} ", order.getOrderPrice());
                return orderDetails1;
            }).collect(Collectors.toList());
            order.setOrderDetails(orderDetails);
            order.setDeliveryPrice(baseOrderDto.getDeliveryPrice());
            logger.info("Order price is {} and Deliver Price is {} and Discount is {} ", order.getOrderPrice(), baseOrderDto.getDeliveryPrice(), baseOrderDto.getDiscount());
            order.setAmount((order.getOrderPrice().add(baseOrderDto.getDeliveryPrice())).subtract(baseOrderDto.getDiscount()));
            orderRepository.save(order);
            logger.info("order is saved {} " , order.toString());
            logger.info("update stock");
            updateStock(order);
            logger.info("order is saved with order details");
        }
        catch (Exception exception)
        {
            logger.error(Arrays.toString(exception.getStackTrace()));
            throw  exception;
        }
    }

    private Customer checkCustomerExistOrNew(CustomerDto customerno) {
        Customer customer = customerRepository.findCustomerByPhone(customerno.getPhone());
        if(customer != null)
            return customer;
        logger.info("new customer added");
        return mappingClass.MapToCustomer(customerno);
    }

    @Override
    public List<OrderDto> findOrders(SearchParPojo searchParPojo , Pageable pageable) {
        String orderno = null;
        String customerno = null;
        String fromDate = null;
        String toDate = null;
        String orderType = null;
        String phone = null;
        String orderFilter = null;
        FilterPojo filterPojo = new FilterPojo();


        boolean fieldNameExist = filterPojo.getFieldName() != null && !filterPojo.getFieldName().isEmpty();
        boolean filterValueExist = filterPojo.getFilter() != null && !filterPojo.getFilter().isEmpty();

        if (searchParPojo.getFiltersList() != null && !searchParPojo.getFiltersList().isEmpty()) {
            for (FilterPojo forFilterPojo : searchParPojo.getFiltersList()) {
                if (!fieldNameExist && !filterValueExist) {
                    if(forFilterPojo.getFieldName().equals("orderFilter"))
                    {
                        orderFilter = forFilterPojo.getFilter().isEmpty() ? null : forFilterPojo.getFilter();
                    }
/*                    if (forFilterPojo.getFieldName().equals("orderno")) {
                        orderno = forFilterPojo.getFilter().isEmpty() ? null : forFilterPojo.getFilter();
                    } else if (forFilterPojo.getFieldName().equals("customerno")) {
                        customerno = forFilterPojo.getFilter().isEmpty() ? null : forFilterPojo.getFilter();
                    } else if (forFilterPojo.getFieldName().equals("phone")) {
                        phone = forFilterPojo.getFilter().isEmpty() ? null : forFilterPojo.getFilter();
                    }*/ else if (forFilterPojo.getFieldName().equals("orderType")) {
                        orderType = forFilterPojo.getFilter().isEmpty() ? null : forFilterPojo.getFilter();
                    } else if (forFilterPojo.getFieldName().equals("fromDate")) {
                        fromDate = forFilterPojo.getFilter().isEmpty() ? null : forFilterPojo.getFilter();
                    } else if (forFilterPojo.getFieldName().equals("toDate")) {
                        toDate = forFilterPojo.getFilter().isEmpty() ? null : forFilterPojo.getFilter();
                    }

                }
            }
        }
        List<Order> orderList = orderRepository.findOrders(orderFilter , orderType, fromDate , toDate , pageable);
        return orderList.stream().map(order -> mappingClass.MapToOrderDto(order)).collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findAllOrders() {
        return orderRepository.findAll().stream().map(order -> mappingClass.MapToOrderDto(order)).collect(Collectors.toList());
    }

    private void updateStock(Order order) {
        try {
            order.getOrderDetails().stream().forEach(orderDetails -> {
                Stock stock = stockRepository.findStock(orderDetails.getInventoryBranch() , orderDetails.getItemno());
                if(stock == null)
                {
                    throw new BusinessException("this item didn't have stock " + orderDetails.getItemno());
                }
                else {
                    stock.setSoldQuantity(stock.getSoldQuantity() + orderDetails.getItemQuantity());
                    stock.setRemainQuantity(stock.getQuantity() - stock.getSoldQuantity());
                }
            });
        }
        catch (Exception exception)
        {
            throw exception;
        }
    }

    private void validateStockItem(BaseOrderDto baseOrderDto) {
        try {
            baseOrderDto.getOrderDetails().stream().forEach(orderDetailsDto -> {
                Stock stock = stockRepository.findStock(orderDetailsDto.getInventoryBranch() , orderDetailsDto.getItemno());
                if(stock == null)
                    throw new BusinessException("this item {} didn't have stock " + orderDetailsDto.getItemno());
                else
                {
                    if(stock.getRemainQuantity() < orderDetailsDto.getItemQuantity())
                        throw new BusinessException("we didn't have enough quantity for this item" + orderDetailsDto.getItemno() + " we have only "
                        + stock.getRemainQuantity() + " and the requested quantity is " + orderDetailsDto.getItemQuantity());
                }
            });
        }
        catch (Exception exception)
        {
            throw  exception;
        }
    }
}
