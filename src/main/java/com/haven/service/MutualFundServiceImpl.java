package com.haven.service;

import com.haven.model.MutualFund;
import com.haven.repository.MutualFundRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class MutualFundServiceImpl implements MutualFundService {
    private MutualFundRepository mutualFundRepository;

    public MutualFundServiceImpl(MutualFundRepository mutualFundRepository) {
        super();
        this.mutualFundRepository = mutualFundRepository;
    }

    @Override
    public Optional<MutualFund> getFundByCode(String code) {
        return mutualFundRepository.findById(code);
    }


    // @Override
    // public Iterable<MutualFund> getFundsByFundType(String category) {
    // return null;
    // }

}
