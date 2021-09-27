package ua.testing.demo_jpa.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "t_role")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Enumerated(value = EnumType.STRING)
    RoleType type;

    public Role(RoleType type) {
        this.type = type;
    }

    @Override
    public String getAuthority() {
        return type.name();
    }
}
