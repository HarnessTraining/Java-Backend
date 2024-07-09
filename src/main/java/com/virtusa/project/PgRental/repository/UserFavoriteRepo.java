package com.virtusa.project.PgRental.repository;

import com.virtusa.project.PgRental.model.User;
import com.virtusa.project.PgRental.model.UserFavorites;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFavoriteRepo extends JpaRepository<UserFavorites, Long> {

    @Modifying
    @Transactional
    @Query("DELETE FROM UserFavorites uf WHERE uf.user.id = :uid AND uf.property.id = :pid")
    void deleteByUserIdAndPropertyId(@Param("uid") Long uid, @Param("pid") Long pid);

    @Query("SELECT uf FROM UserFavorites uf WHERE uf.user.id = :uid AND uf.property.id = :pid")
    Optional<UserFavorites> findByUserIdAndPropertyId(@Param("uid") Long uid, @Param("pid") Long pid);

    @Query(value = "select * from user_favorites where user_id = :userId", nativeQuery = true)
    List<UserFavorites> findAllByUser(long userId);

    // Optional<UserFavorites> findAllByUserId(Long userId);
}
