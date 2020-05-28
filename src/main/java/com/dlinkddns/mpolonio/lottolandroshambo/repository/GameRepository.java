package com.dlinkddns.mpolonio.lottolandroshambo.repository;

import com.dlinkddns.mpolonio.lottolandroshambo.model.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
}
