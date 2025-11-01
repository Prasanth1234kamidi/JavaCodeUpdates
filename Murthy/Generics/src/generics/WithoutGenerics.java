package generics;

import java.util.ArrayList;
import java.util.List;

public class WithoutGenerics {

	public static void main(String[] args) {
		List list = new ArrayList(); 

        list.add("Hello");
        //list.add(123);  

        for (Object obj : list) {
            String str = (String) obj;   
            System.out.println(str);
        }


	}

}
