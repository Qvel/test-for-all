package structurepatterns.composite;

import java.util.Date;

public class MainComposite {
    public static void main(String[] args) {


        var folder = new Folder(new Date(),"widows");
        var secondFolder = new Folder(new Date(),"java");
        secondFolder.addFile(new File("thinks.txt"));
        folder.addFolder(secondFolder);
        System.out.println(folder);

    }
}
