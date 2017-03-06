package loggers;

import events.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by WORK_x64 on 06.03.2017.
 */
public class CacheFileEventLogger extends FileEventLogger {

    private int cacheSize;
    private List<Event> cache;
    CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        cache = new ArrayList<>();
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);
        if (cache.size() == cacheSize) {
            for (int i = 0; i < cache.size(); i++)
                super.logEvent(cache.get(i));
            cache.clear();
        }
    }

    /* destroy-method нужен для того, чтобы spring вызвал его, когда закрывается контекст, и записал в файл последнее
    сообщение (иначе оно потеряется) **/
    private void destroy() {
        if (!cache.isEmpty()) {
            for (int i = 0; i < cache.size(); i++)
                super.logEvent(cache.get(i));
        }
//        cache.clear();
    }
    @Override
    public void init() throws Exception {
        super.init();
    }
}
