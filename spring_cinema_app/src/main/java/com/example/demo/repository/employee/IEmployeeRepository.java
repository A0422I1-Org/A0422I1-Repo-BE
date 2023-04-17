package com.example.demo.repository.employee;

import com.example.demo.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee,String> {
    @Query("UPDATE Employee e SET e.isDelete=true WHERE e.id=?1 and e.isDelete=false")
    void deleteById(String id);

    @Query("SELECT e FROM Employee e WHERE e.id=?1 and e.isDelete=false")
    Optional<Employee> findById(String id);
    @Query("SELECT e FROM Employee e WHERE e.isDelete=false ")
    List<Employee> findAll();

    @Query("SELECT e FROM Employee e WHERE e.fullName=?1 and e.isDelete=false")
    List<Employee> findAllByFullNameContaining(String name);

    @Query("SELECT e FROM Employee e WHERE e.fullName=?1 and e.position.id=?2 and e.isDelete=false")
    List<Employee> findAllByFullNameContainingAndPosition(String name, Integer positionId);

}
