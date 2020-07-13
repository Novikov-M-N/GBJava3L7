import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void start(Class inputClass) throws InvocationTargetException, IllegalAccessException {
        // Ссылки для обращения в последствии к методам с аннотациями @BeforeSuite и @AfterSuite
        Method beforeMethod = null;
        Method afterMethod = null;
        // Флаги показывают, найдены ли уже методы с аннотациями @BeforeSuite и @AfterSuite
        boolean beforeMethodExist = false;
        boolean afterMethodExist = false;
        // Сначала ищем аннотации @BeforeSuite и @AfterSuite
        for (Method m: inputClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(BeforeSuite.class)) {
                // Если @BeforeSuite найдена больше одного раза, выбрасываем исключение
                if (beforeMethodExist) {
                    throw new RuntimeException("В классе " + inputClass.getName() +
                            " найдено более одной аннотации @BeforeSuite");
                }
                beforeMethod = m;
                beforeMethodExist = true;
            }
            if (m.isAnnotationPresent(AfterSuite.class)) {
                // Если @AfterSuite найдена больше одного раза, выбрасываем исключение
                if (afterMethodExist) {
                    throw new RuntimeException("В классе " + inputClass.getName() +
                            " найдено более одной аннотации @AfterSuite");
                }
                afterMethod = m;
                afterMethodExist = true;
            }
        }
        // Запускаем методы с аннотациями @BeforeSuite и @AfterSuite, если таковые найдены
        // Между ними находим и запускаем все методы с аннтацией @Test в порядке приоритета
        if (beforeMethod != null) { beforeMethod.invoke(null); }
        for (int i = 1; i <= 10; i++) {
            for (Method m: inputClass.getDeclaredMethods()) {
                if (m.isAnnotationPresent(Test.class)){
                    if (m.getAnnotation(Test.class).priority() == i) { m.invoke(null); }
                }
            }
        }
        if (afterMethod != null) { afterMethod.invoke(null); }
    }

}
