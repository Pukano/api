package com.ocr.repository;

import com.ocr.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository //declare to Spring that a class is a bean
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
