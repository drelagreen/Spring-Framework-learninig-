import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    private final int cacheSize;
    private final List<Event> cache;

    public CacheFileEventLogger(String filePath, int cacheSize) {
        super(filePath);
        cache=new ArrayList<>(cacheSize+1);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size()==cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    private void writeEventsFromCache() {
        for (Event event : cache) {
            logEvent(event);
        }
    }
}
