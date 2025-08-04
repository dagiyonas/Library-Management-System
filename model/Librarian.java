package model;
import Interfaces.Borrowable;
import Interfaces.Returnable;

public class Librarian extends LibraryUser implements Borrowable, Returnable {
    private String shift;

    public Librarian(String userId, String section, boolean isAuthorized, String shift) {
        super(userId, section, isAuthorized);
        this.shift = shift;
    }

    @Override
    public void borrowBook() {
        System.out.println("Librarian processes book for borrowing.");
    }

    public void borrowBook(String department) {
        System.out.println("Books borrowed from: " + department + " section.");
    }

    @Override
    public String returnBook() {
        return "Return policy managed by librarian.";
    }

    public String getShiftDetails() {
        return "Shift: " + shift;
    }

    @Override
    public void checkCondition() {
        try {
            super.checkCondition();
            System.out.println("Librarian verified.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Librarian ID: " + userId + ", Section: " + section + ", Shift: " + shift);
    }
}
