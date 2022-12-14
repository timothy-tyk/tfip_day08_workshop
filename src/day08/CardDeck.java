import java.security.SecureRandom;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class CardDeck {

  List<Card> deck = new LinkedList<Card>();
  public static final String[] CARD_NAME={"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
  public static final Integer[] CARD_VALUE={1,2,3,4,5,6,7,8,9,10,10,10,10};
  public CardDeck(){};  //why can't generate in the constructor?

  public List<Card> generateDeck(){
    String[] suits =new String[]{"diamonds","clubs","hearts","spades"};
    for(int j =0;j<suits.length;j++){
      for(int i=0;i<CARD_NAME.length;i++){
        Card card = new Card(suits[j], CARD_NAME[i], CARD_VALUE[i]);
        // if(card.getRank().equals("1")){
        //   card.setRank("Ace");
        // }
        // else if(card.getRank().equals("11")){
        //   card.setRank("Jack");
        //   card.setValue(10);
        // }
        // else if(card.getRank().equals("12")){
        //   card.setRank("Queen");
        //   card.setValue(10);
        // }
        // else if(card.getRank().equals("13")){
        //   card.setRank("King");
        //   card.setValue(10);
        // }
        deck.add(card);
        System.out.printf("%s of %s\n",card.getRank(), card.getSuit());
    }
    }
    return deck;
  }

  public Optional<Card> getCard(){
    //Get the top card
    if(deck.size()>0){
      Card card = deck.remove(0);
    System.out.printf("You have drawn %s of %s,%d cards left in the deck\n", card.getRank(),card.getSuit(),deck.size());
    return Optional.of(card);
    }else{
      return Optional.empty();
    }
    
  }

  public List<Card> shuffle(){
    // Collections.shuffle(deck);
    Random rnd = new SecureRandom();
    List<Card> shuffled = new LinkedList<>();
    for(int i=0;i<deck.size();i++){
      Integer idx1 = rnd.nextInt(deck.size());
      Card card0 = deck.get(i);
      Card card1 = deck.get(idx1);
      deck.set(i, card1);
      deck.set(idx1,card0); 
    }

    return shuffled;
  }


}
