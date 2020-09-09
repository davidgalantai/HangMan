package hangMan;

import java.util.*;

import hangMan.GuessWord;

public class HangMan {

	

		public static void Startgame() { // printar ut första delen på spelet

			System.out.println("________");
			System.out.println("        |");
			System.out.println("        |");
			System.out.println("           ");
			System.out.println("           ");
			System.out.println("           ");
			System.out.println("           ");
			System.out.println("------------------");
		}

		public static void head() { // printar ut huvudet

			System.out.println("________");
			System.out.println("        |");
			System.out.println("        |");
			System.out.println("        O");
			System.out.println("           ");
			System.out.println("           ");
			System.out.println("           ");
			System.out.println("------------------");

		}

		public static void chest() {// printar ut bröstkorgen

			System.out.println("________");
			System.out.println("        |");
			System.out.println("        |");
			System.out.println("        O");
			System.out.println("        |");
			System.out.println("           ");
			System.out.println("           ");
			System.out.println("------------------");
		}

		public static void rhand() {// printar ut höger hand

			System.out.println("________");
			System.out.println("        |");
			System.out.println("        |");
			System.out.println("        O");
			System.out.println("        |\\");
			System.out.println("           ");
			System.out.println("           ");
			System.out.println("------------------");

		}

		public static void lhand() {// printar ut vänster hand

			System.out.println("________");
			System.out.println("        |");
			System.out.println("        |");
			System.out.println("        O");
			System.out.println("       /|\\");
			System.out.println("           ");
			System.out.println("           ");
			System.out.println("------------------");

		}

		public static void rleg() {// printar ut höger ben

			System.out.println("________");
			System.out.println("        |");
			System.out.println("        |");
			System.out.println("        O");
			System.out.println("       /|\\");
			System.out.println("         \\");
			System.out.println("           ");
			System.out.println("------------------");

		}

		public static void gameOver() {// printar ut vänster ben

			System.out.println("_______   ");
			System.out.println("        |");
			System.out.println("        |");
			System.out.println("        O");
			System.out.println("       /|\\");
			System.out.println("       / \\");
			System.out.println("           ");
			System.out.println("------------------");

		}

		public static void main(String[] args) {

			Scanner sc = new Scanner(System.in); // skapar en Scanner
			String answer[] = GuessWord.getAnswer(); //
			String output[] = { "_", "_", "_", "_", "_", }; //skapar en String array som håller linjerna till bokstäverna
			int chances = 6; // skapar en int med 6 försök

			System.out.println("Welcome to Hangman Game!"); 
			Startgame(); // kallar på start delen på metoden

			while (chances > 0 && (!Arrays.equals(answer, output))) { // om försök är större en 0 och speleran inte har hittat ordet
				System.out.println("Give me a letter or word!");
				String letterGuessed = sc.next(); // läser in vad användaren skriver

				if (letterGuessed.equals("skola")) { // om ordet användaren ange är skola
					System.out.println("Congratulation, you guessed the word!"); // grattis du vann
					break;
				} else if (letterGuessed.equals("s") || letterGuessed.equals("k") || letterGuessed.equals("o")
						|| letterGuessed.equals("l") || letterGuessed.equals("a")) { // eller om bokstaven gissad är lika med s, k, o, l, a
					for (int i = 0; i < answer.length; i++) { // i är 0 sålänge i är mindre en svarets längd plussa på i et
						if (letterGuessed.equals(answer[i])) { // om svaret är lika med 1 karakter i i lägg ut bokstaven där den ska vara 
							output[i] = letterGuessed;

						}

					}

					if (Arrays.equals(answer, output)) { // om spelaren har hittat ordet grats du har vunnit spelet
						System.out.println("Congrats, you won the game!");
					}
				}

				else {
					System.out.println("Wrong letter!"); //annars fel bokstav
					chances--; // chansen går ner
				}
				if (chances == 6) {
					Startgame();
				}
				if (chances == 5) {
					head();
				}
				if (chances == 4) {             // beroande på hur många chans kvar så printar den ut en method med hänggubben
					chest();
				}
				if (chances == 3) {
					rhand();
				}
				if (chances == 2) {
					lhand();
				}
				if (chances == 1) {
					rleg();
				}
				if (chances == 0) {
					gameOver();
				}
				System.out.println(output[0] + " " + output[1] + " " + output[2] + " " + output[3] + " " + output[4]);
				System.out.println("You have " + chances + " lifes's left!");   //printar ut hur många liv användaren har kvar
			}

		}
	}


