import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;
import java.lang.reflect.Method;
import java.nio.file.*;

public class hiddenclassesafter {
    public static void main(String[] args) throws Throwable {
        Lookup lookup = MethodHandles.lookup();

        // Load real compiled bytecode from Greeter.class
        byte[] classBytes = Files.readAllBytes(Path.of("Greeter.class"));

        // Define hidden class from the bytecode
        Class<?> hidden = lookup.defineHiddenClass(classBytes, true).lookupClass();

        System.out.println("Hidden class name: " + hidden.getName());

        // Create instance and invoke method
        Object instance = hidden.getDeclaredConstructor().newInstance();
        Method method = hidden.getMethod("greet");
        method.invoke(instance);
    }
}
