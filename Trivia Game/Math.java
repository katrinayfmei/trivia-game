//imports
import java.io.*;
import java.util.*;
//this java file reads in the txt file to create math q&a
//this file was coded by Katrina
class Math {

  // turns questions from math.txt to arrayList
  // @return ArrayList of math questions
  public ArrayList<String> MQuest() throws IOException {
    // variable
    ArrayList<String> mql = new ArrayList<String>();
    // temporary holder
    ArrayList<String> mal = new ArrayList<String>();

    // open file
    File myFile = new File("math.txt");
    // file scanner
    Scanner mathScanQ = new Scanner(myFile);
    // while loop to read file
    while (mathScanQ.hasNextLine()) {
      // read question
      String mq = mathScanQ.nextLine();
      // add to arrayList
      mql.add(mq);
      // read answer, the answers are just a holder in this method 
      String ma = mathScanQ.nextLine();
      // add answer to list
      mal.add(ma);
    } // close while loop

    // close file and Scanners
    mathScanQ.close();

    return mql;
  }

  // turns answers from math.txt to arrayList
  // @return ArrayList of math answers
  public ArrayList<String> MAns() throws IOException {
    // temporary holder
    ArrayList<String> mql = new ArrayList<String>();
    // variable
    ArrayList<String> mal = new ArrayList<String>();
    // open file
    File myFile = new File("math.txt");

    // scanner for file
    Scanner mathScanA = new Scanner(myFile);
    // reading file
    while (mathScanA.hasNextLine()) {
      //holder for questions
      String mq = mathScanA.nextLine();
      mql.add(mq);
      //reads and add questions to arrayList
      String ma = mathScanA.nextLine();
      mal.add(ma);

    } // close while loop

    //close file and scanners
    mathScanA.close();
    return mal;
  }

}
