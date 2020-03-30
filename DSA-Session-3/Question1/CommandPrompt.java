package Session3.Question1;

import java.util.Date;
import java.util.Scanner;

public class CommandPrompt {

	Directory root = new Directory(null, "R", new Date());
	String path = "R:";

	public void startCommandPrompt(String command) {
		
//		System.out.println("Your command is : "+command);

		String[] tokens = command.split(" ", 2);
		String cmd = tokens[0];
		String fileName = null;
		if (tokens.length > 1) {
			fileName = tokens[1];
		}
//		System.out.println("CMD : "+cmd);
		switch (cmd) {
		case "mkdir":
			root.mkDir(fileName);
			break;

		case "cd":
			root = root.cd(fileName);
			if(root.getName().equals(fileName))
				path = path + "/" + fileName;
			break;

		case "list": root.list();
			break;

		case "back": root = root.back();
			if(path.indexOf("/") != -1)
				path = path.substring(0,path.lastIndexOf("/"));
			break;

		case "find": root.find(fileName, path);
			break;

		case "tree": root.tree(path);
			break;

		case "exit":
			break;

		default:
			System.out.println("Enter Correct Command.");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CommandPrompt cmpd = new CommandPrompt();
		while (true) {
			System.out.print(cmpd.path + "> ");
			String input = sc.nextLine();
			cmpd.startCommandPrompt(input);
			if (input.equals("exit"))
				break;
		}
		sc.close();
	}

}
