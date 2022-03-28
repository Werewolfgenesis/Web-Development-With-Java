package labs.week3.task1;

import java.time.LocalDate;

public abstract class ContentFile extends File {
    protected String content;
    protected LocalDate lastExecutionDate;

    public ContentFile() {

    }

    public ContentFile(String name, String location, LocalDate creationDate, boolean isDeleted,
                       String content, LocalDate lastExecutionDate) {
        super(name, location, creationDate, isDeleted);
        this.content = content;
        this.lastExecutionDate = lastExecutionDate;
    }


}
