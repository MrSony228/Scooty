package com.scooty.scooty.repository;

import com.scooty.scooty.table.ParkingPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingPlaceRepository extends JpaRepository<ParkingPlace, Integer> {

    List<ParkingPlace> findAll();
}