package com.shrimp.pageutil;

import java.lang.reflect.Field;

/**
 * @description: 反射工具
 * @author: shrimp
 * @date: Created in 2020-01-05 17:12
 * @version: 1.0
 * @modified By:
 */
public class ReflectHelper {
	
	/**
	 * @description 获取obj对象fieldName的Field
	 * @author shrimp
	 * @date 2020-01-05 17:21
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	public static Field getFieldByFieldName(Object obj, String fieldName) {
		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				return superClass.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e) {
			}
		}
		return null;
	}

	/**
	 * @description 获取obj对象fieldName的属性值
	 * @author shrimp
	 * @date 2020-01-05 17:22
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	public static Object getValueByFieldName(Object obj, String fieldName)
			throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		Field field = getFieldByFieldName(obj, fieldName);
		Object value = null;
		if(field!=null){
			if (field.isAccessible()) {
				value = field.get(obj);
			} else {
				field.setAccessible(true);
				value = field.get(obj);
				field.setAccessible(false);
			}
		}
		return value;
	}

	/**
	 * @description 设置obj对象fieldName的属性值
	 * @author shrimp
	 * @date 2020-01-05 17:22
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	public static void setValueByFieldName(Object obj, String fieldName,
			Object value) throws SecurityException, NoSuchFieldException,
			IllegalArgumentException, IllegalAccessException {
		try{
			Field field = obj.getClass().getDeclaredField(fieldName);
			if (field.isAccessible()) {
				field.set(obj, value);
			} else {
				field.setAccessible(true);
				field.set(obj, value);
				field.setAccessible(false);
			}
		}catch(Exception err){
			//
		}
	}
}
