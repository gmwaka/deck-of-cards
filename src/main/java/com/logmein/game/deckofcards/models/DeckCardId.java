import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DeckCardId implements Serializable{

    private Long deckId;

    private Long cardId;

}