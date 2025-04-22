package com.example.springapp.web.dao;


import com.example.springapp.web.model.PayRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayRateRepository extends JpaRepository<PayRates,Integer> {

    @Query("SELECT p FROM PayRates p")
    List<PayRates> findAllDistinct();
}
