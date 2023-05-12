package javafxtrial;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
//For Debugging purposes and for adding words

public class Bot 
    {
        private final static HashMap<String, String> HardD= new HashMap<>();
        private final static HashMap<String, String> HardV= new HashMap<>();
        private final static HashMap<String, String> ImpossibruD = new HashMap<>();
        private final static HashMap<String, String> ImpossibruV = new HashMap<>();
        private final static HashMap<Integer, String> Easy = new HashMap<>();
        
        public static HashMap<String, String> getHardD()
            {
                return HardD;
            }
        
        public static HashMap<String, String> getHardV()
            {
                return HardV;
            }
        
        public static HashMap<String, String> getImpossibruD()
            {
                return ImpossibruD;
            }
        
        public static HashMap<String, String> getImpossibruV()
            {
                return ImpossibruV;
            }
        
        public static void loadEasy() throws IOException
            {
                
                Path pathw = Paths.get("src/Words/Easy.txt");
                String[] Words = Files.readString(pathw, StandardCharsets.UTF_8).split("_");
                
                for(int i=0;i<Words.length;i++)
                    {
                        Easy.put(i,Words[i]);
                    }
            }
        
        public static void loadHard() throws IOException
            {
                
                Path pathhard = Paths.get("src/Words/Hard.txt");
                Path pathhardV = Paths.get("src/Words/HardV.txt");
                Path pathmhardD = Paths.get("src/Words/HardD.txt");
                String[] Words = Files.readString(pathhard, StandardCharsets.UTF_8).split("_");
                String[] MeaningsV = Files.readString(pathhardV, StandardCharsets.UTF_8).split("_");
                String[] MeaningsD = Files.readString(pathmhardD, StandardCharsets.UTF_8).split("_");
                
                for(int i=0;i<Words.length;i++)
                    {
                        HardV.put(Words[i],MeaningsV[i]);
                    }
                
                for(int i=0;i<Words.length;i++)
                    {
                        HardD.put(Words[i],MeaningsD[i]);
                    }
            }
         
        public static void loadImpossibru() throws IOException
            {
                Path pathimpossibru = Paths.get("src/Words/Impossibru.txt");
                Path pathimpposibruV = Paths.get("src/Words/ImpossibruV.txt");
                Path pathimpossibruD = Paths.get("src/Words/ImpossibruD.txt");
                String[] Words = Files.readString(pathimpossibru, StandardCharsets.UTF_8).split("_");
                String[] MeaningsV = Files.readString(pathimpposibruV, StandardCharsets.UTF_8).split("_");
                String[] MeaningsD = Files.readString(pathimpossibruD, StandardCharsets.UTF_8).split("_");
                
                for(int i=0;i<Words.length;i++)
                    {
                        ImpossibruV.put(Words[i],MeaningsV[i]);
                    }
                
                for(int i=0;i<Words.length;i++)
                    {
                        ImpossibruD.put(Words[i],MeaningsD[i]);
                    }
            }
        
        public static HashMap<Integer, String> getEasy()
            {
                return Easy;
            }
        
    }