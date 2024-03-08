public class Ability {
    private String abilityName;
    private String message;
    public Ability(String abilityName, String message) {
        this.abilityName = abilityName;
        this.message = message;
    }
    public void cast(Character opponent) {
        System.out.println(message);
        opponent.takeDamage(40);
    }
}
