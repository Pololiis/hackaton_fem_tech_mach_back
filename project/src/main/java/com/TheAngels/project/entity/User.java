package com.TheAngels.project.entity;

import jakarta.persistence.*;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Random;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private String lastName;
    @NotNull
    @Column(unique = true)
    private String idDocument;
    private String phone;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;
    public User() {
        this.account = new Account();
        Random random = new Random();
        String accountNumber = String.format("%012d", random.nextInt(1000000000));
        this.account.setAccountNumber(accountNumber);
        this.account.setBalance(0.0);
    }
}
