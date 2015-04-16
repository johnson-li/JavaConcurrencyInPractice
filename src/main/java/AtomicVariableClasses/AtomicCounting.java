package AtomicVariableClasses;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by johnson on 4/16/15.
 */
public class AtomicCounting implements Counting{
    AtomicInteger count = new AtomicInteger(0);

    @Override
    public Object addCount() {
        count.incrementAndGet();
        return null;
    }

    @Override
    public int getCount() {
        return count.get();
    }
}
