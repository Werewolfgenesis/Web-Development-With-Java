package labs.week3.task1;

public class TestFileSystem {
    public static void main(String[] args) {
        FileManagement fileManagement = new FileManagement();

        fileManagement.make("opii.txt", "/mitaka/projects/", "Content=Hello world");

        fileManagement.info("opii.txt");

        fileManagement.delete("opii.txt");
        fileManagement.info("opii.txt");

    }

}
