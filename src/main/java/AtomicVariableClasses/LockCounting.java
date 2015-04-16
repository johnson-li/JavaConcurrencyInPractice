package AtomicVariableClasses;

/**
 * Created by johnson on 4/16/15.
 */
public class LockCounting implements Counting{
    Integer amount = 0;

    @Override
    public synchronized Object addCount() {
        amount++;
        return null;
    }

    @Override
    public synchronized int getCount() {
        return this.amount;
    }
}
