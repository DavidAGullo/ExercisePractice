import java.util.Scanner;

/*

	Project Two Decimals
	By: David Gullo
	
	
								Summary:
	This Program takes the input and Calculates based off Quanity. (Example: Input is: 5.004, Input Quanity 3. Calculates
	5.004 * 3 = 15.012) For the next part, we will then round it to 2 Decimal, so instead of 15.012 we will get 15.02 
	if we want it to Round up, such as using it for Money. Then option B will be round to the nearest 1/100 so it will
	we will get 15.01.
	
								Objective List:
		1: 2 Inputs
		2: Calculation
		3: 2 Decimals - Round Up
		4: 2 Decimals - Round to Nearest 1/100

*/



public class TwoDecimals {
	
	//Class Variables
	static double outputA = 0; //Standard Output
	static double outputB = 0; //Round up
	static double outputC = 0; //Round up nearest 1/100
	static double inputA = 0;
	static int inputB = 0;
	
	//Constructor
	TwoDecimals()
	{
		inputA = 0;
		inputB = 0;
	}
	
	//Setter
	public void setInput(double inputA, int inputB)
	{
		this.inputA = inputA;
		this.inputB = inputB;
	}
	//Getter
	public static double getInputA()
	{
		return inputA;
	}
	public static int getInputB()
	{
		return inputB;
	}
	
	//Main Method
	public static void main(String[] args) {
		
		//Variables
		TwoDecimals SetInput =  new TwoDecimals();
		Scanner input = new Scanner(System.in);
		String iA = ""; //String Input A
		String iB = ""; //String Input B
		
		//Input
		System.out.print("Please insert Price: ");
		iA = input.nextLine();
		System.out.print("Please Enter Quanity: ");
		iB = input.nextLine();
		
		//Here I just clean up some code by sending both numbers into the setter
		//to grab later. Also I converted them to the right datatype.
		SetInput.setInput(Double.parseDouble(iA), Integer.parseInt(iB));
		
		//Method
		NoRound(getInputA(), getInputB());
		RoundUp(getInputA(), getInputB());
		RoundNear(getInputA(), getInputB());
		
		
		
		
	}
	
	public static void NoRound(double inA, int inB)
	{
		outputA = inA * inB;
		System.out.println("No Round = " + outputA);
	}
	public static void RoundUp(double inA, int inB)
	{
		double out, round;
		out = inA * inB;
		round = Math.ceil(out*100)/100;
		System.out.println("Round Up = " + round);
	}
	public static void RoundNear(double inA, int inB)
	{
		double out, round = 0, determine, tch =0;
		out = inA * inB;
		
		
		//Calc
		determine = (out) - (Math.ceil(out)-1);
		
		//Figure if its Rounding up or down
		if (determine >= 0.05)
		{
			round = Math.ceil(out*100)/100;
		}
		else if (determine < 0.05 )
		{
			double tck = (Math.ceil(out*100)/100)-0.01;
			double tct = (Math.ceil(out*1000)/1000);
			double dd = 0;
			
			dd = (tck - tct) + 0.003;
			if (dd < 0.010)
			{
				round = (Math.ceil(out*100)/100)-0.01;
			}
			else
			{
				round = (Math.ceil(out*100)/100);
			}
			
			
		}
		if (out == Math.ceil(out*100)/100 )
		{
			round = Math.ceil(out*100)/100;
		}
		
		
		//Output
		System.out.println("Round Near = " + round + " " + determine);
	}

}
;