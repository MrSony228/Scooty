package com.scooty.scooty.services;

import com.scooty.scooty.repository.ManufacturerRepository;
import com.scooty.scooty.table.Manufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;


@Service
public class TestService {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @PostConstruct
    private void test() {
        System.out.println("Startup!");
        List<Manufacturer> manufacturers = manufacturerRepository.findAllByTitleOrderByIdDesc("Xiaomi");
        manufacturers.forEach(System.out::println);
    }

}
