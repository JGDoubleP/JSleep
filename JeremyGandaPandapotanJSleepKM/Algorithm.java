package JeremyGandaPandapotanJSleepKM;
import java.util.*;

public class Algorithm {
	private Algorithm() {
		
	}
	
	public static <T> int count(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return count(iterator, pred);
    }

    public static <T> int count(T[] array, T value) {
        final Iterator<T> counter = Arrays.stream(array).iterator();
        return count(counter, value);
    }

    public static <T> int count(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> counter = iterable.iterator();
        return count(counter, pred);
    }

    public static <T> int count(T[] array, Predicate<T> pred) {
        final Iterator<T> counter = Arrays.stream(array).iterator();
        return count(counter, pred);
    }

    public static <T> int count(Iterator<T> iterator, Predicate<T> pred) {
        int count = 0;
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current))
                count = count + 1;
        }
        return count;
    }

    public static <T> int count(Iterable<T> iterable, T value) {
        final Iterator<T> counter = iterable.iterator();
        return count(counter, value);
    }

    public static <T> boolean exists(T[] array, T value) {
        final Iterator<T> counter = Arrays.stream(array).iterator();
        return exists(counter, value);
    }

    public static <T> boolean exists(Iterable<T> iterable, T value) {
        final Iterator<T> counter = iterable.iterator();
        return exists(counter, value);
    }

    public static <T> boolean exists(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return exists(iterator, pred);
    }

    public static <T> boolean exists(T[] array, Predicate<T> pred) {
        final Iterator<T> counter = Arrays.stream(array).iterator();
        return exists(counter, pred);
    }

    public static <T> boolean exists(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> counter = iterable.iterator();
        return exists(counter, pred);
    }

    public static <T> boolean exists(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T current = iterator.next();
            if(pred.predicate(current))
                return true;
        }
        return false;
    }

    public static <T> T find(T[] array, T value) {
        final Iterator<T> counter = Arrays.stream(array).iterator();
        return find(counter, value);
    }

    public static <T> T find(Iterable<T> iterable, T value) {
        final Iterator<T> counter = iterable.iterator();
        return find(counter, value);
    }

    public static <T> T find(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return find(iterator, pred);
    }

    public static <T> T find(T[] array, Predicate<T> pred) {
        final Iterator<T> counter = Arrays.stream(array).iterator();
        return find(counter, pred);
    }

    public static <T> T find(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> counter = iterable.iterator();
        return find(counter, pred);
    }

    public static <T> T find(Iterator<T> iterator, Predicate<T> pred) {
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current))
                return current;
        }
        return null;
    }
}
