import java.util.Scanner;

public class Numero2 {

    static class No {
        int dado;
        No proximo;
        No anterior;

        public No(int dado) {
            this.dado = dado;
        }
    }

    static class ListaDuplaCabeca {
        No cabeca;

        public ListaDuplaCabeca() {
            cabeca = new No(0);
            cabeca.proximo = cabeca;
            cabeca.anterior = cabeca;
        }

        public boolean isEmpty() {
            return cabeca.proximo == cabeca;
        }

        public void inserir(int dado) {
            No novo = new No(dado);
            No ultimo = cabeca.anterior;

            novo.proximo = cabeca;
            novo.anterior = ultimo;
            ultimo.proximo = novo;
            cabeca.anterior = novo;
        }

        public boolean buscar(int dado) {
            No atual = cabeca.proximo;
            while (atual != cabeca) {
                if (atual.dado == dado) {
                    return true;
                }
                atual = atual.proximo;
            }
            return false;
        }

        public boolean eliminar(int dado) {
            No atual = cabeca.proximo;
            while (atual != cabeca) {
                if (atual.dado == dado) {
                    No ant = atual.anterior;
                    No prox = atual.proximo;
                    ant.proximo = prox;
                    prox.anterior = ant;
                    return true;
                }
                atual = atual.proximo;
            }
            return false;
        }

        public void imprimir() {
            if (isEmpty()) {
                System.out.println("Lista: [ VAZIA ]");
                return;
            }
            System.out.print("Lista: [ ");
            No atual = cabeca.proximo;
            while (atual != cabeca) {
                System.out.print(atual.dado + " ");
                atual = atual.proximo;
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaDuplaCabeca lista = new ListaDuplaCabeca();
        int escolha = 0;

        while (escolha != 5) {
            System.out.println("\n--- LISTA DUPLA COM CABEÇA (Ex 2) ---");
            System.out.println("1. Inserir (no final)");
            System.out.println("2. Buscar elemento");
            System.out.println("3. Eliminar elemento");
            System.out.println("4. Imprimir lista");
            System.out.println("5. Sair");
            System.out.print("Escolha: ");
            
            escolha = scanner.nextInt();
            int valor;

            switch (escolha) {
                case 1:
                    System.out.print("Digite o valor para INSERIR: ");
                    valor = scanner.nextInt();
                    lista.inserir(valor);
                    System.out.println(valor + " inserido.");
                    break;
                case 2:
                    System.out.print("Digite o valor para BUSCAR: ");
                    valor = scanner.nextInt();
                    if (lista.buscar(valor)) {
                        System.out.println("ACHOU o " + valor);
                    } else {
                        System.out.println("NÃO ACHOU o " + valor);
                    }
                    break;
                case 3:
                    System.out.print("Digite o valor para ELIMINAR: ");
                    valor = scanner.nextInt();
                    if (lista.eliminar(valor)) {
                        System.out.println(valor + " ELIMINADO.");
                    } else {
                        System.out.println(valor + " não encontrado para eliminar.");
                    }
                    break;
                case 4:
                    lista.imprimir();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}