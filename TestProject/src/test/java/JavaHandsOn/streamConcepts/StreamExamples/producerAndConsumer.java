package JavaHandsOn.streamConcepts.StreamExamples;

import org.testng.annotations.Test;

public class producerAndConsumer {
    /**
     * Producer
     */
    public class Producer implements Runnable {
        private Utility utility;

        public Producer(Utility utility) {
            this.utility = utility;
            Thread producer = new Thread(this, "Producer");
            producer.start();
        }

        @Override
        public void run() {
            int i = 0;
            while (true) {
                try {
                    utility.set(i++);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public class Consumer implements Runnable {
        private Utility utility;

        public Consumer(Utility utility) {
            this.utility = utility;
            Thread consumer = new Thread(this, "consumer");
            consumer.start();
        }

        @Override
        public void run() {
            while (true) {
                try {
                    utility.get();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * utility class to wait and notify
     */
    public class Utility {
        int i;
        boolean bool = false;

        public synchronized void set(int i) throws InterruptedException {
            while (bool) {
                wait();
            }
            this.i = i;
            bool = true;
            System.out.println("Producer " + i);
            notify();
        }

        public synchronized void get() throws InterruptedException {
            while (!bool) {
                wait();
            }
            bool = false;
            System.out.println("Consumer " + i);
            notify();

        }
    }

    public void main(String[] args) {
        Utility utility = new Utility();
        new Producer(utility);
        new Consumer(utility);

    }
}
