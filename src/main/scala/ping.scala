import java.io.IOException
import java.net.{InetAddress, InetSocketAddress, Socket, UnknownHostException}
import scala.io.StdIn.readLine
import scala.util.control.Breaks._
import Console.{BLACK, BLUE, GREEN, RED, RESET, UNDERLINED, YELLOW}

/**
 * Rudimentary implementation of ping command
 * Example (ping is used automatically when program runs, I.E. scala ping)
 * -c 5 8.8.8.8
 * Indexing[0, 1, 2]
 *
 * @author Stockton Woodworth
 */
object ping {

  var received = 0
  var lost = 0

  /**
   * Checks if host is reachable and provides console feedback
   *
   * @param address - InetAddress
   */
  private def reach(address: InetAddress): Unit = {

    if (address.isReachable(5000)) {
      println(s"$RESET${GREEN}Host reachable$RESET")
      received += 1
    } else {
      println("IP Address: " + address)
      println(s"$RESET${RED}Host Unreachable$RESET")
      lost += 1
    }
  }

  /**
   * This function will ping the address
   *
   * @param count     - optional parameter for -c, number of pings
   * @param ipAddress - IP Address from cmd line argument
   * @throws java.net.UnknownHostException - Can't find host
   * @throws java.io.IOException           - I/O Exception
   */
  @throws(classOf[UnknownHostException])
  @throws(classOf[IOException])
  private def pingRequest(ipAddress: String, count: String): Unit = {

    val numPings = count.toInt
    val address: InetAddress = InetAddress.getByName(ipAddress)

    println("PING " + ipAddress)

    // if count is used
    if (numPings > 1) {
      var i = 0
      while (i < numPings) {
        reach(address)
        i += 1
      }
    } else { // Count not used
      reach(address)
    }
  }

  /**
   * Usage instructions
   */
  private def printUsage(): Unit = {
    println("ping [-c <count> or --count <count>] <IP Address>") // specify number of packets
    println("ping [-s] <IP Address>") // Single packet
    println("ping [-h or --help]\n") // Help
  }

  /**
   * Main method, calls upon others to run ping command
   *
   * @param args - cmd line arguments
   */
  def main(args: Array[String]): Unit = {

    // check number of args, print usage if invalid options
    if (args.length == 0) printUsage()

    val argsList = args.toList // create list of arguments
    type OptionMap = Map[Symbol, Any]

    // Checks
    //    println("argsList: " + argsList.toString())
    //    println("argsList.last: " + argsList.last)
    //    val ip: String = argsList.last

    /**
     * Pattern matching used as a Java or C switch statement. nextOption
     * will check for cmd line arguments from a list to check which ping
     * options to use.
     *
     * @param map  - OptionMap
     * @param list - list
     * @return OptionMap
     */
    def nextOption(map: OptionMap, list: List[String]): OptionMap = {
      list match {
        case Nil => map
        case ("-c" | "--count") :: _ => pingRequest(argsList.last, argsList(1)); sys.exit(0)
        case ("-h" | "--help") :: _ => printUsage(); sys.exit(0)
        case "-s" :: _ => pingRequest(argsList.last, "1"); sys.exit(0)
        case _ => printUsage(); sys.exit(0)
      }
    }

    /* Try option map, catch and handle any exceptions that may occur */
    try {
      nextOption(Map(), argsList)
    } catch {
      case _: NumberFormatException => Console.err.println(s"${RED}Wrong usage, try: ping -c 5 'ipAddr'$RESET") // Color not necessary unless running a script
        printUsage()
      case e: IOException => e.printStackTrace()
      case e: Exception => e.printStackTrace()
    }
  }
}