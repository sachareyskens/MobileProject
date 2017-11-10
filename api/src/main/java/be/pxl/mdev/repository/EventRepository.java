package be.pxl.mdev.repository;
import be.pxl.mdev.entity.City;
import be.pxl.mdev.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 11400982 on 9/11/2017.
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Integer>{
    @Query("from Event e where city =:city")
    List<Event> findByCity(@Param("city") City city);
}

