public class Complex {
 
 private double real;
 private double imaginary;
 
 public double getReal() {
  return this.real;
 }

 public void setReal(double real) {
  this.real = real;
 }

 public double getImaginary() {
  return this.imaginary;
 }

 public void setImaginary(double imaginary) {
  this.imaginary = imaginary;
 }

 public Complex() {
  this.setReal(0);
  this.setImaginary(0);
 }
 
 public Complex(double real, double imaginary){
  this.setReal(real);
  this.setImaginary(imaginary);
 }
 
 public void setRealAndImaginary(double real, double imaginary){
  this.setReal(real);
  this.setImaginary(imaginary);
 }
 
 
 @Override
 public String toString() {
  return "Values : [ (" + real + " ) + (" + imaginary + " i ) ]";
 }
  
    public Complex addition(Complex temp){
     Complex result = new Complex();
     result.real = this.getReal() + temp.getReal();
     result.imaginary = this.getImaginary() + temp.getImaginary();
     return result;
    }
 
    public Complex subtraction(Complex temp){
     Complex result = new Complex();
     result.real = this.getReal() - temp.getReal();
     result.imaginary = this.getImaginary() - temp.getImaginary();
     return result;
    }
    
    public Complex multiplication(Complex temp){
     Complex result = new Complex();
     result.real = ( this.getReal() * temp.getReal() ) - ( this.getImaginary() * temp.getImaginary());
     result.imaginary = ( this.getReal() * temp.getImaginary() ) + ( this.getImaginary() * temp.getReal());
     return result;
    }
    
    public Complex division(Complex temp){
     Complex result = new Complex();
     result.real = ((( this.getReal() * temp.getReal() ) + ( this.getImaginary() * temp.getImaginary())) / (Math.pow(temp.getReal(), 2) + Math.pow(temp.getImaginary(), 2)));
     result.imaginary =((( this.getReal() * temp.getImaginary() ) - ( this.getImaginary() * temp.getReal() )) / (Math.pow(temp.getReal(), 2) + Math.pow(temp.getImaginary(), 2)));
     return result;
    }
    
 public static void main(String[] args) {
  
  Complex complex = new Complex();
 
  Complex complex1 = new Complex(2,-1);
  Complex complex2 = new Complex(3,4);
  
  System.out.println("complex  " + complex);
  System.out.println("complex1  " + complex1);
  System.out.println("complex2  " + complex2);
  
  System.out.println("\n\n\nAddition  " + complex1.addition(complex2));
  System.out.println("Subtraction  " + complex1.subtraction(complex2));
  System.out.println("Multiplication " + complex1.multiplication(complex2));
  System.out.println("Division  " + complex1.division(complex2));
  
 }

}