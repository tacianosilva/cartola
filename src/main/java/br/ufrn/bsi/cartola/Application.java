package br.ufrn.bsi.cartola;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
 
=======

>>>>>>> upstream/master
import br.ufrn.bsi.cartola.service.SoccerService;
 
@SpringBootApplication
public class Application implements CommandLineRunner{
    
    @Autowired
    SoccerService soccerService;
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Override
    public void run(String... arg0) throws Exception {
        
        soccerService.addBarcelonaPlayer("Xavi Hernandez", "Midfielder", 6);
<<<<<<< HEAD
        soccerService.addBarcelonaPlayer("Wesley Safadão", "Midfielder", 2);
=======
>>>>>>> upstream/master
        
        List<String> players = soccerService.getAllTeamPlayers(1);
        
        for(String player : players) {
            System.out.println("Introducing Barca player => " + player);
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> upstream/master
