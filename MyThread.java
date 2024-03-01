class MyThread extends Thread {

    public void run(Character character) {
        for (int i = 0; i < 5; i++) {
            System.out.println(this.getName() + ": " + i);
            try {
                Thread.sleep(character.getAttackSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
