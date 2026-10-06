
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Os testes prontos servem de exemplo.
 * Complete os testes marcados com //TODO (Tarefas 4 e 5).
 */
public class AssinanteTest {

    private Assinante assinante;

    @BeforeEach
    void setUp() {
        assinante = new Assinante("Ana");
    }

    @Test
    void deveRegistrarAssistidoPorTitulo() {
        assinante.adicionar(new Episodio("Piloto", 1, 42));
        assertTrue(assinante.registrarAssistido("Piloto"));
        assertEquals(42, assinante.tempoTotalAssistido());
    }

    @Test
    void naoDeveRegistrarTituloInexistente() {
        assinante.adicionar(new Episodio("Piloto", 1, 42));
        assertFalse(assinante.registrarAssistido("Final"));
    }

    @Test
    void deveCalcularCreditoDeTempo() {
        assinante.adicionar(new Episodio("A", 1, 40));
        assinante.adicionar(new Episodio("B", 1, 50));
        assinante.registrarAssistido("A");
        assertEquals(50, assinante.creditoDeTempo());
    }

    @Test
    void resumoDeveConterNomeEClassificacao() {
        assinante.adicionar(new Episodio("Piloto", 1, 42));
        String r = assinante.resumo();
        assertTrue(r.contains("Ana"), r);
        assertTrue(r.contains("INICIANTE"), r);
    }

    @Test
    void deveClassificarEngajamento() {
        //TODO Tarefa 4: testar classificacaoEngajamento em pelo menos dois cenários
        // (ex.: 4 episódios com 2 assistidos → REGULAR; 4 com 4 assistidos → BINGE)

        Assinante assinante = new Assinante("Tiago");
        Episodio ep1 = new Episodio("Flash", 9, 38); ep1.marcarAssistido();
        Episodio ep2 = new Episodio("Flash", 9, 38); ep2.marcarAssistido();
        Episodio ep3 = new Episodio("Flash", 9, 38);
        Episodio ep4 = new Episodio("Flash", 9, 38);
        assinante.adicionar(ep1); assinante.adicionar(ep2); assinante.adicionar(ep3); assinante.adicionar(ep4);
        
        assertEquals(assinante.classificacaoEngajamento(), Engajamento.REGULAR);

        ep1.marcarAssistido();
        ep2.marcarAssistido();
        ep3.marcarAssistido();
        ep4.marcarAssistido();

        assertEquals(assinante.classificacaoEngajamento(), Engajamento.BINGE);
    }

    @Test
    void deveCalcularTarifaMensal() {
        //TODO Tarefa 5: testar tarifaMensal usando o fator da classificação
        // (ex.: BINGE sem isenção → 29,90 × 1,10) e a isenção acima de 600 minutos

        Assinante assinante = new Assinante("Tiago");
        Episodio ep1 = new Episodio("Flash", 9, 200); ep1.marcarAssistido();
        Episodio ep2 = new Episodio("Flash", 9, 200); ep2.marcarAssistido();
        Episodio ep3 = new Episodio("Flash", 9, 200); ep3.marcarAssistido();
        Episodio ep4 = new Episodio("Flash", 9, 200); ep4.marcarAssistido();
        assinante.adicionar(ep1); assinante.adicionar(ep2); assinante.adicionar(ep3); assinante.adicionar(ep4);

        assertEquals(assinante.tarifaMensal(), 0);
    }
}
