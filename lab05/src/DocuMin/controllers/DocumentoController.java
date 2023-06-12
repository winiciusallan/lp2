package DocuMin.controllers;

import DocuMin.entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Representação de um controlador para o Documento. Contém todas as operações do sistema para: criação de documentos,
 * remoção de documentos, criação de elementos dentro de um documento, apagar os elementos, criação de uma visão
 * (exportação do documento) e exibir uma dessas visões.
 *
 * @author Winicius Allan - 122110397
 */
public class DocumentoController {

    /**
     * Um mapa contendo os documentos do sistema. Cada documento possui um identificador que é o seu título.
     */
    private HashMap<String, Documento> documentos;

    /**
     * Uma lista contendo todas as visões do sistema na ordem em que foram inseridas.
     */
    private ArrayList<Visao> visoes;

    /**
     * Construtor do controller, instanciando todas as coleções.
     */
    public DocumentoController() {
        this.documentos = new HashMap<>();
        this.visoes = new ArrayList<>();
    }

    /* OPERAÇÕES PARA DOCUMENTO */

    /**
     * Cria um documento e armazena no mapa. Casó o documento já esteja cadastrado, o sistema não o cadastra.
     *
     * @param titulo O titulo do documento.
     * @return Um valor booleano indicando se a operação deu certo ou não.
     * @throws IllegalAccessException Exceção lançada caso o titulo já esteja cadastrado.
     */
    public boolean criarDocumento(String titulo) throws IllegalAccessException {
        if (estaCadastrado(titulo)) return false;

        if (titulo.trim().equals("")) {
            throw new IllegalAccessException("Título com tamanho inválido");
        }

        documentos.put(titulo, new Documento(titulo));
        return true;
    }

    /**
     * Cria um documento e armazena no mapa. Casó o documento já esteja cadastrado, o sistema não o cadastra.
     *
     * @param titulo O titulo do documento.
     * @param tamanhoMaximo O tamanho máximo que o documento pode ter de Elementos.
     * @return Um valor booleano indicando se a operação deu certo ou não.
     * @throws IllegalAccessException Exceção lançada caso o titulo já esteja cadastrado.
     */
    public boolean criarDocumento(String titulo, int tamanhoMaximo) throws IllegalAccessException {
        if (estaCadastrado(titulo)) return false;

        if (titulo.trim().equals("")) {
            throw new IllegalAccessException("Título com tamanho inválido");
        }
        if (tamanhoMaximo <= 0) { throw new IllegalArgumentException(); }

        documentos.put(titulo, new Documento(titulo, tamanhoMaximo));
        return true;
    }

    /**
     * Remove um documento da coleção. Caso o titulo do documento seja vázio, uma exceção é lançada. Se o documento não
     * estiver cadastrado, o sistema não remove.
     *
     * @param titulo O titulo do documento a ser removido.
     */
    public void removerDocumento(String titulo) {
        if (titulo.trim().equals("")) throw new IllegalArgumentException();
        if (!estaCadastrado(titulo)) throw new NoSuchElementException();

        documentos.remove(titulo);
    }

    /* OPERAÇÕES PARA ELEMENTO */

    /**
     * Cria um elemento e adiciona ele em um documento.
     *
     * @param tituloDoc O titulo do documento em que o elemento será adicionado.
     * @param elem O elemento a ser adicionado
     * @return A posição em que o elemento foi inserido no documento.
     */
    public int criaElemento(String tituloDoc, Elemento elem) {
        return documentos.get(tituloDoc).criaElemento(elem);
    }

    /**
     * Apaga um elemento em um documento.
     *
     * @param tituloDoc O titulo do documento que o elemento será removido.
     * @param posElemento A posição em que o elemento se encontra.
     * @return Valor lógico indicando se a operação deu certo ou não.
     */
    public boolean apagarElemento(String tituloDoc, int posElemento) {
        return documentos.get(tituloDoc).apagarElemento(posElemento);
    }

    /**
     * Conta a quantidade de elementos que um documento tem.
     *
     * @param titulo O titulo do documento
     * @return Um inteiro representando a quantidade de elementos.
     */
    public int contarElementos(String titulo) {
        if (titulo.trim().equals("")) throw new IllegalArgumentException();
        if (!estaCadastrado(titulo)) throw new NoSuchElementException();

        return documentos.get(titulo).getElementos().size();
    }

    /**
     * Exibe um documento mostrando todos os elementos que ele contém.
     *
     * @param titulo O título do documento
     * @return Um vetor com todas as representações dos elementos.
     */
    public String[] exibirDocumento(String titulo) {
        if (titulo.trim().equals("")) throw new IllegalArgumentException();
        if (!estaCadastrado(titulo)) throw new NoSuchElementException();

        return documentos.get(titulo).exibeDocumento();
    }

    private boolean estaCadastrado(String titulo) {
        return documentos.get(titulo) != null;
    }

    /**
     * Move um elemento para uma posição mais próxima do início do documento.
     *
     * @param tituloDoc O título do documento
     * @param posElemento A posição do elemento no documento.
     */
    public void moverParaCima(String tituloDoc, int posElemento) {
        documentos.get(tituloDoc).moverPosicaoAcima(posElemento);
    }

    /**
     * Move um elemento para uma posição mais próxima do fim do documento.
     *
     * @param tituloDoc O título do documento.
     * @param posElemento A posição do elemento no documento.
     */
    public void moverParaBaixo(String tituloDoc, int posElemento) {
        documentos.get(tituloDoc).moverPosicaoAbaixo(posElemento);
    }

    /**
     * Representacao completa de um elemento.
     *
     * @param tituloDoc O titulo do documento.
     * @param posElemento A posição do elemento que será representado.
     * @return Uma string com a representação completa do elemento.
     */
    public String representacaoCompleta(String tituloDoc, int posElemento) {
        return documentos.get(tituloDoc).getElemento(posElemento).representacaoCompleta();
    }

    /**
     * Representacao resumida de um elemento.
     *
     * @param tituloDoc O título do documento.
     * @param posElemento A posição do elemento.
     * @return Uma string com a representação resumida do elemento
     */
    public String representacaoResumida(String tituloDoc, int posElemento) {
        return documentos.get(tituloDoc).getElemento(posElemento).representacaoResumida();
    }

    /**
     * Criação de um atalho como elemento. Caso um documento já seja atalho não poderá ter um novo atalho. Caso o documento
     * referenciado já esteja sendo atalhado, não poderá ser referenciado novamente.
     *
     * @param tituloDoc O título do documento que será atalho.
     * @param tituloReferenciado O título do documento que será referenciado.
     * @return Inteiro indicando a posição do atalho no documento.
     */
    public int criarAtalho(String tituloDoc, String tituloReferenciado) {
        Documento docRef = documentos.get(tituloReferenciado);
        Documento docAtalho = documentos.get(tituloDoc);

        if (!(docAtalho.isAtalho() || docRef.hasAtalho())) {
            docRef.setHasAtalho(true);
            docAtalho.setIsAtalho(true);

            return documentos.get(tituloDoc)
                    .criaElemento(new Atalho(tituloReferenciado, docRef.mediaPrioridade(), docRef));
        } else {
            throw new IllegalStateException();
        }
    }

    /* OPERAÇÕES PARA VISÃO */

    /**
     * Cria a visão completa de um documento.
     *
     * @param tituloDoc Título do documento a ser criado a visão.
     * @return Inteiro com a posição em que a visão foi armazenada.
     */
    public int criarVisaoCompleta(String tituloDoc) {
        if (tituloDoc.trim().equals("")) throw new IllegalArgumentException();

        Visao visao = new VisaoCompleta(documentos.get(tituloDoc));
        visoes.add(visao);
        return visoes.indexOf(visao);
    }

    /**
     * Cria a visão resumida de um documento.
     *
     * @param tituloDoc Título do documento a ser criado a visão.
     * @return Inteiro com a posição em que a visão foi armazenada.
     */
    public int criarVisaoResumida(String tituloDoc) {
        if (tituloDoc.trim().equals("")) throw new IllegalArgumentException();

        Visao visao = new VisaoResumida(documentos.get(tituloDoc));
        visoes.add(visao);
        return visoes.indexOf(visao);
    }

    /**
     * Cria a visão prioritária de um documento. Apenas elementos com a prioridade maior ou igual ao passado como parâmetro
     * será retornada na visão.
     *
     * @param tituloDoc Título do documento a ser criado a visão.
     * @param prioridade A prioridade base dos elementos.
     * @return Inteiro com a posição em que a visão foi armazenada.
     */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        if (tituloDoc.trim().equals("")) throw new IllegalArgumentException();
        if (prioridade < 1 || prioridade > 5) throw new IllegalArgumentException();

        Visao visao = new VisaoPrioritaria(documentos.get(tituloDoc), prioridade);
        visoes.add(visao);
        return visoes.indexOf(visao);
    }

    /**
     * Cria a visão titulo de um documento.
     *
     * @param tituloDoc Título do documento a ser criado a visão.
     * @return Inteiro com a posição em que a visão foi armazenada.
     */
    public int criarVisaoTitulo(String tituloDoc) {
        if (tituloDoc.trim().equals("")) throw new IllegalArgumentException();

        VisaoTitulo visao = new VisaoTitulo(documentos.get(tituloDoc));
        visoes.add(visao);
        return visoes.indexOf(visao);
    }

    /**
     * Exibe uma visão, retornando a representação dos elementos de um documento.
     *
     * @param visaoId O índice da visão na coleção
     * @return Um vetor de String contendo a representação dos elementos.
     */
    public String[] exibirVisao(int visaoId) {
        return visoes.get(visaoId).exibirVisao();
    }
}
