package com.example.stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();  //Hier erstelle ich einen neuen Stack

        // Hinzufügen von Elementen
        stack.push("Element 1");
        stack.push("Element 2");
        stack.push("Element 3");

        // Ausgabe der Elemente im Stack
        System.out.println("Stack Inhalt:");
        Stack<String>.StackIterator iterator = stack.iterator();  //hier verwende ich einen iterator
        while (iterator.hasNext()) {
            System.out.println(iterator.next());  // hier verwende ich das LIFO prinzip
        }

        // Entfernen des obersten Elements und Ausgabe
        System.out.println("Oberstes Element entfernen: " + stack.pop());

        // Ausgabe des aktuellen Stack-Zustands
        System.out.println("Stack nach pop:");
        iterator = stack.iterator();  //hier gibt es einen neuen iterator weil sich der stack geändert hat
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
