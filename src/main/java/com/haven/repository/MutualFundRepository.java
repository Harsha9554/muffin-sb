package com.haven.repository;

import com.haven.model.MutualFund;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MutualFundRepository extends CrudRepository<MutualFund, String> {
    @Query("SELECT m from MutualFund m")
    List<MutualFund> getAllFunds();
    MutualFund getMutualFundByCode(String code);
}

