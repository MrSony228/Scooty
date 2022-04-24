package com.scooty.scooty.repository;

import com.scooty.scooty.table.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {

    Boolean existsByEmail(String email);
    Boolean existsByPhoneNumber(String phoneNumber);
    Boolean existsBySeriesDriverLicenseAndNumberDriverLicense(String seriesDriveLicense, String numberDriveLicense);
    Boolean existsBySeriesPassportAndNumberPassport(String seriesPassport, String  numberPassport);
    User getUserByEmail(String email);

}