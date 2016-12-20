package collutils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zabor on 20.12.2016.
 */
public class CollectionUtils {
    public static<T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static<T> List<T> newArrayList() {
    return new ArrayList<T>();
    }

    public static<T> int indexOf(List<? extends T> source, Object o) {
        return source.indexOf(o);
    }

    public static<T> List<T> limit(List<T> source, int size) {
        return source.subList(0,size);
    }

    public static <T>void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static<T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static<T> boolean containsAll(List<T> c1, List<T> c2) {
        return c1.containsAll(c2);
    }

    public static<T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for(Object t : c2){
            if(c1.contains(c2)){
                return true;
            }
        }
        return false;
    }

    public static <T extends Comparable<T>> List<? super T> range(List<? extends T> list, T min, T max) {
        List<? super T> result = newArrayList();
        for(T o : list)
            if ((o.compareTo(min) > 0) && (o.compareTo(max) < 0))
                result.add(o);
        return result;
    }

    public static <T>List<? super T> range(List<? extends T> list, Object min, Object max, Comparator comparator) {
        List<? super T> result = newArrayList();
        for(T o : list)
            if ((comparator.compare(o, min) > 0) && (comparator.compare(o, max) < 0))
                result.add(o);
        return result;
    }

}
