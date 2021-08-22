import java.util.Scanner;
import java.util.*;

class Display {

  // title method- displays title Katrina
  public void title() {
    // font marquee from
    // https://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20
    System.out.println(ConsoleColours.BLUE_BOLD_BRIGHT + "\n\n\n.::: .::::::                                  ");
    System.out.println("     .::            .:            .:          ");
    System.out.println("     .::    .: .:::   .::     .::      .::   ");
    System.out.println("     .::     .::   .:: .::   .:: .:: .::  .:: ");
    System.out.println("     .::     .::   .::  .:: .::  .::.::   .::");
    System.out.println("     .::     .::   .::   .:.::   .::.::   .:: ");
    System.out.println("     .::    .:::   .::    .::    .::  .:: .:::" + ConsoleColours.RESET);

  }// close title method

  // end game method displays ending- Katrina
  public void endGame() {
    /*
     * design from: https://fsymbols.com/text-art/twitter/
     * https://1lineart.kulaone.com/#/
     */
    System.out.println("\n");
    System.out.println(ConsoleColours.BLUE_BOLD_BRIGHT + "─▄▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▄");
    System.out.println("█░░░█░░░░░░░░░░▄▄░██░█");
    System.out.println("█░▀▀█▀▀░▄▀░▄▀░░▀▀░▄▄░█");
    System.out.println("█░░░▀░░░▄▄▄▄▄░░██░▀▀░█");
    System.out.println("─▀▄▄▄▄▄▀─────▀▄▄▄▄▄▄▀");
    System.out.println("\n------------Thank you for playing!------------");
    System.out.println(",.-~*´¨¯¨`*·~-.¸-(_END OF GAME_)-,.-~*´¨¯¨`*·~-.¸\n" + ConsoleColours.RESET);

  }

  // line seperator method - Katrina
  public void line() {
    System.out.println("---------------------------------------------------------------------");

  }

  // print rules method - Anna
  private void rules() {
    // print title and rules
    System.out.println(ConsoleColours.CYAN_BRIGHT + "\nRULES:\n\n" + ConsoleColours.RESET);
    System.out.println(
        " ✔ You will be asked to enter the number of players.\n ✔ You will then be asked how many rounds of trivia you would like to play.\n ✔ Each player will take turns choosing a category and answering a trivia question.\n ✔ You will be awarded one point for a correct answer and a point will be taken way for an incorrect answer.\n ✔ When answering a question, exclude articles. For example, type in 'tiger' instead of 'a tiger'.\n ✔ If the answer to a question is a number, enter it in number form unless it specifically says to enter it in word form.\n ✔ Enter years in number form.\n ✔ Type in all lowercase.\n ✔ After you are done each round, a leaderboard will be displayed.\n ✔ A final leaderboard will be displayed at the end of the game.\n ✔ Have fun!");

  }// close rules method

  // display menu and rules method- Anna
  // @return choice on menu
  public int menu() {
    // display title and options
    System.out.println("\n\n,.-~*´¨¯¨`*·~-.¸-(_Welcome to Trivia™!_)-,.-~*´¨¯¨`*·~-.¸");
    line();
    System.out.println(ConsoleColours.GREEN_BOLD_BRIGHT + "1. Start Game" + ConsoleColours.RESET);
    System.out.println(ConsoleColours.YELLOW_BOLD_BRIGHT + "2. Rules" + ConsoleColours.RESET);
    System.out.println(ConsoleColours.RED_BOLD_BRIGHT + "3. Exit" + ConsoleColours.RESET);

    // variables for while loop and return variable
    boolean menu = true;
    int menuOutput = 1;

    line();// line seperator

    System.out.print("Enter a number from the menu to get started: ");// request input
    Scanner menuScanner = new Scanner(System.in);// menu scanner
    String menuInput = menuScanner.nextLine();
    // convert string to int for the return variable
    menuOutput = Integer.parseInt(menuInput);

    // while loop to filter out invalid input
    while (menu) {
      if (1 <= menuOutput && menuOutput <= 3) {
        break;
      } // close if
      else {
        // request valid input
        System.out
            .print(ConsoleColours.RED_BRIGHT + "Please enter a valid number from the menu: " + ConsoleColours.RESET);
        // parse return variable into an int
        menuInput = menuScanner.nextLine();
        menuOutput = Integer.parseInt(menuInput);
        continue;
      } // close else
    } // close while loop

    line();// line seperator

    // if the user wants to see the rules, call the rules method
    if (menuOutput == 2) {
      rules();// rules method
      String menuCont = "";
      Scanner rulesScanner = new Scanner(System.in);// scanner

      // ask user to enter 'm' to return to the menu, dont accept invalid input
      while (!menuCont.equals("m")) {
        line();
        System.out.print(ConsoleColours.CYAN_BRIGHT + "\n\nEnter 'm' to go back to menu: " + ConsoleColours.RESET);
        // catch user input
        menuCont = rulesScanner.nextLine();//

        // return to the menu and return the users choice according to the menu
        if (menuCont.equals("m")) {
          int mReturn = menu();
          if (mReturn == 3) {
            menuOutput = 3;
          } else if (mReturn == 1) {
            menuOutput = 1;
          }
          break;// break while loop after valid choice is made
        } // close if
        else {
          continue;

        } // close else
      } // close while
    } // close if menuOutput==2

    return menuOutput;

  }// close menu method

  /*
   check answer method- Katrina  
   @param corAns is correct answer   
   @param userAns is userAnswer   
   @return correct or wrong with colours as a string
   */
  public String right(String corAns, String userAns) {
    String corWro = "";
    // if users and library answers match
    if (corAns.equals(userAns)) {
      corWro = ConsoleColours.GREEN_BRIGHT + "correct" + ConsoleColours.RESET;
    }
    // if the answers do not match
    else if (!corAns.equals(userAns)) {
      corWro = ConsoleColours.RED_BRIGHT + "wrong" + ConsoleColours.RESET;
    }
    return corWro;
  }// close right method

  /*
   printpoints method-Anna   
   @param answer is correct/incorrect for the answer user entered
   @param cPoints is player current points
   return updated points
   */
  public int points(String answer, int cPoints) {
    if (answer.equals(ConsoleColours.GREEN_BRIGHT + "correct" + ConsoleColours.RESET)) {
      cPoints = 1;

    } else if (answer.equals(ConsoleColours.RED_BRIGHT + "wrong" + ConsoleColours.RESET)) {
      cPoints = -1;

    }
    return cPoints;
  }// close points method

  /*
   * keep track of points method- Anna
   * 
   * @param p1Scores displays current player points
   * 
   * @param p2Scores displays current player points
   */
  public void points(String nickOne, String nickTwo, int p1Score, int p2Score) {
    System.out.println(nickOne + "'s current points: " + p1Score);
    System.out.println(nickTwo + "'s current points: " + p2Score);
    line();

  }// close points method

  // print categories method- Anna
  // prints out categories in yellow
  public void disCat() {
    System.out.println(ConsoleColours.YELLOW_BOLD_BRIGHT + "Here are the categories:\nentertainment"
        + ConsoleColours.RESET + "- questions about music, movies, tv-shows and pop culture "
        + ConsoleColours.YELLOW_BOLD_BRIGHT + "\ngeography" + ConsoleColours.RESET
        + "- questions about places around the world" + ConsoleColours.YELLOW_BOLD_BRIGHT + " \nhistory"
        + ConsoleColours.RESET + " questions about Canadian and international history " + ConsoleColours.YELLOW_BOLD_BRIGHT
        + "\nmath" + ConsoleColours.RESET + "-simple math problems and math trivia" + ConsoleColours.YELLOW_BOLD_BRIGHT
        + "\nscience" + ConsoleColours.RESET + "- science history and modern science questions "
        + ConsoleColours.YELLOW_BOLD_BRIGHT + "\nsports" + ConsoleColours.RESET
        + "- trivia about current sports and sports history");
    line();

  }// close disCat method

  // method to determine number of players, accepts only valid input- Anna
  // @return number of players
  public int askPlayers() {
    // scanner and while loop variable
    Scanner playScan = new Scanner(System.in);
    boolean wrongNum = true;
    // prompt user to enter number of players
    System.out.print("How many players? Enter 1 or 2: ");
    String tempVal = playScan.nextLine();// store input
    int numPlay = Integer.parseInt(tempVal); // parse to int
    // while loop to ensure valid input
    while (wrongNum) {
      // break if input is correct
      if (numPlay == 1 || numPlay == 2) {
        break;
      }
      // request valid input
      else {
        System.out.print(ConsoleColours.RED_BRIGHT + "Enter a valid number of players: " + ConsoleColours.RESET);
        tempVal = playScan.nextLine();
        numPlay = Integer.parseInt(tempVal);
        continue;
      }

    } // close while loop
    return numPlay;

  }// close ask number of players method


  // method to determine number of rounds, accepts only valid input - Anna 
  // @return number of rounds
  public int askRounds() {
    // scanner and while loop variable
    Scanner roundScan = new Scanner(System.in);
    boolean wrongNum = true;
    // prompt user to enter number of rounds
    System.out.print("How many rounds do you want to play? Enter a number between 1-50: ");
    String tempVal = roundScan.nextLine();// hold input
    int numRounds = Integer.parseInt(tempVal);// parse to int

    // only accept valid input
    while (wrongNum) {

      if (numRounds >= 1 && numRounds <= 50) {
        break;
      }
      // request valid input
      else {
        System.out.print(ConsoleColours.RED_BRIGHT + "Enter a valid number of rounds: " + ConsoleColours.RESET);
        tempVal = roundScan.nextLine();
        numRounds = Integer.parseInt(tempVal);
        // continue loop to check if it's valid
        continue;
      }

    } // close while loop
    return numRounds;

  }// close ask number of rounds method


  // method asks choice of category and accepts only vallid input- Anna 
  //@return the users choice of category
  public String askCat() {
    // scanner and while loop variable
    Scanner catScan = new Scanner(System.in);
    boolean wrongCat = true;

    // display menu options and prompt input
    System.out.print("\nWhat category? Enter entertainment, geography, history, math, science, sports: ");
    String cat = catScan.nextLine();// hold user input
    // while loop to catch invalid input
    while (wrongCat) {

      // only accept strings that mathch the 6 categories
      if (cat.equals("math") || cat.equals("geography") || cat.equals("history") || cat.equals("science")
          || cat.equals("sports") || cat.equals("entertainment")) {
        break;
      }
      // otherwise, get user to enter a valid category
      else {
        System.out.print(ConsoleColours.RED_BRIGHT + "Enter a valid category: " + ConsoleColours.RESET);
        cat = catScan.nextLine();
        // continue loop to check if the new input is valid
        continue;
      }

    } // close while loop
    return cat;// return the users choice of category
  }// close ask cat method

  /*
   reveal is also the overloading method for katrina
   this method reveal a random int according to ArrayList size- Katrina
   @param qRand is an arrayList of questions that will be used to generate a random int of the arrayList size
   @return random index of an array list
   */
  public int reveal(ArrayList<String> qRand) {
    Random rand = new Random();
    // new variable to generate a random int of the arraylist size
    int randomElement = rand.nextInt(qRand.size());
    return randomElement;
  }// close reveal

  /*
   displays question and answer at random element- Katrina
   @param qRand is an arraylist of the questions or answer of any of the categories
   @param randIndex is a random integer with the size of the arraylist of one of the 6 categories
   @return question or answer of any of the 6 categories by using a random integer index
   */
  public String reveal(ArrayList<String> qRand, int randIndex) {

    String something = qRand.get(randIndex);
    return something;

  }// close reveal

  /*
    displays the leaderboard at the end of each game -method made by Anna
    @param nickOne nickname of player one 
    @param nickTwo nickname of player two
    @param score1, the final score of player one
    @param score2, the final score of player two
    @return leaderboard string 
   */
  public String leaderboard(String nickOne, String nickTwo, int score1, int score2) {

    int scores[] = { score1, score2 };

    String leaderboard = "";

    if (scores[0] > scores[1]) {
      leaderboard = "🥇  First place: " + nickOne + "!  🥇\n🥈  Second place: " + nickTwo
          + "! 🥈\n🏆  Congratulations! The winner is " + nickOne + "! 🏆";
    } else if (scores[0] < scores[1]) {
      leaderboard = "🥇  First place: " + nickTwo + "!  🥇\n🥈  Second place: " + nickOne
          + "! 🥈\n🏆  Congratulations! The winner is " + nickTwo + "! 🏆";
    } else {
      leaderboard = "\nLeaderboard:\n🏆  First place: " + nickOne + "! 🏆\n🏆  First place: " + nickTwo
          + "! 🏆\nIt's a tie!";
    }

    return leaderboard;

  }// close leaderboard method

  // continue game or exit program method- Anna
  // @param loopCount is the number of while loops/full games of trivia
  // @return true or false for main while loop
  public boolean contGame(int loopCount) {
    // output
    line();
    System.out.print("You have played " + loopCount
        + " games of trivia! Enter 'm' to go back to the menu or 'e' to exit the program: ");
    // scanner and put user input into a String variable
    Scanner contScan = new Scanner(System.in);

    String contInput = contScan.nextLine();

    boolean contGame;
    // if the user wants to continue to menu, return true to continue the loop,
    // otherwise return false to terminate the program
    if (contInput.equals("m")) {
      contGame = true;
    } else {
      contGame = false;
    }

    return contGame;

  }

  /*
   this method is used for the printwriter nickname display method- Katrina 
   @param name is user nickname
   @param score is the user final score
   @return string with the players nickname and their final score 
   */
  public String nickname(String name, int score) {
    String disNick = name + " finished with a score: " + score;
    return disNick;

  }

  /*
   displays the leaderboard at the end of each game- this method is by Anna
   @param nickOne nickname of player one
   @param nickTwo nickname of player two 
   @param rounds, the rounds played
   @return a string saying how many rounds of trivia were played and by whom
   */
  public String disRounds(String nickOne, String nickTwo, int rounds) {
    String str = "" + nickOne + " and " + nickTwo + " played " + rounds / 2 + " rounds of trivia.";

    return str;
  }

}// close class
