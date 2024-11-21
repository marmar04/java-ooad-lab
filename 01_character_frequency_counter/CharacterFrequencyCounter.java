import java.util.*;

public class CharacterFrequencyCounter {
    // sort character
    static void characterSort(int[] numberArray, char[] sentenceArray) {
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
    
    // sort frequency
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

    public static void main(String args[]){
	Scanner scan = new Scanner(System.in);

	// prompt for input
	System.out.print("Enter a sentence: ");
	String sentence = scan.nextLine();

	// close scanner
	scan.close();

	// remove punctuation and whitespace
	sentence = sentence.replaceAll("[^a-zA-Z]", "").toLowerCase();

	// exit if there's no letters
	if (sentence.trim().isEmpty()) {
	    System.out.println("Sentence does not contain any letters");
	    System.exit(0);
	}
	
	// initialise frequency array
	int[] freq = new int[sentence.length()];

	// for debugging
	//System.out.println(sentence);

	// character array for sorting
	char sentenceCharArray[] = sentence.toCharArray();

	// put frequency for each letter
	for (int i = 0; i < sentence.length(); i++) {
	    freq[i] = 1;

	    for (int j = i + 1; j < sentence.length(); j++) {
		if (sentenceCharArray[i] == sentenceCharArray[j]) {
		    freq[i]++;

		    // set sentenceCharArray to 0 if duplicate letter
		    sentenceCharArray[j] = '0';
		}
	    }
	}

	// sort characters
	characterSort(freq, sentenceCharArray);
	numberSort(freq, sentenceCharArray);

	// display characters
	System.out.println("Character frequency (sorted):");

	for (int i = 0; i < freq.length; i++) {
	    if (sentenceCharArray[i] != ' ' && sentenceCharArray[i] != '0')
		System.out.println(sentenceCharArray[i] + ": " + freq[i]);
	}
    }
}
