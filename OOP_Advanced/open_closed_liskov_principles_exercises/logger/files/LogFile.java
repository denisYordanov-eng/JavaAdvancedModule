package logger.files;

public class LogFile implements File{
    private StringBuilder buffer = new StringBuilder();

    public  LogFile() {
        buffer = new StringBuilder();
    }

    @Override
    public void write(String text) {
        this.buffer.append(text).append(System.lineSeparator());
    }

    @Override
    public int getSize() {
        int size = 0;
        for(char c : this.buffer.toString().toCharArray()) {
            if(Character.isLetter(c)){
                size += c;
            }
        }
        return size;
    }

    @Override
    public String getContent() {
        return this.buffer.toString();
    }
}
