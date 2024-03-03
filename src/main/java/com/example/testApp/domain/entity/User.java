package com.example.testApp.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
@EqualsAndHashCode
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ElementCollection
    @CollectionTable(name = "user_phones", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "phone_number", nullable = false)
    private Set<String> phones = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "user_emails", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "email", nullable = false)
    private Set<String> emails = new HashSet<>();

    @Column(nullable = false)
    private LocalDate birthDate;

    @OneToOne(mappedBy = "users", cascade = CascadeType.ALL)
    private Account account;

    public User(String username, String password,String firstName, String lastName, String phone,
                String email, LocalDate birthDate, Account account) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phones.add(phone);
        this.emails.add(email);
        this.birthDate = birthDate;
        this.account = account;
    }

    public User(String username, String password,String firstName, String lastName, String phone,
                String email, LocalDate birthDate) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phones.add(phone);
        this.emails.add(email);
        this.birthDate = birthDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
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
        return true;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phones=" + phones +
                ", emails=" + emails +
                ", birthDate=" + birthDate +
                ", account=" + account +
                '}';
    }
}
