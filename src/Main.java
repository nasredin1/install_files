import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> fileList = Arrays.asList(
                new File("c://Games//src//main//main.java"),
                new File("c://Games//src//main//utils.java"),
                new File("c://Games//temp//temp.txt")
        );
        List<File> folderList = Arrays.asList(
                new File("c://Games//temp"),
                new File("c://Games//src"),
                new File("c://Games//res"),
                new File("c://Games//savegames"),
                new File("c://Games//src//main"),
                new File("c://Games//src//test"),
                new File("c://Games//res//drawables"),
                new File("c://Games//res//vectors"),
                new File("c://Games//res//icons")
        );

        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) sb.append("Папка " + folder + " создана\n");
            else sb.append("Папка " + folder + " не создана\n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл " + file + " создан\n");
                else sb.append("Файл " + file + " не создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');
            }
        });
        try (FileWriter log = new FileWriter("c://Games//temp//temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader("c://Games//temp//temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
