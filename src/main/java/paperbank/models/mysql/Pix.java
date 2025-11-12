package paperbank.models.mysql;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "pix")
@PrimaryKeyJoinColumn(name = "idPixTransacao") // Liga esta tabela à PK da tabela 'transacao'
public class Pix extends Transacao {

    @Column(nullable = false)
    private String chavePix;

    @Column(nullable = false, length = 20)
    private String tipoChave;
}