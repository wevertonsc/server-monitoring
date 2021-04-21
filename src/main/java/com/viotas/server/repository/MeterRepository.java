package com.viotas.server.repository;

/*
- - - - - - - - - - - - - - - - - - - - - -
 Viotas Assessment
- - - - - - - - - - - - - - - - - - - - - -
 Candidate: Weverton de Souza Castanho
 Email: wevertonsc@gmail.com
 Data: 21.APRIL.2021
- - - - - - - - - - - - - - - - - - - - - -
*/

import org.springframework.data.jpa.repository.Query;
import com.viotas.server.model.Meter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeterRepository extends JpaRepository<Meter,Long>{

    static final String FIND_METER_IDS = "select distinct meter_id from meter";

    static final String FIND_METERS_LIMIT_300 = "select id, measure, meter_id, time_measure from (select id, measure, " +
            "meter_id, time_measure, row_number() over (partition by meter_id order by id desc) as row_num from meter) " +
            "temp_data where row_num between 1 and 100";

    static final String FIND_METER_ACTIVITY = "select id, measure, meter_id, time_measure from (select id, measure, " +
            "meter_id, time_measure, row_number() over (partition by meter_id order by id desc) as row_num from meter) " +
            "temp_data where row_num between 1 and 1";

    @Query(value = FIND_METER_IDS, nativeQuery = true)
    List<String> findMetersId();

    @Query(value = FIND_METERS_LIMIT_300, nativeQuery = true)
    List<Meter> findMetersLimit300();

    @Query(value = FIND_METER_ACTIVITY, nativeQuery = true)
    List<Meter> findMeterActivity();

    Meter findMeterById(Long id);

}
