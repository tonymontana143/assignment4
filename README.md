# Assignment4
 **MyHashTable**
MyHashTable is a simple implementation of a hash table in Java. It supports key-value pair storage and retrieval using separate chaining to handle collisions.

**Usage**

Create an instance of MyHashTable with the desired key and value types:

  MyHashTable<KeyType, ValueType> hashTable = new MyHashTable<>();
  
**Use the following methods to interact with the hash table:**
  
  '**put(K key, V value)**': Inserts a key-value pair into the hash table. If the key already exists, the value is updated.
  
  **get(K key)**: Retrieves the value associated with the specified key. Returns null if the key is not found.

  **remove(K key)**: Removes the key-value pair associated with the specified key. Returns the value that was removed, or null if the key is not found.
  
  **contains(V value)**: Checks if the hash table contains a specific value. Returns true if the value is found, false otherwise.
  
  **getKey(V value)**: Retrieves the key associated with a specific value. Returns the key if the value is found, or null if the value is not present.

# MyTestingClass 

This Java program demonstrates the usage of `MyTestingClass` and `MyHashTable` classes. The `MyTestingClass` represents a custom class with a custom implementation of `hashCode()` and `equals()` methods. The `MyHashTable` class is a simple implementation of a hash table that uses instances of `MyTestingClass` as keys.


## Usage


 Compile the Java files:

   ```shell
   javac MyTestingClass.java
   javac MyHashTable.java

