import java.lang.Math;

/**
* This class creates a triangle.
*
* @author  Marcus A. Mosley
* @version 1.0
* @since   2021-06-03
*/
public class Triangle {
  private String type;
  private double angleA;
  private double sideA;
  private double angleB;
  private double sideB;
  private double angleC;
  private double sideC;
  private double perimeter;
  private double area;
  private double height;
  private double inRadius;
  private double circumArea;
  
  // Constructors
  
  /**
  * The Triangle method constructs a triangle.
  */
  public Triangle(double startAngleA, double startSideA, double startAngleB, double startSideB, 
      double startAngleC, double startSideC) throws IllegalArgumentException {
    angleA = startAngleA;
    sideA = startSideA;
    angleB = startAngleB;
    sideB = startSideB;
    angleC = startAngleC;
    sideC = startSideC;
    
    angleA = Math.toRadians(angleA);
    angleB = Math.toRadians(angleB);
    angleC = Math.toRadians(angleC);
    
    if (this.sideA != 0) {
      if (this.sideB != 0) {
        if (this.sideC != 0) {
          // 1, 1, 1
        } else {
          // 1, 1, 0
          if (this.angleA != 0) {
            angleB = Math.asin(Math.sin(angleA) * (sideB / sideA));
            angleC = Math.PI - (angleA + angleB);
            sideC = sideA * (Math.sin(angleC) / Math.sin(angleA));
          } else if (this.angleB != 0) {
            angleA = Math.asin(Math.sin(angleB) * (sideA / sideB));
            angleC = Math.PI - (angleA + angleB);
            sideC = sideB * (Math.sin(angleC) / Math.sin(angleB));
          } else { // angleC != 0
            sideC = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2)
              - 2 * sideA * sideB * Math.cos(angleC));
          }
        }
      } else {
        if (this.sideC != 0) {
          // 1, 0, 1
          if (this.angleA != 0) {
            angleC = Math.asin(Math.sin(angleA) * (sideC / sideA));
            angleB = Math.PI - (angleA + angleC);
            sideB = sideA * (Math.sin(angleB) / Math.sin(angleA));
          } else if (this.angleB != 0) {
            sideB = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideC, 2)
              - 2 * sideA * sideC * Math.cos(angleB));
          } else { // angleC != 0
            angleA = Math.asin(Math.sin(angleC) * (sideA / sideC));
            angleB = Math.PI - (angleA + angleC);
            sideB = sideC * (Math.sin(angleB) / Math.sin(angleC));
          }
        } else {
          // 1, 0, 0
          if (this.angleA != 0 && this.angleB != 0) {
            sideB = sideA * (Math.sin(angleB) / Math.sin(angleA));
            angleC = Math.PI - (angleA + angleB);
            sideC = sideA * (Math.sin(angleC) / Math.sin(angleA));
          } else if (this.angleA != 0 && this.angleC != 0) {
            sideC = sideA * (Math.sin(angleC) / Math.sin(angleA));
            angleB = Math.PI - (angleA + angleC);
            sideB = sideA * (Math.sin(angleB) / Math.sin(angleA));
          } else { // angleB != 0 && angleC != 0
            angleA = Math.PI - (angleB + angleC);
            sideC = sideA * (Math.sin(angleC) / Math.sin(angleA));
            sideB = sideA * (Math.sin(angleB) / Math.sin(angleA));
          }
        }
      }
    } else {
      if (this.sideB != 0) {
        if (this.sideC != 0) {
          // 0, 1, 1
          if (this.angleA != 0) {
            sideA = Math.sqrt(Math.pow(sideB, 2) + Math.pow(sideC, 2)
              - 2 * sideB * sideC * Math.cos(angleA));
          } else if (this.angleB != 0) {
            angleC = Math.asin(Math.sin(angleB) * (sideC / sideB));
            angleA = Math.PI - (angleB + angleC);
            sideA = sideB * (Math.sin(angleA) / Math.sin(angleB));
          } else { // angleC != 0
            angleB = Math.asin(Math.sin(angleC) * (sideB / sideC));
            angleA = Math.PI - (angleB + angleC);
            sideA = sideC * (Math.sin(angleA) / Math.sin(angleC));
          }
        } else {
          // 0, 1, 0
          if (this.angleA != 0 && this.angleB != 0) {
            sideA = sideB * (Math.sin(angleA) / Math.sin(angleB));
            angleC = Math.PI - (angleA + angleB);
            sideC = sideB * (Math.sin(angleC) / Math.sin(angleB));
          } else if (this.angleA != 0 && this.angleC != 0) {
            angleB = Math.PI - (angleA + angleC);
            sideA = sideB * (Math.sin(angleA) / Math.sin(angleB));
            sideC = sideB * (Math.sin(angleC) / Math.sin(angleB));
          } else { // angleB != 0 && angleC != 0
            sideC = sideB * (Math.sin(angleC) / Math.sin(angleB));
            angleA = Math.PI - (angleB + angleC);
            sideA = sideB * (Math.sin(angleA) / Math.sin(angleB));
          }
        }
      } else {
        // 0, 0, 1
        if (this.angleA != 0 && this.angleB != 0) {
          angleC = Math.PI - (angleA + angleB);
          sideA = sideC * (Math.sin(angleA) / Math.sin(angleC));
          sideB = sideC * (Math.sin(angleB) / Math.sin(angleC));
        } else if (this.angleA != 0 && this.angleC != 0) {
          sideA = sideC * (Math.sin(angleA) / Math.sin(angleC));
          angleB = Math.PI - (angleA + angleC);
          sideB = sideC * (Math.sin(angleB) / Math.sin(angleC));
        } else { // angleB != 0 && angleC != 0
          sideB = sideC * (Math.sin(angleB) / Math.sin(angleC));
          angleA = Math.PI - (angleB + angleC);
          sideA = sideC * (Math.sin(angleA) / Math.sin(angleC));
        }
      }
    }
    
    angleA = Math.toDegrees(angleA);
    angleB = Math.toDegrees(angleB);
    angleC = Math.toDegrees(angleC);
    
    if (!this.isTriangleValid()) {
      throw new IllegalArgumentException();
    }
  }
  
  // Getters
  
  /**
  * The getName method prints the Type of Triangle.
  */
  public void getName() {
    if (this.sideA == this.sideB && this.sideA == this.sideC) {
      this.type = "Equilateral";
    } else if (this.sideA == this.sideB || this.sideA == this.sideC || this.sideB == this.sideC) { 
      if (this.angleA == 90 || this.angleB == 90 || this.angleC == 90) {
        this.type = "Right Isosceles";
      } else if (this.angleA > 90 || this.angleB > 90 || this.angleC > 90) {
        this.type = "Obtuse Isosceles";
      } else {
        this.type = "Acute Isosceles";
      }
    } else {
      if (this.angleA == 90 || this.angleB == 90 || this.angleC == 90) {
        this.type = "Right Scalene";
      } else if (this.angleA > 90 || this.angleB > 90 || this.angleC > 90) {
        this.type = "Obtuse Scalene";
      } else {
        this.type = "Acute Scalene";
      }
    }
    
    System.out.print("\nType: " + type);
  }
  
  /**
  * The getArea method prints the Permieter and Area of the triangle.
  */
  public void getArea() {
    perimeter = sideA + sideB + sideC;
    System.out.print("\nPerimeter: " + perimeter);
    
    area = Math.sqrt(0.5 * perimeter * ((0.5 * perimeter) - sideA)
      * ((0.5 * perimeter) - sideB) * ((0.5 * perimeter) - sideC));
    System.out.print("\nArea: " + area);
  }
  
  public void getHeight() {
    height = area * 2 / sideB;
    System.out.print("\nHeight: " + height);
  }
  
  public void getIncircle() {
    inRadius = area / (perimeter / 2);
    System.out.print("\nIncircle Radius: " + inRadius);
  }
  
  public void getCircumcircle() {
    circumArea = Math.PI * Math.pow(((sideA * sideB * sideC) / (4 * area)), 2);
    System.out.print("\nCircumcircle Area: " + circumArea);
  }
  
  // Methods
  
  private Boolean isTriangleValid() {
    if (Double.isNaN(angleA) || Double.isNaN(sideA) || Double.isNaN(angleB) || Double.isNaN(sideB)
        || Double.isNaN(angleC) || Double.isNaN(sideC) || sideA + sideB <= sideC || sideA + sideC 
        <= sideB || sideB + sideC <= sideA) {
      return false;
    } else {
      System.out.printf("\nTriangle is Valid!\n");
      return true;
    }
  }
}
