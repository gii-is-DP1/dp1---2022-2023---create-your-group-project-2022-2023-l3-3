package sevenislands.punctuation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;
import sevenislands.game.Game;
import sevenislands.model.BaseEntity;
import sevenislands.user.User;

@Getter
@Setter
@Entity
public class Punctuation extends BaseEntity{
    
    @Column(name = "punctuation", nullable = false, columnDefinition = "Integer default 0")
    private Integer punctuation;

    @ManyToOne
    private User user;

    @ManyToOne
    private Game game;

}
