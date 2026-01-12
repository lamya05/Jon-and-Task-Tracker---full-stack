package com.example.demo.repository;


import com.example.demo.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {

    List<Habit> findByUserEmail(String email);
    
    List<Habit> findByUserEmailAndHabitNameAndWeekNumberAndDayIndex(
        String userEmail, String habitName, int weekNumber, int dayIndex
    );

    @Modifying
    @Transactional
    void deleteByUserEmailAndHabitName(String userEmail, String habitName);
}