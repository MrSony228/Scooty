package com.scooty.scooty.repository;

import com.scooty.scooty.table.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Id> {

     List<Manufacturer> findAll();
     List<Manufacturer> findAllByTitleOrderByIdDesc(String title);

}
