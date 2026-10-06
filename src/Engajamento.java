
/**
 * Classificação de engajamento do assinante.
 * Cada classificação tem um fator aplicado sobre a tarifa base:
 * INICIANTE 1,00; REGULAR 1,00; ENGAJADO 0,95; BINGE 1,10.
 */
public enum Engajamento {
    INICIANTE(1.0f), 
    REGULAR(1.0f), 
    ENGAJADO(0.95f), 
    BINGE(1.10f);

    Engajamento(float fator)
    {
        this.Fator = fator;
    }

    //TODO Tarefa 1: associar a cada constante seu fator de tarifa
    // (atributo, construtor e método getFator())

    public float getFator()
    {
        return Fator;
    }

    private float Fator;
}
