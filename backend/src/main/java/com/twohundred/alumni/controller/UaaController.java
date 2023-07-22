package com.twohundred.alumni.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twohundred.alumni.aspect.annotation.LogMe;
import com.twohundred.alumni.entity.dto.request.LoginRequest;
import com.twohundred.alumni.entity.dto.request.RegisterRequest;
import com.twohundred.alumni.entity.dto.response.LoginResponse;
import com.twohundred.alumni.service.AuthService;

import java.util.*;

@RestController
@RequestMapping("/uaa")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UaaController {

    @Autowired
    AuthService authService;

    @LogMe
    @PostMapping("/signin")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @LogMe
    @PostMapping("/signup")
    public ResponseEntity<LoginResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @GetMapping("/generateStudents")
    public void generateStudents() {
        String[] states = new String[] {"Florida", "Alabama", "Arizona", "Arkansas", "California", "Illinois", "Georgia"};
        Map<String, String[]> cities = new HashMap<>();
        cities.put("Florida", new String[] {"Miami", "Orlando", "Tampa", "Destin"});
        cities.put("Alabama", new String[] {"Montgomery", "Birmingham", "Auburn"});
        cities.put("Arizona", new String[] {"Phoenix", "Tucson"});
        cities.put("Arkansas", new String[] {"Conway", "Rogers"});
        cities.put("California", new String[] {"Los Angeles", "Mountain View", "San Fransisco"});
        cities.put("Illinois", new String[] {"Chicago", "Peoria", "Rockford"});
        cities.put("Georgia", new String[] {"Atlanta", "Savannah", "Augusta", "Athens"});
        List<String> fName = Arrays.asList("Jim", "Fred", "Baz", "Bing");
        List<String> lName = Arrays.asList("Duck", "Swan", "Cooper", "Bing");
        for(int i = 0; i<1000; i++) {
            RegisterRequest request =  new RegisterRequest();
            request.setRole("STUDENT");
            String state =  getRandom(states);
            String city = getRandom(cities.get(state));
            request.setState(state);
            request.setCity(city);
            request.setZip("" + gen());
            Collections.shuffle(fName);
            Collections.shuffle(lName);
            request.setFirstname(fName.get(0));
            request.setLastname(lName.get(0));
            request.setStreet(fName.get(0) + " 10 th Street");
            request.setPassword("p");
            request.setGpa(genGpa());
            request.setMajor(getRandom(new String[] {"MBA", "ComPro", "Vedic"}));
            request.setEmail(fName.get(0) + System.currentTimeMillis() + "@miu.edu");
            authService.register(request);
        }
    }

    public static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public static int gen() {
        Random r = new Random( System.currentTimeMillis() );
        return 10000 + r.nextInt(20000);
    }

    public static double genGpa() {
        Random r = new Random( System.currentTimeMillis() );
        return (3000 + r.nextInt(1000))/1000;
    }
}