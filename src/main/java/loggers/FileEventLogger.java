package loggers;

import events.Event;
import org.apache.commons.io.FileUtils;
import utilities.EventLogger;

import java.io.File;
import java.io.IOException;

/**
 * Created by Ежище on 05.03.2017.
 */
public class FileEventLogger implements EventLogger {
    private String filename;

    @Override
    public void logEvent(Event event) {
//        try (FileWriter writer = new FileWriter(filename, true)) {
//            writer.write(event.toString());
//            writer.flush();
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
        File file = new File(filename);
        try {
            String encoding = null;
            FileUtils.writeStringToFile(file, event.toString(), encoding,true); // encoding = null означает,
            // что используется кодировка, принятая на данной платформе
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
