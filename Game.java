import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;



/**
 * The main program of project-moba initializes the map, players, starts clock
 *
 */

public class Game {
    public static boolean areFighting = true;
    /**
     * Creates the pool of characters from the characterpool.txt file
     * @param characterPoolFile the source file containing character stats
     * @return an array containing all playable Characters
     */
    public static HashMap<String, Character> buildCharacters(File characterPoolFile) {
        Scanner sc;
        HashMap<String, Character> characters = new HashMap<>();
        try {
            sc = new Scanner(characterPoolFile);
            while(sc.hasNextLine()) {
                String[] characterData = sc.nextLine().strip().split(" ");
                Character character = new Character(characterData[0], Integer.parseInt(characterData[1]), 
                Integer.parseInt(characterData[2]),Integer.parseInt(characterData[3]));
                characters.put(characterData[0], character);
            }
            sc.close();
            return characters;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public static void simulateFight(Character character1, Character character2) {
        //implement time
        //call AA fnc on each character
        while(areFighting){
            //functions to call basic attack

            

            /*
            character1.basicAttack(character2);
            character2.basicAttack(character1);
            */

            System.out.println(character1);
            System.out.println(character2);

            

            if(character1.getHealthPoints() == 0){
                areFighting = false;
                System.out.println(character2.getName() + " has slain " + character1.getName());
            } else if(character2.getHealthPoints() == 0){
                areFighting = false;
                System.out.println(character1.getName() + " has slain " + character2.getName());
            }
        }

    }
    public static void main(String[] args) {
        File characterPoolFile = new File(args[0]);
        HashMap<String, Character> characterPool = buildCharacters(characterPoolFile);
        //
        Scanner sc = new Scanner(System.in);
        System.out.println("Player 1 select character (enter name):");
        String player1CharacterName = sc.nextLine();
        System.out.println("Player 2 select character (enter name):");
        String player2CharacterName = sc.nextLine();
        Character player1Character = characterPool.get(player1CharacterName);
        Character player2Character = characterPool.get(player2CharacterName);
        //simulateFight(player1Character, player2Character);
        MyThread player1Thread = new MyThread();
        MyThread player2Thread = new MyThread();
        
        player1Thread.run(player1Character);
        player2Thread.run(player2Character);


    }
}