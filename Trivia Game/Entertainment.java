//imports
import java.io.*;
import java.util.*;

//this java file reads in the txt file to create entertainment q&a
//this file was coded by Katrina

class Entertainment {

  // turns questions from entertainment.txt to arrayList
  // @return ArrayList of entertainment questions
  public ArrayList<String> eQuest() throws IOException {
    // variable
    ArrayList<String> eql = new ArrayList<String>();
    // temporary holder for answers
    ArrayList<String> eal = new ArrayList<String>();

    // open file
    File myFile = new File("entertainment.txt");
    // file scanner
    Scanner entScanQ = new Scanner(myFile);
    // while loop to read file

    while (entScanQ.hasNextLine()) {
      // read question
      String eq = entScanQ.nextLine();
      // add to arrayList
      eql.add(eq);
      // read answer, the answers are just a holder in this method
      String ea = entScanQ.nextLine();
      // add answer to list
      eal.add(ea);
    } // close while loop

    // close scanner&file
    entScanQ.close();

    return eql;
  }

  // turns answers from entertainment.txt to a arrayList
  // @return ArrayList of entertainment answers
  public ArrayList<String> eAns() throws IOException {
    // temporary holder
    ArrayList<String> eql = new ArrayList<String>();
    // variable
    ArrayList<String> eal = new ArrayList<String>();

    // open file
    File myFile = new File("entertainment.txt");
    // scanner for file
    Scanner entScanA = new Scanner(myFile);
    // reading file

    while (entScanA.hasNextLine()) {  
      //holder for question
      String eq = entScanA.nextLine();
      eql.add(eq);
      //varaibles to read answers and add to arraylist
      String ea = entScanA.nextLine();
      eal.add(ea);

    } // close while loop
    //close scanner&file
    entScanA.close();
    return eal;
  }

}
