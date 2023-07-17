package com.example.geeks.controller;

import com.example.geeks.entity.Advertisement;
import com.example.geeks.services.AdvertisementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/advertisements")
@CrossOrigin
public class AdvertisementController {

    @Qualifier("ads")
    @Autowired
    AdvertisementService advertisementService;

    /*
    @PostMapping
    public Advertisement addAdvertisement(@RequestBody Advertisement advertisement) {
        Advertisement savedAdvertisement = advertisementService.addAdvertisement(advertisement);
        return savedAdvertisement;
    }
    */

    @GetMapping("/newest")
    public List<Advertisement> getLastTen(){
        return advertisementService.getNewTen();
    }

    @GetMapping
    public List<Advertisement> getAllAdvertisements() {
        List<Advertisement> advertisements = advertisementService.getAllAdvertisements();
        return advertisements;
    }

    @GetMapping("/{id}")
    public Advertisement getAdvertisementById(@PathVariable Long id) {
        Advertisement advertisement = advertisementService.getAdvertisementById(id);
        if (advertisement != null) {
            return advertisement;
        } else {
            return null;
        }
    }

    @GetMapping("/byCity/{city}")
    public List<Advertisement> getAdvertisementsByCity(@PathVariable String city) {
        List<Advertisement> advertisements = advertisementService.getAdvertisementsByCity(city);
        return advertisements;
    }

    @GetMapping("/byState/{state}")
    public List<Advertisement> getAdvertisementsByState(@PathVariable String state) {
        List<Advertisement> advertisements = advertisementService.getAdvertisementsByState(state);
        return advertisements;
    }

    @GetMapping("/byTag/{tag}")
    public List<Advertisement> getAdvertisementsByTag(@PathVariable String tag) {
        List<Advertisement> advertisements = advertisementService.getAdvertisementsByTag(tag);
        return advertisements;
    }

    @GetMapping("/byCompanyName/{companyName}")
    public List<Advertisement> getAdvertisementsByCompanyName(@PathVariable String companyName) {
        List<Advertisement> advertisements = advertisementService.getAdvertisementsByCompanyName(companyName);
        return advertisements;
    }

    @DeleteMapping("/{id}")
    public void getAdvertisementsByCompanyName(@PathVariable Long id) {
       advertisementService.deleteAdvertisement(id);
    }
}
