package zork;

import java.util.List;

public class Room {
  private String room;
  private String name;
  private String description;
  private List<String> directions;

  public Room(String room, String name, String description, List<String> directions){
    this.room = room;
    this.name = name;
    this.description = description;
    this.directions = directions;
    }
  public String getRoom() {
    return room;
  }
  public String getName() {
    return name;
  }
  public String getDescription() {
    return description;
  }
  public List<String> getDirections() {
    return directions;
  }


}
