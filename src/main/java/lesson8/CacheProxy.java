package lesson8;

import java.io.File;

public class CacheProxy {
    protected static File rootDirectory;

    public CacheProxy(File rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    public ServiceProxy cache(Class<?> service) {
        return new ServiceProxy(service);
    }
}
