package paperbank.models.mysql;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import javax.money.MonetaryAmount;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "emprestimo")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT [cite: 391]
    private Long idEmprestimo;

    @Column(nullable = false, precision = 15, scale = 2)
    private MonetaryAmount valor; // Mapeia DECIMAL(15,2) [cite: 392]

    @Column(nullable = false)
    private Float juros;

    @Column(nullable = false)
    private Integer parcelas;

    @Column(nullable = false)
    private LocalDate dataContratacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_numeroConta", nullable = false) // FOREIGN KEY [cite: 396, 398]
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "investimentos", "emprestimos", "cliente"})
    private ContaBancaria contaBancaria;
}