package paperbank.models.mysql;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import javax.money.MonetaryAmount; // Do JavaMoney
import java.time.LocalDate;
import java.util.Set;

/**
 * Mapeia a tabela 'conta_bancaria' [cite: 341-353].
 * Usa estratégia SINGLE_TABLE baseada na coluna 'tipoConta'[cite: 346].
 */
@Data
@Entity
@Table(name = "conta_bancaria")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoConta", discriminatorType = DiscriminatorType.STRING, length = 20)
public abstract class ContaBancaria {

    @Id
    @Column(nullable = false)
    private Long numeroConta; // PK, mas não é auto-incremento [cite: 342, 349]

    @Column(nullable = false, precision = 15, scale = 2)
    private MonetaryAmount saldo; // Mapeia DECIMAL(15,2) [cite: 343]

    @Column(nullable = false)
    private LocalDate dataAbertura;

    @Column(nullable = false, length = 20)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_idCliente", nullable = false) // FOREIGN KEY [cite: 348, 350]
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "contas", "cartoes"})
    private Cliente cliente;

    @OneToMany(mappedBy = "contaBancaria", fetch = FetchType.LAZY)
    private Set<Investimento> investimentos;

    @OneToMany(mappedBy = "contaBancaria", fetch = FetchType.LAZY)
    private Set<Emprestimo> emprestimos;

    @OneToMany(mappedBy = "contaOrigem", fetch = FetchType.LAZY)
    private Set<Transacao> transacoesOrigem;

    @OneToMany(mappedBy = "contaDestino", fetch = FetchType.LAZY)
    private Set<Transacao> transacoesDestino;
}