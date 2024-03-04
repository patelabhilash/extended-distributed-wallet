package com.supabaseconnector.artifact2.entity.acci;

import java.time.LocalDateTime;
import java.util.List;

import com.supabaseconnector.artifact2.entity.jour.Vehicle;
import com.supabaseconnector.artifact2.util.Constraints.AccidentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "accident")
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accident_id")
    private long accidentId;

    @ManyToOne
    private Vehicle vehicle;

    @Column(name = "accident_date")
    private LocalDateTime accidentDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate; // date this data has been added to the system

    @Column(name = "status")
    private AccidentStatus status;

    @OneToMany(mappedBy = "accident")
    private List<AccidentRepairExpense> accidentRepairExpenses;

}
