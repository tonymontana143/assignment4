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

    // Example usage of MyTestingClass with String as the value type
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
    }
}