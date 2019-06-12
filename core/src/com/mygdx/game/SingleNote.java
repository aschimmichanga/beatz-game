public abstract class Note
{
  private int noteNum; //1-4
  private double timeInSong; //what song position the note occurs at

  public Note(int n, int t)
  {
      noteNum = n;
      timeInSong = t;
  }
  private double getTime()
  {
    return timeInSong;
  }
  private int getNoteNum()
  {
    return noteNum;
  }
}
