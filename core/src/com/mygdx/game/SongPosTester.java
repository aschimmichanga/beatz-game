public class SongPosTester
{
    import com.badlogic.gdx.Game;
    import com.badlogic.gdx.Gdx;
    import com.mygdx.game.utils;
    import assets.ElectroSurge.mp3;


    public static void main(String[] args)
    {
        Song x = new Song("ElectroSurge.mp3", 0, 128);
        boolean playing;

        x.getMusic().play();
        playing = x.getMusic().isPlaying();
       // System.out.println("Playing: " + playing);
        Gdx.app.log("PlayingTest", Boolean.toString(playing));
        x.getMusic().pause();
        playing = x.getMusic().isPlaying();
//        System.out.println("Playing: " + playing);
        Gdx.app.log("PlayingTest", Boolean.toString(playing));
        x.getMusic().play();
        playing = x.getMusic().isPlaying();
//        System.out.println("Playing: " + playing);
        Gdx.app.log("PlayingTest", Boolean.toString(playing));
        while (x.getMusic().isPlaying()) {
            if (x.getMusic().getPosition() == 13.2) {
                //System.out.println(x.getMusic().getPosition()); //time elapsed with mp3
                Gdx.app.log("PlayingTest", Float.toString(x.getMusic().getPosition())); //time elapsed with mp3
               //System.out.println(x.getSongPosition()); //time elapsed with Song. bottom line should be top line * bpm
                Gdx.app.log("PlayingTest", Float.toString(x.getSongPosition())); //time elapsed with Song. bottom line should be top line * bpm
            }
            if (x.getMusic().getPosition() == 30.366) {
                Gdx.app.log("PlayingTest", Float.toString(x.getMusic().getPosition())); //time elapsed with mp3
                Gdx.app.log("PlayingTest", Float.toString(x.getSongPosition())); //time elapsed with Song. bottom line should be top line * bpm
            }
            if (x.getMusic().getPosition() == 60.1) {
                Gdx.app.log("PlayingTest", Float.toString(x.getMusic().getPosition())); //time elapsed with mp3
                Gdx.app.log("PlayingTest", Float.toString(x.getSongPosition())); //time elapsed with Song. bottom line should be top line * bpm
            }
            if (x.getMusic().getPosition() == 90.233) {
                Gdx.app.log("PlayingTest", Float.toString(x.getMusic().getPosition())); //time elapsed with mp3
                Gdx.app.log("PlayingTest", Float.toString(x.getSongPosition())); //time elapsed with Song. bottom line should be top line * bpm
            }
            if (x.getMusic().getPosition() == 120.9) {
                Gdx.app.log("PlayingTest", Float.toString(x.getMusic().getPosition())); //time elapsed with mp3
                Gdx.app.log("PlayingTest", Float.toString(x.getSongPosition())); //time elapsed with Song. bottom line should be top line * bpm
            }
            if (x.getMusic().getPosition() == 300) //not supposed to work
            {
                Gdx.app.log("PlayingTest", Float.toString(x.getMusic().getPosition())); //time elapsed with mp3
                Gdx.app.log("PlayingTest", Float.toString(x.getSongPosition())); //time elapsed with Song. bottom line should be top line * bpm
            }
        }
    }
}
