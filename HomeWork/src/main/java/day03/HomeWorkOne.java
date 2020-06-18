package day03;

//用Java代码来编写生产者—消费者模式; wait(), notify()
public class HomeWorkOne  {


    public static void main(String[] args) {
        Food food = new Food();
        Producer p = new Producer(food);
        Consumer c = new Consumer(food);
        p.start();
        c.start();

    }

    static class Producer extends Thread {

        Food f;

        Producer(Food f) {
            this.f = f;
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                f.setValue(i);
                System.out.println("Producer put:" + i);
            }
        }
    }

    static class Consumer extends Thread {

        Food f;

        Consumer(Food f) {
            this.f = f;
        }

        public void run() {
            while (true) {
                System.out.println("Consumer get:" + f.getValue());
            }
        }
    }

}
