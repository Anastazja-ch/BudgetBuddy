package com.budget.budget.service;

import com.budget.budget.model.Transaction;
import com.budget.budget.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findAllByUpdatedBy(String userId) {
        return transactionRepository.findAllByUpdatedBy(userId);
    }

    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void delete(UUID id) {
        transactionRepository.deleteById(id);
    }

    public Transaction findById(UUID id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public void importTransactionsFromCSV(MultipartFile file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            int rowIndex = 0;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (rowIndex != 0) {
                    Transaction transaction = new Transaction();
                    transaction.setName(fields[0]);
                    transaction.setAmount(new BigDecimal(fields[1]));
                    transaction.setDate(LocalDateTime.parse(fields[2]));
                    transaction.setUpdatedBy(fields[3]);
                    transaction.setUpdatedAt(LocalDateTime.parse(fields[4]));
                    transactionRepository.save(transaction);
                }
                rowIndex++;
            }
        }
    }
}

