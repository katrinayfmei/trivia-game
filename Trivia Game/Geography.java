//imports
import java.io.*;
import java.util.*;
//this java file reads in the txt file to create geography q&a
//this file was coded by Katrina
class Geography {

  // turns questions from geography.txt to arrayList
  // @return ArrayList of geography questions
  public ArrayList<String> gQuest() throws IOException {
    // variable
    ArrayList<String> gql = new ArrayList<String>();
    // temporary holder
    ArrayList<String> gal = new ArrayList<String>();

    // open file
    File myFile = new File("geography.txt");
    // file scanner
    Scanner geoScanQ = new Scanner(myFile);

    // while loop to read file
    while (geoScanQ.hasNextLine()) {
      // read question
      String gq = geoScanQ.nextLine();
      // add to arrayList
      gql.add(gq);
      // read answer, the answers are just a holder in this method
      String ga = geoScanQ.nextLine();
      // add answer to list
      gal.add(ga);
    } // close while loop

    // close file and scanner 
    geoScanQ.close();

    return gql;
  }

  // turns answers from geography.txt to arrayList
  // @return ArrayList of geography answers
  public ArrayList<String> gAns() throws IOException {
    // temporary holder
    ArrayList<String> gql = new ArrayList<String>();
    // variable
    ArrayList<String> gal = new ArrayList<String>();

    // open file
    File myFile = new File("geography.txt");
    // scanner for file
    Scanner geoScanA = new Scanner(myFile);
    // reading file
    while (geoScanA.hasNextLine()) {

      //holder for question
      String gq = geoScanA.nextLine();
      gql.add(gq);
      //read and add answers
      String ga = geoScanA.nextLine();
      gal.add(ga);

    } // close while loop
    geoScanA.close();
    return gal;
  }

}
