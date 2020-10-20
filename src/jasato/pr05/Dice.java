package jasato.pr05;

import java.util.Random;

public class Dice implements Runnable {

    public static volatile int[] diceRolls = new int[6];
    public static int totalThrows;
    protected final int numThrows = 100000;
    Random random = new Random();
    private Object[] bloqueador = new Object[6];
    private final Object bloqueadorTotalThrows = new Object();

    public Dice () {
        for (int i = 0; i < bloqueador.length; i++) {
            bloqueador[i] = new Object();
        }

    }


    @Override
    public synchronized void run() {
        int result;
        for (int i = 0; i < numThrows; i++) {

            result = random.nextInt(6) + 1;
            switch (result) {
                case 1:
                    synchronized (bloqueador[0]) {
                        diceRolls[0] += 1;
                    }
                    break;
                case 2:
                    synchronized (bloqueador[1]) {
                        diceRolls[1] += 1;
                    }
                    break;
                case 3:
                    synchronized (bloqueador[2]) {
                        diceRolls[2] += 1;
                    }
                    break;
                case 4:
                    synchronized (bloqueador[3]) {
                        diceRolls[3] += 1;
                    }
                    break;
                case 5:
                    synchronized (bloqueador[4]) {
                        diceRolls[4] += 1;
                    }
                    break;
                case 6:
                    synchronized (bloqueador[5]) {
                        diceRolls[5] += 1;
                    }
                    break;

            }
            synchronized (bloqueadorTotalThrows) {
                totalThrows++;
            }

 
        }
    }

    public int[] getDiceRolls() {
        return diceRolls;
    }

    public int getTotalThrows() {
        return totalThrows;
    }
}
