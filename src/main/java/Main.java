import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InterruptedException {

        char[] chars = {'T', 'o', 'p', 'J', 'a', 'v', 'a'};
//
//        String x = new String(chars);
//        System.out.println(x);

//        String str1 = "TopJava";
//        String str2 = "Top";
//        String str3 = str2 + "Java";
//        System.out.println(str1 == str3.intern());

        String[] strings = {new String(chars), new String(chars)};
        Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);

        System.out.println("Хэш первого обьекта: " + value.get(strings[0]));
        System.out.println("Хэш второго обьекта: " + value.get(strings[1]));

        System.gc();
        Thread.sleep(100);

        System.out.println("Хэш первого обьекта: " + value.get(strings[0]));
        System.out.println("Хэш второго обьекта: " + value.get(strings[1]));

    }
}
