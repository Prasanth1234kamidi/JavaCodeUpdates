package HiddenClasses;
import java.lang.reflect.*;

interface Hello { void greet(); }

public class hiddenclassesbefore {
    public static void main(String[] args) {
        Hello proxy = (Hello) Proxy.newProxyInstance(
            Hello.class.getClassLoader(),
            new Class[]{Hello.class},
            (obj, method, arg) -> {
                System.out.println("Hello from Old Dynamic Class");
                return null;
            }
        );

        System.out.println("Class name: " + proxy.getClass().getName());
        proxy.greet();
    }
}
