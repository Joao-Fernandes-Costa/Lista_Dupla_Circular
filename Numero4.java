import java.util.Scanner;

public class Numero4 {

    static class No {
        int dado;
        No proximo;
        No anterior;
        public No(int dado) {
            this.dado = dado;
            this.proximo = null;
            this.anterior = null;
        }
    }

    static class ListaCircularDupla {
        private No fim;

        public ListaCircularDupla() {
            this.fim = null;
        }

        public boolean isEmpty() {
            return this.fim == null;
        }

        public int contarElementos() {
            if (isEmpty()) {
                return 0;
            }
            int cont = 0;
            No atual = fim.proximo;
            do {
                cont++;
                atual = atual.proximo;
            } while (atual != fim.proximo);
            return cont;
        }

        public void inserirInicio(int dado) {
            No novo = new No(dado);
            if (isEmpty()) {
                fim = novo;
                fim.proximo = fim;
                fim.anterior = fim;
            } else {
                No inicio = fim.proximo;
                novo.proximo = inicio;
                novo.anterior = fim;
                inicio.anterior = novo;
                fim.proximo = novo;
            }
        }
        
        public void concatenar(ListaCircularDupla outra) {
            if (outra.isEmpty()) return;
            
            if (this.isEmpty()) {
                this.fim = outra.fim;
            } else {
                No inicio1 = this.fim.proximo;
                No fim1 = this.fim;
                No inicio2 = outra.fim.proximo;
                No fim2 = outra.fim;
                
                fim1.proximo = inicio2;
                inicio2.anterior = fim1;
                fim2.proximo = inicio1;
                inicio1.anterior = fim2;
                
                this.fim = fim2;
            }
            outra.fim = null;
        }
        
        public static ListaCircularDupla intercalarOrdenadas(ListaCircularDupla l1, ListaCircularDupla l2) {
            ListaCircularDupla nova = new ListaCircularDupla();
            if (l1.isEmpty()) return l2.fazerCopia();
            if (l2.isEmpty()) return l1.fazerCopia();

            No p1 = l1.fim.proximo;
            No p2 = l2.fim.proximo;
            int c1 = l1.contarElementos();
            int c2 = l2.contarElementos();
            int i = 0, j = 0;

            while (i < c1 && j < c2) {
                if (p1.dado <= p2.dado) {
                    nova.inserirFim(p1.dado);
                    p1 = p1.proximo;
                    i++;
                } else {
                    nova.inserirFim(p2.dado);
                    p2 = p2.proximo;
                    j++;
                }
            }
            while (i < c1) {
                nova.inserirFim(p1.dado);
                p1 = p1.proximo;
                i++;
            }
            while (j < c2) {
                nova.inserirFim(p2.dado);
                p2 = p2.proximo;
                j++;
            }
            return nova;
        }

        public ListaCircularDupla fazerCopia() {
            ListaCircularDupla copia = new ListaCircularDupla();
            if (isEmpty()) return copia;
            
            No atual = fim.proximo;
            do {
                copia.inserirFim(atual.dado);
                atual = atual.proximo;
            } while (atual != fim.proximo);
            
            return copia;
        }

        public void imprimir(String nome) {
            if (isEmpty()) {
                System.out.println(nome + ": [ VAZIA ]");
                return;
            }
            System.out.print(nome + ": [ ");
            No atual = fim.proximo;
            do {
                System.out.print(atual.dado + " ");
                atual = atual.proximo;
            } while (atual != fim.proximo);
            System.out.println("]");
        }
        
        public void inserirFim(int dado) {
            No novo = new No(dado);
            if (isEmpty()) {
                fim = novo;
                fim.proximo = fim;
                fim.anterior = fim;
            } else {
                No inicio = fim.proximo;
                novo.proximo = inicio;
                novo.anterior = fim;
                inicio.anterior = novo;
                fim.proximo = novo;
                fim = novo;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaCircularDupla l1 = new ListaCircularDupla();
        ListaCircularDupla l2 = new ListaCircularDupla();
        int escolha = 0;
        int valor;
        
        while (escolha != 9) {
            
            System.out.println("1. Inserir Início (L1)  ");
            System.out.println("2. Inserir Início (L2)  ");
            System.out.println("3. Imprimir L1 e L2");
            System.out.println("4. Contar (L1) ");
            System.out.println("5. Concatenar (L1 += L2)");
            System.out.println("6. Intercalar (L1, L2)");
            System.out.println("7. Copiar (L1)");
            System.out.println("8. (Helper) Inserir Fim (L1)");
            System.out.println("9. Sair");
            System.out.print("Escolha: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Valor p/ L1: ");
                    valor = scanner.nextInt();
                    l1.inserirInicio(valor);
                    break;
                case 2:
                    System.out.print("Valor p/ L2: ");
                    valor = scanner.nextInt();
                    l2.inserirInicio(valor);
                    break;
                case 3:
                    l1.imprimir("L1");
                    l2.imprimir("L2");
                    break;
                case 4:
                    System.out.println("L1 tem " + l1.contarElementos() + " elementos.");
                    break;
                case 5:
                    System.out.println("Concatenando L1 e L2...");
                    l1.concatenar(l2);
                    l1.imprimir("Nova L1");
                    l2.imprimir("L2 (vazia)");
                    break;
                case 6:
                    System.out.println("Intercalando L1 e L2 (listas DEVEM estar ordenadas)...");
                    ListaCircularDupla inter = ListaCircularDupla.intercalarOrdenadas(l1, l2);
                    inter.imprimir("Intercalada");
                    break;
                case 7:
                    System.out.println("Copiando L1...");
                    ListaCircularDupla copia = l1.fazerCopia();
                    copia.imprimir("Cópia");
                    l1.imprimir("Original L1");
                    break;
                case 8:
                    System.out.print("Valor (Fim) p/ L1: ");
                    valor = scanner.nextInt();
                    l1.inserirFim(valor);
                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}