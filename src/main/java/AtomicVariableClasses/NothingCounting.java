package AtomicVariableClasses;

/**
 * Created by johnson on 4/16/15.
 */
public class NothingCounting implements Counting{
    @Override
    public Object addCount() {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
