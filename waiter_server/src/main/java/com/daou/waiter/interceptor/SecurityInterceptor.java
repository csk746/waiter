/**
 *
 */
package com.daou.waiter.interceptor;

import com.daou.waiter.security.SpringSecurityContext;
import com.daou.waiter.security.authmap.AuthAPiMapUtil;
import com.daou.waiter.user.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by hsim on 2017. 9. 8.
 */
@Slf4j
@Component
public class SecurityInterceptor implements HandlerInterceptor {

    @Autowired
    private SpringSecurityContext securityContext;
    @Autowired
    private AuthAPiMapUtil authApiMapUtil;

    /* (non-Javadoc)
     * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (this.securityContext != null) {
            User user = this.securityContext.getUser();
            if (user == null) {
                log.info("not exist user login infomation.. but " + request.getRequestURI() + " is not add api map so, agree access api");
                return true;
            }

            boolean isAccess = this.authApiMapUtil.isUserHavedAccessAuthValue(request, user);
            if (!isAccess) {
                response.sendError(HttpStatus.UNAUTHORIZED.value());
            }
            return true;
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        if (ex != null) {
            log.info("exception : " + ex.getMessage());
        }

    }
}
