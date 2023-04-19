package com.example.demo.repository.customer;

import com.example.demo.model.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, String> {
    @Query(nativeQuery = true, value = "select id, address, birthday, card_id, email, full_name, gender, is_delete, phone_number, username from customer where username = ?")
    Customer findCustomerByAccount(String account);

    @Query(" select new map ( c.id as id , c.fullName as name, sum(p.point) as totalPoint ) from Customer c left join Point p on p.customers.id = c.id group by c.id order by sum(p.point) desc ")
    List<?> getListCustomerPoint();

    @Query(" select new map ( c.id as id , c.fullName as name, count(t.customer.id) as totalTicket ) from Customer c left join Ticket t on t.customer.id = c.id group by c.id order by count(t.customer.id) desc")
    List<?> getListCustomerTicket();



}
