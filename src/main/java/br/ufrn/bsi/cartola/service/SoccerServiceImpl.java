package br.ufrn.bsi.cartola.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufrn.bsi.cartola.model.Player;
import br.ufrn.bsi.cartola.model.Team;
import br.ufrn.bsi.cartola.repository.PlayerRepository;
import br.ufrn.bsi.cartola.repository.TeamRepository;
 
@Service
public class SoccerServiceImpl implements SoccerService {
 
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;
 
    public List<String> getAllTeamPlayers(long teamId) {

        List<String> result = new ArrayList<String>();
        
        List<Player> players = playerRepository.findByTeamId(teamId);

        for (Player player : players) {
            result.add(player.getName());
        }
 
        return result;
    }
 
    public void addPlayer(String name, String position, int number, Long team) {
        
        Team barcelona = teamRepository.findOne(team);
        
        Player newPlayer = new Player();
        newPlayer.setName(name);
        newPlayer.setPosition(position);
        newPlayer.setNum(number);
        newPlayer.setTeam(barcelona);

        playerRepository.save(newPlayer);
    }
}