package JavaHandsOn.Design;

import io.cucumber.java.af.En;

import java.util.LinkedList;

public class myhashMap {


    /**
     * if we found 1005 %5 = 5
     * and 2005 % 5 =5
     * so collison happened we will solve using chaining using linkedlist
     * <p>
     * in place of put if we reached the index and there we found at the indexth place it is empty,
     * then simply put new entry else keep searching till the list ends and if you reached till end and found
     * there is no key you found then simply add entry in the last
     */
    LinkedList<Entry>[] map;
    public static int SIZE = 789;

    public myhashMap() {
        map = new LinkedList[SIZE];
    }

    public void put(int key, int value) {
        int bucket = key % SIZE;
        LinkedList<Entry> entries = map[bucket];
        /** if entries is null means we dont have this entry then add brand new entry*/
        if (entries == null) {
            map[bucket] = new LinkedList<>();
            map[bucket].add(new Entry(key, value));
        }
        /** if we found the key means we have to update the value at a respective key
         * if we keep on going till last element of linked list. We did not find then we simply add
         * the element in the last of the linked list**/

        else {
            for (Entry entry : entries) {
                if (entry.key == key) {
                    entry.value = value;
                    return; /** here we will not use break as we dont want to go further if we found our key*/
                }
            }
            entries.add(new Entry(key, value));
        }
    }

    public void remove(int key) {
        int bucket = key % SIZE;
        Entry toRemove = null; // here we will save entry itself to remove
        LinkedList<Entry> entries = map[bucket];
        if (entries == null) return;
        for (Entry entry : entries) {
            if (entry.key == key) toRemove = entry;
        }
        if (toRemove != null) map[bucket].remove(toRemove); // here we will remove the entry itself if it is not null
        else return;
    }

    public int get(int key) {
        int bucket = key % SIZE;
        LinkedList<Entry> entries = map[bucket];
        if (entries == null) return -1;
        for (Entry entry : entries) {
            if (entry.key == key) return entry.value;
        }
        return -1;
    }


}

class Entry {
    int key;
    int value;

    Entry(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
