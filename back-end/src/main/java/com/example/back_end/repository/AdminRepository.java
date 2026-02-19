package com.example.back_end.repository;


import com.example.back_end.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    // 2. Custom method to find admin by username
    Admin findByUsername(String username);
}
