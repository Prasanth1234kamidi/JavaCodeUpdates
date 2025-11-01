package generics;

import java.util.ArrayList;
import java.util.List;

public class WithGenerics {

	public static void main(String[] args) {
        List<String> list = new ArrayList<>(); // Type-safe list

        list.add("Hello");
        list.add("Hi");
        //list.add(1234);
        

        for (String str : list) {  
            System.out.println(str);
        }


	}

}
