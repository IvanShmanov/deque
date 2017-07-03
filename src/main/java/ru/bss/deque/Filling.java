package ru.bss.deque;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import ru.bss.deque.Deque;


/**
 * загрузка файла в двунаправленную очередь
 * @author Иван
 * @version 1.0
 */
public class Filling 
{
    public static void main( String[] args )
    {
    	
    	Deque<String> d = new Deque<String>();
    	//3 переменных для подсчета загруженных элементов
    	double x = 0;
    	double y = 0;
    	int i = 0;
    
    	//чтение файла
    	try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("task.txt"), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null) {
            	d.addLast(line); 
            }
        } catch (IOException e) {
    		System.out.println("Not read" + e.toString()); 
    	}  	   	
    	
    	//последний элемент списка
    	y = Double.valueOf(d.removeLast()); 
    	d.addLast(String.valueOf(y));
    	
    	//подсчет элементов
    	while(x != y){
    		x = Double.valueOf(d.removeFirst());
    		d.addLast(String.valueOf(x));
    		i++;
    		
    	}	
    	
        //демонстрация того, что очередь осталась в первоначальном виде  
    	d.show();    	
    	System.out.println("---------");
    	//количество элементов
        System.out.println(i);
    }
}
