package br.ufrn.bsi.cartola.service.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.ufrn.bsi.cartola.model.Team;
import br.ufrn.bsi.cartola.repository.TeamRepository;
import br.ufrn.bsi.cartola.service.SoccerService;

@RunWith(SpringRunner.class)
@ContextConfiguration
@ComponentScan("br.ufrn.bsi.cartola")
@DataJpaTest
public class SoccerServiceTest {
    
    @Autowired
    SoccerService soccerService;

    @Autowired
    TeamRepository teamRepository;
    
    private Team barcelona;
    
    @Before
    public void setUp() throws Exception {
        barcelona = new Team();
        barcelona.setName("Barcelona FC");
        
        teamRepository.save(barcelona);
    }

    @After
    public void tearDown() throws Exception {
        teamRepository.delete(barcelona);
        barcelona = null;
    }

    @Test
    public void testGetAllTeamPlayers() {
        
        List<String> jogadores = soccerService.getAllTeamPlayers(barcelona.getId());
        
        assertNotNull("teste-01", jogadores);
        
        int tamanho = jogadores.size();
        
        assertEquals("teste-02",  0, tamanho);
        
        soccerService.addPlayer("Xuxa", "goleiro", 33, barcelona.getId());
        
        jogadores = soccerService.getAllTeamPlayers(barcelona.getId());
        int atual = jogadores.size();
        
        assertEquals("teste-02", 1, atual);

    }
}
