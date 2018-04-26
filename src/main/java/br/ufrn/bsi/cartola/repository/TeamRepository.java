package br.ufrn.bsi.cartola.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.bsi.cartola.model.Team;
 
@Repository
public interface TeamRepository extends CrudRepository<Team, Long> {
 
    Team findByPlayers(long playerId);
}
