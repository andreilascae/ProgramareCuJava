package AWBD.HealthSched.model;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
public class Plata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "programare_id")
    private Programare programare;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDING;

    private OffsetDateTime createdAt = OffsetDateTime.now();

    public enum Status { PENDING, PAID, REFUNDED }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Programare getProgramare() { return programare; }
    public void setProgramare(Programare programare) { this.programare = programare; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }
}
