package com.viotas.server.service;

/*
- - - - - - - - - - - - - - - - - - - - - -
 Viotas Assessment
- - - - - - - - - - - - - - - - - - - - - -
 Candidate: Weverton de Souza Castanho
 Email: wevertonsc@gmail.com
 Data: 15.APRIL.2021
- - - - - - - - - - - - - - - - - - - - - -
*/

import com.viotas.server.model.Meter;
import com.viotas.server.repository.MeterRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class MeterService {
    private final MeterRepository meterRepository;

    public List<Meter> getMeters(){
        log.info("getMeters");
        return meterRepository.findAll();
    }

    public void save(Meter meter) {
        meterRepository.save(meter);
    }
}
