import java.util.Random;

class NumberGenerator implements Runnable {
    private Random random = new Random();
    private SharedData sharedData;

    public NumberGenerator(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            int number = random.nextInt(100); // Generate a random integer between 0 and 99
            System.out.println("Generated number: " + number);

            sharedData.setNumber(number);

            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SquareCalculator implements Runnable {
    private SharedData sharedData;

    public SquareCalculator(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            int number = sharedData.getNumber();
            if (number % 2 == 0) {
                int square = number * number;
                System.out.println("Square: " + square);
            }

            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class CubePrinter implements Runnable {
    private SharedData sharedData;

    public CubePrinter(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (true) {
            int number = sharedData.getNumber();
            if (number % 2 != 0) {
                int cube = number * number * number;
                System.out.println("Cube: " + cube);
            }

            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SharedData {
    private int number;

    public synchronized int getNumber() {
        return number;
    }

    public synchronized void setNumber(int number) {
        this.number = number;
    }
}

public class Multithreading {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        // Create three threads
        Thread generatorThread = new Thread(new NumberGenerator(sharedData));
        Thread squareThread = new Thread(new SquareCalculator(sharedData));
        Thread cubeThread = new Thread(new CubePrinter(sharedData));

        // Start the threads
        generatorThread.start();
        squareThread.start();
        cubeThread.start();
    }
}
