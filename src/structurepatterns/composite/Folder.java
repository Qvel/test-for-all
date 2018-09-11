package structurepatterns.composite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Folder {

    private Date creationDate;
    private String name;
    private List<Folder> folders = new ArrayList<>();
    private List<File> files = new ArrayList<>();

    public Folder(Date creationDate, String name) {
        this.creationDate = creationDate;
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getName() {
        return name;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void addFolder(Folder folder){
        folders.add(folder);
    }

    public void removeFolder(Folder folder){
        folders.remove(folder);
    }

    public List<File> getFiles() {
        return files;
    }

    public void addFile(File file){
        files.add(file);
    }

    public void removeFile(File file){
        files.remove(file);
    }



    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Folder{");
        sb.append("creationDate=").append(creationDate);
        sb.append(", name='").append(name).append('\'');
        sb.append(", folders=").append(folders);
        sb.append(", files=").append(files);
        sb.append('}');
        return sb.toString();
    }
}
