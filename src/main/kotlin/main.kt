import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.slf4j.event.Level

fun main() {
    embeddedServer(Netty, 8080, module = { application() }).start(wait = true)
}

fun Application.application() {
    install(CallLogging) {
    level = Level.INFO
}
    routing {
        get("/info") {
            call.respond("I'm a test string")
        }
        get("/") {
            call.respondText(index_html(context.request.uri), contentType = ContentType.Text.Html)
        }
        static("/") {
            resources("static")
//            defaultResource("index.html", "static")
        }
    }
}

fun index_html(baseHref: String = "/") = """<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0"
          name="viewport">
    <meta content="ie=edge" http-equiv="X-UA-Compatible">
    <title>Simple test project</title>
    <base href="$baseHref" />
</head>
<body>
<div id="app">Hallo Welt</div>
<script src="bundle.js"></script>
</body>
</html>"""
