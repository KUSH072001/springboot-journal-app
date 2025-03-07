package com.example.demo.Controller;

import com.example.demo.Entity.JournalEntry;
import com.example.demo.Servies.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JournalEntryController {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping("/get")
    public List<JournalEntry> getEntry() {
        return journalEntryService.getAll();
    }

    @PostMapping("/add")
    public String createEntry(@RequestBody JournalEntry myEntry) {
        journalEntryService.saveAll(myEntry); // Fixed method name
        return "added";
    }

    @PutMapping("/update/{id}")
    public String updateEntry(@PathVariable String id, @RequestBody JournalEntry updateEntry) {
        JournalEntry old = journalEntryService.findByid(id).orElse(null);
        if (old != null) {
            old.setTitle(updateEntry.getTitle() != null && !updateEntry.getTitle().isEmpty() ? updateEntry.getTitle() : old.getTitle());
            old.setDescription(updateEntry.getDescription() != null && !updateEntry.getDescription().isEmpty() ? updateEntry.getDescription() : old.getDescription());

            journalEntryService.saveAll(old); // Save updated entry
            return "updated";
        }
        return "Entry not found";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEntry(@PathVariable String id) {
        journalEntryService.deleteByid(id);
        return "deleted";
    }
}
