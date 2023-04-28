package com.example.demo.repository.employee;

import com.example.demo.model.employee.Employee;
import com.example.demo.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,String> {
    @Query(value = "UPDATE employee SET full_name=?1,image=?2,gender=?3,birthday =?4, email=?5,phone_number =?6,address =?7,cart_id=?8,position_id=?9 WHERE id = ?10",nativeQuery = true)
    void updateEmployee( String fullName, String image, boolean gender, Date birthday, String email,
                        String phoneNumber, String address, String cardId, Position positionId,String id);
}
