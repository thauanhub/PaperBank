package paperbank.models.mysql;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;


@Data
@Entity
@Table(name = "gerente")
public class Gerente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT [cite: 321]
    private Long idGerente;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(length = 20)
    private String telefone;

    @Column(nullable = false, length = 100)
    private String departamento;

    @OneToMany(mappedBy = "gerente", fetch = FetchType.LAZY)
    private Set<Cliente> clientes;
}