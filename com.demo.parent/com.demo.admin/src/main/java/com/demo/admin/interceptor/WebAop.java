package com.demo.admin.interceptor;

import com.google.common.base.Stopwatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * WebAop
 *
 * @author ybtccc ,2019/3/20
 */
@Component
@Aspect
public class WebAop {
    private static Logger logger = LoggerFactory.getLogger(WebAop.class);

    @Around(value = "@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object time(ProceedingJoinPoint pjp) throws Throwable {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Object o = pjp.proceed();
        logger.info("接口 {} 耗时{} ms", pjp.getSignature().getName(), stopwatch.elapsed(TimeUnit.MILLISECONDS));
        return o;
    }

}
