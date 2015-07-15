import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiCollection {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter first 64bit Number : ");
		Integer numberOne = scanner.nextInt();
		System.out.println("Enter second 64bit Number : ");
		Integer numberTwo = scanner.nextInt();

		String numberOneBin = Integer.toBinaryString(numberOne);
		String numberTwoBin = Integer.toBinaryString(numberTwo);

		List<Integer> listOne = new ArrayList<Integer>();
		List<Integer> listTwo = new ArrayList<Integer>();

		ArrayList<Integer> listTemp;
		List<ArrayList<Integer>> listMultiSteps = new ArrayList<ArrayList<Integer>>();

		List<Integer> listTotal = new ArrayList<Integer>();

		for (int i = 0; i < numberOneBin.length(); i++) {

			String temp = String.valueOf(numberOneBin.charAt(i));
			listOne.add(Integer.parseInt(temp));
		}

		for (int i = 0; i < numberTwoBin.length(); i++) {

			String temp = String.valueOf(numberTwoBin.charAt(i));
			listTwo.add(Integer.parseInt(temp));
		}

		System.out.print("Number One : ");
		for (Integer i : listOne) {
			System.out.print(" " + i);
		}
		System.out.println();

		System.out.print("Number Two : ");
		for (Integer i : listTwo) {
			System.out.print(" " + i);
		}
		System.out.println();

		int zeroCounter = 0;
		for (int i = listOne.size() - 1; i >= 0; i--) {

			listTemp = new ArrayList<Integer>();

			// for the tenth and hundredth zero digits
			if (i != listOne.size()) {
				for (int z = 0; z < zeroCounter; z++) {
					listTemp.add(0);
				}
				zeroCounter++;
			}

			for (int j = listTwo.size() - 1; j >= 0; j--) {

				Integer tempMulti = listOne.get(i) * listTwo.get(j);
				listTemp.add(tempMulti);
			}

			listMultiSteps.add(listTemp);
		}

		// Calculating Multiplication Steps
		for (int i = 0; i < listMultiSteps.size(); i++) {

			System.out.println();
			ArrayList<Integer> listOneStep = listMultiSteps.get(i);

			for (int j = listOneStep.size() - 1; j >= 0; j--) {

				System.out.print(" " + listOneStep.get(j));
			}

			System.out.println();
		}

		// Get Max Digits
		int maxDigits = listMultiSteps.get(listMultiSteps.size() - 1).size();

		int digitPos = 0;
		while (digitPos < maxDigits) {

			Integer answerDigit = 0;

			for (int i = 0; i < listMultiSteps.size(); i++) {

				ArrayList<Integer> listOneStep = listMultiSteps.get(i);
				if (listOneStep.size() - 1 >= digitPos) {
					answerDigit += listOneStep.get(digitPos);
				}
			}

			listTotal.add(answerDigit);
			digitPos++;
		}

		System.out.println();
		String answerString = "";
		for (int i = listTotal.size() - 1; i >= 0; i--) {

			//System.out.print(" " + listTotal.get(i));
			answerString += listTotal.get(i);
		}
		
		Integer answer = Integer.parseInt(answerString, 2);
		System.out.println(answer);
	}
}
