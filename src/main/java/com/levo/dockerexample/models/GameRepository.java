package com.levo.dockerexample.models;

import com.levo.dockerexample.models.GameEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface GameRepository extends JpaRepository<GameEntities, Integer> {
}