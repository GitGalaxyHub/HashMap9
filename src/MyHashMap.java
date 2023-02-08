import static java.util.Objects.hash;

class MyHashMap <K, V> {
    private HashMap<K, V>[] table;
    private int capacity = 100;

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

    @SuppressWarnings("unchecked")
    public MyHashMap() {
        table = new HashMap[ capacity];

    }

    public void put(K newKey, V data){
        if(newKey==null)
            return;    //does not allow to store null.

        //calculate hash of key.
        int hash=hash(newKey);
        //create new entry.
        HashMap<K,V> newEntry = new HashMap<>(newKey, data, null);

        //if table location does not contain any entry, store entry there.
        if(table[hash] == null){
            table[hash] = newEntry;
        }else{
            HashMap<K,V> previous = null;
            HashMap<K,V> current = table[hash];

            while(current != null){ //we have reached last entry of bucket.
                if(current.key.equals(newKey)){
                    if(previous==null){  //node has to be insert on first of bucket.
                        newEntry.next=current.next;
                        table[hash]=newEntry;
                        return;
                    }
                    else{
                        newEntry.next=current.next;
                        previous.next=newEntry;
                        return;
                    }
                }
                previous=current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }





}

