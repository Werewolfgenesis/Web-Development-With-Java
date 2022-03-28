package labs.week3.task1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileManagement {

    private List<File> files;

    public FileManagement() {
        this.files = new ArrayList<>();
    }

    public void make(String name, String location, String content) {
        if (content.contains("Content=")) {
            int index = content.indexOf('=');
            ContentFile contentFile;
            if (name.endsWith(".avi") ||
                    name.endsWith(".mp3")) {
                contentFile = new MediaContentFile(name, location, LocalDate.now(),
                        false, content, LocalDate.now());
            } else {
                contentFile = new DocumentContentFile(name, location, LocalDate.now(),
                        false, content, LocalDate.now());
            }
            this.files.add(contentFile);
        }
        else if (name.endsWith(".exe")){
            File file = new ExecutableFile(name, location, LocalDate.now(),
                    false,
                    Arrays.asList("one", "two"), LocalDate.now());
            this.files.add(file);
        }
    }

    public void move(String fileName, String newLoc){
        for (File f:
             this.files) {
            if (f.getName().equals(fileName)){
                f.move(newLoc);
            }
        }
    }

    public void mod(String fileName, String newContent){
        for (File f:
             this.files) {
            if (f.getName().equals(fileName)){
                f.modify(newContent);
            }
        }
    }

    public void delete(String fileName){
        try{
            for (File f:
                 this.files) {
                if (f.getName().equals(fileName)){
                    f.delete();
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void exec(String fileName){
        if (fileName.endsWith(".exe")){
            try{
                for (File f:
                        this.files) {
                    if (f.getName().equals(fileName)){
                        f.execute();
                    }
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void info(String fileName){
        for (File f:
                this.files) {
            if (f.getName().equals(fileName)){
                System.out.println(f.getInfo());
            }
        }
    }
}
