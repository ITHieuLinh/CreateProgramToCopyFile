package Controller;

import Repository.FileRepository;

public class FileCopyProgram {

    FileRepository program;

    public FileCopyProgram() {
        program = new FileRepository();
    }

    public void run() {
        System.out.println("\nCopy Program:");
        program.readFileConfig();
    }
}
