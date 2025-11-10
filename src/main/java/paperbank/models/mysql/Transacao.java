package paperbank.models.mysql;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import javax.money.MonetaryAmount;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transacao")
@Inheritance(strategy = InheritanceType.JOINED)
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT [cite: 402]
    private Long idTransacao;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false, precision = 15, scale = 2)
    private MonetaryAmount valor; // Mapeia DECIMAL(15,2) [cite: 403]

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false, length = 20)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_contaOrigem") // FOREIGN KEY [cite: 406]
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "transacoesOrigem", "transacoesDestino", "cliente"})
    private ContaBancaria contaOrigem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_contaDestino") // FOREIGN KEY [cite: 406]
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "transacoesOrigem", "transacoesDestino", "cliente"})
    private ContaBancaria contaDestino;
}