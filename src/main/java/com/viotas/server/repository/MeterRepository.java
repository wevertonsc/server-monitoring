package com.viotas.server.repository;

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
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeterRepository extends JpaRepository<Meter,Long>{

    Meter findMeterById(Long id);

}
