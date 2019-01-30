package dagger.test.com.daggermvp.di.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * @Qualifier annotation is provided by javax inject package and is used to qualify the dependency
 * Thus @Qualifier is used to distinguish between objects of the same type but with different
 * instances. In the above code, we have ActivityContext and ApplicationContext so that the Context
 * object being injected can refer to the respectiveContext type
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityContext {
}
