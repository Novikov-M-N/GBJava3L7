/**
 * Класс для намеренного вызова ошибок в классе Tester
 */
public class IllegalSample {

    @BeforeSuite
    public static void method1() { System.out.println("Method1"); }

    @BeforeSuite
    public static void method5() { System.out.println("Method5"); }

    @AfterSuite
    public static void method3() { System.out.println("Method3"); }

    @AfterSuite
    public static void method2() { System.out.println("Method2"); }

    @Test
    public static void method4() { System.out.println("Method4"); }

    @BeforeSuite
    public static void methodBefore() { System.out.println("MethodBefore"); }

    @AfterSuite
    public static void methodAfter() { System.out.println("MethodAfter"); }

}
