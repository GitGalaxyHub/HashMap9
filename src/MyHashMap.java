import java.util.HashMap;

import static java.util.Objects.hash;

class MyHashMap <K, V> {
    private HashMap<K, V>[] table;
    private int capacity = 4;

    static class HashMap<K, V> {
        K key;
        V value;
        HashMap<K, V> next;

        public HashMap(K key, V value, HashMap<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

    }

    public void clear() {
        int modCount = 0;
        modCount++;
        HashMap[] tab = table;
        for (int i = 0; i < tab.length; i++)
            tab[i] = null;
        capacity = 0;
    }

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new HashMap[capacity];

    }

    public void put(K newKey, V data) {
        if (newKey == null)
            return;    //does not allow to store null.

        //calculate hash of key.
        int hash = hash(newKey) % capacity;
        //create new entry.
        HashMap<K, V> newEntry = new HashMap<>(newKey, data, null);

        //if table location does not contain any entry, store entry there.
        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            HashMap<K, V> previous = null;
            HashMap<K, V> current = table[hash];

            while (current != null) { //we have reached last entry of bucket.
                if (current.key.equals(newKey)) {
                    if (previous == null) {  //node has to be insert on first of bucket.
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }

    public boolean remove(K deleteKey) {

        int hash = hash(deleteKey) % capacity;

        if (table[hash] == null) {
            return false;
        } else {
            HashMap<K, V> previous = null;
            HashMap<K, V> current = table[hash];

            while (current != null) { //we have reached last entry node of bucket.
                if (current.key.equals(deleteKey)) {
                    if (previous == null) {  //delete first entry node.
                        table[hash] = table[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

    }


   public V get(K key) {
        int hash = hash(key) % capacity;
        if (table[hash] == null) {
            return null;
        } else {
            HashMap<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next; //return value corresponding to key.
            }
            return null;   //returns null if key is not found.
        }
    }
    public int size() {
        return capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                HashMap<K, V> entry = table[i];
                while (entry != null) {
                    sb.append(entry.key + "=" + entry.value + " ");
                    entry = entry.next;
                }
            }
        }
        return sb.toString();
    }
}
