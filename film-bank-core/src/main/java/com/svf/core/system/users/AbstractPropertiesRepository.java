package com.svf.core.system.users;

import com.svf.core.facades.UsersFacade;
import com.svf.core.tools.ResourcesUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by stepanferubko
 */
public abstract class AbstractPropertiesRepository {
    private final static Logger LOG = Logger.getLogger(UsersFacade.class.getName());

    private static final String ROOT = "config/";

    /**
     * 1. A /config subdirectory of the current directory.
     * 2. The current directory
     * 3. A classpath /config package
     * 4. The classpath root
     */
    protected Properties load(String name) {
        return ResourcesUtil.loadProperties(() -> ResourcesUtil.getTopConfig(name, getClass()));
    }

    protected Properties remove(String property, String name) {
        Properties all = load(name);
        Properties removed = new Properties();
        if (all.containsKey(property)) {
            all.remove(property);
            write(all, name);
        }
        return removed;
    }

    protected void write(Properties properties, String name) {
        try {
            Path path = getDestinationPath(name);
            makeBackup(name, path);
            properties.store(Files.newOutputStream(path, StandardOpenOption.CREATE), null);
            LOG.info("Saved changes to " + path.toAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Path getDestinationPath(String name) throws IOException {
        Path rootPath = Paths.get(ROOT);
        if (!Files.exists(rootPath)) {
            LOG.info("Created config directory: " + rootPath.toAbsolutePath());
            Files.createDirectory(rootPath);
        }
        return Paths.get(ROOT, name);
    }

    private void makeBackup(String name, Path path) throws IOException {
        if (Files.exists(path)) {
            String backupName = String.format("%s.%s", name, new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date()));
            Files.move(path, getDestinationPath(backupName));
        }
    }
}
