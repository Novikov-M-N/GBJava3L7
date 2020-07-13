import java.lang.reflect.InvocationTargetException;

public class TestLaunch {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Tester.start(Sample.class);
        Tester.start(IllegalSample.class);
    }
}
