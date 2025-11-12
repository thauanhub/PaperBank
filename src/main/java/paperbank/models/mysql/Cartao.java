package paperbank.models.mysql;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import javax.money.MonetaryAmount;
import java.time.LocalDate;
import java.util.Set;

@SuppressWarnings("ALL")
@Data
@Entity
@Table(name = "cartao")
public class Cartao {

    @Id

    @Column(nullable = false)
    private Long numeroCartao;

    @Column(nullable = false)
    private LocalDate validade;

    @Column(nullable = false)
    private Integer cvv;

    @Column(nullable = false, length = 20)
    private String tipo;

    @Column(nullable = false, precision = 15, scale = 2)
    private MonetaryAmount limite; // Usa MonetaryAmountConverter

    // Muitos Cartoes pertencem a um Cliente
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_idCliente", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "contas", "cartoes"})
    private Cliente cliente;

    // Um Cartao pode ter muitas Faturas
    @OneToMany(mappedBy = "cartao", fetch = FetchType.LAZY)
    private Set<Fatura> faturas;
}