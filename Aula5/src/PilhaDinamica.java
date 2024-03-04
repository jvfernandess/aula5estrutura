class No {
    int dado;
    No proximo;

    public No(int dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

public class PilhaDinamica {
    private No topo;
    private int tamanho;

    public PilhaDinamica() {
        this.topo = null;
        this.tamanho = 0;
    }

    public void inserir(int elemento) {
        No novoNo = new No(elemento);
        novoNo.proximo = topo;
        topo = novoNo;
        tamanho++;
    }

    public int remover() {
        if (estaVazia()) {
            System.out.println("Erro: Pilha vazia");
            return -1;
        }
        int elementoRemovido = topo.dado;
        topo = topo.proximo;
        tamanho--;
        return elementoRemovido;
    }

    public int tamanho() {
        return tamanho;
    }

    public boolean estaVazia() {
        return (topo == null);
    }

    public void imprimir() {
        if (estaVazia()) {
            System.out.println("Pilha vazia");
            return;
        }
        System.out.println("Elementos da pilha:");
        No temp = topo;
        while (temp != null) {
            System.out.println(temp.dado);
            temp = temp.proximo;
        }
    }

    public static void main(String[] args) {
        PilhaDinamica pilha = new PilhaDinamica();
        pilha.inserir(10);
        pilha.inserir(20);
        pilha.inserir(30);

        System.out.println("Tamanho da pilha: " + pilha.tamanho());
        System.out.println("A pilha está vazia? " + pilha.estaVazia());

        pilha.imprimir();

        pilha.remover();
        pilha.remover();

        pilha.imprimir();
    }
}
