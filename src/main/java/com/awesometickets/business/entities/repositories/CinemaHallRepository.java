package com.awesometickets.business.entities.repositories;

import com.awesometickets.business.entities.CinemaHall;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaHallRepository extends CrudRepository<CinemaHall, Integer> {

    //根据影院查询影厅名字
	@Query("select c.cinemaHallId, c.cinema.cinemaId, c.hallName from CinemaHall c where c.cinemaHallId = ?1")
    List<Object[]> findWithoutSeatLayout(Integer cinemaHallId);

    //根据影院查询座位布局
    @Query("select c.cinemaHallId, c.seatLayout from CinemaHall c where c.cinemaHallId = ?1")
    List<Object[]> findWithSeatLayout(Integer cinemaHallId);

}
