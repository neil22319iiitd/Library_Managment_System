package org.example;
import java.sql.SQLOutput;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Library portal initailized...");
        System.out.println("------------------");
        System.out.println("1. Enter as a librarian");
        System.out.println("2. Enter as a member");
        System.out.println("3.Exit");
        Scanner sc = new Scanner(System.in);

        System.out.println("------------------");
        int elements = 100;
        ArrayList<Member> members_of_library = new ArrayList<>(elements);
        // arr1 stores the information of memebers in the l
        ArrayList<books> Books_info = new ArrayList<>(100);
        // Books_info stores the info of each book in it
        while(true){
            int Choice=sc.nextInt();
            if(Choice==1){
                // enter as a librarian
//            System.out.println("1   Register a member\n" +
//                    "2   Remove a member\n" +
//                    "3    Add a book\n" +
//                    "4    Remove a book\n" +
//                    "5    View all members along with their books and fines to be paid\n" +
//                    "6    View all books\n" +
//                    "7    Back\n");
                Member.options_to_librarian();
                while(true){
                    int Choice_two=sc.nextInt();
                    if(Choice_two==7){
                        System.out.println("back ");
                        System.out.println();
                        System.out.println("1. Enter as a librarian");
                        System.out.println("2. Enter as a member");
                        System.out.println("3.Exit");
                        break;
                    }
                    else if(Choice_two==4){
                        System.out.print("enter book id : ");
                        int Book_id_to_remove=sc.nextInt();
                        for(int id=0;id<Books_info.size();id++){
                            if(id==Book_id_to_remove-1){
                                System.out.println(Books_info.get(id).BOOK_title+"has been removed ");
                                Books_info.remove(Books_info.get(id));
                            }
                        }
                    }
                    else if(Choice_two==2){
                        System.out.print("enter member id: ");
                        int Member_id_to_remove=sc.nextInt();
                        for(int id=0;id<members_of_library.size();id++){
                            if(id==Member_id_to_remove-1){
                                System.out.println(members_of_library.get(id).name+" has been removed from the library");
                                members_of_library.remove(members_of_library.get(id));
                            }

                        }
                    }
                    else if(Choice_two==1){
                        sc.nextLine();
                        System.out.print("Name : ");
                        String name =sc.nextLine();
                        //sc.nextLine();
                        //System.out.println();
                        System.out.print("Age : ");
                        int age=sc.nextInt();
                        //System.out.println();
                        System.out.print("Phone no:  ");
                        long phone_no=sc.nextLong();
                        System.out.println();

                        Member new_member= new Member(age,name,phone_no);
//                        System.out.println(new_member.name);
//                        System.out.println(new_member.age);
//                        System.out.println(new_member.phone_no);
                        int id_of_member=Member.getNextMemberId();
                        System.out.println("Member Successfully Registered with ! "+id_of_member);

                        members_of_library.add(new_member);

//                    System.out.println(members_of_library.get(id_of_member-1).name+" "+members_of_library.get(id_of_member-1).phone_no+" "+members_of_library
//                            .get(id_of_member-1).age);






                    }
                    else if(Choice_two==3){
                        sc.nextLine();
                        System.out.print("Book title :  ");
                        String BOOK_title=sc.nextLine();
                        //sc.nextLine();
                        // System.out.println();
                        System.out.print("Book author :  ");
                        String Author=sc.nextLine();
                        System.out.print("Copies");
                        int no_of_copies=sc.nextInt();
                        sc.nextLine();
                        books BOOK=new books(BOOK_title,Author,no_of_copies);
                        int id_of_Book=books.getNo_of_Books();
                        System.out.println("Book added succesfully with book id "+id_of_Book);
                        Books_info.add(BOOK);
                        System.out.println(BOOK.BOOK_title);




                    }
                    else if(Choice_two==6){
                        for(int i=0;i<Books_info.size();i++){
                            int ID=i+1;
                            System.out.println("Book id"+"="+(ID));
                            System.out.println("Name ="+Books_info.get(i).BOOK_title);
                            //System.out.println("Name ="+Books_info.get(i).BOOK_title);
                            System.out.println("Author="+Books_info.get(i).Author);
                            System.out.println();
                        }
                    }


                }


            }
            else if(Choice==2){
                // enter as a Member
                sc.nextLine();
                System.out.print("Name:  ");
                String name=sc.nextLine();
                //sc.nextLine();

                System.out.print("Phone no: ");
                long Phone_no=sc.nextLong();
                int i;
                for(i=0;i<members_of_library.size();i++){
                    if(members_of_library.get(i).name.equals(name) && members_of_library.get(i).phone_no==Phone_no){
                        System.out.println("Welcome " + members_of_library.get(i).name + ". Member id " + (i + 1));
                        break;
                    }

                }
                if(i==members_of_library.size()){
                    System.out.println("Member with name "+ name + ". and Phone no "+Phone_no+" doesnt exist");

                }
                else if(i<=members_of_library.size()-1){
                    while(true){
                        Member.options();
//                    System.out.println("1.List Available Books\n" +
//                            "2.List My Books\n" +
//                            "3.Issue book\n" +
//                            "4.Return book\n" +
//                            "5.Pay Fine\n" +
//                            "6.Back\n");
                        int choice_to_members=sc.nextInt();
                        LocalDateTime current_time=null;
                        LocalDateTime return_time=null;
                        if(choice_to_members==3){
                            // Issue a book
                            System.out.print("BOOK ID :");
                            int book_id=sc.nextInt();
                            sc.nextLine();
                            System.out.print("BOOK_NAME :");
                            String Book_name=sc.nextLine();
                            //sc.nextLine();
                            //System.out.println("hello 1");
                            for(int z=0;z<Books_info.size();z++){
                                if(book_id==z+1){
                                    //System.out.println("HELLO 2"); //
                                    for(int j=0;j<members_of_library.size();j++){
                                        if(members_of_library.get(j).name.equals(name)){
                                            //System.out.println("hello 2.5"); //
                                            if((members_of_library.get(j).Books_borrowed[0]==0 || (members_of_library.get(j)).Books_borrowed[1]==0)){
                                                //System.out.println("hello 3"); //

                                                for(int k=0;k<Books_info.size();k++){
                                                    //System.out.println(k); //
                                                    if((Books_info.get(k).BOOK_title).equals(Book_name)){
                                                        //System.out.println("hello 4");

                                                        if(Books_info.get(k).no_of_copies>=1){
                                                            if(members_of_library.get(j).fines[0]==0 && members_of_library.get(j).fines[1]==0){

                                                                int changed_copies =Books_info.get(k).change_copies();
                                                                System.out.println("Book issued succesfully");
                                                                long curent_time=Member.present_time();
                                                                int index=0;
                                                                if(members_of_library.get(j).Books_borrowed[0]==0){
                                                                    index=0;
                                                                }
                                                                else if(members_of_library.get(j).Books_borrowed[1]==0){
                                                                    index=1;
                                                                }
                                                                members_of_library.get(j).issuedate1(index);
                                                                members_of_library.get(j).addbookstoarray(book_id);


                                                            }
                                                            else{
                                                                System.out.println("you have to pay your dues ");
                                                            }
                                                            //System.out.println("hello 5");


//                                                            current_time=LocalDateTime.now();
//                                                            System.out.println("issueing time is "+current_time);




                                                        }
                                                    }
                                                }


                                            }


                                        }
                                    }

                                }
                            }
                        }
                        else if(choice_to_members==1){
                            for(int t=0;t<Books_info.size();t++){
                                if(Books_info.get(t).no_of_copies>=1){
                                    System.out.println("BOOK TITLE I: "+Books_info.get(t).BOOK_title);
                                    System.out.println("BOOK AUTHOR :"+Books_info.get(t).Author);
                                    System.out.println("BOOK  ID:  :"+t+1);
                                }

                            }

                        }
                        else if (choice_to_members==2){
                            for(int t=0;t<members_of_library.size();t++){
                                if(members_of_library.get(t).name.equals(name)){
                                    for(int bb=0;bb<members_of_library.get(t).Books_borrowed.length;bb++){
                                        if(members_of_library.get(t).Books_borrowed[bb]!=0){
                                            System.out.println("BOOK TITLE is "+Books_info.get((members_of_library.get(t).Books_borrowed[bb])-1).BOOK_title);
                                        }
                                        //System.out.println("-----------------");
                                    }
                                }
                            }
                        }
                        else if(choice_to_members==4){

                            System.out.print("ENTER BOOK ID : ");
                            int BOOK_ID_TO_RETURN=sc.nextInt();
                            //sc.nextLine();
                            System.out.println("BOOK WITH BOOK ID :"+BOOK_ID_TO_RETURN+" RETURNED SUCCESFULLY");
                            for(int anyvar=0;anyvar<members_of_library.size();anyvar++){
                                //System.out.println(anyvar);
                                if(members_of_library.get(anyvar).name.equals(name)){
                                    //System.out.println("hello1");
                                    System.out.println(members_of_library.get(anyvar).Books_borrowed[0]);
                                    if(members_of_library.get(anyvar).Books_borrowed[0]==BOOK_ID_TO_RETURN){
                                        //System.out.println("hello2");
                                        members_of_library.get(anyvar).Books_borrowed[0]=0;
                                        members_of_library.get(anyvar).returned(0);

                                    }
                                    else if(members_of_library.get(anyvar).Books_borrowed[1]==BOOK_ID_TO_RETURN){
                                        //System.out.println("hello 3");
                                        members_of_library.get(anyvar).Books_borrowed[1]=0;
                                        members_of_library.get(anyvar).returned(0);

                                    }
                                }

                            }
                            for(int anyvar=0;anyvar<Books_info.size();anyvar++){
                                if(anyvar==BOOK_ID_TO_RETURN){
                                    int new_no_of_copies=Books_info.get(anyvar).increase_copies();

                                }
                            }




                        }
                        else if(choice_to_members==5){


//                            System.out.println("enter phone number");
//                            long phone_num_person=sc.nextLong();
//                            sc.nextLine();
//                            System.out.print("enter  name :");
//                            String name_of_person=sc.nextLine();
//                            System.out.println(name_of_person);
                            for(int vari=0;vari<members_of_library.size();vari++){
                                //System.out.println("302");
                                if(members_of_library.get(i).name.equals(name) && members_of_library.get(i).phone_no==Phone_no){
                                    //System.out.println("304");
                                    if(members_of_library.get(vari).is_returned[0]){
                                        //System.out.println("306");
                                        long pain=Member.present_time();
                                        long answer=members_of_library.get(vari).issuedate[0];
                                        long pain_answer=Math.abs(pain-answer);
                                        if(pain_answer>10){
                                            //System.out.println("311");
                                            System.out.println("you fine is "+ (pain_answer-10)*3.0);
                                        }
                                        else{
                                            System.out.println("no fine to be paid");
                                        }
                                    }else if(members_of_library.get(vari).is_returned[1]){
                                        long pain=Member.present_time();
                                        long answer=members_of_library.get(vari).issuedate[1];
                                        long pain_answer=Math.abs(pain-answer);
                                        if(pain_answer>10){
                                            System.out.println("you fine is "+ (pain_answer-10)*3.0);
                                        }
                                        else{
                                            System.out.println("no fine to be paid");
                                        }

                                    }else{
                                        System.out.println("no books issued ");
                                    }
                                }
                            }

                        }else if(choice_to_members==6){
                            System.out.println("going back ...");
                            break;
                        }


                    }
                }
            }
            else{
                break;
            }


        }
    }


}

