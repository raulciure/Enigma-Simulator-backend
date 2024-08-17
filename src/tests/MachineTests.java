package tests;

import models.Machine;
import models.Plugboard;
import models.Rotor;
import models.RotorType;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MachineTests {
    // Plugboard test
    @Test
    public void plugboardTest() {
        // Set plugboard map
        Map<Character, Character> plugboardMap = new HashMap<Character, Character>();
        plugboardMap.put('B', 'Q');
        plugboardMap.put('C', 'R');
        plugboardMap.put('D', 'I');
        plugboardMap.put('E', 'J');
        plugboardMap.put('K', 'W');
        plugboardMap.put('M', 'T');
        plugboardMap.put('O', 'S');
        plugboardMap.put('P', 'X');
        plugboardMap.put('U', 'Z');
        plugboardMap.put('G', 'H');

        // Set plugboard object
        Plugboard plugboard = new Plugboard(plugboardMap.size(), plugboardMap);

        char input = 'C';
        char expectedOutput = 'R';

        char output = plugboard.encode(input);
        assertEquals(expectedOutput, output);
    }

    // Test for normal operation encoding
    @Test
    public void encodingTest1() {
        // Set plugboard map
        Map<Character, Character> plugboardMap = new HashMap<Character, Character>();
        plugboardMap.put('B', 'Q');
        plugboardMap.put('C', 'R');
        plugboardMap.put('D', 'I');
        plugboardMap.put('E', 'J');
        plugboardMap.put('K', 'W');
        plugboardMap.put('M', 'T');
        plugboardMap.put('O', 'S');
        plugboardMap.put('P', 'X');
        plugboardMap.put('U', 'Z');
        plugboardMap.put('G', 'H');

        // Set plugboard object
        Plugboard plugboard = new Plugboard(plugboardMap.size(), plugboardMap);

        // Set rotors
        Rotor entryWheel = new Rotor(RotorType.setRotorTypeByID("EKW"));
        Rotor rotor1 = new Rotor(RotorType.setRotorTypeByID("I"), 'A', 'A');
        Rotor rotor2 = new Rotor(RotorType.setRotorTypeByID("III"), 'L', 'A');
        Rotor rotor3 = new Rotor(RotorType.setRotorTypeByID("VII"), 'Q', 'A');
        Rotor extraRotor = new Rotor(RotorType.setRotorTypeByID("beta"), 'A', 'A');
        Rotor reflector = new Rotor(RotorType.setRotorTypeByID("b"));

        // Set machine
        Machine machine = new Machine(plugboard, entryWheel, rotor1, rotor2, rotor3, extraRotor, reflector);

        String encodingString = "ABCDEFGH";
        String expectedOutput = "RFSQARMF";

        String output = machine.encode(encodingString);

        assertEquals(expectedOutput, output);
    }

    // Test for rotor character encoding
    @Test
    public void encodingTest2() {
        // Set plugboard object
        Plugboard plugboard = new Plugboard();

        // Set rotors
        Rotor entryWheel = new Rotor(RotorType.setRotorTypeByID("EKW"));
        Rotor rotor1 = new Rotor(RotorType.setRotorTypeByID("I"), 'O', 'A');
        Rotor rotor2 = new Rotor(RotorType.setRotorTypeByID("III"), 'H', 'A');
        Rotor rotor3 = new Rotor(RotorType.setRotorTypeByID("VII"), 'G', 'A');
        Rotor extraRotor = new Rotor(RotorType.setRotorTypeByID("beta"), 'B', 'A');
        Rotor reflector = new Rotor(RotorType.setRotorTypeByID("b"));

        // Set machine
        Machine machine = new Machine(plugboard, entryWheel, rotor1, rotor2, rotor3, extraRotor, reflector);

        char encodingChar = 'B';
        char expectedOutput = 'U';

        char output = machine.encode(encodingChar);

        assertEquals(expectedOutput, output);
    }

    // Test for normal operation encoding
    @Test
    public void encodingTest3() {
        // Set plugboard map
        Map<Character, Character> plugboardMap = new HashMap<Character, Character>();
        plugboardMap.put('A', 'Z');
        plugboardMap.put('P', 'O');
        plugboardMap.put('T', 'Y');
        plugboardMap.put('E', 'W');
        plugboardMap.put('U', 'I');
        plugboardMap.put('L', 'K');
        plugboardMap.put('B', 'H');
        plugboardMap.put('N', 'M');

        // Set plugboard object
        Plugboard plugboard = new Plugboard(plugboardMap.size(), plugboardMap);

        // Set rotors
        Rotor entryWheel = new Rotor(RotorType.setRotorTypeByID("EKW"));
        Rotor rotor1 = new Rotor(RotorType.setRotorTypeByID("VIII"), 'F', 'A');
        Rotor rotor2 = new Rotor(RotorType.setRotorTypeByID("V"), 'I', 'A');
        Rotor rotor3 = new Rotor(RotorType.setRotorTypeByID("VII"), 'Q', 'A');
        Rotor extraRotor = new Rotor(RotorType.setRotorTypeByID("gamma"), 'M', 'A');
        Rotor reflector = new Rotor(RotorType.setRotorTypeByID("c"));

        // Set machine
        Machine machine = new Machine(plugboard, entryWheel, rotor1, rotor2, rotor3, extraRotor, reflector);

        String encodingString = "HEILHITLER";
        String expectedOutput = "LJZEUBZCBY";

        String output = machine.encode(encodingString);

        assertEquals(expectedOutput, output);
    }

    // Test for normal operation encoding using ring settings
    @Test
    public void encodingTestRings() {
        // Set plugboard map
        Map<Character, Character> plugboardMap = new HashMap<Character, Character>();
        plugboardMap.put('A', 'Z');
        plugboardMap.put('P', 'O');
        plugboardMap.put('T', 'Y');
        plugboardMap.put('E', 'W');
        plugboardMap.put('U', 'I');
        plugboardMap.put('L', 'K');
        plugboardMap.put('B', 'H');
        plugboardMap.put('N', 'M');

        // Set plugboard object
        Plugboard plugboard = new Plugboard(plugboardMap.size(), plugboardMap);

        // Set rotors
        Rotor entryWheel = new Rotor(RotorType.setRotorTypeByID("EKW"));
        Rotor rotor1 = new Rotor(RotorType.setRotorTypeByID("VIII"), 'F', 'J');
        Rotor rotor2 = new Rotor(RotorType.setRotorTypeByID("V"), 'I', 'Z');
        Rotor rotor3 = new Rotor(RotorType.setRotorTypeByID("VII"), 'Q', 'E');
        Rotor extraRotor = new Rotor(RotorType.setRotorTypeByID("gamma"), 'M', 'V');
        Rotor reflector = new Rotor(RotorType.setRotorTypeByID("c"));

        // Set machine
        Machine machine = new Machine(plugboard, entryWheel, rotor1, rotor2, rotor3, extraRotor, reflector);

        String encodingString = "HEILHITLER";
        String expectedOutput = "SVYEMXLULE";

        String output = machine.encode(encodingString);

        assertEquals(expectedOutput, output);
    }
}
