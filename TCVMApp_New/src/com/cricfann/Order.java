package com.cricfann;


import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *This is a domain class represents Order.
 * @author Devesh
 */
class Order {
    /**
     * A unique order id,here it is auto-generated as current milliseconds, but it should use some standard algo for primary key generation.
     */
    private Long orderId = System.currentTimeMillis();
    /**
     * unique product id.
     */
    private Integer productId;
    /**
     * Stores Product Name.
     */
    private String productName;
    private Float amount;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    Date date1 = new Date();  
    private String date = formatter.format(date1);
    private Integer quantity;
    private String remark;
    private String customerName;
    private Long CustomerMobileNo;

    public Order() {
    }

    public Long getOrderId() {
        return orderId;
    }
    /**
     * 
     * @param orderId 
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    /**
     * 
     * @return 
     */
    public Integer getProductId() {
        return productId;
    }
    /**
     * 
     * @param productId 
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    /**
     * 
     * @return 
     */
    public Float getAmount() {
        return amount;
    }
    
    /**
     * 
     * @param amount 
     */
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public SimpleDateFormat getFormatter() {
        return formatter;
    }

    public void setFormatter(SimpleDateFormat formatter) {
        this.formatter = formatter;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCustomerMobileNo() {
        return CustomerMobileNo;
    }

    public void setCustomerMobileNo(Long CustomerMobileNo) {
        this.CustomerMobileNo = CustomerMobileNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    /**
     * Parameterized Constructor.
     * @param productName
     * @param productId
     * @param amount
     * @param quantity
     * @param remark
     * @param customerName
     * @param CustomerMobileNo 
     */
    public Order(String productName,Integer productId, Float amount, Integer quantity, String remark, String customerName, Long CustomerMobileNo) {
        this.productName = productName;
        this.productId = productId;
        this.amount = amount;
        this.quantity = quantity;
        this.remark = remark;
        this.customerName = customerName;
        this.CustomerMobileNo = CustomerMobileNo;
        
    }

    
    
    
}
    