package com.hallSearcher.repository;

import com.hallSearcher.entity.HallAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HallAttributesRepository extends JpaRepository<HallAttribute,Long> {

}
