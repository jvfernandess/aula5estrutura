class No {
    int dado;
    No proximo;

    public No(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

public class FilaDinamica {
    private No inicio;
    private No fim;
    private int tamanho;

    public FilaDinamica() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void inserir(int elemento) {
        No novoNo = new No(elemento);
        if (estaVazia()) {
            inicio = novoNo;
        } else {
            fim.proximo = novoNo;
        }
        fim = novoNo;
        tamanho++;
    }

    public int remover() {
        if (estaVazia()) {
            System.out.println("Erro: Fila vazia");
            return -1;
        }
        int elementoRemovido = inicio.dado;
        inicio = inicio.proximo;
        if (inicio == null) {
            fim = null;
        } 
        tamanho--;
        return elementoRemovido;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return (inicio == null);
    }

    public void imprimir() {
        if (estaVazia()) {
            System.out.println("Fila vazia");
            return;
        }
        System.out.println("Elementos da fila:");
        No temp = inicio;
        while (temp != null) {
            System.out.println(temp.dado);
            temp = temp.proximo;
        }
    }

    public static void main(String[] args) {
        FilaDinamica fila = new FilaDinamica();
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        System.out.println("Tamanho da fila: " + fila.tamanho());
        System.out.println("A fila está vazia? " + fila.estaVazia());

        fila.imprimir();

        fila.remover();
        fila.remover();

        fila.imprimir();
    }
}
