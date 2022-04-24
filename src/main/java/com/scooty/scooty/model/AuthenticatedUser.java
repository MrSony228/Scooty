package com.scooty.scooty.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
public class AuthenticatedUser implements Serializable {
    @Getter
    private final Integer id;
    @Getter
    private final String email;
    @Getter
    private final String firstName;
    @Getter
    private final String lastName;
}
