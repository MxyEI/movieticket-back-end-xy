package com.awesometickets.business.entities.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.awesometickets.business.entities.Cinema;

import java.util.List;


@Repository
public interface CinemaRepository extends CrudRepository<Cinema, Integer> {

    //根据影院名搜索
    @Query("select c.cinemaId, c.cinemaName, c.cinemaAddr from Cinema c where c.cinemaName like %"+"?1"+"%")
    List getCinemaByName(String cinemaName);
}
