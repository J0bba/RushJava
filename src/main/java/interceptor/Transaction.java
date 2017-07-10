package interceptor;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.TYPE, ElementType.METHOD })
@InterceptorBinding
@Inherited
public @interface Transaction {
}
