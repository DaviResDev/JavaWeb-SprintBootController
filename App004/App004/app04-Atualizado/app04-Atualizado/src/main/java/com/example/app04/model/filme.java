package seu.pacote.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String genero;
    private int ano;
    private boolean assistido;
    private LocalDate dataAssistido;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
