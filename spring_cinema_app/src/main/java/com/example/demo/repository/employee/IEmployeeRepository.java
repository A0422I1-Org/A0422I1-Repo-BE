package com.example.demo.repository.employee;


import com.example.demo.model.customer.Customer;
import com.example.demo.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,String> {
    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.isDelete=true WHERE e.id=?1 and e.isDelete=false")
    Integer updateIsDeleteById(String id);

    @Modifying
    @Transactional
    @Query("UPDATE Account a SET a.isDelete=true  WHERE a.username IN (select e.account.username FROM Employee e WHERE e.id= ?1)")
    Integer updateIsDeleteAccount(String id);

    @Query("SELECT e FROM Employee e WHERE e.id=?1 and e.isDelete=false ")
    Optional<Employee> findById(String id);

    @Query("SELECT e " +
            "FROM Employee e WHERE e.fullName LIKE concat('%',?1,'%') and e.isDelete=false")
    Page<Employee> findAllByFullNameContaining(String name, Pageable pageable);

    @Query("SELECT e " +
            " FROM Employee e WHERE e.fullName LIKE concat('%',?1,'%') and e.position.id=?2 and e.isDelete=false")
    Page<Employee> findAllByFullNameContainingAndPosition(String name, Integer positionId, Pageable pageable);

    @Query(value = "select * from employee where username = ?", nativeQuery = true)
    Employee findEmployeeByUsername(String username);

}
