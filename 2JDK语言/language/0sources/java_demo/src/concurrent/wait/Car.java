package concurrent.wait;

/**
 * @author : zhenyun.su
 * @comment : polish �׹⣬wax ����
 * @since : 2019-10-25
 */

public class Car {
    private String step = "wax"; //��ǰִ�� polish �׹⣬wax ����

    public synchronized void waxed(){
        this.step= "polish";
        notifyAll();

    }
    public synchronized void polished(){
        this.step= "wax";
        notifyAll();
    }

    public synchronized  void waitForWaxing() throws InterruptedException {
        while("wax".equals(step)){
            wait();
        }
    }
    public synchronized  void waitForPolishing() throws InterruptedException {
        while("polish".equals(step)){
            wait();
        }
    }
}
