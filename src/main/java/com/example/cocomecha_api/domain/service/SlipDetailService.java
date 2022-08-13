package com.example.cocomecha_api.domain.service;

import com.example.cocomecha_api.domain.model.SlipDetail;
import com.example.cocomecha_api.domain.repository.SlipDetailRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SlipDetailService {
    @NonNull
    private final SlipDetailRepository slipDetailRepository;

    public List<SlipDetail> findById(String slipNo) {
        return this.slipDetailRepository.findById(slipNo);
    }

    public SlipDetail postSlip(SlipDetail slipDetail) {
        return this.slipDetailRepository.save(slipDetail);
    }

    public SlipDetail putSlip(SlipDetail slipDetail) {
        return this.slipDetailRepository.save(slipDetail);
    }

    public void deleteSlip(String slipNo) {
        this.slipDetailRepository.deleteById(slipNo);
    }

    public List<SlipDetail> getSlipAll() {
        return this.slipDetailRepository.findAll();
    }
}
