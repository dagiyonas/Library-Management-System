package model;

import Interfaces.Borrowable;
import Interfaces.Returnable;

import java.util.ArrayList;

public class Member extends LibraryUser implements Borrowable, Returnable {
    private ArrayList<String> borrowedBooks;

    public Member(String userId, String section, boolean isAuthorized) {
        super(userId, section, isAuthorized);
        this.borrowedBooks = new ArrayList<>();
    }

    @Override
    public void borrowBook() {
        System.out.println("Member is borrowing a book.");
    }

    public void borrowBook(String bookTitle) {
        borrowedBooks.add(bookTitle);
        System.out.println("Borrowed: " + bookTitle);
    }

    @Override
    public String returnBook() {
        borrowedBooks.clear();
        return "Return successful for all borrowed books.";
    }

    public void listBorrowedBooks() {
        System.out.println("Borrowed Books:");
        for (String book : borrowedBooks) {
            System.out.println("- " + book);
        }
    }

    @Override
    public void checkCondition() {
        try {
            super.checkCondition();
            System.out.println("Member validated.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Member ID: " + userId + ", Section: " + section);
    }
}
