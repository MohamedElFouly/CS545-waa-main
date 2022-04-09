package miu.edu.demo.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transaction_id;
    private Date date;
    private long time;
    private String operation;

    @ManyToOne
    @JoinColumn(name="principle_id")
    @JsonBackReference
    private User principle;

}
