/*
. For given players statistics..
Found the below -
  1. Player with the best highest run scored.
2. Top 5 players by run scored.
3. Top 5 players by wicket taken.
4. Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored.
  Sample -
  Year, PlayerName, Country, Matches, Runs, Wickets
2021, Sam, India, 23, 2300, 3
2021, Ram, India, 23, 300, 30
2021, Mano, India, 23, 300, 13
*/


import scala.util.control.Breaks._
class playerStat(var year:Int,var name:String,var country:String, var matches:Int, var runs:Int, var wicket:Int){}

object ques2 {
  def insert(yr:Int, plName:String,cnName:String,mat:Int,run:Int,wic:Int): playerStat ={

    var obj  = new playerStat(yr,plName,cnName,mat,run,wic)
    return obj

  }

  def main(args: Array[String]): Unit = {
       var lst = List(insert(2021, "Sam", "India", 23, 2300, 3))
       lst = lst :+ insert(2021, "Ram", "India", 23, 300, 30)
       lst = lst :+ insert(2021, "Mano", "India", 23, 300, 13)
       lst = lst :+ insert(2020, "Nano", "England", 21, 330, 5)
       lst = lst :+ insert(2019, "Manu", "India", 23, 3100, 50)
       lst = lst :+ insert(2016, "Anderson", "England", 40, 300, 51)
       lst = lst :+ insert(2019, "Kohli", "India", 35, 5300, 5)
       lst = lst :+ insert(2018, "Dhoni", "Australia", 75, 3300, 15)


//    1. Player with the best highest run scored.
      println(" Player with the best highest run scored.")
       lst = lst.sortBy(_.runs).reverse
       println(lst(0).name)
//    2. Top 5 players by run scored.
      println("Top 5 players by run scored.")
      var c:Int =0;
      breakable {
        for (i <- lst) {
          println(i.name)
          c = c + 1
          if(c==5)break

        }
      }
//    3. Top 5 players by wicket taken.
    println("Top 5 players by wicket taken.")
      lst = lst.sortBy(_.wicket).reverse
      println(lst(0).name)
//    4. Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored.
    println("Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored.")
    lst = lst.sortBy(_.wicket*5).sortBy(_.runs*(5/100)).reverse
    println(lst(0).name)
  }
}
