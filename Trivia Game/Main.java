import java.io.*;
import java.util.*;
/* 
Game title: Trivia
Game description: Test out your skills. How much do you really know? Learn more about entertainment, geography, history,math,science, sports around the world! Play alone or with a friend and see how many questions you can get right!
Created by: Katrina M and Anna F
Date created: 2021-01-14
Last modified: 2021-01-29

Questions sources:
https://github.com/arnabsarker/Trivial-Pursuit-Game
https://parade.com/977752/samuelmurrian/movie-trivia/
https://triviaquiznight.com/entertainment-trivia-questions/
https://toronto.citynews.ca/2007/11/09/could-you-pass-this-canadian-history-quiz/
https://icebreakerideas.com/science-trivia/
https://icebreakerideas.com/math-trivia/

Text File formating: finding questions and format question answer every other line: 80% done by Anna and 20% by Katrina
*/

class Main {
  public static void main(String[] args) throws IOException {

    // scanners
    Scanner mainScanner = new Scanner(System.in);
    Scanner catScanner = new Scanner(System.in);
    Scanner answerScanner = new Scanner(System.in);
    Scanner nickScanner = new Scanner(System.in);

    // points
    int onePlay = 0;
    int twoPlay = 0;

    // display class
    Display display = new Display();

    // category classes
    History hs = new History();
    Geography gg = new Geography();
    Entertainment ent = new Entertainment();
    Science sci = new Science();
    // if you see a red underline under Math its ok ! Yu can run the program or just refresh the page
    Math math = new Math();
    Sports spo = new Sports();

    // history question arraylist
    ArrayList<String> mainHQ = hs.hQuest();
    // history answer arrayList
    ArrayList<String> mainHA = hs.hAns();
    // geography question arraylist
    ArrayList<String> mainGQ = gg.gQuest();
    // geography answer arrayList
    ArrayList<String> mainGA = gg.gAns();
    // entertainment question arraylist
    ArrayList<String> mainEQ = ent.eQuest();
    // entertainment answer arraylist
    ArrayList<String> mainEA = ent.eAns();
    // science question arraylist
    ArrayList<String> mainSciQ = sci.sciQuest();
    // science answer arrayList
    ArrayList<String> mainSciA = sci.sciAns();
    // sports question arraylist
    ArrayList<String> mainSpoQ = spo.spoQuest();
    // sports answer arrayList
    ArrayList<String> mainSpoA = spo.spoAns();
    // math question arraylist
    ArrayList<String> mainMQ = math.MQuest();
    // math answer arrayList
    ArrayList<String> mainMA = math.MAns();

    // title
    display.title();
    
    //while loop variable and loop counters 
    boolean contGame = true;
    int loopCount=0;
    int roundCount=0;

    //start main game loop 
    while (contGame == true) {

      // menu
      int menuChoice = display.menu();

      
      // start game    
      if (menuChoice == 1) {

        // determine number of players
        int numPlay = display.askPlayers();

        //strings for nicknames 
        String nickOne="";
        String nickTwo="";

        //first player prompt nickname
        if (numPlay==1){
          System.out.print("Enter a nickname: "); 
          nickOne=nickScanner.nextLine();
        }

        // second player 
        else if (numPlay==2){
          System.out.print("Enter a nickname for player one: ");
          nickOne=nickScanner.nextLine();
          System.out.print("Enter a nickname player two: ");
          nickTwo=nickScanner.nextLine();

        }

        // determine number of rounds
        int numRounds = display.askRounds();
        display.line();

        // calculate for loop
        int looping = numRounds * numPlay;

        //code for single player only
        if (numPlay == 1) {
        
          // prints out categories
          display.disCat();
          for (int j = 0; j < looping; j++) {

            // prompt user to enter what category to play
            String mainCat = display.askCat();

            // history category code
            if (mainCat.equals("history")) {

              // variable random question
              int random = (display.reveal(mainHQ));
              // variable for the answer to the random question
              String realAnswer = (display.reveal(mainHA, random));

              // reveals question to user
              System.out.println(display.reveal(mainHQ, random));

              // prompt user to answer the random question
              System.out.print("Enter your answer: ");
              String userAnswer = answerScanner.nextLine();

              // return correct/wrong
              String mainCW = (display.right(userAnswer, realAnswer));

              // prints answer correct answer
              System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);
            
              //adds or subtracts points
              onePlay += (display.points(mainCW, onePlay));
              display.line();
              //display current points
              System.out.println("Your current points: " + onePlay);
              display.line();
              //remove question and answer from arrayList to prevent it from being asked again
              mainHQ.remove(random);
              mainHA.remove(random);

            } // close if cat history

            else if (mainCat.equals("geography")) {

              // random
              int random = (display.reveal(mainGQ));
              // answer if question variable
              String realAnswer = (display.reveal(mainGA, random));

              // reveals question
              System.out.println(display.reveal(mainGQ, random));

              // prompt user answer
              System.out.print("Enter your answer: ");
              String userAnswer = answerScanner.nextLine();

              // return correct/wrong
              String mainCW = (display.right(userAnswer, realAnswer));

              // display points
              System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);
              
              //display points
              onePlay += (display.points(mainCW, onePlay));
              display.line();
              System.out.println("Your current points: " + onePlay);
              display.line();
              //remove question and answer from arrayList to prevent it from being asked again
              mainGQ.remove(random);
              mainGA.remove(random);

            } // close if cat geography

            else if (mainCat.equals("entertainment")) {

              // random
              int random = (display.reveal(mainEQ));
              // answer if question variable
              String realAnswer = (display.reveal(mainEA, random));

              // reveals question
              System.out.println(display.reveal(mainEQ, random));

              // prompt user answer
              System.out.print("Enter your answer: ");
              String userAnswer = answerScanner.nextLine();

              // return correct/wrong
              String mainCW = (display.right(userAnswer, realAnswer));

              // prints answer
              System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);
            

              onePlay += (display.points(mainCW, onePlay));
              display.line();
              System.out.println("Your current points: " + onePlay);
              display.line();
              //remove question and answer from arrayList to prevent it from being asked again
              mainEQ.remove(random);
              mainEA.remove(random);

            } // close if cat entertainment

            else if (mainCat.equals("science")) {

              // random
              int random = (display.reveal(mainSciQ));
              // answer if question variable
              String realAnswer = (display.reveal(mainSciA, random));

              // reveals question
              System.out.println(display.reveal(mainSciQ, random));

              // prompt user answer
              System.out.print("Enter your answer: ");
              String userAnswer = answerScanner.nextLine();

              // return correct/wrong
              String mainCW = (display.right(userAnswer, realAnswer));

              // display points
              System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);
           

              onePlay += (display.points(mainCW, onePlay));
              display.line();
              System.out.println("Your current points: " + onePlay);
              display.line();
              //remove question and answer from arrayList to prevent it from being asked again
              mainSciQ.remove(random);
              mainSciA.remove(random);

            } // close if cat science

            else if (mainCat.equals("sports")) {

              // random
              int random = (display.reveal(mainSpoQ));
              // answer if question variable
              String realAnswer = (display.reveal(mainSpoA, random));

              // reveals question
              System.out.println(display.reveal(mainSpoQ, random));

              // prompt user answer
              System.out.print("Enter your answer: ");
              String userAnswer = answerScanner.nextLine();

              // return correct/wrong
              String mainCW = (display.right(userAnswer, realAnswer));

              // prints answer out
              System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);
        
              //display points
              onePlay += (display.points(mainCW, onePlay));
              display.line();
              System.out.println("Your current points: " + onePlay);
              display.line();
              //remove question and answer from arrayList to prevent it from being asked again
              mainSpoQ.remove(random);
              mainSpoA.remove(random);

            } // close if cat sports

            else if (mainCat.equals("math")) {

              // random
              int random = (display.reveal(mainMQ));
              // answer if question variable
              String realAnswer = (display.reveal(mainMA, random));

              // reveals question
              System.out.println(display.reveal(mainMQ, random));

              // prompt user answer
              System.out.print("Enter your answer: ");
              String userAnswer = answerScanner.nextLine();

              // return correct/wrong
              String mainCW = (display.right(userAnswer, realAnswer));

              // prints answer
              System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);
           
              // display points
              onePlay += (display.points(mainCW, onePlay));
              display.line();
              System.out.println("Your current points: " + onePlay);
              display.line();
              //remove question and answer from arrayList to prevent it from being asked again
              mainMQ.remove(random);
              mainMA.remove(random);

            } // close if cat math

            //add to total rounds 
            roundCount+=1;

          } // close for loop for player 1
          // print final score
          System.out.print("Your final score: " + onePlay + "\n");
          display.endGame();

          //add to the loop counter
          loopCount+=1;
          
          //https://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java
          //code to write data to userData.txt. Only for one player
          if (numPlay==1){
            //prevent overwrite
            FileWriter fw = new FileWriter("userData.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw= new PrintWriter(bw);
          
           //display in file   
           pw.println(nickOne+ " played "+ roundCount+ " rounds of trivia.");
           pw.println(display.nickname(nickOne,onePlay));
           pw.println("\n");
           //close PrintWriter
           pw.close();              



          }

          // loop game or end game 
          if (display.contGame(loopCount) == true) {
            // reset score variable
            onePlay = 0;
            //reset round counter
            roundCount=0;
            continue;
          } else {
            display.endGame();
            break;
          }

        } // close numplay==1

        // two players
        else if (numPlay == 2) {
          // prints out categories
          display.disCat();
          for (int i = 1; i < looping + 1; i++) {

            if (i % 2 == 0) {
              System.out.print(ConsoleColours.CYAN_BRIGHT + "It is "+ nickTwo+"'s turn! " + ConsoleColours.RESET);
              // prompt for category
              String mainCat = display.askCat();

              // history stuff
              if (mainCat.equals("history")) {

                // random
                int random = (display.reveal(mainHQ));
                // answer if question variable
                String realAnswer = (display.reveal(mainHA, random));

                // reveals question
                System.out.println(display.reveal(mainHQ, random));

                // prompt user answer
                System.out.print("Enter your answer: ");
                String userAnswer = answerScanner.nextLine();

                // return correct/wrong
                String mainCW = (display.right(userAnswer, realAnswer));

                // prints answer
                System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);
                // display points

                twoPlay += (display.points(mainCW, onePlay));

                display.line();
                //remove question and answer from arrayList to prevent it from being asked again
                mainHQ.remove(random);
                mainHA.remove(random);
                display.points(nickOne, nickTwo, onePlay, twoPlay);

              } // close if cat history

              else if (mainCat.equals("entertainment")) {

                // random
                int random = (display.reveal(mainEQ));
                // answer if question variable
                String realAnswer = (display.reveal(mainEA, random));

                // reveals question
                System.out.println(display.reveal(mainEQ, random));

                // prompt user answer
                System.out.print("Enter your answer: ");
                String userAnswer = answerScanner.nextLine();

                // return correct/wrong
                String mainCW = (display.right(userAnswer, realAnswer));

                // prints answer
                System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);
                // display points

                twoPlay += (display.points(mainCW, onePlay));

                display.line();
                //remove question and answer from arrayList to prevent it from being asked again
                mainEQ.remove(random);
                mainEA.remove(random);
                display.points(nickOne, nickTwo, onePlay, twoPlay);

              } // close if cat history

              else if (mainCat.equals("geography")) {

                // random
                int random = (display.reveal(mainGQ));
                // answer if question variable
                String realAnswer = (display.reveal(mainGA, random));

                // reveals question
                System.out.println(display.reveal(mainGQ, random));

                // prompt user answer
                System.out.print("Enter your answer: ");
                String userAnswer = answerScanner.nextLine();

                // return correct/wrong
                String mainCW = (display.right(userAnswer, realAnswer));

                // prints answer
                System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);
                // display points

                twoPlay += (display.points(mainCW, onePlay));

                display.line();
                //remove question and answer from arrayList to prevent it from being asked again
                mainGQ.remove(random);
                mainGA.remove(random);
                display.points(nickOne, nickTwo,onePlay, twoPlay);

              } // close if cat geo

              else if (mainCat.equals("math")) {

                // random
                int random = (display.reveal(mainMQ));
                // answer if question variable
                String realAnswer = (display.reveal(mainMA, random));

                // reveals question
                System.out.println(display.reveal(mainMQ, random));

                // prompt user answer
                System.out.print("Enter your answer: ");
                String userAnswer = answerScanner.nextLine();

                // return correct/wrong
                String mainCW = (display.right(userAnswer, realAnswer));

                // prints answer
                System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);

                // display points
                twoPlay += (display.points(mainCW, onePlay));

                display.line();
                //remove question and answer from arrayList to prevent it from being asked again
                mainMQ.remove(random);
                mainMA.remove(random);
                display.points(nickOne, nickTwo,onePlay, twoPlay);

              } // close if cat math

              else if (mainCat.equals("science")) {

                // random
                int random = (display.reveal(mainSciQ));
                // answer if question variable
                String realAnswer = (display.reveal(mainSciA, random));

                // reveals question
                System.out.println(display.reveal(mainSciQ, random));

                // prompt user answer
                System.out.print("Enter your answer: ");
                String userAnswer = answerScanner.nextLine();

                // return correct/wrong
                String mainCW = (display.right(userAnswer, realAnswer));

                // prints answer
                System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);
                // display points

                twoPlay += (display.points(mainCW, onePlay));

                display.line();
                //remove question and answer from arrayList to prevent it from being asked again
                mainSciQ.remove(random);
                mainSciA.remove(random);
                display.points(nickOne, nickTwo,onePlay, twoPlay);

              } // close if cat history

              else if (mainCat.equals("sports")) {

                // random
                int random = (display.reveal(mainSpoQ));
                // answer if question variable
                String realAnswer = (display.reveal(mainSpoA, random));

                // reveals question
                System.out.println(display.reveal(mainSpoQ, random));

                // prompt user answer
                System.out.print("Enter your answer: ");
                String userAnswer = answerScanner.nextLine();

                // return correct/wrong
                String mainCW = (display.right(userAnswer, realAnswer));

                // prints answer
                System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);

                // display points
                twoPlay += (display.points(mainCW, onePlay));
                display.line();
                //remove question and answer from arrayList to prevent it from being asked again
                mainSpoQ.remove(random);
                mainSpoA.remove(random);
                display.points(nickOne, nickTwo, onePlay, twoPlay);

              } // close if cat history

            } // close % if
            else if (i % 2 != 0) {
              System.out.print(ConsoleColours.CYAN_BRIGHT + "It is "+ nickOne+"'s turn! " + ConsoleColours.RESET);
              // prompt for category
              String mainCat = display.askCat();

              // history category
              if (mainCat.equals("history")) {

                // random
                int random = (display.reveal(mainHQ));
                // answer if question variable
                String realAnswer = (display.reveal(mainHA, random));

                // reveals question
                System.out.println(display.reveal(mainHQ, random));

                // prompt user answer
                System.out.print("Enter your answer: ");
                String userAnswer = answerScanner.nextLine();

                // return correct/wrong
                String mainCW = (display.right(userAnswer, realAnswer));

                // prints answer
                System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);
              
                // display points
                onePlay += (display.points(mainCW, onePlay));

                display.line();
                //remove question and answer from arrayList to prevent it from being asked again
                mainHQ.remove(random);
                mainHA.remove(random);

              } // close if cat history

              // entertainment category
              else if (mainCat.equals("entertainment")) {

                // random
                int random = (display.reveal(mainEQ));
                // answer if question variable
                String realAnswer = (display.reveal(mainEA, random));

                // reveals question
                System.out.println(display.reveal(mainEQ, random));

                // prompt user answer
                System.out.print("Enter your answer: ");
                String userAnswer = answerScanner.nextLine();

                // return correct/wrong
                String mainCW = (display.right(userAnswer, realAnswer));

                // prints answer
                System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);
                
                // display points
                onePlay += (display.points(mainCW, onePlay));

                display.line();
                //remove question and answer from arrayList to prevent it from being asked again
                mainEQ.remove(random);
                mainEA.remove(random);

              } // close if cat entertainment

              // geography category
              else if (mainCat.equals("geography")) {

                // random
                int random = (display.reveal(mainGQ));
                // answer if question variable
                String realAnswer = (display.reveal(mainGA, random));

                // reveals question
                System.out.println(display.reveal(mainGQ, random));

                // prompt user answer
                System.out.print("Enter your answer: ");
                String userAnswer = answerScanner.nextLine();

                // return correct/wrong
                String mainCW = (display.right(userAnswer, realAnswer));

                // prints answer
                System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);
           
                // display points
                onePlay += (display.points(mainCW, onePlay));

                display.line();
                //remove question and answer from arrayList to prevent it from being asked again
                mainGQ.remove(random);
                mainGA.remove(random);

              } // close if cat geo

              // math category
              else if (mainCat.equals("math")) {

                // random
                int random = (display.reveal(mainMQ));
                // answer if question variable
                String realAnswer = (display.reveal(mainMA, random));

                // reveals question
                System.out.println(display.reveal(mainMQ, random));

                // prompt user answer
                System.out.print("Enter your answer: ");
                String userAnswer = answerScanner.nextLine();

                // return correct/wrong
                String mainCW = (display.right(userAnswer, realAnswer));

                // prints answer
                System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);
                // display points

                onePlay += (display.points(mainCW, onePlay));

                display.line();
                //remove question and answer from arrayList to prevent it from being asked again
                mainMQ.remove(random);
                mainMA.remove(random);

              } // close if cat math

              // Science category
              else if (mainCat.equals("science")) {

                // random
                int random = (display.reveal(mainSciQ));
                // answer if question variable
                String realAnswer = (display.reveal(mainSciA, random));

                // reveals question
                System.out.println(display.reveal(mainSciQ, random));

                // prompt user answer
                System.out.print("Enter your answer: ");
                String userAnswer = answerScanner.nextLine();

                // return correct/wrong
                String mainCW = (display.right(userAnswer, realAnswer));

                // prints answer
                System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);
                // display points

                onePlay += (display.points(mainCW, onePlay));

                display.line();
                //remove question and answer from arrayList to prevent it from being asked again
                mainSciQ.remove(random);
                mainSciA.remove(random);

              } // close if cat science

              // sports category
              else if (mainCat.equals("sports")) {

                // random
                int random = (display.reveal(mainSpoQ));
                // answer if question variable
                String realAnswer = (display.reveal(mainSpoA, random));

                // reveals question
                System.out.println(display.reveal(mainSpoQ, random));

                // prompt user answer
                System.out.print("Enter your answer: ");
                String userAnswer = answerScanner.nextLine();

                // return correct/wrong
                String mainCW = (display.right(userAnswer, realAnswer));

                // prints answer
                System.out.println("You are " + mainCW + "! The answer is: " + realAnswer);
                // display points
                onePlay += (display.points(mainCW, onePlay));

                display.line();
                //remove question and answer from arrayList to prevent it from being asked again
                mainSpoQ.remove(random);
                mainSpoA.remove(random);

              } // close if cat sports

            } // close % else if

            //add to total rounds 
            roundCount+=1;
              

           } // close for loop for module 2
         }//close else if

          //add to loop counter;
          loopCount+=1;


          //https://stackoverflow.com/questions/1625234/how-to-append-text-to-an-existing-file-in-java
          //code to write data to userData.txt. Only for two player
          if (numPlay==2){
            //prevent overwrite
            FileWriter fw = new FileWriter("userData.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw= new PrintWriter(bw);
        
            //display data in file
            pw.println(display.disRounds(nickOne,nickTwo,roundCount));
            pw.println(display.nickname(nickOne,onePlay));
            pw.println(display.nickname(nickTwo,twoPlay));
            pw.println("\n");
            //close PrintWriter
            pw.close(); 
          }
          
          // leaderboard
          String leaderboard = display.leaderboard(nickOne, nickTwo, onePlay, twoPlay);
          System.out.println(leaderboard);
          display.line();
          display.endGame();

          // loop game
          if (display.contGame(loopCount) == true) {
            // reset score variables and number of rounds variable
            onePlay = 0;
            twoPlay = 0;
            roundCount=0;
            continue;
          } 
          else {
            break;
          }

      

      } // if menu==1

      if(menuChoice==3){
        break;
      }
    } // close main while loop

  }// close main method
}// close main class