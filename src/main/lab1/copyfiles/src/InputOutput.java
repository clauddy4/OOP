import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class InputOutput {
    private final File file;

    public InputOutput(String pathToFile) throws IOException {
        this.file = new File(pathToFile);
        getFileInstance();
    }

    public File getFileInstance() throws IOException {
        create();
        return file;
    }

    public void create() throws IOException {
        if (!file.exists()) {
            final boolean isCreated = file.createNewFile();
            if (!isCreated) {
                throw new IOException("Cannot create input file!");
            }
        }
    }

    public InputOutput write(String string) throws IOException {
        final List<String> lines = Collections.singletonList(string);
        Files.write(Path.of(file.getAbsolutePath()), lines, Charset.forName("UTF-8"));
        return this;
    }

    public String read() throws IOException {
        return Files.readString(Path.of(file.getAbsolutePath()));
    }
}