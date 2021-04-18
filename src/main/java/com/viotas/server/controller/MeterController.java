package com.viotas.server.controller;

/*
- - - - - - - - - - - - - - - - - - - - - -
 Assessment
- - - - - - - - - - - - - - - - - - - - - -
 Candidate: Weverton de Souza Castanho
 Email: wevertonsc@gmail.com
 Data: 15.APRIL.2021
- - - - - - - - - - - - - - - - - - - - - -
*/

import com.viotas.server.model.Meter;
import com.viotas.server.service.MeterService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/meter")
public class MeterController {
    private final MeterService meterService;

    public MeterController(MeterService meterService) {
        this.meterService = meterService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Meter> getMeter(){
        return meterService.getMeters();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveMeter(@RequestBody Meter meter){
        meterService.save(meter);
    }
}
