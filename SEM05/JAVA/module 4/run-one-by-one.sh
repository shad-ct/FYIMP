#!/bin/bash
# Run Module-4 apps ONE BY ONE
# Usage:
#   ./run-one-by-one.sh list            # show all 20 app names
#   ./run-one-by-one.sh start           # start Tomcat
#   ./run-one-by-one.sh stop            # stop Tomcat
#   ./run-one-by-one.sh BasicServlet    # deploy + test ONE app
#   ./run-one-by-one.sh all             # deploy + test ALL apps one by one
#   ./run-one-by-one.sh                 # interactive menu
#
# Run this from inside "module 4" folder.

cd "$(dirname "$0")"

TOMCAT=tomcat
BASE=http://localhost:8080

APPS=(BasicServlet GenericHttpServlet ServletLifeCycle RequestResponse GetPostHead ServletChaining CookieDemo SessionCart LoginSecurity ErrorHandling BasicJsp JspExpressions JspDirectives JspActions JspImplicit ExpressionLanguage JstlDemo CustomTag SimpleMvcApp MvcCrudApp)

# URL to open for each app (first URL if multiple)
url_for() {
  case "$1" in
    BasicServlet) echo "$BASE/BasicServlet/basic" ;;
    GenericHttpServlet) echo "$BASE/GenericHttpServlet/generic $BASE/GenericHttpServlet/http" ;;
    ServletLifeCycle) echo "$BASE/ServletLifeCycle/life" ;;
    RequestResponse) echo "$BASE/RequestResponse/form.html" ;;
    GetPostHead) echo "$BASE/GetPostHead/form.html" ;;
    ServletChaining) echo "$BASE/ServletChaining/first" ;;
    CookieDemo) echo "$BASE/CookieDemo/cookie?name=Amit" ;;
    SessionCart) echo "$BASE/SessionCart/cart?item=Book" ;;
    LoginSecurity) echo "$BASE/LoginSecurity/login.html  (admin/1234)" ;;
    ErrorHandling) echo "$BASE/ErrorHandling/error" ;;
    BasicJsp) echo "$BASE/BasicJsp/index.jsp" ;;
    JspExpressions) echo "$BASE/JspExpressions/marks.jsp" ;;
    JspDirectives) echo "$BASE/JspDirectives/directives.jsp" ;;
    JspActions) echo "$BASE/JspActions/actions.jsp" ;;
    JspImplicit) echo "$BASE/JspImplicit/implicit.jsp" ;;
    ExpressionLanguage) echo "$BASE/ExpressionLanguage/el.jsp?name=Amit" ;;
    JstlDemo) echo "$BASE/JstlDemo/jstl.jsp" ;;
    CustomTag) echo "$BASE/CustomTag/custom.jsp" ;;
    SimpleMvcApp) echo "$BASE/SimpleMvcApp/student" ;;
    MvcCrudApp) echo "$BASE/MvcCrudApp/crud" ;;
  esac
}

# curl path (no $BASE, no extra text) for auto test
curl_path_for() {
  case "$1" in
    BasicServlet) echo "BasicServlet/basic" ;;
    GenericHttpServlet) echo "GenericHttpServlet/generic" ;;
    ServletLifeCycle) echo "ServletLifeCycle/life" ;;
    RequestResponse) echo "RequestResponse/form.html" ;;
    GetPostHead) echo "GetPostHead/form.html" ;;
    ServletChaining) echo "ServletChaining/first" ;;
    CookieDemo) echo "CookieDemo/cookie?name=Amit" ;;
    SessionCart) echo "SessionCart/cart?item=Book" ;;
    LoginSecurity) echo "LoginSecurity/login.html" ;;
    ErrorHandling) echo "ErrorHandling/error" ;;
    BasicJsp) echo "BasicJsp/index.jsp" ;;
    JspExpressions) echo "JspExpressions/marks.jsp" ;;
    JspDirectives) echo "JspDirectives/directives.jsp" ;;
    JspActions) echo "JspActions/actions.jsp" ;;
    JspImplicit) echo "JspImplicit/implicit.jsp" ;;
    ExpressionLanguage) echo "ExpressionLanguage/el.jsp?name=Amit" ;;
    JstlDemo) echo "JstlDemo/jstl.jsp" ;;
    CustomTag) echo "CustomTag/custom.jsp" ;;
    SimpleMvcApp) echo "SimpleMvcApp/student" ;;
    MvcCrudApp) echo "MvcCrudApp/crud" ;;
  esac
}

do_start() {
  chmod +x $TOMCAT/bin/*.sh
  ./$TOMCAT/bin/startup.sh
  echo "Wait 5 sec, then: curl -I $BASE/"
}

do_stop() {
  ./$TOMCAT/bin/shutdown.sh
}

deploy_one() {
  app="$1"
  echo "== Deploying $app =="
  cp -r "$app" $TOMCAT/webapps/
  if [ "$app" = "JstlDemo" ]; then
    mkdir -p $TOMCAT/webapps/JstlDemo/WEB-INF/lib
    cp lib/jstl.jar lib/standard.jar $TOMCAT/webapps/JstlDemo/WEB-INF/lib/
  fi
  if [ "$app" = "MvcCrudApp" ]; then
    mkdir -p $TOMCAT/webapps/MvcCrudApp/WEB-INF/lib
    cp lib/mysql-connector-j.jar $TOMCAT/webapps/MvcCrudApp/WEB-INF/lib/
    echo "NOTE: MvcCrudApp needs MySQL: college_db, root/root. See HOW-TO-RUN.md"
  fi
  sleep 3
  echo "Open: $(url_for "$app")"
  code=$(curl -s -o /dev/null -w '%{http_code}' "$BASE/$(curl_path_for "$app")")
  echo "HTTP $code <- $app"
}

list_apps() {
  echo "20 apps:"
  i=1
  for a in "${APPS[@]}"; do
    echo " $i. $a  ->  $(url_for "$a")"
    i=$((i+1))
  done
}

run_all() {
  do_start
  sleep 5
  for a in "${APPS[@]}"; do
    deploy_one "$a"
  done
  echo ""
  echo "ALL DONE. Open URLs above in browser."
}

menu() {
  echo "Pick one to run (Tomcat must be started):"
  select app in "${APPS[@]}" ALL START STOP QUIT; do
    case "$app" in
      ALL) run_all; break ;;
      START) do_start; break ;;
      STOP) do_stop; break ;;
      QUIT) break ;;
      "") echo "Invalid choice" ;;
      *) deploy_one "$app"; break ;;
    esac
  done
}

case "$1" in
  "") menu ;;
  list|ls) list_apps ;;
  start) do_start ;;
  stop) do_stop ;;
  all|ALL) run_all ;;
  *)
    found=0
    for a in "${APPS[@]}"; do
      if [ "$1" = "$a" ]; then found=1; fi
    done
    if [ $found -eq 1 ]; then
      deploy_one "$1"
    else
      echo "Unknown app: $1"
      list_apps
      exit 1
    fi
    ;;
esac
