public class GarbageCollectionExample {

        private String name;

        public GarbageCollectionExample(String name) {
            this.name = name;
            System.out.println("Object created: " + this.name);
        }

        // This method is called by the garbage collector before an object is reclaimed
        @Override
        protected void finalize() throws Throwable {
            System.out.println("Garbage collector reclaiming object: " + this.name);
            super.finalize(); // Call the superclass's finalize method
        }

        public static void main(String[] args) {
            // Create objects
            GarbageCollectionExample obj1 = new GarbageCollectionExample("Object A");
            GarbageCollectionExample obj2 = new GarbageCollectionExample("Object B");
            GarbageCollectionExample obj3 = new GarbageCollectionExample("Object C");

            // Make obj1 and obj2 eligible for garbage collection by setting their references to null
            obj1 = null;
            obj2 = null;

            // Request the JVM to run the garbage collector (not guaranteed to run immediately)
            System.gc();

            // Introduce a small delay to allow the garbage collector a chance to run
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Create another object after some objects are potentially garbage collected
            GarbageCollectionExample obj4 = new GarbageCollectionExample("Object D");
        }
    }

