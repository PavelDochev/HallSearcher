package com.hallSearcher.repository;

import com.hallSearcher.entity.Hall;
import com.hallSearcher.entity.HallAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface HallRepository extends JpaRepository<Hall,Long> {

    List<Hall> findAllByAttributes(Set<HallAttribute> attributesSet);


    @Query("select h from Hall h\n" +
            "join fetch h.availabilities ha\n" +
            "join fetch h.attributes hAttr\n")
    List<Hall> findJoined();



//    @Query(value = "select h.id,h.name from halls h\n" +
//            "join halls_attributes hattr on hattr.hall_id= h.id\n" +
//            "join hall_attributes on hall_attributes.id = hattr.attribute_id\n" +
//            "join halls_availabilities ha on ha.hall_id = h.id\n" +
//            "join hall_availabilities on ha.availabilities_id = hall_availabilities.id\n" +
//            "where (:endDate < hall_availabilities.start_date or :startDate > hall_availabilities.end_date)\n" +
//            "and hall_attributes.id in :hallAttrIds\n" +
//            "and h.min_number_of_people > :numOfPpl\n" +
//            "group by h.id"
//            ,nativeQuery = true)
//    List<Object> findAllBySearchCriteria(@Param("startDate") long startDate,
//                                       @Param("endDate") long endDate,
//                                       @Param("hallAttrIds")List<Long> hallAttrIds,
//                                       @Param("numOfPpl")int minNumberOfPeople);


    @Query("select h from Hall h \n"+
            "join h.availabilities ha\n" +
            "join h.attributes hAttr\n"+
            "where (:endDate < ha.startDate or :startDate > ha.endDate)\n" +
            "and hAttr.id in :hallAttrIds\n" +
            "and h.minNumberOfPeople > :numOfPpl\n" +
            "group by h.id\n" +
            "having count(distinct hAttr.id) = :numOfAttributes")
    List<Hall> findBySearch(@Param("startDate") long startDate,
                            @Param("endDate") long endDate,
                            @Param("hallAttrIds")List<Long> hallAttrIds,
                            @Param("numOfPpl")int minNumberOfPeople,
                            @Param("numOfAttributes") long numOfAttributes);

}
