package ru.bss.deque;

import java.util.LinkedList;

/**
 * Класс реализующий двунаправленную очередь на основе LinkedList
 * @author Иван
 * @version 1.0
 * @param <T> тип очереди
 */
public class Deque<T> {
	
	LinkedList<T> items = new LinkedList<T>();
	
	/**
	 * добавление элемента в начало очереди
	 * @param value добавляемый элемент
	 */
	public void pushFirst(T value)
	{
	    items.addFirst(value);
	}
	
	/**
	 * добавление элемента в конец очереди
	 * @param value добовляемый элементп
	 */
	public void pushLast(T value)
	{
	    items.addLast(value);
	}
 
	/**
	 * метод изьятия первого элемента
	 * @return 
	 */
	public T pullFirst()
	{
	    if (items.isEmpty())
	    {
	        throw new IllegalArgumentException("Первое значение очереди является пустым");
	    }
	 
	    T temp = (T) items.getFirst();
	 
	    items.removeFirst();
	 
	    return temp;
	}
 
	/**
	 * метод изьятия второго элемента
	 * @return
	 */
	public T pullLast()
	{
	    if (items.isEmpty())
	    {
	        throw new IllegalArgumentException("Последнее значение очереди является пустым");
	    }
	 
	    T temp = (T) items.getLast();	    
	 
	    items.removeLast();
	 
	    return temp;
	}
	
	/**
	 * демонстрация списка
	 */
	public void Show(){
		System.out.println(items);
	}
}
