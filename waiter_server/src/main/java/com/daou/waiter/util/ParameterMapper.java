package com.daou.waiter.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.NativeWebRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParameterMapper {
	
	private static String getSetMethodName(String name){
		return "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
	}
	
	public static Object RequestParamaterToObject(NativeWebRequest  req, Class<?> c){
		return RequestParamaterToObject(req, c, "UTF-8");
	}
	
	public static Object RequestParamaterToObject(NativeWebRequest  req, Class<?> c, String charset){
		
		HttpServletRequest request = (HttpServletRequest) req.getNativeRequest();
		
		Map<String, String> map = new HashMap<>();
		
		String query = request.getQueryString() ; 
		
		String[] params = query.split("&");
		
		for ( String param : params){
			if ( param == null || param.indexOf("=") < 0 ) continue ; 
			String pv[] = param.split("=");
			if ( pv.length != 2) continue ; 
			
			try {
				map.put(pv[0], URLDecoder.decode(pv[1], charset) );
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return MapToObject(map, c);
		
	}
	
	public static Method findMethod(Class<?> c , String methodName){
		for ( Method m :  c.getMethods()){
			//if ( !m.getName().equals(methodName)) continue ; 
			if ( !m.getName().equalsIgnoreCase(methodName)) continue ; 
			if  (m.getParameterCount() != 1) continue ; 
			return m; 
		}
		
		return null ; 
	}
	
	public static Object castValue(Class<?> castType, String value){

		try{
			if ( castType == String.class){
				return value ; 
			}
			else if ( castType == Integer.class  || castType == int.class ){
				return Integer.parseInt(value);
			}
			else if ( castType == Long.class || castType == long.class){
				return Long.parseLong(value);
			}
			else if ( castType == Double.class || castType == double.class){
				return Double.parseDouble(value);
			}
			else if ( castType == Float.class || castType == float.class){
				return Float.parseFloat(value);
			}
			else{
				System.out.println("invalid castType : " + castType);
				return null; 
			}
		}catch(NumberFormatException e){
			log.info("value : " + value + " is invalid value, setter parameter type is  : " + castType);
			return null ; 
		}
	}
	
	public static Object MapToObject(Map<String, String> map , Class<?> c){
		
		Method m = null ; 
		Object obj = null ;
		
		try {
			obj = c.newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		for ( Map.Entry<String, String> entry : map.entrySet()){
			
			if ( entry.getValue() == null || entry.getValue().trim().isEmpty()){
				continue ; 
			}
			
			if ( entry.getValue().equalsIgnoreCase("undefined")) continue ; 
			
			try {
				m = findMethod(c, getSetMethodName(entry.getKey()));
				if ( m == null){
					log.info("not found mapping method : " + entry.getKey());
					continue ; 
				}
				
				try {
					m.invoke(obj, castValue(m.getParameterTypes()[0], entry.getValue()));
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}  catch (SecurityException e) {
				e.printStackTrace();
			}
			
			
		}
		
		return obj ; 
		
	}

}
