import java.io.IOException
import java.net.{InetAddress, UnknownHostException}
import scala.io.StdIn.readLine

/**
 * Rudimentary implementation of ping command
 *
 * @author Stockton Woodworth
 */
object ping {

  /**
   * This function will ping the address
   * TODO massive overhaul to support multiple ping options
   *
   * @param ipAddress - IP Address from cmd line argument
   * @throws java.net.UnknownHostException - Can't find host
   * @throws java.io.IOException           - I/O Exception
   */
  @throws(classOf[UnknownHostException])
  @throws(classOf[IOException])
  def pingRequest(ipAddress: String): Unit = {
    val address: InetAddress = InetAddress.getByName(ipAddress)
    println("PING " + address)

    if (address.isReachable(5000))
      println("Host is reachable")
    else
      println("Host unreachable")
  }

  /**
   * Usage instructions
   */
  def printUsage(): Unit = {
    println("ping [-c <count> or --count <count>] <IP Address>")
    println("ping [-h or --help]\n")
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
        case ("-c" | "--count") :: _ => pingRequest(list.last); sys.exit(0)
        case ("-h" | "--help") :: _ => printUsage(); sys.exit(0)
        case _ => printUsage(); sys.exit(0)
      }
    }

    //    val newAddress = readLine("\nInput IP address: ")
    //    for (i <- 0 to 100) pingRequest(newAddress)
    val options = nextOption(Map(), argsList)
    // println(options)
  }
}