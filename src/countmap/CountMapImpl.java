package countmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zabor on 20.12.2016.
 */
public class CountMapImpl<T> implements CountMap<T> {

    private HashMap<T, Integer> map = new HashMap<T, Integer>();

    @Override
    public void add(T o) {
        if (map.get(o) == null) {
            map.put(o, 1);
        } else {
            map.put(o, map.get(o) + 1);
        }
    }

    @Override
    public int getCount(T o) {
        return map.get(o);
    }

    @Override
    public int remove(T o) {
        if (map.containsKey(o)) {
            return map.remove(o);
        }
        return -1;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public void addAll(CountMap<? extends T> source) {
        source.toMap().keySet().forEach(this::add);
    }

    @Override
    public Map toMap() {
        Map<? super T, Integer> newMap = new HashMap<>();
        for (T o : map.keySet()) {
            newMap.put(o, map.get(o));
        }
        return newMap;
    }

    @Override
    public void toMap(Map<? super T, Integer> destination) {
        for (T o : map.keySet())
            destination.put(o, map.get(o));
    }
}
