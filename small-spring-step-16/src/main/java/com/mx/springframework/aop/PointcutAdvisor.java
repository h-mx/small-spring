package com.mx.springframework.aop;

/**
 * 由切入点驱动的所有advisor的超接口。这几乎涵盖了所有的advisors ，除了引入advisors，其中方法级匹配不适用。
 * <p>
 * PointcutAdvisor 承担了 Pointcut 和 Advice 的组合，Pointcut 用于获取 JoinPoint，而 Advice 决定于 JoinPoint 执行什么操作。
 *
 * @author Hu-Mingxing
 * @version 1.0
 * @date 2023/1/13
 */
public interface PointcutAdvisor extends Advisor{

    /**
     * 获取驱动该Advisor的切入点。
     */
    Pointcut getPointcut();
}
