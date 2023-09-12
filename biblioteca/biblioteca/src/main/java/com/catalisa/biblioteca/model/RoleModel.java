package com.catalisa.biblioteca.model;

import com.catalisa.biblioteca.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "TB_ROLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleModel implements GrantedAuthority{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleEnum role;

    @Override
    public String getAuthority() {
        return this.role.toString();
    }
}