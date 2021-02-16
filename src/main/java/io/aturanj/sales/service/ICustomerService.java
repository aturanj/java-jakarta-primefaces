package io.aturanj.sales.service;

import io.aturanj.sales.model.Customer;
import java.util.Collection;

public interface ICustomerService extends ISalesService<Customer> {

    public Collection<String> findAllCities();
}
