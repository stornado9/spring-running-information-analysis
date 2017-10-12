package com.pxue.week1.service;

import com.pxue.week1.domain.Information;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RunningInformationAnalysisService {
    List<Information> saveInformationAnalysis(List<Information> InformationAnalysis);
    Page<Information> findByRunningId(String runningId, Pageable pageable);
    Page<Information> findAllByOrderByHeartRateDesc(String heartRate, Pageable pageable);
    void deleteByRunningId(String runningId);
}
