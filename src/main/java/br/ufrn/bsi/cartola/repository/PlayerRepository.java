package br.ufrn.bsi.cartola.repository;

import java.util.List;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.ufrn.bsi.cartola.model.Player;
<<<<<<< HEAD
  
=======
 
>>>>>>> upstream/master
@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
 
    List<Player> findByTeamId(long teamId);
<<<<<<< HEAD
}
=======
}
>>>>>>> upstream/master
