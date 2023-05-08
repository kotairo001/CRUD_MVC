package rikkei.academy.service;

import rikkei.academy.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements ICustomerService {
    public static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Thu", "thu@gmail.com", "yen bai"));
        customerList.add(new Customer(2, "Ha", "ha@gmail.com", "phu tho"));
        customerList.add(new Customer(3, "Chuan", "chuan@gmail.com", "nam dinh"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        if (findById(customer.getId()) != null) {
            customerList.set(customerList.indexOf(findById(customer.getId())), customer);
        } else {
            customerList.add(customer);
        }
    }

    @Override
    public Customer findById(int id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == id) {
                return customerList.get(i);
            }
        }
        return null;
    }

    @Override
    public void deleteById(int id) {
        customerList.remove(findById(id));
    }
}
