package P02_FileStream;

public class Main {
    public static void main(String[] args) {
        Streamable file = new File(10,10);
        Streamable music = new Music(10,20);

        StreamProgressInfo musicStreamInfo = new StreamProgressInfo(music);
        StreamProgressInfo fileStreamInfo = new StreamProgressInfo(file);

        System.out.println("music stream info -> " + musicStreamInfo.calculateCurrentPercent());
        System.out.println("file stream info -> " + fileStreamInfo.calculateCurrentPercent());
    }
}
