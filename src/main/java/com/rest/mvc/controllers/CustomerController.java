package com.rest.mvc.controllers;

import com.core.models.Customer;
import com.core.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * Created by volodymyr on 18.09.15.
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value = "/customers.json", method = RequestMethod.GET)
    public @ResponseBody
    List<Customer> getAllContacts(){
        return customerRepository.getAllCustomer();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/add-customer", method = RequestMethod.POST)
    public @ResponseBody String addNewContract( @RequestParam("firstName") String firstName,
                                                @RequestParam("lastName") String lastName,
                                                @RequestParam("city") String city,
                                                @RequestParam("street") String street,
                                                @RequestParam("numberHouse") String numberHouse) {

        Customer customer = null;
        int numb = Integer.parseInt(numberHouse);
        customer = new Customer(firstName,lastName,city,street,numb);
        customerRepository.addOrUpdateContact(customer);
        return "customer add";
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/delete-customer", method = RequestMethod.POST)
    public @ResponseBody String deleteContact(
            @RequestParam(value = "customerIds", required = true) String customerIds){

        String[] contactIdsArr = customerIds.split(",");

        List<Customer> customers = customerRepository.getAllCustomer();
        for (Customer customer: customers) {
            for (String customerId: contactIdsArr) {
                if (customer.getId() == Long.parseLong(customerId)) {
                    customerRepository.deleteCustomer(customer);
                }
            }
        }
        return "customer deleted";
    }
}
