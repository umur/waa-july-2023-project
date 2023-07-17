package com.example.geeks.repos;

import com.example.geeks.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisementRepo extends ListCrudRepository<Advertisement, List<Advertisement>> {


    public Advertisement getAdvertisementByIdIsAndIsDeleted(Long id, boolean b);

    public List<Advertisement> getAdvertisementsByTagIsAndIsDeleted(String tag, boolean b);

    @Query(value = "SELECT * FROM alumni_db.advertisement order by date desc limit 10", nativeQuery = true)
    public List<Advertisement> getLastTen();

    public List<Advertisement> getAdvertisementsByStateIsAndIsDeleted(String state, boolean b);

    public List<Advertisement> getAdvertisementsByCityIsAndIsDeleted(String city, boolean b);

    public List<Advertisement> getAdvertisementsByCompanyNameIsAndIsDeleted(String companyName, boolean b);

    @Modifying
    @Query(value = "UPDATE `alumni_db`.`advertisement` SET `is_deleted` = true WHERE (`id` = ?);\n",
            nativeQuery = true)
    public void updateAdvertisementByIdIs(Long id);
}
