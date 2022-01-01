package com.haven.repository;

import com.haven.model.MutualFund;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MutualFundRepository extends CrudRepository<MutualFund, String> {
    @Query("SELECT m from MutualFund m")
    List<MutualFund> getAllFunds();
    @Query("SELECT m from MutualFund m")
    Page<MutualFund> getFundsPages(Pageable pageable);
    MutualFund getMutualFundByCode(String code);
}

