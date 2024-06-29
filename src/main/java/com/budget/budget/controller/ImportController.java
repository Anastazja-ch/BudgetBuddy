package com.budget.budget.controller;

import com.budget.budget.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ImportController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/import")
    public String showImportForm() {
        return "import";
    }

    @PostMapping("/import")
    public String importCSV(@RequestParam("file") MultipartFile file, Model model) {
        try {
            transactionService.importTransactionsFromCSV(file);
            model.addAttribute("message", "File uploaded successfully!");
        } catch (IOException e) {
            model.addAttribute("message", "Failed to upload file: " + e.getMessage());
        }
        return "redirect:/transactions";
    }
}
