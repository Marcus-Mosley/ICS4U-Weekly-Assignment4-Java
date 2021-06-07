import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
* This class uses the Triangle.
*
* @author  Marcus A. Mosley
* @version 1.0
* @since   2021-06-07
*/
public class Main {
  /**
  * The Main method receives input and checks viability.
  */
  public static void main(String[] args) {
    int count = 0;
    int anumber;
    double angleA = 0;
    double sideA = 0;
    double angleB = 0;
    double sideB = 0;
    double angleC = 0;
    double sideC = 0;
    
    while (true) {
      try {
        // Input
        System.out.print("Please enter 0 if there is no value!\n");
        
        Scanner input = new Scanner(System.in);
        
        while (count < 3) {
          if ((angleA == 0 && angleB == 0) || (angleA == 0 && angleC == 0) || (angleB == 0 
              && angleC == 0)) {
            System.out.print("\nWhat would you like to enter (Angle A:"
                + " 1, Side A: 2, Angle B: 3, Side B: 4, Angle C: 5, Side C: 6)? ");
            anumber = input.nextInt();
            if (anumber == 1) {
              System.out.print("\nEnter Angle A: ");
              angleA = input.nextDouble();
            } else if (anumber == 2) {
              System.out.print("\nEnter Side A: ");
              sideA = input.nextDouble();
            } else if (anumber == 3) {
              System.out.print("\nEnter Angle B: ");
              angleB = input.nextDouble();
            } else if (anumber == 4) {
              System.out.print("\nEnter Side B: ");
              sideB = input.nextDouble();
            } else if (anumber == 5) {
              System.out.print("\nEnter Angle C: ");
              angleC = input.nextDouble();
            } else if (anumber == 6) {
              System.out.print("\nEnter Side C: ");
              sideC = input.nextDouble();
            } else {
              throw new IOException();
            }
          } else {
            System.out.print("\nWhat would you like to enter (Side A: 2, Side B: 4, Side C: 6)? ");
            anumber = input.nextInt();
            if (anumber == 2) {
              System.out.print("\nEnter Side A: ");
              sideA = input.nextDouble();
            } else if (anumber == 4) {
              System.out.print("\nEnter Side B: ");
              sideB = input.nextDouble();
            } else if (anumber == 6) {
              System.out.print("\nEnter Side C: ");
              sideC = input.nextDouble();
            } else {
              throw new IOException();
            }
          }
          count++;
        }
        
        Triangle atriangle = new Triangle(angleA, sideA, angleB, sideB, angleC, sideC);
        atriangle.getName();
        atriangle.getArea();
        atriangle.getHeight();
        atriangle.getIncircle();
        atriangle.getCircumcircle();
        break;
      } catch (InputMismatchException e) {
        System.out.printf("\nThat is not a number, please input a number!\n\n");
      } catch (IOException e) {
        System.out.printf("\nThat is not Valid Input!\n\n");
      } catch (IllegalArgumentException  e) {
        System.out.printf("\nTriangle is Not Valid!\n\n");
      }
    }
  }
}