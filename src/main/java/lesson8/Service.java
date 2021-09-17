package lesson8;

import java.util.Date;
import java.util.List;

public interface Service {
    void doHardWork();

    @Cache(cacheType = CacheType.FILE, fileName = "data", doZipArchive = false)
    List<String> run(String item, double value, Date date);

    @Cache(cacheType = CacheType.IN_MEMORY)
    List<String> work(String item);

}
