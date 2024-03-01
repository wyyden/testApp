package com.example.testApp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@EqualsAndHashCode
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private BigDecimal balance;

    @Column(name = "start_balance")
    private BigDecimal startBalance;

    @OneToOne(mappedBy = "account")
    private User users;

    public Account(BigDecimal startBalance, User users) {
        this.balance = startBalance;
        this.startBalance = startBalance;
        this.users = users;
    }
}
