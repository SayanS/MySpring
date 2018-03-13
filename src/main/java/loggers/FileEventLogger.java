package loggers;

import beans.Event;

import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class FileEventLogger implements EventLogger{
    private  File file;
    private String filename;

    public FileEventLogger(String filename){
        this.filename=filename;
    }

    public void init() throws Exception {
        file = new File(filename);
        if (file.exists() && !file.canWrite()) {
            throw new IllegalArgumentException("Can't write to file " + filename);
        } else if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Exception e) {
                throw new IllegalArgumentException("Can't create file", e);
            }

        }

    }

    public void logEvent(Event event) {
        try {
            FileWriter fw=new FileWriter(filename, true);
            fw.write(event.toString());
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
}
