/**
 *
 * @author Ashton Hoeft
 * @version January 31, 2023
 * 
 * This class checks to make sure the methods of ArrayBag, LinkedBag,
 * Bag, and Player work correctly.
 * 
 */
public class Client {
    public static void main(String[] args) {
        //Declare ArrayBag mensTeam and add 8 players to it
        ArrayBag mensTeam = new ArrayBag(2);
        mensTeam.add(new Player("Cam Miller", "Quarterback", 7));
        mensTeam.add(new Player("Zach Mathis", "Wide Reciever", 0));
        mensTeam.add(new Player("Courtney Eubanks", "Cornerback", 1));
        mensTeam.add(new Player("Kaden Zenzen", "Tight End", 40));
        mensTeam.add(new Player("Hunter Luepke", "Fullback", 44));
        mensTeam.add(new Player("Jenaro Ocama", "CornerBack", 24));
        mensTeam.add(new Player("James Kaczor", "Linebacker", 26));
        mensTeam.add(new Player("Brandon Westberg", "Center", 77));
        
        //Print the contents of mensTeam
        System.out.println(mensTeam.toString() + "\n");
        
        //Remove a random player from mensTeam and print the updated contents
        mensTeam.remove();
        System.out.println(mensTeam.toString() +"\n");
        
        //Get player that is 5th in the bag and add a new player
        System.out.println("Player in the 5th place in bag is " + mensTeam.get(4) + "\n");
        mensTeam.add(new Player("Eli Green", "Wide Receiver", 86));
        System.out.println(mensTeam.toString() + "\n");
        
        //Remove 5th player in the bag and print updated contents of bag
        mensTeam.remove(mensTeam.get(4));
        System.out.println(mensTeam.toString() + "\n");
        
        //Declare ArrayBag courses and add all of my courses to it
        ArrayBag courses = new ArrayBag();
        courses.add("CSCI 161");
        courses.add("CSCI 222");
        courses.add("ENGR 312");
        courses.add("MATH 265");
        courses.add("MUSC 108");
        courses.add("MUSC 112");
        courses.add("PSYC 111");
        //Print courses content, remove a random course, and print updated contents
        
        System.out.println(courses.toString() + "\n");
        System.out.println(courses.remove() + " was removed\n");
        System.out.println(courses.toString() + "\n");
        
        //Declare LinkedBag womensTeam andadd 8 players to it
        LinkedBag womensTeam = new LinkedBag(2);
        womensTeam.add(new Player("Abbie Draper", "Forward", 2));
        womensTeam.add(new Player("Leah Mackenzie", "Guard", 3));
        womensTeam.add(new Player("Marwa Bedziri", "Forward", 5));
        womensTeam.add(new Player("Heaven Hamling", "Guard", 11));
        womensTeam.add(new Player("Emily Behnke", "Forward", 20));
        womensTeam.add(new Player("Elle Evans", "Guard", 21));
        womensTeam.add(new Player("Abby Schulte", "Guard", 24));
        womensTeam.add(new Player("Sophie Olsen", "Guard", 32));
        
        //Print contents of womensTeam
        System.out.println(womensTeam.toString() + "\n");
        
        //Remove a random player and print updated contents
        womensTeam.remove();
        System.out.println(womensTeam.toString() + "\n");
        
        //Get 5th player in womensTeam, add a new player, and print updated contents
        System.out.println("Player in the 5th place in bag is " + womensTeam.get(5) + "\n");
        womensTeam.add(new Player("Katie Hildebrandt", "Forward", 33));
        System.out.println(womensTeam.toString() + "\n");
        
        //Remove 5th player and print updated contents
        womensTeam.remove(womensTeam.get(5));
        System.out.println(womensTeam.toString() + "\n");
    }
}