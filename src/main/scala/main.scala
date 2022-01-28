package main

import scala.collection.JavaConverters.*

def fromStandardInput: String = io.StdIn.readLine

def fromStandardInputs: List[String] =
  val scanner = new java.util.Scanner(System.in)
  scanner.asScala.toList

def standardOutputs(strAry: List[String]): Unit = strAry.foreach(println(_))
