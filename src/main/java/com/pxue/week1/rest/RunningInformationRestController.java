package com.pxue.week1.rest;

import com.pxue.week1.service.RunningInformationAnalysisService;
import com.pxue.week1.domain.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class RunningInformationRestController {
    private RunningInformationAnalysisService informationAnalysisService;

    @Autowired
    public RunningInformationRestController(RunningInformationAnalysisService informationAnalysisService) {
        this.informationAnalysisService = informationAnalysisService;
    }

    //POST: http://127.0.0.1:8080/runninginfo
    @RequestMapping(value = "/runninginfo", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<Information> runningInformation) {
        this.informationAnalysisService.saveInformationAnalysis(runningInformation);
    }

    @RequestMapping(value = "/runninginfo/{runningId}", method = RequestMethod.DELETE)
    public void deleteByRunningId(@PathVariable String runningId){
        this.informationAnalysisService.deleteByRunningId(runningId);
    }

    //GET: http://127.0.0.1:8080/runninginfo/7c01233d-bed4-4cbd-9c28-9282a02a7038?page=0&size=2
    @RequestMapping(value = "/runninginfo/{runningId}", method = RequestMethod.GET)
    public Page<Information> findByRunningId(@PathVariable String runningId, @RequestParam(name="page") int page,
                                        @RequestParam(name="size") int size){
        return this.informationAnalysisService.findByRunningId(runningId, new PageRequest(page, size));
    }

    //GET: http://127.0.0.1:8080/runninginfo?page=0&size=2
    /*@RequestMapping(value = "/runninginfo", method = RequestMethod.GET)
    public Page<Information> findByhealthWarningLevelDecrease(@PathVariable String healthWarningLevel, @RequestParam(name="page") int page,
                                                              @RequestParam(name="size") int size) {
        return this.informationAnalysisService.findByhealthWarningLevelDecrease(healthWarningLevel, new PageRequest(page, size));
    }*/

}
