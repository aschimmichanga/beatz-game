public class DoubleNote extends Note
{
    private int secondNoteNum;
        public DoubleNote(int n, int nn, int t) //nn is the second note #
        {
            super(n, t);
            secondNoteNum = nn;
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
