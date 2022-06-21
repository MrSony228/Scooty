package com.scooty.scooty.repository;

import com.scooty.scooty.table.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Integer> {
    List<Transport> findAll();
    Transport findByQrCodeValue(String qrCode);
    Transport findById(int id);
}