package com.example

import akka.actor.{Actor, ActorSystem, Props}

object ActorIntro  extends  App {
  var actorSystem = ActorSystem("firstActorSystem")
  println(actorSystem.name)
//  part 2
//  work count actor
  class WordCountActor extends Actor {

    var totalWords = 0
    override def receive: Receive = {

      case message: String =>
        println(s"[Word count] I have received:  $message")
        totalWords = message.split("").length
      case msg => print(s"[word count] I cannot understand ${msg.toString}")
    }
  }

  val wordCounter = actorSystem.actorOf(Props[WordCountActor], "wordcount")
  val anotherWordCount = actorSystem.actorOf(Props[WordCountActor], "anotherWordCounter")
  //  part 4 communication
  wordCounter.!("I'm learning Akka and it's pretty cool")
  anotherWordCount ! "A different message"
}
