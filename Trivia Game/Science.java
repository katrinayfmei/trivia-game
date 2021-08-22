//imports
import java.io.*;
import java.util.*;
//this java file reads in the txt file to create science q&a
//this file was coded by Katrina
class Science {

  // turns questions from science.txt to arrayList
  // @return an ArrayList of science questions
  public ArrayList<String> sciQuest() throws IOException {
    // variable
    ArrayList<String> sciQL = new ArrayList<String>();
    // temporary holder
    ArrayList<String> sciAL = new ArrayList<String>();

    // open file
    File myFile = new File("science.txt");
    // file scanner
    Scanner sciScanQ = new Scanner(myFile);
    // while loop to read file
    while (sciScanQ.hasNextLine()) {
      // read question
      String sciQ = sciScanQ.nextLine();
      // add to arrayList
      sciQL.add(sciQ);
      // read answer, the answers are just a holder in this method
      String sciA = sciScanQ.nextLine();
      // add answer to list
      sciAL.add(sciA);
    } // close while loop

    // close file
    sciScanQ.close();

    return sciQL;
  }

  // turns answers from science.txt to arrayList
  // @return an ArrayList of science answers
  public ArrayList<String> sciAns() throws IOException {
    // temporary holder
    ArrayList<String> sciQL = new ArrayList<String>();
    // variable
    ArrayList<String> sciAL = new ArrayList<String>();
    // open file
    File myFile = new File("science.txt");

    // scanner for file
    Scanner sciScanA = new Scanner(myFile);
    // reading file
    while (sciScanA.hasNextLine()) {

      //holder for questions
      String sciQ = sciScanA.nextLine();
      sciQL.add(sciQ);
      //reads answers and adds to arrayLIst
      String sciA = sciScanA.nextLine();
      sciAL.add(sciA);

    } // close while loop
    sciScanA.close();
    return sciAL;
  }//close sciAns method

}
