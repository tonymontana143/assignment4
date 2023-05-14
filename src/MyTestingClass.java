import java.util.Random;

public class MyTestingClass {
    private String name;
    private int age;

    public MyTestingClass(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Custom hashCode() implementation
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + age;
        return result;
    }

    // Equals method is required to properly compare objects
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        MyTestingClass other = (MyTestingClass) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return age == other.age;
    }

    // Example usage of MyTestingClass with MyHashTable
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, String> table = new MyHashTable<>();
        Random random = new Random();

        // Add 10000 random elements to the hash table
        for (int i = 0; i < 10000; i++) {
            String name = "Name" + i;
            int age = random.nextInt(100);
            MyTestingClass key = new MyTestingClass(name, age);
            String value = "Value" + i;
            table.put(key, value);
        }

        // Print the number of elements in each bucket
        int[] bucketSizes = table.getBucketSizes();
        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i] + " elements");
        }

        // Get a value using a key
        MyTestingClass searchKey = new MyTestingClass("Name5", 20);
        String retrievedValue = table.get(searchKey);
        System.out.println("Retrieved value: " + retrievedValue);

        // Remove a key-value pair
        MyTestingClass removeKey = new MyTestingClass("Name10", 30);
        String removedValue = table.remove(removeKey);
        System.out.println("Removed value: " + removedValue);

        // Check if a value exists in the table
        boolean containsValue = table.contains("Value100");
        System.out.println("Contains value 'Value100': " + containsValue);

        // Get the key for a value
        MyTestingClass keyForValue = table.getKey("Value500");
        System.out.println("Key for value 'Value500': " + keyForValue);
    }
}
