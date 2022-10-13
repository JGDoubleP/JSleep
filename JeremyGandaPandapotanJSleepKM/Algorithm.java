package JeremyGandaPandapotanJSleepKM;
import java.util.*;

public class Algorithm {
	private Algorithm() {
		
	}
	
	public static <T> List<T> collect(Iterable<T> iterable, T value) {
        final Iterator<T> counter = iterable.iterator();
        return collect(counter, value);
    }
	
	public static <T> List<T> collect(Iterable<T> iterable, Predicate<T> pred) {
        final Iterator<T> counter = iterable.iterator();
        return collect(counter, pred);
    }
	
	public static <T> List<T> collect(T[] array, T value) {
        final Iterator<T> counter = Arrays.stream(array).iterator();
        return collect(counter, value);
    }
	
	public static <T> List<T> collect(Iterator<T> iterator, T value) {
        final Predicate<T> pred = value::equals;
        return collect(iterator, pred);
    }
	
	public static <T> List<T> collect(T[] array, Predicate<T> pred) {
        final Iterator<T> counter = Arrays.stream(array).iterator();
        return collect(counter, pred);
    }
	
	public static <T> List<T> collect(Iterator<T> iterator, Predicate<T> pred) {
        List<T> List = new ArrayList<T>();
		int count = 0;
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (pred.predicate(current))
                List.add(current);
        }
        return List;
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
    
    public static <T> List<T> paginate (T[] array, int page, int pageSize, Predicate<T> pred) {
    	Iterator<T> iterator = Arrays.stream(array).iterator();
    	return paginate(iterator, page, pageSize, pred);
    }
    
    public static <T> List<T> paginate (Iterator<T> iterator, int page, int pageSize, Predicate<T> pred) {
    	List<T> List = new ArrayList<T>();
    	int first = (page * pageSize) + 1;
    	int last = (first + pageSize) - 1;
    	
    	while(iterator.hasNext()) {
    		for(int i = 0 ; i < (last - first) ; i++ ) {
    			T value = iterator.next();
    			if (pred.equals(iterator)) {
    				List.add(value);
    			}
    		}
    	}
    	return List;
    }
    
    public static <T> List<T> paginate (Iterable<T> iterable, int page, int pageSize, Predicate<T> pred) {
    	Iterator<T> iterator = iterable.iterator();
    	return paginate(iterator, page, pageSize, pred);
    }
    
    
}
