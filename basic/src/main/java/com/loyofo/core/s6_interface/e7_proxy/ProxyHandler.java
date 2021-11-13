package com.loyofo.core.s6_interface.e7_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ProxyHandler implements InvocationHandler {
    private Object[] sourceArray;
    private Map<Method, Object> methodObjectMap;

    public ProxyHandler(Object[] sourceArray) {
        this.sourceArray = sourceArray;
        createMethodMap();
    }

    private void createMethodMap() {
        methodObjectMap = new HashMap<>();
        Stream.of(sourceArray).forEach(obj ->
                Stream.of(obj.getClass().getInterfaces()).forEach(c ->
                        Stream.of(c.getDeclaredMethods()).forEach(m -> methodObjectMap.put(m, obj))
                )
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("===调用处理器===" + method.getName() + ": ");
        Object sourceObj = methodObjectMap.get(method);
        return method.invoke(sourceObj, args);
    }
}
