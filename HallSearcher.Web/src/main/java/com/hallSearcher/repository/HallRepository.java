package com.hallSearcher.repository;

import com.hallSearcher.entity.Hall;
import com.hallSearcher.entity.HallAttribute;
import com.hallSearcher.model.HallSearchViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Repository
public interface HallRepository extends JpaRepository<Hall,Long> {

    List<Hall> findAllByAttributes(Set<HallAttribute> attributesSet);

    List<Hall> findAllByAvailabilitiesStartDateLessThan(Date startDate,Date endDate,Set<HallAttribute> hallAttributes,int minNumberOfPeople);

//    select halls.name,hall_availabilities.start_date,hall_availabilities.end_date from halls
//    join halls_availabilities ha on ha.hall_id = halls.id
//    join hall_availabilities on ha.availabilities_id = hall_availabilities.id
//    where not ('3918-04-02 19:00:00' > start_date or '3918-04-02 17:00:00' > end_date)

}
