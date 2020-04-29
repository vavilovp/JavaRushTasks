package com.javarush.task.task34.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache<K, V> {
    private WeakHashMap<K, V> cache = new WeakHashMap<K, V>();   //add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //add your code here
        V returnValue;
        returnValue = cache.get(key);
        if(returnValue==null){
            Constructor constructor = clazz.getConstructor(key.getClass());
            returnValue = (V) constructor.newInstance(key);
            cache.put(key, returnValue);
        }
        return returnValue;
    }

    public boolean put(V obj) {
        //add your code here
        boolean success=true;
        K key=null;
        try {
            Method method = obj.getClass().getDeclaredMethod("getKey");
            method.setAccessible(true);
            key = (K) method.invoke(obj);
        } catch (NoSuchMethodException e) {
            //e.printStackTrace();
            success=false;
        } catch (IllegalAccessException e) {
            //e.printStackTrace();
            success=false;
        } catch (InvocationTargetException e) {
            //e.printStackTrace();
            success=false;
        }
        if(success) cache.put(key, obj);
        return success;
    }

    public int size() {
        return cache.size();
    }
}
