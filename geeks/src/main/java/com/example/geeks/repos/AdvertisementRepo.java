package com.example.geeks.repos;

import com.example.geeks.entity.Advertisement;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface AdvertisementRepo extends ListCrudRepository<Advertisement, List<Advertisement>> {


    public Advertisement getAdvertisementByIdIs(Long id);

    public List<Advertisement> getAdvertisementsByTagIs(String tag);

    public List<Advertisement> getAdvertisementsByStateIs(String state);

    public List<Advertisement> getAdvertisementsByCityIs(String city);

    public List<Advertisement> getAdvertisementsByCompanyNameIs(String companyName);
}
