package com.example.springdata1.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class WaaOffensiveWordsAspect {

    private static final List<String> OFFENSIVE_WORDS = Arrays.asList("bad", "word");

    @Around("execution(* com.example.springdata1.service.impl.*.*(..))")
    public Object filterOffensiveWords(ProceedingJoinPoint joinPoint) throws Throwable {

        Object[] args = joinPoint.getArgs();

        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof String) {
                String text = (String) args[i];
                for (String word : OFFENSIVE_WORDS) {
                    text = text.replaceAll(word, repeatAsterisks(word.length()));
                }
                args[i] = text;
            }
        }

        // Proceed with the method execution
        return joinPoint.proceed(args);
    }

    private String repeatAsterisks(int count) {
        return "*".repeat(count);
    }
}
