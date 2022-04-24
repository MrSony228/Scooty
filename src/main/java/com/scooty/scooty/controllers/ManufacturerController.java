package com.scooty.scooty.controllers;

import com.scooty.scooty.repository.ManufacturerRepository;
import com.scooty.scooty.services.TestService;
import com.scooty.scooty.table.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ManufacturerController {
    @Autowired
    private ManufacturerRepository manufacturerRepository;
    @GetMapping(value = "/manufacturer")
    public List<Manufacturer> getManufacturer()
    {
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        return manufacturers;
    }
}
