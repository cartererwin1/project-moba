/**
 * The class to represent a chactacter in project-moba that will be piloted by a player
 */

 public class Character  implements Runnable{
    private String playerName;
    private String characterName;
    private int attackDamage;
    private int healthPoints;
    private int attackSpeed;

    public Character(String characterName, int healthPoints, int attackDamage, int attackSpeed) {
        //this.playerName = playerName;
        this.characterName = characterName;
        this.healthPoints = healthPoints;
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
    }

    public String toString() {
        return this.characterName + " HP:" + this.healthPoints + " AD:" + this.attackDamage
        +  " AS:" + this.attackSpeed;
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
    public int getAttackSpeed(){
        return this.attackSpeed;
    }
    public String getName(){
        return this.characterName;
    }

    public void takeDamage(int damage){
        this.healthPoints = this.healthPoints - damage;
        //Blah blah blah
        if( healthPoints < 0){
            this.healthPoints = 0;
        }
    }

    public int getHealthPoints(){
        return this.healthPoints;
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
}
