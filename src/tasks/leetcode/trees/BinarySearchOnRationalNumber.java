package tasks.leetcode.trees;

/*
Problem: Let’s play a guessing game! I have a secret rational number r = p/q
(where these are relatively prime). Your job is to guess r, where I’ll
only tell you whether your guess is high, low, or exactly correct, in as few guesses as you can.
 Design a strategy which (a) will always find r eventually and (b) which can find r quickly if p and q
 are ‘small’ (e.g. if r = ⅔, you should find it quickly, but if r = 7103/2731 it will naturally take lots of guesses).
 */
public class BinarySearchOnRationalNumber {

    public static Fraction guessRational(Fraction low, Fraction high, Oracle oracle) {
        while (true) {
            Fraction middle = low.add(high).divideBy(2);

            int comparison = oracle.compare(middle);
            if (comparison == 0) {
                return middle;
            } else if (comparison < 0) {
                low = middle;
            } else {
                high = middle;
            }
        }
    }

    public static void main(String[] args) {
        Fraction low = new Fraction(0, 1);
        Fraction high = new Fraction(1, 1);
        Oracle oracle = new Oracle(new Fraction(2, 3));

        Fraction guess = guessRational(low, high, oracle);
        System.out.println("Guessed rational: " + guess);
    }
}

class Fraction {
    int numerator, denominator;

    public Fraction(int numerator, int denominator) {
        if(denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction other) {
        int commonDenominator = this.denominator * other.denominator;
        int newNumerator = (this.numerator * other.denominator) + (other.numerator * this.denominator);
        return new Fraction(newNumerator, commonDenominator).simplify();
    }

    public Fraction divideBy(int value) {
        return new Fraction(this.numerator, this.denominator * value).simplify();
    }

    public Fraction simplify() {
        int gcd = gcd(numerator, denominator);
        return new Fraction(numerator / gcd, denominator / gcd);
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public double toDouble() {
        return (double) numerator / denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

class Oracle {
    private Fraction secret;

    public Oracle(Fraction secret) {
        this.secret = secret;
    }

    public int compare(Fraction guess) {
        double difference = secret.toDouble() - guess.toDouble();
        if (difference > 0) return 1;
        if (difference < 0) return -1;
        return 0;
    }
}
