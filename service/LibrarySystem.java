package service;

import exceptions.InvalidLibraryUserException;
import model.Librarian;
import model.Member;
import util.LoggerUtil;

import java.util.ArrayList;

public class LibrarySystem {
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Librarian> librarians = new ArrayList<>();

    public void addMember(Member m) throws InvalidLibraryUserException {
        if (m == null || members.stream().anyMatch(mem -> mem.getUserId().equals(m.getUserId()))) {
            throw new InvalidLibraryUserException("Invalid or duplicate member.");
        }
        members.add(m);
        LoggerUtil.log("Added member: " + m.getUserId());
    }

    public void addLibrarian(Librarian l) throws InvalidLibraryUserException {
        if (l == null || librarians.stream().anyMatch(lib -> lib.getUserId().equals(l.getUserId()))) {
            throw new InvalidLibraryUserException("Invalid or duplicate librarian.");
        }
        librarians.add(l);
        LoggerUtil.log("Added librarian: " + l.getUserId());
    }

    public Member findMember(String id) {
        return members.stream().filter(m -> m.getUserId().equals(id)).findFirst().orElse(null);
    }

    public Librarian findLibrarian(String id) {
        return librarians.stream().filter(l -> l.getUserId().equals(id)).findFirst().orElse(null);
    }
}
