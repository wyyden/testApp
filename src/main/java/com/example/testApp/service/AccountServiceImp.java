package com.example.testApp.service;

import com.example.testApp.domain.entity.Account;
import com.example.testApp.repository.AccountRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountServiceImp implements AccountService {
    private final AccountRepository accountRepository;
    private static final BigDecimal MAX_PERCENT = BigDecimal.valueOf(2.07);
    private static final BigDecimal LIMIT_PERCENT = BigDecimal.valueOf(2.02);
    private static final BigDecimal RATE = BigDecimal.valueOf(0.05);

    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @Transactional
    @Scheduled(fixedRate = 60000)
    public void addPercent() {
        List<Account> accountList = getListAccount();
        for (Account account : accountList) {
            BigDecimal curBalance = account.getBalance();
            BigDecimal startBalance = account.getStartBalance();
            if (curBalance.doubleValue()
                    <= startBalance.multiply(LIMIT_PERCENT).doubleValue()) {
                account.setBalance(curBalance.add(curBalance.multiply(RATE)));
            } else if (curBalance.doubleValue()
                    < startBalance.multiply(MAX_PERCENT).doubleValue()) {
                account.setBalance(startBalance.add(startBalance.multiply(MAX_PERCENT)));
            }
        }
        accountRepository.saveAll(accountList);
    }

    @Override
    public List<Account> getListAccount() {
        return accountRepository.findAll();
    }
}
