package com.example.demo.Servies;

import com.example.demo.Entity.JournalEntry;
import com.example.demo.Repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    public void saveAll(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }

    public Optional<JournalEntry> update(String id, JournalEntry journalEntry) {
        return journalEntryRepository.findById(id).map(existingEntry -> {
            existingEntry.setTitle(journalEntry.getTitle() != null ? journalEntry.getTitle() : existingEntry.getTitle());
            existingEntry.setDescription(journalEntry.getDescription() != null ? journalEntry.getDescription() : existingEntry.getDescription());
            return journalEntryRepository.save(existingEntry);
        });
    }

    public Optional<JournalEntry> findByid(String id) {
        return journalEntryRepository.findById(id);
    }

    public void deleteByid(String id) {
        journalEntryRepository.deleteById(id);
    }
}
