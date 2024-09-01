class Rational(n:Int,d:Int) {
    require(d!=0,"Denominator cannot be zero")

    private val gcdValue = gcd(n.abs,d.abs)
    val numerator:Int = n/gcdValue
    val denominator:Int = d/gcdValue

    def neg:Rational = new Rational(-numerator,denominator)

    override def toString:String = s"$numerator/$denominator"

    private def gcd(a:Int,b:Int):Int = {
        if(b==0)
            a
        else 
            gcd(b,a%b)
    }
}

object RationalSubtraction extends App {
    val x = new Rational(3,4)
    val y = new Rational(5,8)
    val z = new Rational(2,7)

    def sub(a:Rational,b:Rational) : Rational = {
        new Rational(a.numerator * b.denominator - b.numerator * a.denominator,a.denominator * b.denominator)
    }

    val result = sub(sub(x,y),z)
    println(s"x - y - z : $result")
}