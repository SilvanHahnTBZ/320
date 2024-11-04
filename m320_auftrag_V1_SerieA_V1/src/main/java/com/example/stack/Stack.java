package com.example.stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack<E> {
    private ArrayList<E> elements;

    // Konstruktor
    public Stack() {
        this.elements = new ArrayList<>();
    }

    // Hier füge ich ein element zum stack hinzu
    public void push(E element) {
        elements.add(element);  // Das Element wird ans Ende der Liste hinzugefügt
    }

    // Hier entferne ich das oberste element zurück und gib es aus
    public E pop() {
        if (elements.isEmpty()) {
            throw new NoSuchElementException("Der Stack ist leer.");
        }
        return elements.remove(elements.size() - 1);  // hier gib ich mit LIFO das letzte element aus
    }

    // Getter für die abfrage der Größe des Stacks
    public int size() {
        return elements.size();
    }

    // Iterator-Funktionalität als innere Klasse
    public StackIterator iterator() {
        return new StackIterator();
    }

    // Innere Klasse für die Iteration über den Stack
    class StackIterator implements java.util.Iterator<E> {
        private int index = elements.size();  // Startet am Ende des Stacks

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("Keine weiteren Elemente.");
            }
            return elements.get(--index);  // mit LIFO Das letzte hinzugefügte Element wird zurückgegeben
        }

        @Override
        public void remove() {
            if (index == elements.size()) {
                throw new IllegalStateException("Es wurde noch kein Element iteriert.");
            }
            elements.remove(index);  // Entfernt das zuletzt iterierte Element
        }
    }
}
