package reflection;

import annotation.PatternRole;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class ReflectionInspector {

    public record ClassReport(String className, List<String> fieldNames,
                              List<String> methodNames, boolean allFieldsEncapsulated) {}

    public ClassReport inspect(Class<?> target) {
        List<String> fieldNames = new ArrayList<>();
        boolean allEncapsulated = true;
        for (Field f : target.getDeclaredFields()) {
            fieldNames.add(f.getName());
            boolean isPublic = Modifier.isPublic(f.getModifiers());
            boolean isFinal = Modifier.isFinal(f.getModifiers());
            if (isPublic && !isFinal) allEncapsulated = false;
        }
        List<String> methodNames = new ArrayList<>();
        for (Method m : target.getDeclaredMethods()) {
            if (Modifier.isPublic(m.getModifiers())) methodNames.add(m.getName());
        }
        return new ClassReport(target.getSimpleName(), fieldNames, methodNames, allEncapsulated);
    }

    public String describePatternRole(Class<?> target) {
        PatternRole role = target.getAnnotation(PatternRole.class);
        if (role == null) return null;
        return target.getSimpleName() + " -> pattern=" + role.pattern() + ", role=" + role.role();
    }

    public boolean implementsInterface(Object instance, Class<?> expectedInterface) {
        return expectedInterface.isAssignableFrom(instance.getClass());
    }
}
