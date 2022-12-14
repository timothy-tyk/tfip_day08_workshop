package zork;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    List<List<String>> fileText = new LinkedList<List<String>>();
    try {
      File f = new File("src/zork/zork.txt");
      BufferedReader bfr = new BufferedReader(new FileReader(f));
      String line;
      //Read text file, remove empty string lines
      List<String> roomInfo = new LinkedList<String>();
      String starting="";
      while((line=bfr.readLine())!=null){
        if(line.split(":")[0].equals("start")){
          starting=line.split(":")[1];
        }
        if(line.trim().isEmpty()){
          fileText.add(roomInfo);
          roomInfo = new LinkedList<String>();
          continue;
        }
        roomInfo.add(line);

      }
      // System.out.println(fileText);

      //Loop thru nested list
      Map<String, Room> mapOfRooms = new HashMap<String, Room>();
      for(int j=0;j<fileText.size();j++){
        
        List<String> roomInfoList = fileText.get(j);
        String room = roomInfoList.get(0).split(":")[1].trim();
        String name = roomInfoList.get(1).split(":")[1].trim();
        String description = roomInfoList.get(2).split(":")[1].replaceAll("<break>", "\n").trim();
        List<String> direction = new LinkedList<String>();
        for(int i =3;i<roomInfoList.size();i++){
          direction.add(roomInfoList.get(i));
        }
        Room zorkRoom = new Room(room, name, description, direction);
        mapOfRooms.put(room.trim(), zorkRoom);
      }
      // System.out.println(mapOfRooms.keySet());

      Console cons = System.console();
      Room currentRoom = mapOfRooms.get(starting.trim());
      System.out.println("You are in "+currentRoom.getName());
      System.out.println(currentRoom.getDescription());
      System.out.println("============");
      String input = cons.readLine(">> ");

      String[] positions = {"north","south","east","west"};

      while(Arrays.asList(positions).contains(input)){

        String nextRoom="";
        for(String d: currentRoom.getDirections()){
          if(d.contains(input)){
            nextRoom = d.split(":")[1].split(" ")[2];
          }
        }
        currentRoom = mapOfRooms.get(nextRoom);
         System.out.println("You are in "+currentRoom.getName());
         System.out.println(currentRoom.getDescription());
         //Refactor - you can go eg.(North, East)
         String availableMoves = "You can move ";
          // List<String> currentDirections=new LinkedList<String>();
          for(String d:currentRoom.getDirections()){
            String move = d.split(":")[1].trim().split(" ")[0];
            availableMoves+=String.format("%s, ", move);
          }
          System.out.println(availableMoves);
          



         
         input = cons.readLine(">> ");
      }
      System.out.println("You cannot go there.");

      
      
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
