package org.example;

import java.time.LocalDateTime;
import java.time.Duration;

public class books {
    String BOOK_title;
    String Author;
    int no_of_copies;

    static int No_of_Books;

    public books(String BOOK_title,String Author,int no_of_copies){
        this.Author=Author;
        this.BOOK_title=BOOK_title;
        this.no_of_copies=no_of_copies;
        books.No_of_Books++;
    }

    public static int getNo_of_Books(){
        return No_of_Books;
    }

    public int change_copies(){
        this.no_of_copies--;
        return no_of_copies;


    }
    public int increase_copies(){
        this.no_of_copies++;
        return no_of_copies;
    }

    public static long calculateTimeDifferenceInSeconds(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        Duration duration = Duration.between(dateTime1, dateTime2);
        return Math.abs(duration.getSeconds()); // Use Math.abs() to get the absolute difference
    }
}



