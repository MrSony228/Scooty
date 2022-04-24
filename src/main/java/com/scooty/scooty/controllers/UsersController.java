package com.scooty.scooty.controllers;

import com.scooty.scooty.controllers.model.NetworkAnswer;
import com.scooty.scooty.exceptions.AlreadyExistsException;
import com.scooty.scooty.model.InputUser;
import com.scooty.scooty.model.OutputUser;
import com.scooty.scooty.services.EmailAuthenticationProvider;
import com.scooty.scooty.services.RegistrationService;
import com.scooty.scooty.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersController extends BaseRestController {

    private final UsersService usersService;

    private final RegistrationService registrationService;


    @PostMapping("/registration")
    public void register(@RequestBody InputUser inputUser){
        try {
            registrationService.registration(inputUser);
        } catch (AlreadyExistsException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }
    }

    @GetMapping("{id}")
    public OutputUser getUser(@PathVariable int id) {
        return this.usersService.getByIdOutputUser(id);
    }

    @GetMapping("/check-exists")
    public NetworkAnswer<Boolean> checkEmail(@RequestParam(name = "email") String email) {
        return new NetworkAnswer<>(this.usersService.existByEmail(email));
    }

    @PutMapping("{id}")
    public void edit(@RequestBody InputUser inputUser, @PathVariable int id){
        usersService.edit(inputUser, id);
    }

}
