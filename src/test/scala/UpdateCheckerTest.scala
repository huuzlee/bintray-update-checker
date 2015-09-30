package com.hanhuy.sbt.bintray

import scala.concurrent.{Await, Promise}

/**
 * @author pfnguyen
 */
object UpdateCheckerTest extends App {
  val promise = Promise[UpdateChecker.Result]()
  UpdateChecker("pfn", "sbt-plugins", "android-sdk-plugin") {
    _.fold(promise.failure, promise.success)
  }
  val f = promise.future
  val result = Await.result(f, concurrent.duration.Duration.Inf)
  println("result: " + result)
}
