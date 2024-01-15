package JavaHandsOn.Design;

import java.util.*;

public class myHashSet {
    private int SIZE = 15000;

    LinkedList<Integer>[] map;

    public myHashSet() {
        map = new LinkedList[SIZE];
    }

    public void add(int key) {
        int bucket = key % SIZE;
        if (map[bucket] == null) map[bucket] = new LinkedList<>();
        /** index of method will return at what index it is present
         and if it is not present then it will return -1 */
        if (map[bucket].indexOf(key) == -1) map[bucket].add(key);
    }
    public boolean contains(int key){
        int bucket = key % SIZE;
        if(map[bucket]==null || map[bucket].indexOf(key)==-1) return false;
        return true;
    }
    public void remove(int key){
        int bucket = key % SIZE;
        if(map[bucket]==null) return;
        if(map[bucket].indexOf(key)!=-1) map[bucket].remove(map[bucket].indexOf(key));

    }

}
