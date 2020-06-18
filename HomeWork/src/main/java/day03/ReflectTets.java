package day03;

import java.lang.reflect.Constructor;

public class ReflectTets {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Constructor<?>[] declaredConstructors = User.class.getConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
//            System.out.println(declaredConstructor);
        }
        User user = new User("11");
        Class<? extends User> aClass = user.getClass();
//        System.out.println(aClass.getMethod("User",String.class));
        String CLASS_NAME = "net.sxkeji.shixinandroiddemo2.test.reflection.FieldSpy";
        Class<?> c=Class.forName(CLASS_NAME);



    }
}
