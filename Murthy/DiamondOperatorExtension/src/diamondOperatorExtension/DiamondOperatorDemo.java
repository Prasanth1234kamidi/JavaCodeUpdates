package diamondOperatorExtension;

import java.util.ArrayList;
import java.util.List;

public class DiamondOperatorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List<String> names = new ArrayList<>() {
            @Override
            public boolean add(String name) {
                System.out.println("Adding name: " + name);
                return super.add(name);
            }
        };

        // Adding elements
        names.add("Murthy");
        names.add("Ravi");
        names.add("Sita");

                System.out.println("Final List: " + names);


	}

}
