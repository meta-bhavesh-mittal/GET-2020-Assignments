package Session3.Question1;

import java.util.ArrayList;
import java.util.Date;

public class Directory {
	private Directory parent;
	private String name;
	private Date created;
	private ArrayList<Directory> subDirs;
	
	public Directory(Directory parent, String name, Date created) {
		this.parent = parent;
		this.name = name;
		this.created = created;
		this.subDirs = new ArrayList<Directory>();
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public ArrayList<Directory> getSubDirs() {
		return subDirs;
	}
	public void setSubDirs(ArrayList<Directory> subDirs) {
		this.subDirs = subDirs;
	}
	
	/**
	 * 
	 * @return True if has subdirs otherwise false
	 */
	public boolean hasSubDir() {
		if(subDirs.size() > 0)
			return true;
		return false;
	}

	/**
	 * 
	 * @param name Directory Name
	 * @return If same name directory is present as subdirectory then return
	 *  true otherwise false.
	 */
	public boolean isSubDirPresent(String name) {
		for(Directory subDir : subDirs) {
			if(name.equals(subDir.getName())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param name
	 * @return if Same name directory is present as subdirectory then return 
	 * that directory.
	 */
	public Directory getSubDir(String name) {
		for(Directory subDir: subDirs) {
			if(name.equalsIgnoreCase(subDir.name)) {
				return subDir;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param name
	 * @return change Directory with given name
	 */
	public Directory cd(String name) {
		if(isSubDirPresent(name)){
			return getSubDir(name);
		} else {
			System.out.println("Directory Not Present.");
			return this;
		}
	}
	
	/**
	 * Make a Directory in current directory with given name
	 * @param name
	 * 
	 */
	public void mkDir(String name) {
		if(isSubDirPresent(name)){
			System.out.println("Name Already Exist.");
			return;
		}
		subDirs.add(new Directory(this,name, new Date()));
	}
	
	/**
	 * 
	 * @param dir  current dir
	 * @param name Name to be search
	 * @param path path of current dir
	 * @param paths will contain all the paths which matches with name
	 * @return paths
	 */
	public ArrayList<String> findAllPaths(Directory dir , String name , String path, ArrayList<String> paths) {
			for(Directory subDir: dir.getSubDirs()) {
//				System.out.println("matching with : "+subDir.getName()+" "+subDir.getName().contains(name));
				if(subDir.getName().contains(name)) {
					paths.add(path +"\\"+subDir.getName());
				}
				findAllPaths(subDir , name , path+"\\"+subDir.getName(),paths);
			}
		return paths;
	}

	
	/**
	 * 
	 * @param name  Name to be search
	 * @param path Current path 
	 * @return List of path which matches the name
	 */
	public void find(String name , String path) {
		ArrayList<String> paths = findAllPaths(this, name, path,
				new ArrayList<String>());
		for(String filePath : paths) {
			System.out.println(filePath);
		}
	}
	
	/**
	 * 
	 * @return Move to Parent Directory
	 */
	public Directory back() {
		if(this.parent != null) 
			return this.parent;
		System.out.println("you are at root dir.");
		return this;
	}
	
	
	/**
	 * Shows SubDirectories of Current Directory
	 */
	public void list() {
		for(Directory subDir : this.subDirs) {
			System.out.println(subDir.getCreated() + " " +subDir.getName());
		}
		System.out.println("Total Folder : "+this.subDirs.size());
	}
	
	/**
	 * Displays Tree structure
	 */
	public void tree(String path) {
		path = path + "-------";
		for(Directory subDir: this.subDirs) {
			System.out.println(path+" "+subDir.getName());
			subDir.tree(path);
		}
		
	}

}
