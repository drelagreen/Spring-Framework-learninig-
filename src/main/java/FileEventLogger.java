import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger{
    private File file;
    private String filepath;
    FileEventLogger(String filePath){
        this.filepath = filePath;
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException{
        this.file = new File(filepath);
        if (!file.canWrite()) throw new IOException();
    }
}
