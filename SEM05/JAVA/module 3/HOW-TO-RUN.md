# Module 3 — JDBC + MySQL — How To Run

All 10 programs in this folder talk to **MySQL database `college_db`**
(user `root`, password `root`) via `lib/mysql-connector-j.jar`.
Start MySQL first, then compile/run exactly as below.

## 1. Dependencies

| Dependency | Version | Notes |
|---|---|---|
| JDK (`javac` + `java`) | 8+ (tested on OpenJDK 17.0.20) | `javac -version` must work |
| MySQL Server | 8.x (tested 8.4.11) | must be running on `localhost:3306`; programs log in as `root`/`root` and auto-create their tables/procedures |
| `lib/mysql-connector-j.jar` | bundled in `module 3/lib/` | on **every** `javac`/`java -cp` line — without it you get `No suitable driver` / `ClassNotFoundException` |

```bash
java -version
mysql --version
ls lib/mysql-connector-j.jar
sudo systemctl status mysql --no-pager | head -n 5   # or: sudo service mysql status
```

One-time DB setup (tables are auto-created by the programs, but the
database itself must exist):

```bash
# start MySQL if needed:
sudo systemctl start mysql   # or: sudo service mysql start

mysql -u root -p -e "CREATE DATABASE IF NOT EXISTS college_db;"
# when prompted, enter root password.
# If your root password is NOT 'root', either reset it to 'root' or edit
# the url/user/pass strings at the top of each .java file and recompile.
```

> All programs hard-code
> `jdbc:mysql://localhost:3306/college_db` + `root`/`root`.
> Different credentials → edit the 3 strings in the file, then recompile.

## 2. Compile + run (root programs)

Run from `module 3/`:

```bash
cd "SEM05/JAVA/module 3"
```

Compile all 9 root programs at once:

```bash
javac -cp ".:lib/mysql-connector-j.jar" \
  BankTransfer.java DatabaseMetadata.java DbConnection.java \
  JdbcExceptionHandling.java ResultSetMetadata.java ResultSetNavigation.java \
  StoredProcedureDemo.java StudentCrud.java StudentRegistration.java
```

Then run any one (one line per program):

```bash
java -cp ".:lib/mysql-connector-j.jar" DbConnection
java -cp ".:lib/mysql-connector-j.jar" StudentCrud
java -cp ".:lib/mysql-connector-j.jar" StudentRegistration
java -cp ".:lib/mysql-connector-j.jar" JdbcExceptionHandling
java -cp ".:lib/mysql-connector-j.jar" BankTransfer
java -cp ".:lib/mysql-connector-j.jar" StoredProcedureDemo
java -cp ".:lib/mysql-connector-j.jar" ResultSetNavigation
java -cp ".:lib/mysql-connector-j.jar" ResultSetMetadata
java -cp ".:lib/mysql-connector-j.jar" DatabaseMetadata
```

Compile + run a single file (example):

```bash
javac -cp ".:lib/mysql-connector-j.jar" DbConnection.java \
  && java -cp ".:lib/mysql-connector-j.jar" DbConnection
```

Windows: replace `.:` with `.;`, e.g.
`javac -cp ".;lib/mysql-connector-j.jar" DbConnection.java`.

## 3. BlobClobDemo (special folder — must run inside it)

It reads `sample_image.png` / `sample_doc.txt` via **relative paths**,
so `cd` into its folder and point at `../lib/`:

```bash
cd "SEM05/JAVA/module 3/BlobClobDemo"
javac -cp ".:../lib/mysql-connector-j.jar" BlobClobDemo.java
java -cp ".:../lib/mysql-connector-j.jar" BlobClobDemo
cd ..
```

Success prints `Stored BLOB and CLOB.` and creates
`retrieved_image.png` + `retrieved_doc.txt` in the same folder:

```bash
ls -l BlobClobDemo/
diff BlobClobDemo/sample_doc.txt BlobClobDemo/retrieved_doc.txt && echo "CLOB round-trip OK"
```

## 4. Program list — what each does + what to type

| # | Program | Run command (from `module 3/`) | Input / expected output |
|---|---|---|---|
| 1 | `DbConnection.java` — connection test, start here | `java -cp ".:lib/mysql-connector-j.jar" DbConnection` | no input → `Connected to database successfully.` |
| 2 | `StudentCrud.java` — Statement INSERT/UPDATE/DELETE/SELECT | `java -cp ".:lib/mysql-connector-j.jar" StudentCrud` | no input → prints remaining student rows after the demo ops |
| 3 | `StudentRegistration.java` — PreparedStatement insert + search | `java -cp ".:lib/mysql-connector-j.jar" StudentRegistration` | prompts `Enter name:`, `Enter marks:`, then `Enter name to search:` |
| 4 | `JdbcExceptionHandling.java` — duplicate-key, bad SQL, bad input handling | `java -cp ".:lib/mysql-connector-j.jar" JdbcExceptionHandling` | prompts `Enter name:` + `Enter marks:` → prints `Inserted.` / `Duplicate record.` / `Invalid SQL query.` |
| 5 | `BankTransfer.java` — transaction commit/rollback demo (₹200, acc 1→2) | `java -cp ".:lib/mysql-connector-j.jar" BankTransfer` | no input → `Transfer successful.` + both balances |
| 6 | `StoredProcedureDemo.java` — creates + CALLs `get_students()` | `java -cp ".:lib/mysql-connector-j.jar" StoredProcedureDemo` | no input → prints all `students` rows via CallableStatement |
| 7 | `ResultSetNavigation.java` — next/first/last/previous/absolute | `java -cp ".:lib/mysql-connector-j.jar" ResultSetNavigation` | no input (needs ≥1 row in `students` — run `StudentCrud` first if empty) |
| 8 | `ResultSetMetadata.java` — column names/count/types | `java -cp ".:lib/mysql-connector-j.jar" ResultSetMetadata` | no input → `Column count: 3` + column details |
| 9 | `DatabaseMetadata.java` — product/driver version, tables list | `java -cp ".:lib/mysql-connector-j.jar" DatabaseMetadata` | no input → DB name, version, driver, `TABLES:` list |
| 10 | `BlobClobDemo/BlobClobDemo.java` — BLOB image + CLOB text round-trip | see §3 (`cd BlobClobDemo` + `../lib/` cp) | no input → `Stored BLOB and CLOB.` + retrieved_* files |

Suggested first-run order: `DbConnection` → `StudentCrud` (seeds `students`)
→ everything else → `BlobClobDemo` last.

## 5. Troubleshooting

| Symptom | Fix |
|---|---|
| `Communications link failure` / `Connection refused` | MySQL not running: `sudo systemctl start mysql`; check `mysql -u root -p -e "SELECT 1;"` |
| `Unknown database 'college_db'` | `mysql -u root -p -e "CREATE DATABASE IF NOT EXISTS college_db;"` |
| `Access denied for user 'root'` | Password isn't `root` — enter the right one with `-p`, or edit url/user/pass in the `.java` and recompile |
| `No suitable driver found` / `ClassNotFoundException: com.mysql...` | `lib/mysql-connector-j.jar` missing from `-cp`. Re-run with exactly `-cp ".:lib/mysql-connector-j.jar"` from `module 3/` (`../lib/` inside `BlobClobDemo/`) |
| `Table 'college_db.students' doesn't exist` | Normally auto-created — you likely ran an old `.class`. Recompile from source (§2) and rerun |
| `ResultSetNavigation` prints nothing / `Before start of result set` | `students` table is empty — run `StudentCrud` once to seed rows, then rerun |
| `FileNotFoundException: sample_image.png` | You ran from `module 3/` instead of inside `BlobClobDemo/` — follow §3 exactly |
| Windows errors | Use `;` not `:` in `-cp` (`".;lib/mysql-connector-j.jar"`) |
