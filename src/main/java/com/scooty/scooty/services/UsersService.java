package com.scooty.scooty.services;

import com.scooty.scooty.model.InputUser;
import com.scooty.scooty.model.OutputUser;
import com.scooty.scooty.repository.UsersRepository;
import com.scooty.scooty.table.Travel;
import com.scooty.scooty.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    //Поиск по ID
    public User getById(int id) {
        return this.usersRepository.getById(id);
    }

    public User getUserByEmail(String email) {
        return this.usersRepository.getUserByEmail(email);
    }

    //Добавление
    public User add(InputUser inputUser) {
        User user = new User();
        fillUser(user, inputUser);
        return this.usersRepository.save(user);
    }

    public OutputUser getByIdOutputUser(int id) {
        User user = getById(id);
        OutputUser outputUser = new OutputUser();
        outputUser.setFirstName(user.getFirstName());
        outputUser.setMiddleName(user.getMiddleName());
        outputUser.setLastName(user.getLastName());
        outputUser.setEmail(user.getEmail());
        outputUser.setSeriesPassport(user.getSeriesPassport());
        outputUser.setNumberPassport(user.getNumberPassport());
        outputUser.setSeriesDriverLicense(user.getSeriesPassport());
        outputUser.setNumberDriverLicense(user.getNumberDriverLicense());
        outputUser.setBirthdate(user.getBirthdate());
        return outputUser;
    }

    // Проверка на дубликат E-Mail
    public Boolean existByEmail(String email) {
        return this.usersRepository.existsByEmail(email);
    }

    // Проверка на дубликат телефона
    public Boolean existByPhoneNumber(String phoneNumber) {
        return this.usersRepository.existsByPhoneNumber(phoneNumber);
    }

    // Проверка на дубликат водительского удостоверения
    public Boolean existDriverLicense(String seriesDriver, String numberDriver) {
        boolean result = this.usersRepository.existsBySeriesDriverLicenseAndNumberDriverLicense(seriesDriver, numberDriver);
        return result;
    }

    // Проверка на дубликат паспорта
    public Boolean existPassport(String seriesPassport, String numberPassport) {
        return this.usersRepository.existsBySeriesPassportAndNumberPassport(seriesPassport, numberPassport);
    }

    @Transactional
    public void edit(InputUser inputUser, int id) {
        User user = getById(id);
        fillUser(user, inputUser);
    }

    private void fillUser(User user, InputUser inputUser) {
        user.setFirstName(inputUser.getFirstName());
        user.setMiddleName(inputUser.getMiddleName());
        user.setLastName(inputUser.getLastName());
        user.setEmail(inputUser.getEmail());
        user.setPassword(inputUser.getPassword());
        user.setSeriesPassport(inputUser.getSeriesPassport());
        user.setNumberPassport(inputUser.getNumberPassport());
        user.setNumberDriverLicense(inputUser.getNumberDriverLicense());
        user.setSeriesDriverLicense(inputUser.getSeriesDriverLicense());
        user.setBirthdate(inputUser.getBirthdate());
    }

}
