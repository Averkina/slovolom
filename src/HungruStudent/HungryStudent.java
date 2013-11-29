package HungruStudent;

public class HungryStudent implements Runnable {

    public static Food myFood = new Food();

    public void run() {

        while (true) {

            synchronized (myFood) {

                try {

                    myFood.notifyAll();

                    HungryStudent.myFood.wait();

                    myFood.isPrepared = false;

                    System.out.println("Студент поел");

                } catch (InterruptedException e) {

                    e.printStackTrace();

                }

            }

        }

    }

    public static void main(String[] args) {

        new Thread(new HungryStudent()).start();

        new Thread(new Kock()).start();

    }

}
