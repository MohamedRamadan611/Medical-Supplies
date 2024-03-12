package com.MedicalSuppliesSystem.MedicalSupplies.dto;

import com.MedicalSuppliesSystem.MedicalSupplies.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MappingClass {

    @Autowired
    private ModelMapper model;
    public Order MapToOrder(OrderDto orderDto)
    {
        Order order = model.map(orderDto , Order.class);
        return order;
    }

    public OrderDto MapToOrderDto(Order order)
    {
        OrderDto orderDto = model.map(order , OrderDto.class);
        return orderDto;
    }
    public Item MapToItem(ItemDto itemDto)
    {
        Item item = model.map(itemDto , Item.class);
        return item;
    }
    public ItemDto MapToItemDto(Item item)
    {
        ItemDto itemDto = model.map(item , ItemDto.class);
        return itemDto;
    }
    public Customer MapToCustomer(CustomerDto customerDto)
    {
        Customer customer = model.map(customerDto , Customer.class);
        return customer;
    }
    public CustomerDto MapToCustomerDto(Customer customer)
    {
        CustomerDto customerDto = model.map(customer , CustomerDto.class);
        return customerDto;
    }
    public Stock MapToStock(StockDto stockDto)
    {
        Stock stock = model.map(stockDto , Stock.class);
        return stock;
    }
    public StockDto MapToStockDto(Stock stock)
    {
        StockDto stockDto = model.map(stock , StockDto.class);
        return stockDto;
    }
    public Invoices MapToInvoice(InvoicesDto invoicesDto)
    {
        Invoices invoices = model.map(invoicesDto , Invoices.class);
        return invoices;
    }
    public InvoicesDto MapToInvoiceDto(Invoices invoices)
    {
        InvoicesDto invoicesDto = model.map(invoices , InvoicesDto.class);
        return invoicesDto;
    }

}
