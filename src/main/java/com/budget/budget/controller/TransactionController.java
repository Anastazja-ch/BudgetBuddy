package com.budget.budget.controller;

import com.budget.budget.model.Transaction;
import com.budget.budget.model.User;
import com.budget.budget.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Controller
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    public String listTransactions(Model model, Authentication authentication) {
        model.addAttribute("transactions", transactionService.findAllByUpdatedBy(((User)authentication.getPrincipal()).getId().toString()));
        System.out.println(((User)authentication.getPrincipal()).getId().toString());
        return "transactions";
    }

    @GetMapping("/transactions/new")
    public String createTransactionForm(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "create_transaction";
    }

    @PostMapping("/transactions")
    public String saveTransaction(@ModelAttribute Transaction transaction, Authentication authentication) {
        transaction.setUpdatedAt(LocalDateTime.now());
        transaction.setUpdatedBy(((User)authentication.getPrincipal()).getId().toString());
        transactionService.save(transaction);
        return "redirect:/transactions";
    }

    @GetMapping("/transactions/edit/{id}")
    public String editTransactionForm(@PathVariable UUID id, Model model) {
        Transaction transaction = transactionService.findById(id);
        model.addAttribute("transaction", transaction);
        return "edit_transaction";
    }

    @PostMapping("/transactions/update/{id}")
    public String updateTransaction(@PathVariable UUID id, @ModelAttribute Transaction transaction, Authentication authentication) {
        Transaction existingTransaction = transactionService.findById(id);
        existingTransaction.setName(transaction.getName());
        existingTransaction.setAmount(transaction.getAmount());
        existingTransaction.setDate(transaction.getDate());
        existingTransaction.setUpdatedAt(LocalDateTime.now());
        existingTransaction.setUpdatedBy(authentication.getName());
        transactionService.save(existingTransaction);
        return "redirect:/transactions";
    }

    @GetMapping("/transactions/delete/{id}")
    public String deleteTransaction(@PathVariable UUID id) {
        transactionService.delete(id);
        return "redirect:/transactions";
    }
}
