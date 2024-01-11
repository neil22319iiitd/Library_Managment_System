package org.example;

import java.time.LocalTime;
import java.time.Clock;


public class Member {
    int age;
    String name;
    long phone_no;

    static int No_of_members;

    int[] Books_borrowed = {0,0};

    long[] fines={0,0};

    long[] issuedate=new long[2];

    boolean[] is_returned={false,false};




    public Member(int age,String name,long phone_no) {
        this.age = age;
        this.name=name;
        this.phone_no=phone_no;

        Member.No_of_members+=1;

    }
    public void returned (int index){
        is_returned[index]=true;


    }
    public void issuedate1(int index){
        long variable=present_time();
        issuedate[index]=variable;

    }
    public static int getNextMemberId() {
        return No_of_members;
    }

    public static void options(){
        System.out.println("1.List Available Books\n" +
                "2.List My Books\n" +
                "3.Issue book\n" +
                "4.Return book\n" +
                "5.Pay Fine\n" +
                "6.Back\n");

    }
    public static void options_to_librarian(){
        System.out.println("1   Register a member\n" +
                "2   Remove a member\n" +
                "3    Add a book\n" +
                "4    Remove a book\n" +
                "5    View all members along with their books and fines to be paid\n" +
                "6    View all books\n" +
                "7    Back\n");
    }

    public void addbookstoarray(int book_id){
        if(Books_borrowed[0]==0){
            Books_borrowed[0]=book_id;
        }
        else if(Books_borrowed[1]==0){
            Books_borrowed[1]=book_id;

        }


    }
    public static long present_time(){
        Clock clock = Clock.systemDefaultZone();
        LocalTime currentTime = LocalTime.now(clock);
        long min =currentTime.getMinute();
        long secs =currentTime.getSecond();
        long total_time =(min*60) + (secs);
        return total_time;
    }

    public static long difference(long currtime,long prevtime){
        return Math.abs(currtime- prevtime);
    }
}

