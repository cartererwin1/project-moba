import java.util.ArrayList;
import java.util.Collection;

/**
 * The class to represent a chactacter in project-moba that will be piloted by a player
 */

public class Character  implements Runnable{
  private String playerName;   
  private String characterName;
  private int attackDamage;
  private int healthPoints;
  private int attackSpeed;
  private Ability ability1;
  private Ability ability2;
  private Ability specialAbility;
  private ArrayList<Item> items;

  public Character(String characterName, int healthPoints, int attackDamage, int attackSpeed, 
  Ability ability1, Ability ability2, Ability specialAbility) {
    //this.playerName = playerName;
    this.characterName = characterName;
    this.healthPoints = healthPoints;
    this.attackDamage = attackDamage;
    this.attackSpeed = attackSpeed;
    this.ability1 = ability1;
    this.ability2 = ability2;
    this.specialAbility = specialAbility;
    this.items = new ArrayList<>();
  }


  public void ability1(Character opponent) {
    this.ability1.cast(opponent);
  }

  public void ability2(Character opponent) {
    this.ability2.cast(opponent);
  }

  public void specialAbility(Character opponent) {
    this.specialAbility.cast(opponent);
  }


  public int basicAttack( Character opponent ) {
    try {
      // to sleep delay
      Thread.sleep(1000 * this.getAttackSpeed());
      //update character 2's HP
      opponent.takeDamage(this.attackDamage);
      //print who is attacking who
      System.out.println(this.getName() + " attacks " + opponent.getName());
    } catch (InterruptedException e) {
      // recommended because catching InterruptedException clears interrupt flag
      Thread.currentThread().interrupt();
      // you probably want to quit if the thread is interrupted
    }
    return this.attackDamage;
  }
    

  public void takeDamage(int damage){
    this.healthPoints = this.healthPoints - damage;
    //Blah blah blah
    if( healthPoints < 0){
      this.healthPoints = 0;
    }
  }


  public void buyItem(Item item) {
    this.items.add(item);
    this.applyItemAffects(item);
  }

  
  public void applyItemAffects(Item item) {
    this.attackDamage += item.getAttackDamage();
    this.attackSpeed += item.getAttackSpeed();
    this.healthPoints += item.getHealthPoints();
  }


  public void run(){
    System.out.println(this + "is running");
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }


  public int getHealthPoints(){
    return this.healthPoints;
  }


  public Collection<Item> getItems() {
    return this.items;
  }


  public int getAttackSpeed(){
    return this.attackSpeed;
  }


  public String getName(){
    return this.characterName;
  }


  public String toString() {
    String characterString = this.characterName + " HP:" + this.healthPoints + " AD:" + this.attackDamage
    +  " AS:" + this.attackSpeed + "\nitems: " + this.getItems();
    return characterString;
  }
}
