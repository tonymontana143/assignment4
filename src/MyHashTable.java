public class MyHashTable<K, V> {

    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V> [] chainArray;
    private int M=11;
    private int size;

    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }
    private int hash(K key) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode % M);
        return index;
    }

    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);
        if (chainArray[index] == null) {
            chainArray[index] = newNode;
        } else {
            HashNode<K, V> currentNode = chainArray[index];
            while (currentNode.next != null) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value;
                    return;
                }
                currentNode = currentNode.next;
            }
            if (currentNode.key.equals(key)) {
                currentNode.value = value;
            } else {
                currentNode.next = newNode;
            }
        }
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if(chainArray[index]!=null){
            HashNode<K,V> currentNode=chainArray[index];
            while(currentNode!=null){
                if(currentNode.key.equals(key)){
                    return currentNode.value;
                }
                currentNode=currentNode.next;
            }
        }
        return null;
    }
    public V remove(K key) {
        int index = hash(key);
        if(chainArray[index]!=null){
            HashNode<K,V> previousNode=null;
            HashNode<K,V> currentNode=chainArray[index];
            while(currentNode!=null){
                if(currentNode.key.equals(key)){
                    if(previousNode==null){
                        chainArray[index]=currentNode.next;
                    }
                    else{
                        previousNode.next=currentNode.next;
                        size--;
                        return currentNode.value;
                    }
                        previousNode=currentNode;
                        currentNode=currentNode.next;
                }
            }

        }
        return null;

    }

    public boolean contains(V value) {
        for(int i=0;i<M;i++){
            HashNode<K,V> currentNode=chainArray[i];
            while(currentNode!=null){
                if(currentNode.value.equals(value)){
                    return true;
                }
                currentNode=currentNode.next;
            }
        }
        return false;
    }


}