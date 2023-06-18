import java.util.Scanner;
class Node {
    String name;
    Node next;

    public Node(String name) {
        this.name = name;
        this.next = null;
    }
}

class List {
    Node head;

    public void add(String name) {
        Node newNode = new Node(name);

        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public Node find(String name) {
        Node current = head;

        while (current != null) {
            if (current.name.equals(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean delete(String name) {
        if (head == null) {
            return false;
        }

        if (head.name.equals(name)) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.name.equals(name)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean edit(String oldName, String newName) {
        Node existingNode = find(oldName);
        if (existingNode != null) {
            existingNode.name = newName;
            return true;
        }
        return false;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.name);
            current = current.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        List list = new List();
        Scanner scanner = new Scanner(System.in);

        list.add("Иванов Иван Иванович");
        list.add("Петров Петр Петрович");
        list.add("Сидоров Сидор Сидорович");

        System.out.println("Список:");
        list.display();
        System.out.println();

        System.out.println("Добавление нового элемента:");
        System.out.print("Введите ФИО: ");
        String name = scanner.nextLine();
        list.add(name);
        System.out.println("Список после добавления:");
        list.display();
        System.out.println();

        System.out.println("Удаление элемента из списка:");
        System.out.print("Введите ФИО: ");
        name = scanner.nextLine();
        boolean deleted = list.delete(name);
        if (deleted) {
            System.out.println("Элемент успешно удален");
            System.out.println("Список после удаления:");
            list.display();
            System.out.println();
        } else {
            System.out.println("Элемент не найден");
        }

        System.out.println("Изменение элемента в списке:");
        System.out.print("Введите ФИО, которое нужно изменить: ");
        String oldName = scanner.nextLine();
        System.out.print("Введите новое ФИО: ");
        String newName = scanner.nextLine();
        boolean edited = list.edit(oldName, newName);
        if (edited) {
            System.out.println("Элемент успешно изменен");
            System.out.println("Список после изменения:");
            list.display();
            System.out.println();
        } else {
            System.out.println("Элемент не найден");
        }
    }
}
