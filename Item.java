/**
 * Represents an item in project-moba that is able to be purchased from the item shop by characters
 *  in order to enhance their statistics
 */
public class Item {
  private String name;
  private int attackDamage;
  private int attackSpeed;
  private int healthPoints;


  public Item(String name, int attackDamage, int attackSpeed) {
      this.name = name;
      this.attackDamage = attackDamage;
      this.attackSpeed = attackSpeed;
  }
  

  public String getName() {
    return this.name;
  }
  public int getAttackDamage() {
    return this.attackDamage;
  }
  public int getAttackSpeed() {
    return this.attackSpeed;
  }
  public int getHealthPoints() {
    return this.healthPoints;
  }
  
  public String toString() {
    return this.getName();
  }
}