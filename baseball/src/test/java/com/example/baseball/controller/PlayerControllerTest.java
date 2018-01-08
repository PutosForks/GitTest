package com.example.baseball.controller;

import com.example.baseball.domain.Player;
import com.example.baseball.service.PlayerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 502413934 on 8.1.2018.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PlayerControllerTest {

    @Mock(name= "playerService")
    private PlayerService playerService;

    @InjectMocks
    private PlayerController playerController;

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(PlayerController.class).build();
    }

    @Test
    public void testList() throws Exception {
        List<Player> players = new ArrayList<>();
        players.add(new Player());
        players.add(new Player());

        when(playerService.findall()).thenReturn((List) players);
        mockMvc.perform(get("/players/"))
                .andExpect(status().isOk())
//                .andExpect(view().name("/players/index"))
//                .andExpect(model().attribute("players", hasSize(2)))
 ;

    }


}
