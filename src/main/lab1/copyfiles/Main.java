package main.lab1.copyfiles;

import main.lab1.copyfiles.CopyFiles;
import main.lab1.copyfiles.InputOutput;

class Main {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("No arguments");
            }
            if (args.length != 2) {
                throw new IllegalArgumentException("Wrong number of arguments");
            }
            InputOutput input = new InputOutput(args[0]);
            InputOutput output = new InputOutput(args[1]);
            final CopyFiles application = new CopyFiles();
            application.copyfile(input.getFileInstance(), output.getFileInstance());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}