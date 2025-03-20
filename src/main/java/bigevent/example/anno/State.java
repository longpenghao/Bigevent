package bigevent.example.anno;

import bigevent.example.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented // 元注解
// 元注解，标明下面的注解可以用到什么类型的数据上
@Target(FIELD)
// 元注解，标明下面的注解什么时候运行
@Retention(RUNTIME)
// 指定提供校验规则的类
@Constraint(
        validatedBy = {StateValidation.class}
)

public @interface State {

    // 提供校验失败后的提示信息
    String message() default "state参数的值只能是已发布或者草稿";
    // 指定分组
    Class<?>[] groups() default {};
    // 指定负载，获取到State注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
