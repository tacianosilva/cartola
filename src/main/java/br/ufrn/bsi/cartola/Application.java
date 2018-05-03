package br.ufrn.bsi.cartola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.ufrn.bsi.cartola.model.Team;
import br.ufrn.bsi.cartola.repository.TeamRepository;
import br.ufrn.bsi.cartola.service.SoccerService;
 
@SpringBootApplication
public class Application implements CommandLineRunner{
    
    @Autowired
    SoccerService soccerService;
    
    @Autowired
    TeamRepository teamRepository;
    
    private Team barcelona;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Override
    public void run(String... arg0) throws Exception {
        
        barcelona = new Team();
        barcelona.setName("Barcelona FC");
        
        teamRepository.save(barcelona);
        
        soccerService.addPlayer("Xavi Hernandez", "Midfielder", 6, barcelona.getId());
        
        List<String> players = soccerService.getAllTeamPlayers(barcelona.getId());
        
        for(String player : players) {
            System.out.println("Introducing Barca player => " + player);
        }
    }
}
