package io.aturanj.sales.service;

import io.aturanj.sales.model.Customer;
import jakarta.ejb.embeddable.EJBContainer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

/**
 * Test for CustomerService.class
 */
public class CustomerServiceTest {

    private CustomerService customerService;
    private static Integer CUSTOMER_ID = 0;

    @BeforeAll
    public static void setUpClass() throws Exception {
        CUSTOMER_ID = 111;
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
        EJBContainer container = jakarta.ejb.embeddable.EJBContainer.createEJBContainer();
        customerService = (CustomerService) container.getContext().lookup("java:global/classes/CustomerService");
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of create Customer method, of class CustomerService.
     */
    @Test
    @Order(0)
    public void testCreateCustomer() throws Exception {

        System.out.println("Create a Customer");

        //given
        Customer entity = new Customer(CUSTOMER_ID);
        entity.setFirstname("Emily");
        entity.setLastname("Brown");
        entity.setStreet("347 College Av.");
        entity.setCity("Lyon");

        //when
        customerService.create(entity);

        //then
        String expected = "Emily";
        assertEquals(expected, customerService.find(111).getFirstname());
    }

    /**
     * Test of update method, of class CustomerService.
     */
    @Test
    @Order(1)
    public void testUpdateCustomer() throws Exception {

        System.out.println("Update a Customer");

        //given
        Customer entity = customerService.find(CUSTOMER_ID);
        assertNotNull(entity);
        entity.setLastname("Black");

        //when
        customerService.edit(entity);

        //then
        Customer customer = customerService.find(CUSTOMER_ID);

        assertNotNull(customer);

        String result = customer.getLastname();
        String expected = "Black";

        assertEquals(expected, result);
    }

    /**
     * Test of delete method, of class CustomerService.
     */
    @Test
    @Order(2)
    public void testDeleteCustomer() {

        System.out.println("Delete a Customer");

        //given
        Customer entity = customerService.find(CUSTOMER_ID);
        assertNotNull(entity);

        //when
        customerService.remove(entity);

        //then
        Customer customer = customerService.find(CUSTOMER_ID);
        assertNull(customer);
    }
}
