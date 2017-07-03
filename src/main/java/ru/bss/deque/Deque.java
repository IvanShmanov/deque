package ru.bss.deque;


import java.util.NoSuchElementException;

/**
 * Класс реализующий двунаправленную очередь 
 * @author Иван
 * @version 1.0
 * @param <T> тип очереди
 */
public class Deque<T> {
	
	
	/**
	 * вложеный класс реализующий узел 
	 * узел позволяет хранить данные и получать соседние узлы
	 * @param <T> 
	 */
	 private static class Node<T> {
	        T item;
	        Node<T> next;
	        Node<T> prev;

	        Node(Node<T> prev, T element, Node<T> next) {
	            this.item = element;
	            this.next = next;
	            this.prev = prev;
	        }
	    }
	 
	Node<T> first;
	Node<T> last;
	int size = 0;

	public Deque() {
	    }
	 
	
	/**
	 * метод добавляет первый элемент и увеличивает размер очередь 
	 * @param e 
	 */
	 private void linkFirst(T e) {
	        final Node<T> f = first;
	        final Node<T> newNode = new Node<>(null, e, f);
	        first = newNode;
	        if (f == null)
	            last = newNode;
	        else
	            f.prev = newNode;
	        size++;
	       
	    }

	
	 /**
	  * метод добавляет последний элемент и увеличивает размер очереди 
	  * @param e элемент, добавляемый в список
	  */
	    void linkLast(T e) {
	        final Node<T> l = last;
	        final Node<T> newNode = new Node<>(l, e, null);
	        last = newNode;
	        if (l == null)
	            first = newNode;
	        else
	            l.next = newNode;
	        size++;
	    }
	
	    
	    /**
	     * метод изымает первый элемент и уменьшает размер списка 
	     * @param f узел(элемент очереди)
	     * @return возвращает удаляемый элемент
	     */
	    private T unlinkFirst(Node<T> f) {
	        final T element = f.item;
	        final Node<T> next = f.next;
	        f.item = null;
	        f.next = null; 
	        first = next;
	        if (next == null)
	            last = null;
	        else
	            next.prev = null;
	        size--;
	        return element;
	    }

	  
	    /**
	     * метод изымает последний элемент и уменьшает размер очереди 
	     * @param l узел(элемент очереди)
	     * @return возвращает удаляемый элемент
	     */
	    private T unlinkLast(Node<T> l) {
	        final T element = l.item;
	        final Node<T> prev = l.prev;
	        l.item = null;
	        l.prev = null; 
	        last = prev;
	        if (prev == null)
	            first = null;
	        else
	            prev.next = null;
	        size--;
	        return element;
	    }	
	    
	  
	    /**
	     * метод проверяет содержится ли элемент в очереди и если да, 
	  	 * то вызывает метод удаления первого элемента
	     */
	    public T removeFirst() {
	        final Node<T> f = first;
	        if (f == null)
	            throw new NoSuchElementException();
	        return unlinkFirst(f);
	    }

	    /**
	     * метод проверяет содержится ли элемент в очереди и если да, 	   
	     * то вызывает метод удаления первого элемента
	     */
	    public T removeLast() {
	        final Node<T> l = last;
	        if (l == null)
	            throw new NoSuchElementException();
	        return unlinkLast(l);
	    }

	    /**
	     * Метод передаёт 
	     * @param e в метод добавления первого элемента 
	     */
	    public void addFirst(T e) {
	        linkFirst(e);
	    }

	    /**
	     * Метод передаёт 
	     * @param e в метод добавления первого элемента 
	     */
	    public void addLast(T e) {
	        linkLast(e);
	    }
	      
	  /**
	   * Метод демонстрирует элементы очереди
	   */
	    public void show() {
	        Object[] result = new Object[size];
	        int i = 0;
	        for (Node<T> x = first; x != null; x = x.next){
	        	result[i] = x.item;	        	
	        	 System.out.println(result[i]);
	        	 i++;
	        	}
	               
	    }  
	
}
