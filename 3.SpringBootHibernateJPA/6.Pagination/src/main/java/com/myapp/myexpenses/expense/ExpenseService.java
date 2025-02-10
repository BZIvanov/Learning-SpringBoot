package com.myapp.myexpenses.expense;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Page<Expense> getAllExpenses(Pageable pageable) {
        return expenseRepository.findAll(pageable);
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Expense updateExpense(Long id, Expense updatedExpense) {
        return expenseRepository.findById(id).map(existingExpense -> {
            if (updatedExpense.getName() != null) {
                existingExpense.setName(updatedExpense.getName());
            }
            if (updatedExpense.getDescription() != null) {
                existingExpense.setDescription(updatedExpense.getDescription());
            }
            if (updatedExpense.getAmount() != null) {
                existingExpense.setAmount(updatedExpense.getAmount());
            }
            if (updatedExpense.getCategory() != null) {
                existingExpense.setCategory(updatedExpense.getCategory());
            }
            if (updatedExpense.getDate() != null) {
                existingExpense.setDate(updatedExpense.getDate());
            }
            return expenseRepository.save(existingExpense);
        }).orElseThrow(() -> new EntityNotFoundException("Expense not found with ID: " + id));
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}
