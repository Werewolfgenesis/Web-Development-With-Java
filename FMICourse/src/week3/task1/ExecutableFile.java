package week3.task1;

import java.time.LocalDate;
import java.util.List;

public class ExecutableFile extends File{
    protected List<String> requiredResources;
    protected LocalDate lastExecutionDate;

    @Override
    public File copy(String newLocation) {

        lastExecutionDate = LocalDate.now();
        return  this;
    }
}
