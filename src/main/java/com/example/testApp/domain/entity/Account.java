package com.example.testApp.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@EqualsAndHashCode
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column
    private BigDecimal balance;

    @Column(name = "start_balance")
    private BigDecimal startBalance;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User users;

    public Account(BigDecimal startBalance, User users) {
        this.balance = startBalance;
        this.startBalance = startBalance;
        this.users = users;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", startBalance=" + startBalance +
                '}';
    }
}
