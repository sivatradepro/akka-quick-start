package com.example

import akka.actor.Actor
import akka.actor.Props
import akka.event.Logging

class FirstActor extends Actor {
  val log = Logging(context.system, this)

  def receive = {
    case "test" => log.info("received test")
    case _      => log.info("received unknown message")
  }
}