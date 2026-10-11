# Module 4 — Servlets, JSP, MVC — How To Run

All 20 programs in this folder (`SEM05/JAVA/module 4/`) are Java Servlet / JSP
web apps. They run on the **bundled Apache Tomcat** in `tomcat/`.
There is nothing else to install except a JDK (and MySQL for one app).

## 1. Dependencies

| Dependency | Version used / tested | Required for | Notes |
|---|---|---|---|
| JDK (java + javac) | 8+ (tested on OpenJDK 17.0.20) | everything | `java -version` and `javac -version` must work |
| Apache Tomcat | **9.0.85** (bundled in `tomcat/`) | everything | No separate download needed. Listens on port **8080** |
| `lib/javax.servlet-api.jar` (94 KB) | Servlet 4.0 API | compiling every `*.java` Servlet | already in `lib/` |
| `lib/javax.servlet.jsp-api.jar` (53 KB) | JSP 2.3 API | compiling JSP beans / custom tags (`CustomTag`, `ExpressionLanguage`, `JspActions`) | already in `lib/` |
| `lib/jstl.jar` (405 KB) + `lib/standard.jar` (202 KB) | JSTL 1.2 | `JstlDemo/jstl.jsp` only — must be in `JstlDemo/WEB-INF/lib/` | already in `lib/`, copy into webapp |
| `lib/mysql-connector-j.jar` (2.4 MB) | MySQL Connector/J | `MvcCrudApp` only | already in `lib/` |
| MySQL Server 8.x | any 8.x | `MvcCrudApp` only | DB `college_db`, user `root` / `root` (see §5) |
| Browser + `curl` (optional) | any | testing GET/POST/HEAD | `curl -i` is handy for HEAD test |

Check your JDK and Tomcat version:

```bash
java -version
javac -version
./tomcat/bin/version.sh
```

Expected: `Server version: Apache Tomcat/9.0.85`, JVM 17.

## 2. Folder layout (important)

Each sub-folder **is a webapp**. Its name = Tomcat context path:

```
module 4/
├── BasicServlet/         # Servlet + WEB-INF/web.xml + WEB-INF/classes/
├── GenericHttpServlet/
├── ServletLifeCycle/
├── RequestResponse/      # + form.html
├── GetPostHead/          # + form.html
├── ServletChaining/
├── CookieDemo/
├── SessionCart/
├── LoginSecurity/        # + login.html
├── ErrorHandling/        # + error.jsp
├── BasicJsp/             # JSP only: index.jsp
├── JspExpressions/       # marks.jsp
├── JspDirectives/        # directives.jsp + error.jsp
├── JspActions/           # actions.jsp + header.jsp + bean
├── JspImplicit/          # implicit.jsp
├── ExpressionLanguage/   # el.jsp + bean
├── JstlDemo/             # jstl.jsp (needs WEB-INF/lib/jstl*.jar)
├── CustomTag/            # custom.jsp + HelloTag.java + WEB-INF/custom.tld
├── SimpleMvcApp/         # servlet + bean + view.jsp
├── MvcCrudApp/           # servlet + list.jsp (needs MySQL)
├── lib/                  # shared jars (compile-time)
└── tomcat/               # bundled Tomcat 9.0.85 (bin/conf/webapps/logs/...)
```

Deployed copy lives in `tomcat/webapps/<AppName>/` (same structure).
Tomcat serves it at `http://localhost:8080/<AppName>/...`.

## 3. Start / stop Tomcat (run once)

All commands below assume your shell is inside `module 4`:

```bash
cd "SEM05/JAVA/module 4"
# or absolute:
# cd /home/mrrobot/D/CODE-FYIMP/SEM05/JAVA/module\ 4

# make scripts executable (first time only, Linux/macOS)
chmod +x tomcat/bin/*.sh

# start server (port 8080)
./tomcat/bin/startup.sh

# check it is up
curl -I http://localhost:8080/
tail -f tomcat/logs/catalina.out   # server log (Ctrl+C to exit)

# stop server
./tomcat/bin/shutdown.sh
```

Windows equivalent: `tomcat\bin\startup.bat` / `tomcat\bin\shutdown.bat`.

> Port already in use? Either stop the other Tomcat
> (`./tomcat/bin/shutdown.sh`) or change `<Connector port="8080">`
> in `tomcat/conf/server.xml` and use that port in all URLs below.

## 4. Deploy an app

The `.class` files are already committed, so the fastest way is just copying
the source folder into `webapps/` (Tomcat auto-deploys it in seconds):

```bash
# deploy ONE app (example: BasicServlet)
cp -r BasicServlet tomcat/webapps/

# deploy ALL apps at once
for d in BasicServlet GenericHttpServlet ServletLifeCycle RequestResponse \
  GetPostHead ServletChaining CookieDemo SessionCart LoginSecurity \
  ErrorHandling BasicJsp JspExpressions JspDirectives JspActions JspImplicit \
  ExpressionLanguage JstlDemo CustomTag SimpleMvcApp MvcCrudApp; do
  cp -r "$d" tomcat/webapps/
done

# JstlDemo additionally needs its JSTL jars inside the webapp:
mkdir -p tomcat/webapps/JstlDemo/WEB-INF/lib
cp lib/jstl.jar lib/standard.jar tomcat/webapps/JstlDemo/WEB-INF/lib/

# MvcCrudApp needs the MySQL driver inside the webapp (see §5):
mkdir -p tomcat/webapps/MvcCrudApp/WEB-INF/lib
cp lib/mysql-connector-j.jar tomcat/webapps/MvcCrudApp/WEB-INF/lib/
```

Then open the URL from the table in §6. No restart needed — Tomcat picks up
new folders automatically. Watch `tomcat/logs/catalina.out` for errors.

## 5. Recompile from source (optional — .class files already included)

If you edit a `.java` file, recompile it. Run from `module 4/`:

```bash
# --- plain Servlets (most apps) ---
javac -cp "lib/javax.servlet-api.jar" \
  -d BasicServlet/WEB-INF/classes BasicServlet/BasicServlet.java

javac -cp "lib/javax.servlet-api.jar" \
  -d CookieDemo/WEB-INF/classes CookieDemo/CookieDemo.java

javac -cp "lib/javax.servlet-api.jar" \
  -d ErrorHandling/WEB-INF/classes ErrorHandling/ErrorServlet.java

javac -cp "lib/javax.servlet-api.jar" \
  -d GenericHttpServlet/WEB-INF/classes \
  GenericHttpServlet/GenericDemo.java GenericHttpServlet/HttpDemo.java

javac -cp "lib/javax.servlet-api.jar" \
  -d GetPostHead/WEB-INF/classes GetPostHead/GetPostHead.java

javac -cp "lib/javax.servlet-api.jar" \
  -d LoginSecurity/WEB-INF/classes \
  LoginSecurity/LoginServlet.java LoginSecurity/ProtectedServlet.java

javac -cp "lib/javax.servlet-api.jar" \
  -d RequestResponse/WEB-INF/classes RequestResponse/RequestResponse.java

javac -cp "lib/javax.servlet-api.jar" \
  -d ServletChaining/WEB-INF/classes \
  ServletChaining/FirstServlet.java ServletChaining/SecondServlet.java

javac -cp "lib/javax.servlet-api.jar" \
  -d ServletLifeCycle/WEB-INF/classes ServletLifeCycle/ServletLifeCycle.java

javac -cp "lib/javax.servlet-api.jar" \
  -d SessionCart/WEB-INF/classes SessionCart/SessionCart.java

# --- SimpleMvcApp (Servlet + mvc.Student bean) ---
javac -cp "lib/javax.servlet-api.jar" \
  -d SimpleMvcApp/WEB-INF/classes \
  SimpleMvcApp/SimpleMvcApp.java SimpleMvcApp/Student.java

# --- JSP beans / custom tags (need jsp-api too) ---
javac -cp "lib/javax.servlet-api.jar:lib/javax.servlet.jsp-api.jar" \
  -d CustomTag/WEB-INF/classes CustomTag/HelloTag.java

javac -cp "lib/javax.servlet-api.jar:lib/javax.servlet.jsp-api.jar" \
  -d ExpressionLanguage/WEB-INF/classes ExpressionLanguage/StudentBean.java

javac -cp "lib/javax.servlet-api.jar:lib/javax.servlet.jsp-api.jar" \
  -d JspActions/WEB-INF/classes JspActions/StudentBean.java

# --- MvcCrudApp (needs MySQL driver at compile + runtime) ---
javac -cp "lib/javax.servlet-api.jar:lib/mysql-connector-j.jar" \
  -d MvcCrudApp/WEB-INF/classes MvcCrudApp/MvcCrudApp.java
```

Windows: replace `:` in `-cp` with `;`, e.g.
`javac -cp "lib\javax.servlet-api.jar;lib\javax.servlet.jsp-api.jar" ...`

After recompiling, redeploy that app:

```bash
cp -r BasicServlet tomcat/webapps/   # repeat for whichever app you rebuilt
```

Pure-JSP apps (`BasicJsp`, `JspExpressions`, `JspDirectives`, `JspImplicit`,
`JstlDemo`) need **no compilation** — just copy and open the `.jsp` URL.

## 6. Run every program — command + URL cheat sheet

Start Tomcat first (`./tomcat/bin/startup.sh`), deploy the app (§4), then:

### Servlets

| # | Program (folder) | Deploy cmd | Open / test |
|---|---|---|---|
| 1 | `BasicServlet` — displays student info | `cp -r BasicServlet tomcat/webapps/` | `http://localhost:8080/BasicServlet/basic` |
| 2 | `GenericHttpServlet` — GenericServlet vs HttpServlet | `cp -r GenericHttpServlet tomcat/webapps/` | `http://localhost:8080/GenericHttpServlet/generic` and `http://localhost:8080/GenericHttpServlet/http` |
| 3 | `ServletLifeCycle` — init/service/destroy | `cp -r ServletLifeCycle tomcat/webapps/` | `http://localhost:8080/ServletLifeCycle/life` then watch console: `tail tomcat/logs/catalina.out` shows `init() called.` / `service() called.` (reload page → service again; undeploy → destroy) |
| 4 | `RequestResponse` — form → Servlet | `cp -r RequestResponse tomcat/webapps/` | `http://localhost:8080/RequestResponse/form.html` → fill Name/Course → Submit (POST to `/respond`) |
| 5 | `GetPostHead` — GET/POST/HEAD demo | `cp -r GetPostHead tomcat/webapps/` | `http://localhost:8080/GetPostHead/form.html` for GET/POST; HEAD test: `curl -I "http://localhost:8080/GetPostHead/method?name=Amit"` (check `X-Method: HEAD` header) |
| 6 | `ServletChaining` — First → Second via RequestDispatcher | `cp -r ServletChaining tomcat/webapps/` | `http://localhost:8080/ServletChaining/first` (forwards to `/second`, prints `SecondServlet got: Hello from FirstServlet`) |
| 7 | `CookieDemo` — save/read cookie | `cp -r CookieDemo tomcat/webapps/` | Save: `http://localhost:8080/CookieDemo/cookie?name=Amit` → then revisit `http://localhost:8080/CookieDemo/cookie` (reads cookie, prints `Hello Amit`) |
| 8 | `SessionCart` — shopping cart in HttpSession | `cp -r SessionCart tomcat/webapps/` | `http://localhost:8080/SessionCart/cart?item=Book` → add more: `.../cart?item=Pen` → view: `http://localhost:8080/SessionCart/cart` |
| 9 | `LoginSecurity` — login + protected page (admin/1234) | `cp -r LoginSecurity tomcat/webapps/` | `http://localhost:8080/LoginSecurity/login.html` → login `admin` / `1234` → redirects to `/protected`; without login `/protected` prints `Access denied` |
| 10 | `ErrorHandling` — intentional error + custom page | `cp -r ErrorHandling tomcat/webapps/` | `http://localhost:8080/ErrorHandling/error` → throws ServletException → shows `error.jsp` (`Something went wrong...`) |

### JSP pages

| # | Program (folder) | Deploy cmd | Open / test |
|---|---|---|---|
| 11 | `BasicJsp` — JSP translation/compile/execute + visit counter | `cp -r BasicJsp tomcat/webapps/` | `http://localhost:8080/BasicJsp/index.jsp` (reload → Visits increments) |
| 12 | `JspExpressions` — declarations/expressions, total & average | `cp -r JspExpressions tomcat/webapps/` | `http://localhost:8080/JspExpressions/marks.jsp` |
| 13 | `JspDirectives` — page directives (import, contentType, errorPage) | `cp -r JspDirectives tomcat/webapps/` | `http://localhost:8080/JspDirectives/directives.jsp` |
| 14 | `JspActions` — useBean/setProperty/getProperty/include | `cp -r JspActions tomcat/webapps/` | `http://localhost:8080/JspActions/actions.jsp` |
| 15 | `JspImplicit` — request/session/application/out/config/pageContext | `cp -r JspImplicit tomcat/webapps/` | `http://localhost:8080/JspImplicit/implicit.jsp` |
| 16 | `ExpressionLanguage` — EL + bean + param + header | `cp -r ExpressionLanguage tomcat/webapps/` | `http://localhost:8080/ExpressionLanguage/el.jsp?name=Amit` |
| 17 | `JstlDemo` — c:if / c:forEach / c:choose | `cp -r JstlDemo tomcat/webapps/` + copy jars (see below) | `http://localhost:8080/JstlDemo/jstl.jsp` |
| 18 | `CustomTag` — custom `<ct:hello/>` tag + TLD | `cp -r CustomTag tomcat/webapps/` | `http://localhost:8080/CustomTag/custom.jsp` |

```bash
# JstlDemo one-time JSTL setup (required, else taglib error):
mkdir -p tomcat/webapps/JstlDemo/WEB-INF/lib
cp lib/jstl.jar lib/standard.jar tomcat/webapps/JstlDemo/WEB-INF/lib/
```

### MVC apps

| # | Program (folder) | Deploy cmd | Open / test |
|---|---|---|---|
| 19 | `SimpleMvcApp` — Servlet → Student bean → view.jsp | `cp -r SimpleMvcApp tomcat/webapps/` | `http://localhost:8080/SimpleMvcApp/student` |
| 20 | `MvcCrudApp` — Servlet + JSP + JDBC (MySQL), add/view/update/delete | `cp -r MvcCrudApp tomcat/webapps/` + MySQL setup (§5 note + below) | List: `http://localhost:8080/MvcCrudApp/crud` · Add: `.../crud?action=add&name=Ravi&marks=80` · Update: `.../crud?action=update&id=1&marks=90` · Delete: `.../crud?action=delete&id=1` |

```bash
# MvcCrudApp one-time MySQL + driver setup:
# 1. start MySQL, then:
mysql -u root -p -e "CREATE DATABASE IF NOT EXISTS college_db;"
# 2. password/URL must match MvcCrudApp.java:
#    jdbc:mysql://localhost:3306/college_db user=root password=root
#    (edit + recompile if yours differ — see §5)
# 3. copy driver into the webapp:
mkdir -p tomcat/webapps/MvcCrudApp/WEB-INF/lib
cp lib/mysql-connector-j.jar tomcat/webapps/MvcCrudApp/WEB-INF/lib/
```

## 7. Quick smoke test (all apps)

```bash
./tomcat/bin/startup.sh
sleep 5
for u in BasicServlet/basic GenericHttpServlet/generic GenericHttpServlet/http \
  ServletLifeCycle/life ServletChaining/first "CookieDemo/cookie?name=Amit" \
  "SessionCart/cart?item=Book" ErrorHandling/error BasicJsp/index.jsp \
  JspExpressions/marks.jsp JspDirectives/directives.jsp JspActions/actions.jsp \
  JspImplicit/implicit.jsp "ExpressionLanguage/el.jsp?name=Amit" \
  JstlDemo/jstl.jsp CustomTag/custom.jsp SimpleMvcApp/student MvcCrudApp/crud; do
  echo "== $u -> $(curl -s -o /dev/null -w '%{http_code}' http://localhost:8080/$u)"
done
```

Expect `200` for all (ErrorHandling returns 200 via its error page,
MvcCrudApp needs MySQL up or it returns 500 — see §8).

## 8. Troubleshooting

| Symptom | Fix |
|---|---|
| `javac: command not found` | Install JDK 8+: `sudo apt install openjdk-17-jdk` |
| `package javax.servlet does not exist` | Add `-cp lib/javax.servlet-api.jar` (and `jsp-api` for tags/beans). Run `javac` from `module 4/` so `lib/` resolves |
| `HTTP 404` | App not deployed: `ls tomcat/webapps/<App>` must exist; check context name spelling and `WEB-INF/web.xml` `<url-pattern>` |
| `HTTP 500` on JSP / `Unable to load tag handler` | `CustomTag`: `WEB-INF/custom.tld` must map `http://example.com/tags` → `tags.HelloTag`; `JstlDemo`: `jstl.jar`+`standard.jar` must be in `WEB-INF/lib/` |
| `MvcCrudApp` → 500 / `Communications link failure` | MySQL down or wrong credentials. Start MySQL, create `college_db`, match `root`/`root` in `MvcCrudApp.java`, copy `mysql-connector-j.jar` to `WEB-INF/lib/`, restart Tomcat |
| Port 8080 in use | `./tomcat/bin/shutdown.sh`, or edit `tomcat/conf/server.xml` port and use the new port in URLs |
| No output in browser, want server logs | `tail -f tomcat/logs/catalina.out` (ServletLifeCycle `init/service/destroy` prints here) |

## 9. Reference: URL patterns (from each `WEB-INF/web.xml`)

`basic`, `generic`, `http`, `life`, `respond`, `method`, `first`, `second`,
`cookie`, `cart`, `login`, `protected`, `error`, `crud`, `student` —
each mounted under its own context, e.g. `/BasicServlet/basic`.
JSP-only apps are reached by file name, e.g. `/BasicJsp/index.jsp`.
