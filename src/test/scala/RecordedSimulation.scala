package defalut

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8080")
		.inferHtmlResources()
		.acceptHeader("*/*")
		.acceptEncodingHeader("gzip, deflate, sdch")
		.acceptLanguageHeader("de-DE,de;q=0.8,en-US;q=0.6,en;q=0.4")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")

	val headers_0 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
		"Upgrade-Insecure-Requests" -> "1")

	val headers_6 = Map(
		"Accept" -> "application/json, text/plain, */*",
		"X-XSRF-TOKEN" -> "98fb284d-9014-4ebf-babe-2e169103ff40")

	val headers_11 = Map("Accept" -> "image/webp,image/*,*/*;q=0.8")

	val headers_13 = Map("Origin" -> "http://localhost:8080")



	val scn = scenario("RecordedSimulation")
		// Search
		.exec(http("request_0")
			.get("/")
			.headers(headers_0)
			.resources(http("request_1")
			.get("/manifest.bundle.js"),
            http("request_2")
			.get("/global.bundle.js"),
            http("request_3")
			.get("/main.bundle.js"),
            http("request_4")
			.get("/vendor.dll.js"),
            http("request_5")
			.get("/polyfills.bundle.js")))
		.pause(3)
		.exec(http("request_6")
			.get("/api/profile-info")
			.headers(headers_6)
			.resources(http("request_7")
			.get("/i18n/en/home.json")
			.headers(headers_6),
            http("request_8")
			.get("/i18n/en/global.json")
			.headers(headers_6),
            http("request_9")
			.get("/api/account")
			.headers(headers_6)
			.check(status.is(401)),
            http("request_10")
			.get("/api/profile-info")
			.headers(headers_6),
            http("request_11")
			.get("/a30deb26b4eb1521433021e326cbcc2c.png")
			.headers(headers_11),
            http("request_12")
			.get("/ca854e6d0785ba4b9d715049c0bdbcb3.png")
			.headers(headers_11),
            http("request_13")
			.get("/af7ae505a9eed503f8b8e6982036873e.woff2")
			.headers(headers_13)))

	setUp(scn.inject(rampUsers(1000) over(15 seconds))).protocols(httpProtocol)
}