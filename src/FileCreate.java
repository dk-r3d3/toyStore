import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class FileCreate {
    public void createFile(List prizeList) throws Exception {
        File myFile = new File("prizeToys");
        myFile.createNewFile();
        FileWriter outputStream = new FileWriter(myFile);
        outputStream.write("Список призовых игрушек в порядке выпадения: \n");
        for(Object str: prizeList) {
            outputStream.write(str.toString() + System.lineSeparator());
        }
        outputStream.close();
    }
}
