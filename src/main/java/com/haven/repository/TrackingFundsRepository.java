package com.haven.repository;

import com.haven.model.TrackingFunds;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrackingFundsRepository extends CrudRepository<TrackingFunds, Long> {
    List<TrackingFunds> findTrackingFundsByUserId(Long id);
}
