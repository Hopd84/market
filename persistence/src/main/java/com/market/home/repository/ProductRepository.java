package com.market.home.repository;

import com.market.home.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /*@Query("SELECT p FROM Product p WHERE p.department.departmentName=':departmentName'")
    List<Product> findAllByDepartmentName(String departmentName);*/

    @Query("SELECT d.id FROM StoreDepartment d WHERE d.departmentName=:departmentName")
    Integer getDepartmentId(@Param("departmentName") String departmentName);

    @Query("SELECT d.departmentName FROM StoreDepartment d WHERE d.id=:departmentId")
    String getDepartmentName(@Param("departmentId") Integer departmentId);
}
