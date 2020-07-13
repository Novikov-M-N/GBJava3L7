/**
 * Методы 1-3 имеют приоритет в соответствии с их нумерацией
 * Метод 5 имеет приоритет 10
 * Для метода 4 приоритет не указан, по умолчанию используется значение 10
 * Порядок запуска методов: Before -> 1 -> 2 -> 3 -> 4 или 5 в случайном порядке -> After
 */
public class Sample {

    @Test(priority = 1)
    public static void method1() { System.out.println("Method1"); }

    @Test(priority = 10)
    public static void method5() { System.out.println("Method5"); }

    @Test(priority = 3)
    public static void method3() { System.out.println("Method3"); }

    @Test(priority = 2)
    public static void method2() { System.out.println("Method2"); }

    @Test
    public static void method4() { System.out.println("Method4"); }

    @BeforeSuite
    public static void methodBefore() { System.out.println("MethodBefore"); }

    @AfterSuite
    public static void methodAfter() { System.out.println("MethodAfter"); }

}
