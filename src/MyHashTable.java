public class MyHashTable<K, V> {

    // Inner class representing a node in the hash table
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

    private HashNode<K, V> [] chainArray;  // Array to hold the chains of nodes
    private int M = 11;  // Size of the array
    private int size;  // Number of key-value pairs in the hash table

    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }

    // Hash function to calculate the index for a given key
    private int hash(K key) {
        int hashCode = key.hashCode();
        int index = Math.abs(hashCode % M);
        return index;
    }

    // Insert a key-value pair into the hash table
    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);

        if (chainArray[index] == null) {
            // If the chain at the calculated index is empty, insert the new node as the head
            chainArray[index] = newNode;
        } else {
            HashNode<K, V> currentNode = chainArray[index];
            while (currentNode.next != null) {
                // Traverse the chain to find if the key already exists
                if (currentNode.key.equals(key)) {
                    // If the key already exists, update its value and return
                    currentNode.value = value;
                    return;
                }
                currentNode = currentNode.next;
            }
            if (currentNode.key.equals(key)) {
                // If the key already exists at the end of the chain, update its value
                currentNode.value = value;
            } else {
                // If the key doesn't exist in the chain, add the new node at the end
                currentNode.next = newNode;
            }
        }
        size++;
    }

    // Retrieve the value associated with a given key
    public V get(K key) {
        int index = hash(key);
        if (chainArray[index] != null) {
            HashNode<K, V> currentNode = chainArray[index];
            while (currentNode != null) {
                if (currentNode.key.equals(key)) {
                    // If the key is found, return its corresponding value
                    return currentNode.value;
                }
                currentNode = currentNode.next;
            }
        }
        // If the key is not found, return null
        return null;
    }

    // Remove a key-value pair from the hash table
    public V remove(K key) {
        int index = hash(key);
        if (chainArray[index] != null) {
            HashNode<K, V> previousNode = null;
            HashNode<K, V> currentNode = chainArray[index];
            while (currentNode != null) {
                if (currentNode.key.equals(key)) {
                    // If the key is found, remove the node from the chain and return its value
                    if (previousNode == null) {
                        // If the node to remove is the head of the chain
                        chainArray[index] = currentNode.next;
                    } else {                        // If the node to remove is not the head of the chain
                        previousNode.next = currentNode.next;
                    }
                    size--;
                    return currentNode.value;
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        // If the key is not found, return null
        return null;
    }

    // Check if the hash table contains a specific value
    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> currentNode = chainArray[i];
            while (currentNode != null) {
                if (currentNode.value.equals(value)) {
                    // If the value is found, return true
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        // If the value is not found, return false
        return false;
    }
    public boolean containsKey(K key){              //DEFENCE
        for(int i=0;i<M;i++){
            HashNode<K,V> node=chainArray[i];
            while (node!=null){
                if(node.key.equals(key)){
                    return true;
                }
                node=node.next;
            }
        }
        return false;
    }
    public int size(){
        return size;
    }
    // Get the key associated with a specific value
    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> currentNode = chainArray[i];
            while (currentNode != null) {
                if (currentNode.value.equals(value)) {
                    // If the value is found, return its corresponding key
                    return currentNode.key;
                }
                currentNode = currentNode.next;
            }
        }
        // If the value is not found, return null
        return null;
    }
    public int[] getBucketSizes() {
        int[] bucketSizes = new int[M];
        for (int i = 0; i < M; i++) {
            int count = 0;
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                count++;
                current = current.next;
            }
            bucketSizes[i] = count;
        }
        return bucketSizes;
    }
}

