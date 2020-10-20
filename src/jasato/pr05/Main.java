package jasato.pr05;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        Thread[] diceRoller = new Thread[10];
        Dice dice = new Dice();

        for (int i = diceRoller.length - 1; i >= 0; i--) {
            diceRoller[i] = new Thread(dice);
        }

        for (Thread thread : diceRoller) {
            thread.start();
        }

        for (Thread thread : diceRoller) {
            thread.join();
        }

        int num = 1;
        int sum = 0;


        StringBuilder totalRolls = new StringBuilder("Total de veces: ");

        for (int i : dice.getDiceRolls()) {
            System.out.printf("Cara %d: %d veces\n", num, i);
            if (num == dice.getDiceRolls().length) {
                totalRolls.append(i).append(" ");
            } else {
                totalRolls.append(i).append(" + ");
            }

            sum += i;
            num++;
        }
        totalRolls.append("= ").append(sum);
        System.out.println(totalRolls);


    }
}
