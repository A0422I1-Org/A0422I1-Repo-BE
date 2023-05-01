package com.example.demo.service.impl.account;

import com.example.demo.model.account.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class JwtAccountDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private String username;
    private Boolean enabled;
    @JsonIgnore
    private String password;
    private List<GrantedAuthority> grantedAuthorities = null;

    public JwtAccountDetailsImpl() {
    }

    public JwtAccountDetailsImpl(String username, Boolean enabled, String password, List<GrantedAuthority> grantedAuthorities) {
        this.username = username;
        this.enabled = enabled;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
    }

    /**
     * Pham Trung Hieu
     * @param account
     * @return username, password, authorities
     */
    public static JwtAccountDetailsImpl build(Account account) {
        List<GrantedAuthority> authorities = account.getAccountRoleList().stream()
                .map(role -> new SimpleGrantedAuthority(role.getRole().getName()))
                .collect(Collectors.toList());
        return new JwtAccountDetailsImpl(
                account.getUsername(),
                account.getIsEnable(),
                account.getPassword(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        JwtAccountDetailsImpl account = (JwtAccountDetailsImpl) o;
        return Objects.equals(username, account.username);
    }
}
