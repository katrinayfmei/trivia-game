//imports
import java.io.*;
import java.util.*;
//this java file reads in the txt file to create sports q&a
//this file was coded by Katrina
class Sports {

  // turns questions from sports.txt to arrayList
  // @return ArrayList of sports questions
  public ArrayList<String> spoQuest() throws IOException {
    // variable
    ArrayList<String> spoQL = new ArrayList<String>();
    // temporary holder
    ArrayList<String> spoAL = new ArrayList<String>();
    // open file
    File myFile = new File("sports.txt");
    // file scanner
    Scanner spoScanQ = new Scanner(myFile);
    // while loop to read file
    while (spoScanQ.hasNextLine()) {
      // read question
      String spoQ = spoScanQ.nextLine();
      // add to arrayList
      spoQL.add(spoQ);

      // read answer, the answers are just a holder in this method
      String spoA = spoScanQ.nextLine();
      // add answer to list
      spoAL.add(spoA);
    } // close while loop

    // close file
    spoScanQ.close();

    return spoQL;
  }

  // turns answers from sports.txt to arrayList
  // @return ArrayList of sport answers
  public ArrayList<String> spoAns() throws IOException {
    // temporary holder
    ArrayList<String> spoQL = new ArrayList<String>();
    // variable
    ArrayList<String> spoAL = new ArrayList<String>();
    // open file
    File myFile = new File("sports.txt");

    // scanner for file
    Scanner spoScanA = new Scanner(myFile);
    // reading file
    while (spoScanA.hasNextLine()) {

      //holds questions
      String spoQ = spoScanA.nextLine();
      spoQL.add(spoQ);
      //reads answers and adds to arraList
      String spoA = spoScanA.nextLine();
      spoAL.add(spoA);

    } // close while loop
    spoScanA.close();
    return spoAL;
  }

}
