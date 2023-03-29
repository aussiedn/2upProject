import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @org.junit.jupiter.api.Test
    void main() {
    }

    @org.junit.jupiter.api.Test
    @RepeatedTest(50)
    void numberGentest()
    {
      Main.numberGen();
      String numGen = Main.numberGen();
      assertTrue(numGen.equals("Heads") || numGen.equals("Tails"));
    }

    @org.junit.jupiter.api.Test
    void createNewDir()
    {

    }

    @org.junit.jupiter.api.Test
    void createNewFiletest()
    {
        Main.createNewFile(".\\2UPresults\\resultsdazz.txt");
        Path path = Paths.get(".\\2UPresults\\resultsdazz.txt");
        Assertions.assertTrue(Files.exists(path));
    }
}