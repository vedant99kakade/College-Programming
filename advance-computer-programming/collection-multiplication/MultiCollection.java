/*
	Multiply 64 Bit Numbers
	Using Bit Shif Logic
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiCollection {

	public static List<Integer> getShiftList(String number){

		List<Integer> shiftList = new ArrayList<Integer>();

		for(int i=0; i<number.length(); i++){
			if(String.valueOf(number.charAt(i)).equals("1")){
				shiftList.add(number.length()-1-i);
			}
		}

		return shiftList;
	}

	public static Long getMultiplication(Long firstNumber,
			List<Integer> secondNumber) {

		Long result = 0l;
		String secondNumberStr = "";

		/*
		 *  Get shiftList as per secondNumber as it will be used to shift first number
		 *  All shift of firstNumber Added Together to form Result
		 */
		for(int i=0; i<secondNumber.size(); i++){
			secondNumberStr += String.valueOf(secondNumber.get(i));
		}
		List<Integer> shiftList = getShiftList(secondNumberStr);

		/*
		 * Now Use shiftList to shift firstNumber with given shift and add all shifted
		 * numbers together to get result
		 */
		for(int i=0; i<shiftList.size(); i++){

			int shiftBy = shiftList.get(i);
			result += firstNumber << shiftBy;

		}


		return result;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter first 64bit Number : ");
		Long numberOne = scanner.nextLong();
		System.out.println("Enter second 64bit Number : ");
		Integer numberTwo = scanner.nextInt();

		String numberTwoBin = Integer.toBinaryString(numberTwo);
		List<Integer> listTwo = new ArrayList<Integer>();

		for (int i = 0; i < numberTwoBin.length(); i++) {

			String temp = String.valueOf(numberTwoBin.charAt(i));
			listTwo.add(Integer.parseInt(temp));
		}

		System.out.println();
		System.out.print("Multiplication :");
		System.out.print(getMultiplication(numberOne, listTwo));
	}
}
