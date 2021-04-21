package com.viotas.server.service;

/*
- - - - - - - - - - - - - - - - - - - - - -
 Viotas Assessment
- - - - - - - - - - - - - - - - - - - - - -
 Candidate: Weverton de Souza Castanho
 Email: wevertonsc@gmail.com
 Data: 21.APRIL.2021
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

    public String getMeasures() {
        log.info("getMeasures");
        StringBuilder result = new StringBuilder("meter\tdate\tmeasure\n");
        List<Meter>meters = meterRepository.findMetersLimit300();

        for (Meter meter : meters) {
            result.append(meter.getMeterId()).append("\t")
                    .append(meter.getTimeMeasure().substring(3,11)).append("\t").append(meter.getMeasure()).append("\n");
        }
        return result.toString();
    }

    public String getMeterActivity(){
        log.info("getMeasures");
        StringBuilder result = new StringBuilder();
        List<Meter>meters = meterRepository.findMeterActivity();

        for (Meter meter : meters) {
            // - TO DO! -
            result.append(meter.getMeterId());
        }
        return result.toString();
    }
}
