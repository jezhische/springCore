package loggers;

import events.Event;
import org.apache.commons.io.FileUtils;
import utilities.EventLogger;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * Created by Ежище on 05.03.2017.
 */
public class FileEventLogger implements EventLogger {
    private String filename;
    private File file;
    FileEventLogger(String filename){
        this.filename = filename;
    }
    /* с помощью этого метода проверим в spring, что файл можно создать, он не занят и т.п.
    * - check file write access: **/
    @PostConstruct
    public void init() throws Exception { // м.б. даже private для spring, но в этом случае не получится переопределение
        // метода у класса-наследника для java
        this.file = new File(filename);
        file.canWrite(); // ??? - результат никуда не идет???
    }

    @Override
    public void logEvent(Event event) {
//        try (FileWriter writer = new FileWriter(filename, true)) {
//            writer.write(event.toString() + "\n");
//            writer.flush();
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//        file = new File(filename);
        try {
            String encoding = null;
            FileUtils.writeStringToFile(file, event.toString() + "\n", encoding,true); // encoding = null
            // означает, что используется кодировка, принятая на данной платформе
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
