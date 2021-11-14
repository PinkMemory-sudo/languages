package com.pk.reflect.dyproxy;

import javax.jws.soap.SOAPBinding;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;

public class MainTest {
//    public static void main(String[] args) {
//        InvocationHandler handler = (proxy, method, args1) -> {
//            System.out.println(method);
//            if (method.getName().equals("getAgeById")) {
//                Parameter[] parameters = method.getParameters();
//                Parameter parameter = parameters[0];
//                if (parameter.) {
//                    return 0;
//                } else {
//                    return 1;
//                }
//            }
//            return -1;
//        };
//        UserDao userDao = (UserDao) Proxy.newProxyInstance(UserDao.class.getClassLoader(), new Class[]{UserDao.class}, handler);
//        System.out.println(userDao.getAgeById("Tom"));
//    }
}
