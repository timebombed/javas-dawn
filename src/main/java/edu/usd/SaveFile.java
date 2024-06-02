package edu.usd;

import java.io.*;

public class SaveFile {

    // File reading methods.
    public static void saveFile(Player player, boolean overwrite){
        try{
            int duplicateNameExtender = 1;
            File duplicateCheckFile = new File("./savefiles/" + player.getName() + ".dat");
            while(duplicateCheckFile.exists()){
                if (overwrite) {
                    // if we want to overwrite the file, we do not care about finding a valid filename
                    break;
                } else {
                    duplicateCheckFile = new File("./savefiles/" + player.getName() + "(" + duplicateNameExtender + ").dat");
                    duplicateNameExtender++;
                }
            }
            
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(duplicateCheckFile));
            output.writeObject(player);
            output.close();
        }
        catch (FileNotFoundException e){
            System.out.println(e);
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

    public static Player readFile(String filename){
        try{
            FileInputStream f = new FileInputStream(filename);
            ObjectInputStream output = new ObjectInputStream(f);
            Player player = (Player) output.readObject();
            output.close();
            return player;
        }
        catch (ClassNotFoundException e){
            System.out.println(e);
            return null;
        }
        catch (FileNotFoundException e){
            System.out.println(e);
            return null;
        }
        catch (IOException e){
            System.out.println(e);
            return null;
        }
    }
}