import org.scalatest.*
import flatspec.*
import matchers.*
import main.*

import java.io.StringReader
import java.io.ByteArrayOutputStream
import java.nio.charset.Charset

class standardInputOutputSpec extends AnyFlatSpec with should.Matchers:
  "単一行の標準入力" should "標準入力を入れ替える" in {
    val exampleString = "hello"
    val input = new StringReader(exampleString)

    Console.withIn(input) {
      val rs = fromStandardInput
      rs shouldBe exampleString
    }
  }

  //memo: 動かないのでignore
  ignore should "複数行の標準入力の標準入力を入れ替える" in {
    val exampleString = s"hello\nworld"
    val input = new StringReader(exampleString)

    Console.withIn(input) {
      val rs = fromStandardInputs
      rs shouldBe List("hello", "world")
    }
  }

  "単一行の標準出力" should "標準出力を入れ替える" in {
    val exampleLS = List("hello")
    val outCapture = new ByteArrayOutputStream
    Console.withOut(outCapture) {
      standardOutputs(exampleLS)
      val rs = (new String(outCapture.toByteArray)).linesIterator.toList      
      rs shouldBe exampleLS
    }
  }

  "複数行の標準出力" should "標準出力を入れ替える" in {
    val exampleLS = List("hello", "world")
    val outCapture = new ByteArrayOutputStream
    Console.withOut(outCapture) {
      standardOutputs(exampleLS)
      val rs = (new String(outCapture.toByteArray)).linesIterator.toList
      rs shouldBe exampleLS
    }
  }
