// ==========================================================
// FILE I/O & SERIALIZATION PRACTICE SET
// Solve in order. Difficulty increases gradually.
// ==========================================================
// =======================
// LEVEL 1 – BASIC FILE I/O
// =======================
/*
PROBLEM 1:
Create a program that:

1. Creates a file named "notes.txt".
2. Writes 5 lines of text into the file.
3. Closes the file properly.
4. Reopens the same file.
5. Reads all lines and prints them to the console.

Goal:
Understand basic file writing and reading.
*/
/*
PROBLEM 2:
Given a file "data.txt":

1. Read the file line by line.
2. Count:
   - Total number of lines
   - Total number of words
   - Total number of characters
3. Print all three counts.

Goal:
Practice file reading and text processing.
*/
/*
PROBLEM 3:
Create a logging system:

1. Ask the user to enter a sentence.
2. Append the sentence to a file named "log.txt".
3. Do NOT overwrite existing content.
4. Ensure proper resource closing.

Goal:
Understand append mode and safe file writing.
*/
// =======================
// LEVEL 2 – NIO.2 & FILE SYSTEM
// =======================

/*
PROBLEM 4:
Directory Analyzer:

1. Take a directory path.
2. Recursively list all files inside it (including subfolders).
3. For each file print:
   - File name
   - File size
   - Last modified time

Goal:
Understand Files.walk() and file attributes.
*/


/*
PROBLEM 5:
Extension Filter:

Modify your directory walker to:

1. Print only files that end with ".java".
2. Count total number of .java files.
3. Print the final count at the end.

Goal:
Learn filtering in streams.
*/


/*
PROBLEM 6:
Largest File Finder:

1. Recursively scan a directory.
2. Find the largest file.
3. Print:
   - File name
   - Full path
   - Size in bytes

Goal:
Practice comparison and stream operations.
*/



// =======================
// LEVEL 3 – BASIC SERIALIZATION
// =======================

/*
PROBLEM 7:
Student Save & Load:

1. Create a class Student with:
   - id
   - name
   - marks

2. Write a program to:
   - Create a Student object
   - Serialize it into "student.dat"

3. Write another program to:
   - Deserialize the object
   - Print its details

Goal:
Understand object serialization basics.
*/


/*
PROBLEM 8:
Transient and Static Test:

1. Create a class with:
   - One normal field
   - One transient field
   - One static field

2. Assign values to all fields.
3. Serialize the object.
4. Deserialize the object.
5. Observe what happens to each field.

Goal:
Understand how serialization treats different types of fields.
*/



// =======================
// LEVEL 4 – OBJECT GRAPH SERIALIZATION
// =======================

/*
PROBLEM 9:
Nested Object Serialization:

1. Create class Weapon:
   - name
   - damage

2. Create class Player:
   - name
   - level
   - Weapon object

3. Create a Player object with a Weapon.
4. Serialize the Player into "player.dat".
5. Deserialize it.
6. Verify both Player and Weapon data are restored.

Goal:
Understand object graph serialization.
*/



// =======================
// LEVEL 5 – ADVANCED SERIALIZATION CONCEPTS
// =======================

/*
PROBLEM 10:
Version Control Problem:

1. Create a class GameCharacter.
2. Serialize an object into "game.dat".

3. Now modify the class by:
   - Adding a new field
   - Changing an existing field type

4. Try to deserialize the old file.

5. Observe what happens.

6. Experiment with:
   - Adding serialVersionUID
   - Changing serialVersionUID

Goal:
Understand serialization versioning and compatibility issues.
*/


// ==========================================================
// END OF PRACTICE SET
// ==========================================================
package File.Serialization;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

class Create {
    public static void createWrite() {
        try{
        BufferedWriter bw = new BufferedWriter(new FileWriter("notes.txt"));
            System.out.println("created file");
        bw.write("1 st line");
        bw.newLine();
        bw.write("2 st line");
        bw.newLine();
        bw.write("3 st line");
        bw.newLine();
        bw.write("4 st line");
        bw.close();
            System.out.println("writing over");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void openRead(){
        try{
            BufferedReader br= new BufferedReader(new FileReader("notes.txt"));
            String line;
            System.out.println("reading file");
            while((line = br.readLine())!=null ){
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
class ReadAndCount{
    public static void Readcount(){
        try {
            FileReader fr = new FileReader("notes.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            int count = 0;
            int letterCount = 0;

            while((line =br.readLine())!=null){
                count++;// count number of lines
                letterCount+=line.length();//to count character in each line and add up
            }
            System.out.println("number of lines: "+count);
            System.out.println("number of letters: "+letterCount);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
class LoggerFile{
    public static void writeLog(){
        try{
            BufferedWriter br = new BufferedWriter(new FileWriter("Logfile.txt",true));
            System.out.println("log file created");
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter fdt = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            String formattedDate = fdt.format(now);
            br.write(formattedDate+"log entry ......");
            br.newLine();
            br.close();
            System.out.println("append done");
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
class OpenDirectry{
    public static void directryDetails(){
        Path openingPath = Path.of("D:\\abb"); // change path

        try (Stream<Path> paths = Files.walk(openingPath)) {

            paths
                    .filter(Files::isRegularFile)   // only files
                    .forEach(path -> {
                        try {
                            String name = path.getFileName().toString();
                            System.out.println("file name: "+name);
                            long size = Files.size(path);
                            System.out.println("size"+ size + " bytes");
                            Instant lastModified= Files.getLastModifiedTime(path).toInstant();
                            System.out.println(lastModified);
                            System.out.println();
                        } catch (IOException e) {
                            System.out.println("Cannot read file: " + path);
                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class LearningFiles {
    public static void main(String[] args) {
        Create cr=new Create();
        cr.createWrite();
        cr.openRead();

        ReadAndCount rc= new ReadAndCount();
        rc.Readcount();

        LoggerFile lr=new LoggerFile();
        lr.writeLog();

        OpenDirectry od = new  OpenDirectry();
        od.directryDetails();
    }

}
