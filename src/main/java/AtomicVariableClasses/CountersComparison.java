package AtomicVariableClasses;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by johnson on 4/16/15.
 */
public class CountersComparison {

    static int COUNT = 10000;
    static Logger logger = LoggerFactory.getLogger(CountersComparison.class);

    public static void main(String[] args) throws Exception {
        Counting atomicCounting = new AtomicCounting();
        Counting lockCounting = new LockCounting();
        Counting casCounting = new CASCounting();
        Counting nothingCounting = new NothingCounting();

        for (int i = 0; i < 10; i++) {
            counting(nothingCounting, 0);
        }

        long lockCountTime = counting(lockCounting, COUNT);
        long atomicCountTime = counting(atomicCounting, COUNT);
        long casCountTime = counting(casCounting, COUNT);
        logger.info("Atomic counting:\t" + atomicCountTime);
        logger.info("CAS counting:\t\t" + casCountTime);
        logger.info("Lock counting:\t" + lockCountTime);
    }

    public static long counting(Counting counting, int count) throws Exception {
        Thread thread;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            thread = new Thread(counting::addCount);
            thread.start();
            thread.join();
        }
        long time = System.currentTimeMillis() - startTime;
        Assert.assertEquals(count, counting.getCount());
        return time;
    }
}
