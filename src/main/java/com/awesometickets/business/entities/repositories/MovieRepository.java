package com.awesometickets.business.entities.repositories;

import com.awesometickets.business.entities.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MovieRepository extends CrudRepository<Movie, Integer> {

    //查询电影是否在售
    @Query("select m.movieId from Movie m where m.movieStatus.statusName = ?1")
    List<Integer> findByMovieStatus(String status);

    //查询首页大图
    @Query("select m.movieId, m.posterLarge from Movie m where m.posterLarge is not null AND m.posterLarge !=''")
    List<Object[]> findLargePoster();

    //根据电影ID查看详情 hibernate 的left join fetch可以取出lazy对象，当你在one-to-many的时候，设置lazy=true时，取对象的时候会使用延迟加载。但是你可以使用left join fetch强制取出lazy对象
    @Query("from Movie m " +
            "left outer join fetch m.country " +
            "left outer join fetch m.movieStatus " +
            "left outer join fetch m.movieType " +
            "left outer join fetch m.movieStyleSet " +
            "where m.movieId = ?1")
    Movie findOneWithAllDetails(Integer movieId);
}
