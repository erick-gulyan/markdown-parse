import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    //this denoted that we are going to run a JUnit test
    public void addition(){
        assertEquals(2,1+1);
        //assertEquals(expected,actual);
        //checks to see if expected:2 is equal to actual :1+1=2.
         //Should be true
    }
    @Test
    public void testMarkDown() throws IOException{
        Path fileName1 = Path.of("test1-withspace.md");
        String contents1 = Files.readString(fileName1);
        ArrayList<String> links1 = MarkdownParse.getLinks(contents1);
        assertEquals(List.of("https://ucsd-cse15l-w22.github.io/week/week3/"),links1);

        Path fileName2 = Path.of("test2-infiniteloop.md");
        String contents2 = Files.readString(fileName2);
        ArrayList<String> links2 = MarkdownParse.getLinks(contents2);
        assertEquals(List.of("https://ucsd-cse15l-w22.github.io/week/week3/\n[another link!](some-page.html"),links2);

        Path fileName3 = Path.of("test3-nolinks.md");
        String contents3 = Files.readString(fileName3);
        ArrayList<String> links3 = MarkdownParse.getLinks(contents3);
        ArrayList<String> linkdata3= MarkdownParse.getLinks("test3-nolinks.md");
        //did this since when comparing Listof.(""),links, 
        //it compares Collections.list to a List object and fails. 
        //We were told to compare their data by tutor.
        assertEquals(linkdata3,links3);


        
    }
    // public void snippet1Test() throws IOException{
    //     Path fileName = Path.of("snippet1.md");
    //     String contents = Files.readString(fileName);
    //     ArrayList<String> links = MarkdownParse.getLinks(contents);
    //     assertEquals(List.of(), links);
    // }

    // @Test
    // public void snippet2Test() throws IOException{
    //     Path fileName = Path.of("snippet2.md");
    //     String contents = Files.readString(fileName);
    //     ArrayList<String> links = MarkdownParse.getLinks(contents);
    //     assertEquals(List.of(), links);
    // }
    
    // @Test
    // public void snippet3Test() throws IOException{
    //     Path fileName = Path.of("snippet3.md");
    //     String contents = Files.readString(fileName);
    //     ArrayList<String> links = MarkdownParse.getLinks(contents);
    //     assertEquals(List.of(), links);
    // }
}


