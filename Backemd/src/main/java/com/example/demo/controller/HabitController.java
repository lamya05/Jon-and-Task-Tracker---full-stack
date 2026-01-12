package com.example.demo.controller;





import com.example.demo.model.Habit;
import com.example.demo.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RestController
@RequestMapping("/api/habits")
@CrossOrigin(origins = "*")
public class HabitController {

    @Autowired
    private HabitRepository habitRepository;

    @PostMapping("/update")
    public Habit updateHabit(@RequestBody Habit habitDetails) {
        List<Habit> existing = habitRepository.findByUserEmailAndHabitNameAndWeekNumberAndDayIndex(
            habitDetails.getUserEmail(),
            habitDetails.getHabitName(),
            habitDetails.getWeekNumber(),
            habitDetails.getDayIndex()
        );

        Habit habit = existing.isEmpty() ? habitDetails : existing.get(0);
        habit.setStatus(habitDetails.isStatus());
        return habitRepository.save(habit);
    }

    @GetMapping("/user/{email}")
    public List<Habit> getUserHabits(@PathVariable String email) {
        return habitRepository.findByUserEmail(email);
    }

    
    @Transactional
    @DeleteMapping("/delete/{email}/{name}")
    public void deleteHabitByName(@PathVariable String email, @PathVariable String name) {
        habitRepository.deleteByUserEmailAndHabitName(email, name);
    }
}