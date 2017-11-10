package be.pxl.mdev.repository;

import be.pxl.mdev.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 11400982 on 9/11/2017.
 */
@Repository
public interface CityRepository extends JpaRepository<City, String> {
}
