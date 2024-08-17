package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RotorType {
    private Map<Character, Character> wiring;
    private List<Character> notches;

    public RotorType() {}

    public RotorType(Map<Character, Character> wiring, List<Character> notches) {
        this.wiring = wiring;
        this.notches = notches;
    }

    public RotorType(Map<Character, Character> wiring) {
        this.wiring = wiring;
        this.notches = null;
    }

    public Map<Character, Character> getWiring() {
        return wiring;
    }

    public List<Character> getNotches() {
        return notches;
    }

    private static Map<Character, Character> createHashMap(String keys, String values) {
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < keys.length(); i++) {
            map.put(keys.charAt(i), values.charAt(i));
        }
        return map;
    }

    private static List<Character> createArrayList(String string) {
        List<Character> list = new ArrayList<>();
        for(Character c : string.toCharArray()) {
            list.add(c);
        }
        return list;
    }

    /*
     * Sets rotor configuration based on provided ID (String);
     * For convenience and simplicity, the non-turning wheels of the machines (UKW, EKW) are treated as rotors,
       with some attributes set to null;
     */
    public static RotorType setRotorTypeByID(String rotorID) {
        // Define rotors wiring
        final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String rotor_I = "EKMFLGDQVZNTOWYHXUSPAIBRCJ";
        final String rotor_II = "AJDKSIRUXBLHWTMCQGZNPYFVOE";
        final String rotor_III = "BDFHJLCPRTXVZNYEIWGAKMUSQO";
        final String rotor_IV = "ESOVPZJAYQUIRHXLNFTGKDCMWB";
        final String rotor_V = "VZBRGITYUPSDNHLXAWMJQOFECK";
        final String rotor_VI = "JPGVOUMFYQBENHZRDKASXLICTW";
        final String rotor_VII = "NZJHGRCXMYSWBOUFAIVLPEKQDT";
        final String rotor_VIII = "FKQHTLXOCBJSPDZRAMEWNIUYGV";
        final String extraRotor_beta = "LEYJVCNIXWPBQMDRTAKZGFUHOS";
        final String extraRotor_gamma = "FSOKANUERHMBTIYCWLQPZXVGJD";
        final String reflector_b = "ENKQAUYWJICOPBLMDXZVFTHRGS";
        final String reflector_c = "RDOBJNTKVEHMLFCWZAXGYIPSUQ";

        // Define rotors notches
        final String rotor_I_notches = "Q";
        final String rotor_II_notches = "E";
        final String rotor_III_notches = "V";
        final String rotor_IV_notches = "J";
        final String rotor_V_notches = "Z";
        final String rotor_VI_notches = "ZM";
        final String rotor_VII_notches = "ZM";
        final String rotor_VIII_notches = "ZM";

        Map<Character, Character> wireMap;
        List<Character> notches;

        switch (rotorID) {
            case "EKW":
                wireMap = RotorType.createHashMap(alphabet, alphabet);
                return new RotorType(wireMap);

            case "I":
                wireMap = RotorType.createHashMap(alphabet, rotor_I);
                notches = RotorType.createArrayList(rotor_I_notches);
                return new RotorType(wireMap, notches);

            case "II":
                wireMap = RotorType.createHashMap(alphabet, rotor_II);
                notches = RotorType.createArrayList(rotor_II_notches);
                return new RotorType(wireMap, notches);

            case "III":
                wireMap = RotorType.createHashMap(alphabet, rotor_III);
                notches = RotorType.createArrayList(rotor_III_notches);
                return new RotorType(wireMap, notches);

            case "IV":
                wireMap = RotorType.createHashMap(alphabet, rotor_IV);
                notches = RotorType.createArrayList(rotor_IV_notches);
                return new RotorType(wireMap, notches);

            case "V":
                wireMap = RotorType.createHashMap(alphabet, rotor_V);
                notches = RotorType.createArrayList(rotor_V_notches);
                return new RotorType(wireMap, notches);

            case "VI":
                wireMap = RotorType.createHashMap(alphabet, rotor_VI);
                notches = RotorType.createArrayList(rotor_VI_notches);
                return new RotorType(wireMap, notches);

            case "VII":
                wireMap = RotorType.createHashMap(alphabet, rotor_VII);
                notches = RotorType.createArrayList(rotor_VII_notches);
                return new RotorType(wireMap, notches);

            case "VIII":
                wireMap = RotorType.createHashMap(alphabet, rotor_VIII);
                notches = RotorType.createArrayList(rotor_VIII_notches);
                return new RotorType(wireMap, notches);

            case "beta":
                wireMap = RotorType.createHashMap(alphabet, extraRotor_beta);
                return new RotorType(wireMap);

            case "gamma":
                wireMap = RotorType.createHashMap(alphabet, extraRotor_gamma);
                return new RotorType(wireMap);

            case "b":
                wireMap = RotorType.createHashMap(alphabet, reflector_b);
                return new RotorType(wireMap);

            case "c":
                wireMap = RotorType.createHashMap(alphabet, reflector_c);
                return new RotorType(wireMap);
        }
        return null;
    }
}
