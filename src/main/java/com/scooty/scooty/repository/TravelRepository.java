package com.scooty.scooty.repository;

import com.scooty.scooty.table.Travel;
import liquibase.pro.packaged.id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelRepository extends JpaRepository<Travel, id> {
    Travel getById(int id);
    Travel getByUserIdAndTravelTimeStopIsNull(int userId);
}
