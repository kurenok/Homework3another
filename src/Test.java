import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (exit == false) {
            System.out.println("Test 1: Проверка удаления Корня");
            System.out.println("Test 2: Проверка удаления Лепестка");
            System.out.println("Test 3: Проверка удаления Родителя");
            System.out.println("Test 4: Проверка удаления Старика ");
            System.out.print("Укажите номер теста который вас интересует: ");
            byte testIndex = scanner.nextByte();
            //Проверка удаления корня
            if (testIndex == 1) {
                TreeSet<Integer> myTree = new TreeSet<>();
                myTree.put(100);
                myTree.put(160);
                myTree.put(50);
                System.out.println("Корень равен: " + myTree.getRoot() + "\n---Список всех элементов до удаления---");
                myTree.printTree();
                myTree.remove(100);
                System.out.println("Корень равен: " + myTree.getRoot() + "\n---Список всех элементов после удаления---");
                myTree.printTree();
                System.out.println("Продолжим Да/Нет?");
                String string = scanner.next();
                if (string.equals("Нет") || string.equals("нет")) {
                    exit = true;
                }
            } else if (testIndex == 2) {
                TreeSet<Integer> myTree = new TreeSet<>();
                myTree.put(100);
                myTree.put(160);
                myTree.put(50);
                System.out.println("---Список всех элементов до удаления---");
                myTree.printTree();
                myTree.remove(50);
                System.out.println("---Список всех элементов после удаления---");
                myTree.printTree();
                System.out.println("Продолжим Да/Нет?");
                String string = scanner.next();
                if (string.equals("Нет") || string.equals("нет")) {
                    exit = true;
                }
            } else if (testIndex == 3) {
                TreeSet<Integer> myTree = new TreeSet<>();
                myTree.put(40);
                myTree.put(60);
                myTree.put(20);
                myTree.put(10);
                myTree.put(30);
                System.out.println("---Список всех элементов до удаления---");
                myTree.printTree();
                myTree.remove(20);
                System.out.println("---Список всех элементов после удаления---");
                myTree.printTree();
                System.out.println("Продолжим Да/Нет?");
                String string = scanner.next();
                if (string.equals("Нет") || string.equals("нет")) {
                    exit = true;
                }

            } else {
                TreeSet<Integer> myTree = new TreeSet<>();
                myTree.put(40);
                myTree.put(60);
                myTree.put(20);
                myTree.put(10);
                myTree.put(30);
                myTree.put(5);
                System.out.println("---Список всех элементов до удаления---");
                myTree.printTree();
                myTree.remove(20);
                System.out.println("---Список всех элементов после удаления---");
                myTree.printTree();
                System.out.println("Продолжим Да/Нет?");
                String string = scanner.next();
                if (string.equals("Нет") || string.equals("нет")) {
                    exit = true;
                }
            }

        }
    }
}
//я не знаю как сделать тест к 3 дз, вот другая прога(