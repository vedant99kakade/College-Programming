
public class NeuralNW {

	static int inputArray[][] = {{0,0},{0,1},{1,0},{1,1}};
	static int outputArray[] = {0,0,0,1};
	static double learningRate = 0.25;
	static double weightArray[] = {0.15,0.50};
	static double errorRate[] = new double[4];
	
	public static void main(String[] args) {
		double checker = 0.5;
		int counter = 1000000;
		while(counter > 0){	
			
			for(int i= 0 ; i< 4 ; i++){
				double sum = 0;
				double error = 0;
				for(int j =0 ; j< 2 ; j++){
	
					sum +=inputArray[i][j] * weightArray[j];
				}
				error = outputArray[i] - sum;
				System.out.println("Output at" + i + " :" + sum);
				errorRate[i] = error;
				if(error != 0.00000){
					for(int j=0; j<2 ; j++){
						weightArray[j] += learningRate * error * inputArray[i][j];
						
					}
				}
				
			}
			checker = errorRate[0] * errorRate[0] + errorRate[1] * errorRate[1] + errorRate[2] * errorRate[2]
					+ errorRate[3] * errorRate[3];
			System.out.println("Checker is: " + checker);
			counter--;
		}
		
		System.out.println("Expected output achieved");
	}
	
}
