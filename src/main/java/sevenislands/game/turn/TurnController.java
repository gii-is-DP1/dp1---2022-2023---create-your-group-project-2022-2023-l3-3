package sevenislands.game.turn;

import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import sevenislands.player.Player;
import sevenislands.player.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TurnController {

    private static final String VIEWS_GAME = "game/game"; // vista pasiva del juego

    private final TurnService turnService;
    private final PlayerService playerService;

    @Autowired
    public TurnController(TurnService turnService, PlayerService playerService) {
        this.turnService = turnService;
        this.playerService = playerService;
    }

    @GetMapping("/turn")
    public String gameTurn(Principal principal) { // vista del botón rojo
        return VIEWS_GAME;
    }

    @GetMapping("/turn/asignTurn")
    public String gameAsignTurn(Principal principal) { // ordenación de jugadores según botón rojo
        Player player = playerService.findPlayer(principal.getName());
        Turn turn = new Turn();
        turn.setTimePress(LocalDateTime.now());
        turn.setPlayer(player);
        turnService.save(turn);

        return "redirect:/turn";

    }

}
