This is a test repository for
https://youtrack.jetbrains.com/issue/KTOR-1624

Steps to reproduce:
1. Run `gradle war` to create war file
2. Copy `ktor-root-test-1.3.0.war` from `build/libs` to `C:\Program Files\Apache Software Foundation\Tomcat 9.0\webapps`
3. Start Tomcat using `startup.bat`
4. Visit `localhost:8080/ktor-root-test-1.3.0` => does not work
5. Visit `localhost:8080/ktor-root-test-1.3.0/bundle.js` => does work
5. Visit `localhost:8080/ktor-root-test-1.3.0/info` => does work
6. Rename `ktor-root-test-1.3.0.war` to `ROOT.war`, restart tomcat if you like
7. Visit `http://localhost:8080/` => does work

