package sonia.youtrack;

public class TestYouTrack {

    public static void main(String[] args) {
        YouTrackSession session = YouTrack.createSession("https://moneta.stringdata.cz/hub", "marko.ziza@stringdata.cz", "leonardcohen");
    }

}
