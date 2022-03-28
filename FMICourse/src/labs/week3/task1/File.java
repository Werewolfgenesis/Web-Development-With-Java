package labs.week3.task1;

import java.time.LocalDate;
import java.util.Date;

public abstract class File {
    private String name;
    protected String location;
    protected LocalDate creationDate;
    protected boolean isDeleted;

    public File() {

    }

    public File(String name, String location, LocalDate creationDate, boolean isDeleted) {
        this.setName(name);
        this.location = location;
        this.creationDate = creationDate;
        this.isDeleted = isDeleted;
    }

    public File(File other) {
        this(other.getName(), other.location, other.creationDate, other.isDeleted);
    }

    public void move(String newLocation) {
        if (newLocation == null ||
                newLocation.isBlank()) {
            throw new IllegalArgumentException("Please check your argument!");
        } else {
            this.location = newLocation;
        }
    }

    //public abstract File copy(String newLocation);

    public void delete() throws Exception {
        System.out.println("Deleting file...");
        if (isDeleted) {
            throw new Exception("File already deleted!");
        }
        this.isDeleted = true;
    }

    public boolean execute() throws Exception {
        if (this.isDeleted) {
            throw new Exception();
        }
        return true;
    }

    public boolean modify(String data) {
        return false;
    }

    public String getInfo() {
        return this.toString();
    }

    @Override
    public String toString() {
        if (isDeleted){
            return "File " +
                     getName() + " has been deleted!";
        }
        return "File{" +
                "name='" + getName() + '\'' +
                ", location='" + location + '\'' +
                ", creationDate=" + creationDate +
                ", isDeleted=" + isDeleted +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
