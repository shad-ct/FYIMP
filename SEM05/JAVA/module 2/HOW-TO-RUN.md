# Module 2 — Threads, File I/O, AWT, Swing, Applets — How To Run

Mixed module: console programs (threads, file I/O) + GUI programs
(AWT/Swing, need a display) + legacy Applets (need JDK 8's `appletviewer`).

## 1. Dependencies

| Dependency | Version | Required for |
|---|---|---|
| JDK (`javac` + `java`) | 8+ (tested on OpenJDK 17.0.20) | everything (compile + console/GUI run) |
| Graphical display (X11 / desktop) | any | AWT + Swing programs only (`CalculatorAWT`, `ColorSelection`, `LoginForm`, `MarkListSwing`, `MouseKeyboardDemo`, `RegistrationForm`, `StudentPerformance`). Headless SSH servers will throw `HeadlessException` — run these on your laptop/desktop |
| JDK 8 with `appletviewer` | 1.8 only | Applets only (`AnimationApplet`, `AppletLifeCycle`, `ColorParamApplet`, `MouseApplet`, `StudentInfoApplet`). `appletviewer` was **removed in JDK 11+**, so on JDK 17 you can still *compile* applets but cannot *view* them without a JDK 8 install |
| No extra jars, no DB | — | nothing else needed |

```bash
java -version
javac -version
which appletviewer || echo "no appletviewer (normal on JDK 11+)"
```

## 2. Console programs — threads + file I/O + GC (no display needed)

Run from `module 2/`:

```bash
cd "SEM05/JAVA/module 2"
```

### Threads & synchronization (no input — just run)

| Program | Command |
|---|---|
| `ThreadClassDemo.java` — 3 threads via `extends Thread` | `javac ThreadClassDemo.java && java ThreadClassDemo` |
| `RunnableDemo.java` — 2 tasks via `implements Runnable` | `javac RunnableDemo.java && java RunnableDemo` |
| `ThreadLifeCycle.java` — NEW → RUNNABLE → TIMED_WAITING → TERMINATED | `javac ThreadLifeCycle.java && java ThreadLifeCycle` |
| `BankSynchronization.java` — synchronized deposit/withdraw | `javac BankSynchronization.java && java BankSynchronization` |
| `TicketBooking.java` — synchronized ticket pool, 5 tickets | `javac TicketBooking.java && java TicketBooking` |
| `GarbageCollectionDemo.java` — null refs + `System.gc()` | `javac GarbageCollectionDemo.java && java GarbageCollectionDemo` |
| `StudentManagement.java` — constructors + grades + GC demo | `javac StudentManagement.java && java StudentManagement` |

Compile all thread demos at once:

```bash
javac ThreadClassDemo.java RunnableDemo.java ThreadLifeCycle.java \
  BankSynchronization.java TicketBooking.java
```

### File I/O (run in the stated folder — they use relative paths)

| Program | Command |
|---|---|
| `FileWrite.java` — append line to `output.txt` (Scanner input) | `javac FileWrite.java && java FileWrite` |
| `DataStreamDemo.java` — `DataOutputStream`/`DataInputStream` → `student.dat` (Scanner: roll, name, marks) | `javac DataStreamDemo.java && java DataStreamDemo` |
| `EmployeeRecord.java` — append + read all → `employee.dat` (Scanner: id, name, salary) | `javac EmployeeRecord.java && java EmployeeRecord` |
| `FileRead/` — reads `input.txt` via `FileInputStream` | `cd FileRead && javac FileRead.java && java FileRead && cd ..` |
| `FileCopy/` — `source.txt` → `destination.txt` via buffered streams | `cd FileCopy && javac FileCopy.java && java FileCopy && cd ..` |

Verify file outputs:

```bash
cat output.txt student.dat 2>/dev/null | head
cat FileRead/input.txt
cat FileCopy/source.txt FileCopy/destination.txt
```

## 3. GUI programs — AWT / Swing (needs a display, no input files)

Each is a single file with `main()` that opens a window. Same pattern:

```bash
cd "SEM05/JAVA/module 2"
javac CalculatorAWT.java && java CalculatorAWT
```

| Program | Command | What it opens |
|---|---|---|
| `CalculatorAWT.java` — AWT `+ - * /`, handles bad input & ÷0 | `javac CalculatorAWT.java && java CalculatorAWT` | 2 text fields + 4 buttons |
| `ColorSelection.java` — Red/Green/Blue buttons recolor panel | `javac ColorSelection.java && java ColorSelection` | frame with color buttons |
| `MouseKeyboardDemo.java` — mouse position/click + key press via adapters | `javac MouseKeyboardDemo.java && java MouseKeyboardDemo` | frame with live coordinate label |
| `RegistrationForm.java` — AWT name/roll/course/checkboxes, Submit/Clear | `javac RegistrationForm.java && java RegistrationForm` | student registration form |
| `StudentPerformance.java` — AWT marks → total/average | `javac StudentPerformance.java && java StudentPerformance` | performance form |
| `LoginForm.java` — Swing login, admin/1234, Reset/Exit | `javac LoginForm.java && java LoginForm` | login window (user `admin`, pass `1234`) |
| `MarkListSwing.java` — Swing name/regno/3 marks → total/avg/grade, Calculate/Clear/Exit | `javac MarkListSwing.java && java MarkListSwing` | mark-list window (marks must be 0–100) |

> `HeadlessException` / window never appears → you are on a headless
> server. Copy the folder to a machine with a desktop and rerun the same
> two commands there. Close the window (× button) to end the program.

## 4. Applets — legacy (compile anywhere, view with JDK 8)

Each applet is a folder with `<Name>.java` + `<Name>.html`.
On JDK 17 they **compile** (one `deprecation` warning is normal) but
`appletviewer` no longer exists, so viewing needs JDK 8:

```bash
# compiles on JDK 8–17 (warning on 17 is harmless):
cd "SEM05/JAVA/module 2/AppletLifeCycle"
javac AppletLifeCycle.java
```

| Applet (folder) | Compile | View (needs JDK 8) |
|---|---|---|
| `AppletLifeCycle/` — init/start/paint/stop/destroy messages | `cd AppletLifeCycle && javac AppletLifeCycle.java` | `appletviewer AppletLifeCycle.html` |
| `AnimationApplet/` — moving circle, start/stop demo | `cd AnimationApplet && javac AnimationApplet.java` | `appletviewer AnimationApplet.html` |
| `ColorParamApplet/` — bg/fg/message via `<param>` | `cd ColorParamApplet && javac ColorParamApplet.java` | `appletviewer ColorParamApplet.html` |
| `MouseApplet/` — click shows x,y coordinates | `cd MouseApplet && javac MouseApplet.java` | `appletviewer MouseApplet.html` |
| `StudentInfoApplet/` — name/regno/course/sem via `<param>` | `cd StudentInfoApplet && javac StudentInfoApplet.java` | `appletviewer StudentInfoApplet.html` |

With JDK 8 installed alongside JDK 17:

```bash
/usr/lib/jvm/java-8-openjdk-amd64/bin/appletviewer AppletLifeCycle.html
```

No JDK 8 available? Options: install it
(`sudo apt install openjdk-8-jdk`), or just read the `.java` —
the lifecycle/console prints are visible in the source, and the
`.html` shows the `<applet>/<param>` wiring the question asks for.

## 5. Troubleshooting

| Symptom | Fix |
|---|---|
| `javac: command not found` | `sudo apt install openjdk-17-jdk` |
| `Could not find or load main class X` | `javac X.java` first, then `java X` without extension, from the folder containing the file (`FileRead`/`FileCopy` must `cd` into their folder) |
| `File not found: input.txt / source.txt` | You ran from the wrong folder — `FileRead` and `FileCopy` use relative paths, `cd` into their subfolder first (see §2) |
| `HeadlessException` / GUI never shows | No display — run AWT/Swing programs on a desktop machine, not headless SSH |
| `appletviewer: command not found` | Normal on JDK 11+. Install JDK 8 for viewing; compiling alone (`javac`) still works on JDK 17 |
| `warning: Applet has been deprecated` | Harmless — expected on JDK 9+. The code still compiles and runs under JDK 8's viewer |
| Window won't close / program hangs | Close via window × button (WindowAdapter handles it); or `Ctrl+C` / `pkill -f ClassName` in the terminal |
