import java.util.Optional;

public class Main {
  public static void main(String[] args) {
    CardDeck cards = new CardDeck();
    cards.generateDeck();
    cards.getCard();
    cards.getCard();
    cards.getCard();

    cards.shuffle();
    cards.getCard();
    cards.getCard();

    Optional<Card> opt = cards.getCard();
    if(opt.isPresent()){
      Card c = opt.get();
      System.out.printf("Drawn: %s of %s\n",c.getRank(),c.getSuit());
    }
    opt.ifPresent(c -> System.out.printf("Drawn: %s of %s\n",c.getRank(),c.getSuit()));

  }
}
