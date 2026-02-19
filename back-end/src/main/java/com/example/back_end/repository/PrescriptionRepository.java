package com.example.back_end.repository;


import com.example.back_end.models.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrescriptionRepository extends MongoRepository<Prescription, String> {

    // 2. Custom query method to find prescriptions by appointment ID
    List<Prescription> findByAppointmentId(Long appointmentId);
}
