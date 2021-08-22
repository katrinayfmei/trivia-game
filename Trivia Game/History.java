//imports
import java.io.*;
import java.util.*;
//this java file reads in the txt file to create history q&a
//this file was coded by Katrina
class History {

  // turns questions from history.txt to arrayList
  // @return ArrayList of history questions
  public ArrayList<String> hQuest() throws IOException {
    // variable
    ArrayList<String> hql = new ArrayList<String>();
    // temporary holder
    ArrayList<String> hal = new ArrayList<String>();

    // open file
    File myFile = new File("history.txt");
    // file scanner
    Scanner historyScanQ = new Scanner(myFile);
    // while loop to read file
    while (historyScanQ.hasNextLine()) {
      // read question
      String hq = historyScanQ.nextLine();
      // add to arrayList
      hql.add(hq);
       // read answer, the answers are just a holder in this method
      String ha = historyScanQ.nextLine();
      // add answer to list
      hal.add(ha);
    } // close while loop

    // close file
    historyScanQ.close();

    return hql;
  }

  // turns answers from history.txt to arrayList
  // @return ArrayList of history answers
  public ArrayList<String> hAns() throws IOException {
    // temporary holder
    ArrayList<String> hql = new ArrayList<String>();
    // variable
    ArrayList<String> hal = new ArrayList<String>();
    // open file
    File myFile = new File("history.txt");

    // scanner for file
    Scanner historyScanA = new Scanner(myFile);
    // reading file
    while (historyScanA.hasNextLine()) {
      //holder for questions
      String hq = historyScanA.nextLine();
      hql.add(hq);
      //reads answers aNd add answers to arrayList
      String ha = historyScanA.nextLine();
      hal.add(ha);

    } // close while loop
    historyScanA.close();
    return hal;
  }

}
