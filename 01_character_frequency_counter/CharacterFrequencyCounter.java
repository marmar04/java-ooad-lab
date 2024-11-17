import java.util.*;

public class CharacterFrequencyCounter {
    static void numberSort(int[] numberArray, char[] sentenceArray) {
	int n = numberArray.length;

	for (int i = 0; i < n - 1; i++) {
	    for (int j = 0; j < n - i - 1; j++)
		if (numberArray[j] <= numberArray[j+1]) {

		    // swap
		    int temp = numberArray[j];
		    char tempChar = sentenceArray[j];
		    numberArray[j] = numberArray[j+1];
		    sentenceArray[j] = sentenceArray[j+1];
		    numberArray[j+1] = temp;
		    sentenceArray[j+1] = tempChar;
		}
	}
    }

    static void characterSort(int[] numberArray, char[] sentenceArray) {
	// sort character first before doing bubble sort
	int n = numberArray.length;

	for (int i = 0; i < n - 1; i++) {
	    for (int j = 0; j < n - i - 1; j++)
		if (sentenceArray[j] <= sentenceArray[j+1]) {

		    // swap
		    int temp = numberArray[j];
		    char tempChar = sentenceArray[j];
		    numberArray[j] = numberArray[j+1];
		    sentenceArray[j] = sentenceArray[j+1];
		    numberArray[j+1] = temp;
		    sentenceArray[j+1] = tempChar;
		}
	}
    }
    
    public static void main(String args[]){
	Scanner scan = new Scanner(System.in);

	// prompt for input
	System.out.print("Enter a sentence: ");
	String sentence = scan.nextLine();

	// remove punctuation and whitespace
	sentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();
	int[] freq = new int[sentence.length()];

	// for debugging
	//System.out.println(sentence);

	char sentenceArray[] = sentence.toCharArray();

	// put into array of character:freq
	for (int i = 0; i < sentence.length(); i++) {
	    freq[i] = 1;

	    for (int j = i + 1; j < sentence.length(); j++) {
		if (sentenceArray[i] == sentenceArray[j]) {
		    freq[i]++;

		    // set sentenceArray to 0
		    sentenceArray[j] = '0';
		}
	    }
	}

	// sort characters
	characterSort(freq, sentenceArray);
	numberSort(freq, sentenceArray);

	// display characters
	System.out.println("Character frequency (sorted):");

	for (int i = 0; i < freq.length; i++) {
	    if (sentenceArray[i] != ' ' && sentenceArray[i] != '0')
		System.out.println(sentenceArray[i] + ": " + freq[i]);
	}
    }
}
