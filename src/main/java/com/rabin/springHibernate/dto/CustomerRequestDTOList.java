package com.rabin.springHibernate.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class CustomerRequestDTOList {

    @JsonProperty("customerCount")
    private long customerCount;
    @JsonProperty("customerRequestDTO")
    private List<CustomerRequestDTO> customers;

    public CustomerRequestDTOList() {
    }

    public CustomerRequestDTOList(long customerCount, List<CustomerRequestDTO> customers) {
        this.customerCount = customerCount;
        this.customers = customers;
    }

    public long getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(long customerCount) {
        this.customerCount = customerCount;
    }

    public List<CustomerRequestDTO> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerRequestDTO> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerRequestDTOList that = (CustomerRequestDTOList) o;
        return customerCount == that.customerCount;
    }

    @Override
    public int hashCode() {
        return (int) (customerCount ^ (customerCount >>> 32));
    }
}
