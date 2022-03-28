package labs.week3.task1;

import java.time.LocalDate;

public class DocumentContentFile extends ContentFile{
    public DocumentContentFile(){
        super();
    }

    public DocumentContentFile(String name, String location, LocalDate creationDate, boolean isDeleted,
                               String content, LocalDate lastExecutionDate){
        super(name, location, creationDate, isDeleted, content, lastExecutionDate);
    }
}
