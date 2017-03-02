package ua.edu.uzhnu.biks;

/**
 * Created by elitebook on 02.03.2017.
 */
public class Fraction {

    private final int numerator;
    private final int denominator;

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }
     
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменник не може дорівнювати 0");
        }

        if (denominator > 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        } else {
            // Нормалізація дробу, якщо знаменник виявився від’ємним
            this.numerator = -numerator;
            this.denominator = -denominator;
        }
    }

    public static Fraction fromDouble(double value) {
        final int denominator = 100000000;
        return new Fraction((int) (value * denominator), denominator).simplify();
    }

    public static Fraction valueOf(String value) {
        // Розіб’ємо рядок по знаку '/'
        String[] parts = value.split("/");
        return new Fraction(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    public boolean isProper() {
        return Math.abs(numerator) < denominator;
    }

    public Fraction inverse() {
        return new Fraction(denominator, numerator);
    }

    public Fraction simplify() {
        int gcd = gcd(numerator, denominator);
        return new Fraction(numerator / gcd, denominator / gcd);
    }

    public static Fraction add(Fraction a, Fraction b) {
        Fraction result = new Fraction(
                a.numerator * b.denominator + b.numerator * a.denominator,
                a.denominator * b.denominator
        );
        return result.simplify();
    }

    public static Fraction subtract(Fraction a, Fraction b) {
        Fraction result = new Fraction(
                a.numerator * b.denominator - b.numerator * a.denominator,
                a.denominator * b.denominator
        );
        return result.simplify();
    }

    public static Fraction multiply(Fraction a, Fraction b) {
        return new Fraction(a.numerator * b.numerator, a.denominator * b.denominator).simplify();
    }

    public static Fraction divide(Fraction a, Fraction b) {
        return new Fraction(a.numerator * b.denominator, a.denominator * b.numerator).simplify();
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}