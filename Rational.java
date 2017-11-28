/**
 * Created by Rahul Sehrawat on 28-11-2017.
 */
public class Rational {

    private int num, den;

    public Rational(int num, int den) {

        if(den==0) throw new ArithmeticException("Denominator is zero");

        int g = gcd(num,den);
        num = num/g;
        den = den/g;
        this.num = num;
        this.den = den;
        if (this.den<0) {
            this.den = -this.den;
            this.num = -this.num;
        }
    }

    public Rational plus(Rational b)
    {
        Rational a = this;

        int f = gcd(a.num, b.num);
        int g = gcd(a.den, b.den);

        Rational s = new Rational((a.num / f) * (b.den / g) + (b.num / f) * (a.den / g),
                lcm(a.den, b.den));

        s.num *= f;
        return s;

    }

    public Rational minus(Rational b)
    {
        return this.plus(b.negate());
    }

    public Rational mutiply(Rational b)
    {
        Rational c = new Rational(this.num,b.den);
        Rational d = new Rational(b.num,this.den);
        return new Rational(c.num*d.num,c.den*d.den);
    }

    public Rational divide(Rational b)
    {
        return this.mutiply(b.reciprocal());
    }

    public Rational negate()
    {
        return new Rational(-this.num,this.den);
    }

    public Rational reciprocal()
    {
        return new Rational(this.den,this.num);
    }

    public Rational abs()
    {
        if(this.num<0) return this.negate();
        return this;
    }

    public int gcd(int m,int n)
    {
        if(m<0) m = -m;
        if(n<0) n = -n;
        if(n==0) return m;
        return gcd(n,m%n);

    }

    public int lcm(int m, int n)
    {
        if(m<0) m = -m;
        if(n<0) n = -n;
        return m*(n/gcd(m,n));
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDen() {
        return den;
    }

    public void setDen(int den) {
        this.den = den;
    }


    @Override
    public String toString() {
        if(den==1) return num+"";
        return num+"/"+den;
    }


    public int compareTo(Rational b) {
       return Integer.compare(this.num*b.den,this.den*b.num);
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
}
