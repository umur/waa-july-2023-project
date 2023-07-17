package com.example.geeks.services;


import com.example.geeks.entity.Advertisement;
import com.example.geeks.repos.AdvertisementRepo;
import com.example.geeks.repos.AdvertisementRepo;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Qualifier("ads")
@Component
@Transactional
public class AdvertisementService {

    private final AdvertisementRepo jaRepo;

    public Advertisement addAdvertisement(Advertisement ja){
        return jaRepo.save(ja);
    }

    public List<Advertisement> getAllAdvertisements(){
        return jaRepo.findAll();
    }
    public Advertisement getAdvertisementById(Long id){
        return jaRepo.getAdvertisementByIdIsAndIsDeleted(id, false);
    }

    public List<Advertisement> getAdvertisementsByCity(String city){
        return jaRepo.getAdvertisementsByCityIsAndIsDeleted(city, false);
    }

    public List<Advertisement> getAdvertisementsByState(String state){
        return jaRepo.getAdvertisementsByStateIsAndIsDeleted(state, false);
    }

    public List<Advertisement> getAdvertisementsByTag(String tag){
        return jaRepo.getAdvertisementsByTagIsAndIsDeleted(tag, false);
    }

    public List<Advertisement> getAdvertisementsByCompanyName(String cName){
        return jaRepo.getAdvertisementsByCompanyNameIsAndIsDeleted(cName, false);
    }


    public void deleteAdvertisement(Long id){
        jaRepo.updateAdvertisementByIdIs(id);
    }
}
