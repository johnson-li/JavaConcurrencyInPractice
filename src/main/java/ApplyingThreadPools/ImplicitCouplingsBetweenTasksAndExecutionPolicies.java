package ApplyingThreadPools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.concurrent.*;

/**
 * Created by johnson on 4/9/15.
 */
public class ImplicitCouplingsBetweenTasksAndExecutionPolicies {
    static Logger logger = LoggerFactory.getLogger(ImplicitCouplingsBetweenTasksAndExecutionPolicies.class);
    public static void main(String[] args) throws Exception{
        deadlockInSingleThreadedExecutor();
    }

    public static void deadlockInSingleThreadedExecutor() throws Exception{
        ExecutorService service = Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Future<String> header, footer;
        header = service.submit(() -> "header");
        footer = service.submit(() -> "footer");
        logger.info(header.get() + " " + footer.get());
    }


}
