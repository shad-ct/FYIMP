# Module 1 — Java Basics, OOP, Arrays, Matrices, Exceptions — How To Run

All 42 programs in this folder are plain console Java programs.
No server, no database, no extra jars. Only a JDK is needed.

## 1. Dependencies

| Dependency | Version | Notes |
|---|---|---|
| JDK (`javac` + `java`) | 8+ (tested on OpenJDK 17.0.20) | Only requirement. `javac -version` and `java -version` must work |

```bash
java -version
javac -version
```

No `lib/` jars, no Tomcat, no MySQL for this module.

## 2. General run pattern (works for 40 of 42 programs)

Every program is a single file with `public class <Name>` + `main()`.
Run from inside `module 1`:

```bash
cd "SEM05/JAVA/module 1"

# compile + run ANY single program (example: Factorial)
javac Factorial.java
java Factorial
```

Programs that use `Scanner` are interactive — type the prompted input
(numbers, array elements, matrix values) and press Enter.

Compile all at once (skips the `college/` package sources, handled in §4):

```bash
javac *.java
```

Run all non-interactive ones quickly (example loop for the no-input programs):

```bash
for p in AbstractVehicle AreaOverloading BookConstructors DynamicDispatch \
  InterfacePrintable MethodOverriding MultipleInterfaces Pattern \
  RectangleConstructors StudentDetails; do
  echo "===== $p ====="; java "$p"
done
```

> `*.java` files here have the question as a `//` comment on line 1,
> so `head -n 5 <File>.java` tells you what input it expects.

## 3. Program list — file → run command

All commands run from `module 1/`. Compile once, then `java <Class>`:

### Basics / control flow (Scanner input)

| Program | Command |
|---|---|
| `PositiveNegativeZero.java` — +ve / -ve / zero | `javac PositiveNegativeZero.java && java PositiveNegativeZero` |
| `LargestOfTwo.java` | `javac LargestOfTwo.java && java LargestOfTwo` |
| `LargestOfThree.java` | `javac LargestOfThree.java && java LargestOfThree` |
| `EvenOdd.java` | `javac EvenOdd.java && java EvenOdd` |
| `Calculator.java` — switch calculator | `javac Calculator.java && java Calculator` |
| `Grades.java` — marks → A/B/C/D/F | `javac Grades.java && java Grades` |
| `Factorial.java` | `javac Factorial.java && java Factorial` |
| `CountDigits.java` | `javac CountDigits.java && java CountDigits` |
| `Palindrome.java` — number palindrome | `javac Palindrome.java && java Palindrome` |
| `MultiplicationTable.java` | `javac MultiplicationTable.java && java MultiplicationTable` |
| `Pattern.java` — `*` triangle (no input) | `javac Pattern.java && java Pattern` |

### 1D arrays (Scanner input)

| Program | Command |
|---|---|
| `ArrayDisplay.java` | `javac ArrayDisplay.java && java ArrayDisplay` |
| `SumAverageArray.java` | `javac SumAverageArray.java && java SumAverageArray` |
| `LinearSearch.java` | `javac LinearSearch.java && java LinearSearch` |
| `SmallestElement.java` | `javac SmallestElement.java && java SmallestElement` |
| `SortAscending.java` | `javac SortAscending.java && java SortAscending` |
| `MergeArrays.java` — merge two arrays | `javac MergeArrays.java && java MergeArrays` |
| `DuplicateElements.java` | `javac DuplicateElements.java && java DuplicateElements` |

### 2D arrays / matrices (Scanner input)

| Program | Command |
|---|---|
| `Display2DArray.java` | `javac Display2DArray.java && java Display2DArray` |
| `Sum2DArray.java` | `javac Sum2DArray.java && java Sum2DArray` |
| `AddMatrices.java` | `javac AddMatrices.java && java AddMatrices` |
| `MultiplyMatrices.java` | `javac MultiplyMatrices.java && java MultiplyMatrices` |
| `TransposeMatrix.java` | `javac TransposeMatrix.java && java TransposeMatrix` |
| `SymmetricMatrix.java` | `javac SymmetricMatrix.java && java SymmetricMatrix` |
| `ColumnSum.java` | `javac ColumnSum.java && java ColumnSum` |
| `DiagonalSum.java` — principal + secondary diagonal | `javac DiagonalSum.java && java DiagonalSum` |
| `LargestSmallest2D.java` | `javac LargestSmallest2D.java && java LargestSmallest2D` |
| `EvenOddInMatrix.java` — count even/odd in 3×3 | `javac EvenOddInMatrix.java && java EvenOddInMatrix` |

### OOP (mostly no input — just run)

| Program | Command |
|---|---|
| `StudentDetails.java` — class + object + display | `javac StudentDetails.java && java StudentDetails` |
| `BookConstructors.java` — default + parameterized constructor | `javac BookConstructors.java && java BookConstructors` |
| `RectangleConstructors.java` — overloaded constructors | `javac RectangleConstructors.java && java RectangleConstructors` |
| `AreaOverloading.java` — square / rectangle / circle | `javac AreaOverloading.java && java AreaOverloading` |
| `AbstractVehicle.java` — abstract Vehicle, Car/Bike | `javac AbstractVehicle.java && java AbstractVehicle` |
| `MethodOverriding.java` — Animal/Dog/Cat sound() | `javac MethodOverriding.java && java MethodOverriding` |
| `DynamicDispatch.java` — Shape/Circle/Rectangle draw() | `javac DynamicDispatch.java && java DynamicDispatch` |
| `InterfacePrintable.java` — Student/Teacher print() | `javac InterfacePrintable.java && java InterfacePrintable` |
| `MultipleInterfaces.java` — Sports + Academics | `javac MultipleInterfaces.java && java MultipleInterfaces` |

### Exceptions (Scanner input)

| Program | Command |
|---|---|
| `TryCatchDivision.java` — ArithmeticException | `javac TryCatchDivision.java && java TryCatchDivision` |
| `CheckAge.java` — throw/throws, age < 18 | `javac CheckAge.java && java CheckAge` |
| `MultipleExceptionsFinally.java` — index + finally | `javac MultipleExceptionsFinally.java && java MultipleExceptionsFinally` |

## 4. Packages (2 special programs — compile with `-d`)

These need the `college/` sources on the compile line and `-d .`
so the package folders land in the right place:

```bash
cd "SEM05/JAVA/module 1"

# college.Student demo
javac -d . college/Student.java PackageDemo.java
java PackageDemo

# college.department.ITStudent demo
javac -d . college/Student.java college/department/ITStudent.java SubPackageDemo.java
java SubPackageDemo
```

Expected output: `Name: Ravi / Roll No: 5` and
`Name: Sneha / Roll No: 12 / Department: IT`.

> Do NOT run `java college.Student` — `Student` has no `main()`;
> the entry points are `PackageDemo` and `SubPackageDemo`.

## 5. Troubleshooting

| Symptom | Fix |
|---|---|
| `javac: command not found` | Install JDK: `sudo apt install openjdk-17-jdk` |
| `error: file not found: X.java` | You are in the wrong folder — `cd "SEM05/JAVA/module 1"` first; Linux is case-sensitive (`Factorial.java` ≠ `factorial.java`) |
| `Error: Could not find or load main class` | Compile first (`javac X.java`), then `java X` **without** `.java` or `.class`; don't run `java X.java` with extra args |
| `NoSuchElementException` / program hangs | It is waiting on `Scanner` input — type the requested numbers and press Enter |
| `PackageDemo: package college does not exist` | Use the §4 commands with `-d .` and include `college/*.java` on the `javac` line |
| Stale `.class` after editing | Re-run `javac X.java` (or `rm *.class` then recompile) |
