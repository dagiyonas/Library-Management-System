package ui;

import Interfaces.Borrowable;
import Interfaces.Returnable;
import model.Librarian;
import model.Member;
import service.LibrarySystem;
import util.LoggerUtil;
import exceptions.InvalidLibraryUserException;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LibrarySystem system = new LibrarySystem();

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Add Member");
            System.out.println("2. Add Librarian");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Borrowed Books");
            System.out.println("6. View Librarian Shift Info");
            System.out.println("7. View Logs");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = Integer.parseInt(scanner.nextLine());
            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter Member ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Section: ");
                        String section = scanner.nextLine();
                        Member m = new Member(id, section, true);
                        system.addMember(m);
                        System.out.println("Member added.");
                    }
                    case 2 -> {
                        System.out.print("Enter Librarian ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Section: ");
                        String section = scanner.nextLine();
                        System.out.print("Enter Shift: ");
                        String shift = scanner.nextLine();
                        Librarian l = new Librarian(id, section, true, shift);
                        system.addLibrarian(l);
                        System.out.println("Librarian added.");
                    }
                    case 3 -> {
                        System.out.print("Enter Member ID: ");
                        String id = scanner.nextLine();
                        Member m = system.findMember(id);
                        if (m != null) {
                            ((Borrowable) m).borrowBook();
                            System.out.print("Enter Book Title: ");
                            String title = scanner.nextLine();
                            m.borrowBook(title);
                            LoggerUtil.log("Book borrowed: " + title + " by " + id);
                        } else {
                            System.out.println("Member not found.");
                        }
                    }
                    case 4 -> {
                        System.out.print("Enter Member ID: ");
                        String id = scanner.nextLine();
                        Member m = system.findMember(id);
                        if (m != null) {
                            String result = ((Returnable) m).returnBook();
                            System.out.println(result);
                            LoggerUtil.log("Books returned by " + id);
                        } else {
                            System.out.println("Member not found.");
                        }
                    }
                    case 5 -> {
                        System.out.print("Enter Member ID: ");
                        String id = scanner.nextLine();
                        Member m = system.findMember(id);
                        if (m != null) {
                            m.listBorrowedBooks();
                        } else {
                            System.out.println("Member not found.");
                        }
                    }
                    case 6 -> {
                        System.out.print("Enter Librarian ID: ");
                        String id = scanner.nextLine();
                        Librarian l = system.findLibrarian(id);
                        if (l != null) {
                            l.getShiftDetails();
                        } else {
                            System.out.println("Librarian not found.");
                        }
                    }
                    case 7 -> LoggerUtil.readLogs();
                    case 8 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid option.");
                }
            } catch (InvalidLibraryUserException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}
