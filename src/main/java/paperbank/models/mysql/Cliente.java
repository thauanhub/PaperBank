package paperbank.models.mysql;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT [cite: 328]
    private Long idCliente;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 14) // UNIQUE [cite: 330]
    private String cpf;

    @Column
    private String endereco;

    @Column(length = 20)
    private String telefone;

    @Column(nullable = false, unique = true) // UNIQUE [cite: 333]
    private String email;

    @Column
    private LocalDate dataNascimento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_idGerente", nullable = false) // FOREIGN KEY [cite: 335, 337]
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "clientes"})
    private Gerente gerente;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<ContaBancaria> contas;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private Set<Cartao> cartoes;
}