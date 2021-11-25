package com.pk.annotation.editlog;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记哪些字段需要记录编辑记录
 */
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldComparable {
    /**
     * 中文名称
     * 前端展示用
     *
     * @return
     */
    String zhName() default "";
}
