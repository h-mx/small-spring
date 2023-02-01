package com.mx.springframework.aop.aspectj;

import com.mx.springframework.aop.ClassFilter;
import com.mx.springframework.aop.MethodMatcher;
import com.mx.springframework.aop.Pointcut;
import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * Spring {@link Pointcut} 实现，它使用AspectJ编织器来计算切入点表达式。
 * <p>
 * 切点表达式
 * <p>
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/12
 */
public class AspectJExpressionPointcut implements Pointcut, ClassFilter, MethodMatcher {

    private final static Set<PointcutPrimitive> SUPPORTED_PRIMITIVES = new HashSet<>();

    private final PointcutExpression pointcutExpression;

    static {
        SUPPORTED_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
    }

    public AspectJExpressionPointcut(String expression) {
        PointcutParser pointcutParser = PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingSpecifiedClassLoaderForResolution(SUPPORTED_PRIMITIVES, this.getClass().getClassLoader());
        this.pointcutExpression = pointcutParser.parsePointcutExpression(expression);
    }

    @Override
    public boolean matches(Class<?> clazz) {
        return pointcutExpression.couldMatchJoinPointsInType(clazz);
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return pointcutExpression.matchesMethodExecution(method).alwaysMatches();
    }

    @Override
    public ClassFilter getClassFilter() {
        return this;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}
