package com.haven.service;

import com.haven.model.MutualFund;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface MutualFundService {
    Optional<MutualFund> getFundByCode(String code);
//    @Query("SELECT m FROM MutualFund m WHERE m.category = :category")
//    Iterable<MutualFund> getFundsByFundType(@Param("category") String category);
}
