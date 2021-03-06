package com.daou.waiter.security.account;

import com.daou.waiter.user.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;


public class AccountUserDetails implements UserDetails {

    private static final long serialVersionUID = 1L;

    private User user;
    private int grade;
    private String token;

    public AccountUserDetails(User account) {
        this.user = account;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("USER" + user));
    }

    public String getUserId() {
        return this.user.getLoginId();
    }

    public Long getId() {
        return this.user.getId();
    }

    public String getPassword() {
        return this.user.getPassword();
    }

    public String getUsername() {
        return this.user.getLoginId();
    }

    public String getLoginId() {
        return this.user.getLoginId();
    }

    public String getEmail() {
        return this.user.getEmail();
    }

    public String getName() {
        return this.user.getName();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonExpired()
     */
    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isAccountNonLocked()
     */
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isCredentialsNonExpired()
     */
    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetails#isEnabled()
     */
    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

    public User getUser() {
        return user;
    }

    public int getGrade() {
        return this.user.getGrade();
    }
}
