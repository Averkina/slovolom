package HungruStudent;

public class Kock implements Runnable {

    public void run() {

        while (true) {

            synchronized (HungryStudent.myFood) {

                HungryStudent.myFood.isPrepared = true;

                System.out.println("������ ������");

                HungryStudent.myFood.notifyAll();

                try {

                    HungryStudent.myFood.wait();

                } catch (InterruptedException e) {

                    e.printStackTrace(); // To change body of catch statement
                                         // use File | Settings | File
                                         // Templates.

                }

            }

        }

    }

}
