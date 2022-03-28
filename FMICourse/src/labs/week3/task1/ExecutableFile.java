package labs.week3.task1;

import java.time.LocalDate;
import java.util.List;

public class ExecutableFile extends File {
    protected List<String> requiredResources;
    protected LocalDate lastExecutionDate;

    public ExecutableFile(String name, String location, LocalDate creationDate, boolean isDeleted,
                          List<String> requiredResources, LocalDate lastExecutionDate) {
        super(name, location, creationDate, isDeleted);
        this.requiredResources = requiredResources;
        this.lastExecutionDate = lastExecutionDate;
    }
}
