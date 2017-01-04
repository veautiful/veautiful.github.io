import java.util.Collections;
public class Tunes {
  
   public static void main (String[] args) {
      CDCollection music = new CDCollection ();

      music.newCD ("By the Way", "Red Hot Chili Peppers", 14.95, 10);
      music.newCD ("Come On Over", "Shania Twain", 14.95, 16);
      music.newCD ("Soundtrack", "The Producers", 17.95, 33);
      music.newCD ("Play", "Jennifer Lopez", 13.90, 11);

      System.out.println (music);

      music.newCD ("Double Live", "Garth Brooks", 19.99, 26);
      music.newCD ("Greatest Hits", "Stone Temple Pilots", 15.95, 13);

      System.out.println (music);
      
      music.sort();
      System.out.println (music);
  
   }
}
