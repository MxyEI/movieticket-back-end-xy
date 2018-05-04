package com.awesometickets.business.entities.repositories;

import com.awesometickets.business.entities.MovieOnShow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Repository
public interface MovieOnShowRepository extends CrudRepository<MovieOnShow, Integer> {

    @Query("select m from MovieOnShow m where " +
            "m.movie.movieId = ?1 AND " +
            "m.cinemaHall.cinemaHallId = ?2 AND " +
            "m.showDate = ?3 AND " +
            "m.showTime = ?4")
    List<MovieOnShow> findOne(Integer movieId, Integer cinemaHallId, Date showDate, Time showTime);

    //原生SQL：
//    select DISTINCT(c.cinema_id),m.show_date from MovieOnShow m left join CinemaHall ch on ch.cinema_hall_id=m.cinema_hall_id
//    left join cinema c on c.cinema_id=ch.cinema_id
//    left join movie mo on mo.movie_id=m.movie_id
//    where m.movie_id=1 and m.show_date in('2018-05-03')
    @Query("select DISTINCT(m.cinemaHall.cinema.cinemaId), m.showDate from MovieOnShow m where " +
            "m.movie.movieId = ?1 AND m.showDate IN (?2)")
    List<Object[]> findCinemaByDate(Integer movieId, List<Date> showDates);

    @Query("select m.movieOnShowId from MovieOnShow m where " +
            "m.movie.movieId = ?1 AND m.showDate = ?2 AND m.cinemaHall.cinema.cinemaId = ?3")
    List<Integer> findByDate(Integer movieId, Date showDate, Integer cinemaId);

    @Query("select m.price, m.showTime from MovieOnShow m where " +
            "m.movie.movieId = ?1 AND m.showDate = ?2 AND m.cinemaHall.cinema.cinemaId = ?3 " +
            "order by m.showTime asc")
    List<Object[]> findBriefByDate(Integer movieId, Date showDate, Integer cinemaId);
}
