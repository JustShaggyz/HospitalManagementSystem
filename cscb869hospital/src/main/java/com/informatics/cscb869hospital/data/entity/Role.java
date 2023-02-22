package com.informatics.cscb869hospital.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "role")
public class Role extends BaseEntity implements GrantedAuthority {

    private String authority;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<User> users;

    public Role(String authority) {
        this.authority = authority;
        this.users = new HashSet<>();
    }
}
