package com.MedicalSuppliesSystem.MedicalSupplies.model;

import com.MedicalSuppliesSystem.MedicalSupplies.model.pk.CustomerId;
import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeDeserializer;
import com.MedicalSuppliesSystem.MedicalSupplies.utils.serializer.JsonDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="customer")
public class Customer implements Serializable {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long customerId;
    @Column(name="phone")
    private String phone;
    @Column(name="address")
    private String address;
    @Column(name="customer_name")
    private String customerName;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonSerialize(using = JsonDateTimeSerializer.class)
    @JsonDeserialize(using = JsonDateTimeDeserializer.class)
    @Column(name = "customer_creation_date")
    private Date customerCreationDate;


    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerCreationDate() {
        return customerCreationDate;
    }

    public void setCustomerCreationDate(Date customerCreationDate) {
        this.customerCreationDate = customerCreationDate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerCreationDate=" + customerCreationDate +
                '}';
    }
}
