package AtomicVariableClasses;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by johnson on 4/16/15.
 */
public class CASCounting implements Counting {
    AtomicInteger count = new AtomicInteger(0);
    @Override
    public Object addCount() {
        int oldValue, newValue;
        do {
            oldValue = count.get();
            newValue = oldValue + 1;
        }while (!count.compareAndSet(oldValue, newValue));
        return null;
    }

    @Override
    public int getCount() {
        return count.get();
    }
}
