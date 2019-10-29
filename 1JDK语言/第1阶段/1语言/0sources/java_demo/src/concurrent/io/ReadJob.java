package concurrent.io;

import java.io.IOException;
import java.io.PipedReader;

/**
 * @author : zhenyun.su
 * @comment :
 * @since : 2019-10-28
 */

public class ReadJob implements Runnable {
    private PipedReader pipedReader;

    public ReadJob(WriteJob writeJob) throws IOException {
        this.pipedReader = new PipedReader(writeJob.getPipedWriter());
    }

    @Override
    public void run() {
        try {
            while (true) {
                //pipedReader�����������ݣ���������ֱ�������ݣ��Զ�����
                System.out.println("ReadJob Read:" + (char) pipedReader.read() + ", ");
            }
        } catch (IOException ioe) {
            System.out.println("ReadJob IOException: " + ioe.getMessage());
        } catch (Exception e) {
            System.out.println("ReadJob exception:" + e.getMessage());
        }
        System.out.println("ReadJob finish");
    }
}
