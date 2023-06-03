package com.rimesh.usermanagement.domain;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.ManyToMany;
import static javax.persistence.FetchType.EAGER;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String name;
    private String username;
    private  String password;
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

}
