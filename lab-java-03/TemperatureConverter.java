import java.util.Scanner;

public class TemperatureConverter {
  private double tempC;
  //private int tempF;

  public void setCelcius(double t){
    if ( t>=-274 )    // Temp below 0oKelvin considered out of bounds.
      this.tempC = t;
    else
      System.out.println("Temp too cold!!!");
  }
  public double getCelcius() {
    return this.tempC;
  }
  public void setFahrenheit(double t){
    //this.tempF = t;
    // int c = (int)((t-32)*(5.0/9));   // Double -> Int convert C -> F
    // Int convert (ignore decimal) C -> F
    this.tempC=(t-32)*5/9; // Reuse setCelcius in order to
                        // expoit -274 check
  }
  public double getFahrenheit() {
    return this.tempC*9/5 +32;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Temperacture ").append(Math.round(this.tempC)).append("oC ")
      .append(this.getFahrenheit()).append("oF");
    return sb.toString();
  }

  public static void main(String[] args){
    int t =0;
    Scanner sc = new Scanner(System.in);
    TemperatureConverter tc = new TemperatureConverter();
    do {

      System.out.print("F or C?: ");

      char c = sc.next().charAt(0);
      if(c=='C' || c=='c')
        System.out.print("dwse oC: ");
      else
        System.out.print("dwse oF: ");

      t = sc.nextInt();
      if(c=='C' || c=='c')
        tc.setCelcius(t);
      else
        tc.setFahrenheit(t);

      System.out.println(tc.toString());
    } while (t>=-274);
  }

}
