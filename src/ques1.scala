/*
1. Bucketise the given array[Double] into buckets having range interval (x, x+0.049).
0.000 - 0.049
0.050 - 0.099
0.100 - 0.149
0.150 - 0.199
0.200 - 0.249
0.250 - 0.299
0.300 - 0.349
0.350 - 0.399
  ...
...
100.000 - 100.049
Sample -
  12.05, 12.03, 10.33, 11.45, 13.50
Output- [12.050-12.099, 12.050-12.099, 10.300-10.349, 11.450-11.499, 13.500-13.549]
*/

import scala.util.control.Breaks._

object ques1 {
  def main(args: Array[String]): Unit = {
    var arr:Array[Double] = Array(12.05, 12.03, 10.33, 11.45, 13.5)
    for (i <- arr){
      var k =i.toInt;
      var x = k.toDouble

        while(x<=k.toDouble+1)
          {
          breakable {
            if (i >= x && i <= x + 0.049) {
              var y: Double = x + 0.049
              y = BigDecimal(y).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble
              print(s"$x - $y, ")
              break
            }
          }
            x=x+0.05
            x = BigDecimal(x).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble;
        }


    }
  }

}
