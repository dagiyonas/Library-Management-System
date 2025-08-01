package model;

public class Libraryuser {
package model;

import exceptions.InvalidLibraryUserException;

public abstract class LibraryUser {
    protected String userId;
    protected String section;
    protected boolean isAuthorized;

    public LibraryUser(String userId, String section, boolean isAuthorized) {
        this.userId = userId;
        this.section = section;
        this.isAuthorized = isAuthorized;
    }

    public abstract void displayInfo();

    public void checkCondition() throws InvalidLibraryUserException {
        if (userId == null || userId.length() < 4 || section == null) {
            throw new InvalidLibraryUserException("Invalid user ID or section.");
        }
        if (isAuthorized) {
            System.out.println("Library access granted.");
        }
    }

    public String getUserId() {
        return userId;
    }
}

}
