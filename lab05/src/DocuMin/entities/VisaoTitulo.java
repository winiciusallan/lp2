package DocuMin.entities;

import java.util.ArrayList;

/**
 * Representação de um tipo de visão onde só há a representação de elementos do tipo Título.
 *
 * @author Winicius Allan - 122110397
 */
public class VisaoTitulo extends Visao {

    /**
     * Construtor da visao título.
     *
     * @param docReferenciado O documento que será exportado.
     */
    public VisaoTitulo(Documento docReferenciado) {
        super(docReferenciado);
    }

    /**
     * Exibe, na sua forma resumida, todos os elementos que forem do tipo Título.
     * @return Vetor contendo a representação resumida dos elementos.
     */
    @Override
    public String[] exibirVisao() {
        ArrayList<String> output = new ArrayList<>();

        for (int i = 0; i < docReferenciado.getElementos().size(); i++) {
            if (docReferenciado.getElemento(i) instanceof Titulo) {
                output.add(docReferenciado.getElemento(i).representacaoResumida());
            }
        }
        return output.toArray(new String[0]);
    }
}
