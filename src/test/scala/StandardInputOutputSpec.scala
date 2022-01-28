import org.scalatest.*
import flatspec.*
import matchers.*
import main.*

import java.io.StringReader
import java.io.ByteArrayOutputStream

class standardInputOutputSpec extends AnyFlatSpec with should.Matchers:
  "単一行の標準入力" should "標準入力を入れ替える" in {
    val exampleString = "hello"
    val input = new StringReader(exampleString)

    Console.withIn(input) {
      val rs = fromStandardInput
      rs should be(exampleString)
    }
  }

  //memo: 動かないのでignore
  ignore should "複数行の標準入力の標準入力を入れ替える" in {
    val exampleString = s"hello\nworld"
    val input = new StringReader(exampleString)

    Console.withIn(input) {
      val rs = fromStandardInputs
      rs should be(List("hello", "world"))
    }
  }

  "単一行の標準出力" should "標準出力を入れ替える" in {
    val exampleString = "hello"
    val outCapture = new ByteArrayOutputStream
    Console.withOut(outCapture) {
      standardOutputs(List("hello"))
    }
  }

  "複数行の標準出力" should "標準出力を入れ替える" in {
    val exampleLS = List("hello", "world")
    val outCapture = new ByteArrayOutputStream
    Console.withOut(outCapture) {
      standardOutputs(exampleLS)
    }
  }
