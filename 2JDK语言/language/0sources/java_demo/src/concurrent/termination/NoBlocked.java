package concurrent.termination;

/**
 * @author : zhenyun.su
 * @comment :
 * @since : 2019-10-24
 */

public class NoBlocked implements Runnable {
    @Override
    public void run() {
        while(true)
        System.out.println("NoBlocked is Run()");
    }
}
