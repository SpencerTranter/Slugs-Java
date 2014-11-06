import java.util.*; //for Scanner
import java.io.*; //for File, FileNotFoundException
import java.awt.*; // for Point object

public class Slugs {
  public static void main(String[] args) throws FileNotFoundException {
    // try {
       Scanner input = new Scanner(new File("slug_details.txt"));
       PrintStream output = new PrintStream(new File("slugs.txt"));

       final int BOXSIZE = 400;
       Point[] slugs = new Point [4];
       slugs[0] = new Point(0,0);
       slugs[1] = new Point(0,BOXSIZE);
       slugs[2] = new Point(BOXSIZE,BOXSIZE);
       slugs[3] = new Point(BOXSIZE,0);

       pushToFile(output, slugs);
       output.flush();
       output.close();
       findDistanceBetweenSlugs(slugs);
       accessFile(input);

    // }catch(FileNotFoundException e) {
    //   System.out.println("Error: File was unable to be created or found.");
    // }
  }

  public static void findNextPosition() {

  }

  public static void findDistanceBetweenSlugs(Point [] slugs) {
    double distance = 0;
    for (int i = 0; i < 4; i ++) {
      distance = (Math.sqrt (Math.pow(slugs[(i+1)%4].x-slugs[i].x, 2) + Math.pow(slugs[(i+1)%4].y-slugs[i].y, 2)));
      System.out.println(distance);
    }
  }

  public static void accessFile(Scanner input) {
    while (input.hasNextLine()) {
      String text = input.nextLine();
      System.out.println(text);
    }
  }

  public static void pushToFile(PrintStream output, Point[]slugs) {
    int d = 10;
    output.println("400 400");
    output.flush();
    //while
      for (int i = 0; i < 4; i ++) {
        output.println(slugs[i].x + " ");
        output.print(slugs[i].y + " ");
        output.print(slugs[i].x + d + " ");
        output.print(slugs[i].y + d);
        //output.flush();
      //  output.close();
      }
  //  }
  }

}
