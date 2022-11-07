package org.springframework.samples.sevenislands.lobby.lobbyExceptions;

import lombok.Getter;

@Getter
public class noExistPlayerException extends Exception{
    private String message = "El player especificado no forma parte del lobby";
}
