public class Main5 {
    public static void main(String[] args) {
        Numero5 list = new Numero5();
        System.out.println("--- Teste 1: Lista Vazia ---");
        System.out.println("Lista está vazia? " + list.isEmpty());
        list.display();
        System.out.println("Contagem: " + list.count());
        System.out.println("\n--- Teste 2: Inserindo Elementos ---");
        list.insertAtEnd("Joao");
        list.insertAtEnd("Matheus");
        list.insertAtBeginning("Caique");
        list.insertAtEnd("Luana");
        list.display();
        list.displayReverse();
        System.out.println("Lista está vazia? " + list.isEmpty());
        System.out.println("Contagem: " + list.count());
        System.out.println("\n--- Teste 3: Removendo Elementos ---");
        System.out.println("Removendo 'Matheus': " + list.remove("Matheus"));
        list.display();
        System.out.println("Removendo 'Joao': " + list.remove("Joao"));
        list.display();
        System.out.println("Tentando remover 'Elienia': " + list.remove("Elienia"));
        list.display();
        System.out.println("Removendo 'Caique': " + list.remove("Caique"));
        list.display();
        System.out.println("Removendo 'Luana': " + list.remove("Luana"));
        list.display();
        System.out.println("Contagem: " + list.count());
    }
}
