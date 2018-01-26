/**
 * 
 */
package com.daou.waiter.security.authmap;

import java.util.HashMap;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.daou.waiter.user.domain.User;

/**
 * Create by hsim on 2018. 1. 26.
 */
@Component
public class AuthAPiMapUtil {
	
	private HashMap<String, AuthApiMap> apiMap ; 
	
	private String getUriString(String uri){
		
		String uriStr = null;
		if ( uri.startsWith("/")) {
			uriStr = uri;
		}
		else{
			uriStr = "/" + uri;
		}
		
		if ( uriStr.endsWith("/")){
			uriStr = uriStr.substring(0, uriStr.length()-1);
		}
		
		return uriStr.replaceAll("//", "/");
	}
	
	
	@PostConstruct
	void initMap(){
		this.apiMap = new HashMap<>();
		
		AuthApiMap[] maps = AuthApiMap.values();
		
		for (AuthApiMap map : maps){
			this.apiMap.put(this.getUriString(map.getUri()), map);
		}
		
	}
	
	public AuthApiMap getMappingAuthMap(HttpServletRequest req){
		
		String uri = this.getUriString(req.getRequestURI());
		
		AuthApiMap map = this.apiMap.get(uri);
		if ( map != null) return map ;
		
		String[] uris = uri.split("/");
	
		for ( int im =1 ;im < uris.length; im ++){
			
			String tmpUri="" ; 
			for ( int is =0; is < uris.length-im; is++){
				tmpUri += "/"+ uris[is];
			}
			
			tmpUri = this.getUriString(tmpUri);
			map = this.apiMap.get(tmpUri);
			
			if ( map != null) {
				return map ; 
			}
		}
		return null ; 
		
	}
	
	public boolean isUserHavedAccessAuthValue(HttpServletRequest req, User user){
		AuthApiMap map = this.getMappingAuthMap(req);
		if ( map == null) return true ; 
		
		return (map.getAccessType() & user.getGrade()) > 0 ;
	}
	

}
