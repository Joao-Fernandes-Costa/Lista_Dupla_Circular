import java.util.Scanner;
public class Numero1 {
    static class No {
        int dado;
        No anterior;
        No proximo;
        public No(int dado) {
            this.dado = dado;
        }
    }
    static class ListaDupla {
        private No inicio;
        private No fim;
        
        public boolean isEmpty() {
            return this.inicio == null;
        }
        public void inserirFim(int dado) {
            No novo = new No(dado);
            if (isEmpty()) {
                inicio = fim = novo;
            } else {
                fim.proximo = novo;
                novo.anterior = fim;
                fim = novo;
            }
        }
        public void imprimir(String nome) {
            System.out.print(nome + ": [ ");
            No atual = inicio;
            while (atual != null) {
                System.out.print(atual.dado + " ");
                atual = atual.proximo;
            }
            System.out.println("]");
        }
        public void concatenar(ListaDupla outraLista) {
            if (outraLista.isEmpty()) return;
            if (this.isEmpty()) {
                this.inicio = outraLista.inicio;
                this.fim = outraLista.fim;
            } else {
                this.fim.proximo = outraLista.inicio;
                outraLista.inicio.anterior = this.fim;
                this.fim = outraLista.fim;
            }
            outraLista.inicio = null;
            outraLista.fim = null;
        }
        public ListaDupla fundir(ListaDupla outraLista) {
            ListaDupla listaFundida = new ListaDupla();
            No atual = this.inicio;
            while (atual != null) {
                listaFundida.inserirFim(atual.dado);
                atual = atual.proximo;
            }
            atual = outraLista.inicio;
            while (atual != null) {
                listaFundida.inserirFim(atual.dado);
                atual = atual.proximo;
            }
            return listaFundida;
        }
        public static ListaDupla intercalarOrdenadas(ListaDupla l1, ListaDupla l2) {
            ListaDupla listaIntercalada = new ListaDupla();
            No p1 = l1.inicio;
            No p2 = l2.inicio;
            while (p1 != null && p2 != null) {
                if (p1.dado <= p2.dado) {
                    listaIntercalada.inserirFim(p1.dado);
                    p1 = p1.proximo;
                } else {
                    listaIntercalada.inserirFim(p2.dado);
                    p2 = p2.proximo;
                }
            }
            while (p1 != null) {
                listaIntercalada.inserirFim(p1.dado);
                p1 = p1.proximo;
            }
            while (p2 != null) {
                listaIntercalada.inserirFim(p2.dado);
                p2 = p2.proximo;
            }
            return listaIntercalada;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- LISTA 1 ---");
        System.out.println("Digite os números (separados por espaço):");
        ListaDupla l1 = new ListaDupla();
        String[] numerosL1 = scanner.nextLine().trim().split("\\s+");
        for (String s : numerosL1) {
            if (!s.isEmpty()) l1.inserirFim(Integer.parseInt(s));
        }
        System.out.println("\n--- LISTA 2 ---");
        System.out.println("Digite os números (separados por espaço):");
        ListaDupla l2 = new ListaDupla();
        String[] numerosL2 = scanner.nextLine().trim().split("\\s+");
        for (String s : numerosL2) {
            if (!s.isEmpty()) l2.inserirFim(Integer.parseInt(s));
        }
        System.out.println("\n--- Listas Originais ---");
        l1.imprimir("Lista 1");
        l2.imprimir("Lista 2");
        System.out.println("\n--- 1.B: FUNDIR (Não-Destrutivo) ---");
        ListaDupla fundida = l1.fundir(l2);
        fundida.imprimir("Fundida");
        System.out.println("\n--- 1.C: INTERCALAR (Assumindo listas ordenadas) ---");
        ListaDupla intercalada = ListaDupla.intercalarOrdenadas(l1, l2);
        intercalada.imprimir("Intercalada");
        System.out.println("\n--- 1.A: CONCATENAR (Destrutivo) ---");
        l1.concatenar(l2);
        l1.imprimir("Concatenada (L1)");
        l2.imprimir("L2 (vazia)");
        scanner.close();
    }
}