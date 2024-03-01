package com.example.testApp.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "users")
@EqualsAndHashCode
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String username;

    @Column(name = "full_name", nullable = false)
    private String fullName;

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

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", unique = true)
    private Account account;

    public User(String username, String fullName, String phone,
                String email, LocalDate birthDate, Account account) {
        this.username = username;
        this.fullName = fullName;
        this.phones.add(phone);
        this.emails.add(email);
        this.birthDate = birthDate;
        this.account = account;
    }

    public User(String username, String fullName, String phone,
                String email, LocalDate birthDate) {
        this.username = username;
        this.fullName = fullName;
        this.phones.add(phone);
        this.emails.add(email);
        this.birthDate = birthDate;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
