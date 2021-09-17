package lesson8;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cache {
    CacheType cacheType() default CacheType.IN_MEMORY;
    String rootDirectory() default "...\\main\\resources";
    String fileName() default "";
    boolean doZipArchive() default true;
    Class<?>[] identityBy = new Class[2];
}
