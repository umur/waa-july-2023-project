package com.example.geeks.services;


import com.example.geeks.entity.Advertisement;
import com.example.geeks.repos.AdvertisementRepo;
import com.example.geeks.repos.AdvertisementRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Qualifier("ads")
@Component
public class AdvertisementService {

    private final AdvertisementRepo jaRepo;

    public Advertisement addAdvertisement(Advertisement ja){
        return jaRepo.save(ja);
    }

    public List<Advertisement> getAllAdvertisements(){
        return jaRepo.findAll();
    }
    public Advertisement getAdvertisementById(Long id){
        return jaRepo.getAdvertisementByIdIs(id);
    }

    public List<Advertisement> getAdvertisementsByCity(String city){
        return jaRepo.getAdvertisementsByCityIs(city);
    }

    public List<Advertisement> getAdvertisementsByState(String state){
        return jaRepo.getAdvertisementsByStateIs(state);
    }

    public List<Advertisement> getAdvertisementsByTag(String tag){
        return jaRepo.getAdvertisementsByTagIs(tag);
    }

    public List<Advertisement> getAdvertisementsByCompanyName(String cName){
        return jaRepo.getAdvertisementsByCompanyNameIs(cName);
    }

}
