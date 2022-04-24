package com.scooty.scooty.services;

import com.scooty.scooty.exceptions.AlreadyExistsException;
import com.scooty.scooty.model.InputUser;
import com.scooty.scooty.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UsersService usersService;

    public User registration(InputUser inputUser) throws AlreadyExistsException {
        checkUserEmail(inputUser);

        if (usersService.existDriverLicense(inputUser.getSeriesDriverLicense(), inputUser.getNumberDriverLicense())) {
            throw new AlreadyExistsException("User with this driver license already exists!");
        }

        if (usersService.existPassport(inputUser.getSeriesPassport(), inputUser.getNumberPassport())) {
            throw new AlreadyExistsException("User with this email passport exists!");
        }

       return this.usersService.add(inputUser);
    }

    public Boolean checkUserEmail(InputUser inputUser) throws AlreadyExistsException {

        if (usersService.existByEmail(inputUser.getEmail())) {
            throw new AlreadyExistsException("User with this email already exists!");
        }
        return true;
    }
}
