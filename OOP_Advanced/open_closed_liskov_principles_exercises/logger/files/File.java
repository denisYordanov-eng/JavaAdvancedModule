package logger.files;

public interface File {
    void write(String text);

    int getSize();

    String getContent();
}
