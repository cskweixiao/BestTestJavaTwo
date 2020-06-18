package day03;

public class Food {

    int value;
    boolean flag = false;

    //生产者往这放它所生产的东西
    public synchronized void setValue(int i) {
        //当生产好一个往队列中放了后，放置一个标志。发个通知，告诉说生产好了，并等待消费者来拿
        if (!flag) {
            value = i;
            flag = true;
            notify();
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //消费者从这获取东西
    public synchronized int getValue() {
        //消费这先判断队列是否有东西了，有的话，就让其他线程等待，自己取拿，拿好后设置一个标志，发个通告告诉其他线程，我拿好了
        if (!flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = false;
        notify();
        return value;
    }
}
