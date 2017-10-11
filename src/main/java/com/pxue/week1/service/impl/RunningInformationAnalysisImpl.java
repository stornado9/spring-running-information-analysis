package com.pxue.week1.service.impl;

import com.pxue.week1.service.RunningInformationAnalysisService;
import com.pxue.week1.domain.Information;
import com.pxue.week1.domain.Information;
import com.pxue.week1.domain.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class RunningInformationAnalysisImpl implements RunningInformationAnalysisService{
    @Autowired
    private InformationRepository informationRepository;

    @Override
    public List<Information> saveInformationAnalysis(List<Information> runningInformation) {
        return informationRepository.save(runningInformation);
    }

    @Override
    public Page<Information> findByRunningId(String runningId, Pageable pageable) {
        return informationRepository.findByRunningId(runningId, pageable);
    }
/*
    @Override
    public Page<Information> findByhealthWarningLevelDecrease(String healthWarningLevel, Pageable pageable){
        return informationRepository.findByhealthWarningLevelDecrease(healthWarningLevel, pageable);
    }*/

    @Override
    public void deleteByRunningId(String runningId){
        informationRepository.deleteByRunningId(runningId);
    }

}
