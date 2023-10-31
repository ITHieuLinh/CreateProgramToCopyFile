package Common;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;


public class Library {
    protected Scanner sc;

    public Library() {
        sc = new Scanner(System.in);
    }
    public int getInt(String promt, int m, int n) {
        int a = -1;
        while (true) {
            System.out.print(promt + ": ");
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a >= m && a <= n) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Please enter a number between " + m + " and " + n);
            }
        }
        return a;
    }

//    public int getIntNoLimit(String promt) {
//        int a = -1;
//        while (true) {
//            System.out.print(promt + ": ");
//            try {
//                String s = sc.nextLine();
//                a = Integer.parseInt(s);
//                return a;
//            } catch (Exception e) {
//                System.out.println("Invalid input!!!");
//            }
//        }
//    }
    
    public int getIntNoLimit(String promt) {
        int a = -1;
        while (true) {
            System.out.print(promt);
            try {
                String s = sc.nextLine();
                a = Integer.parseInt(s);
                if (a > 0 && a <= 10000) {
                    return a;
                } else {
                    System.out.println("Invalid input");
                }
            } catch (Exception e) {
                System.out.println("Invalid input");
            }
        }
    }
    
    public String getString(String mes) {
        System.out.print(mes);
        return sc.nextLine();
    }

    public double checkInputDouble(String promt) {
        //loop until user input correct
        while (true) {
            System.out.print(promt);
            try {
                double result = Double.parseDouble(sc.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!!!");
            }
        }
    }

//    public String inputString(String mes) {
//        System.out.print(mes);
//        while (true) {
//            String result = sc.nextLine();
//            if (result.isEmpty()) {
//                System.out.print("Enter again: ");
//            } else {
//                return result;
//            }
//        }
//    }
//    public String checkInputPathFile(String promt) {
//        System.out.print(promt);
//        while (true) {
//            String result = sc.nextLine().trim();
//            File file = new File(result);
//            //check file exist or not and path must be file
//            if (!file.exists() || !file.isFile()) {
//                System.err.println("Path doesn't exist!!!");
//                System.out.print("Enter again: ");
//            } else {
//                return result;
//            }
//        }
//    }
    public boolean checkInputYN(String mes) {
        System.out.print(mes);
        while (true) {
            String result = sc.nextLine();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    
    public boolean checkFileConfig(File propertiesFile) {
        Properties prop = new Properties();
        InputStream input = null;
        boolean exist = false;
        try {
            input = new FileInputStream(propertiesFile);
            prop.load(input);
            if (prop.getProperty("COPY_FOLDER").length() == 0) {
                System.err.println("Folder Sourse is not input");
            }
            if (prop.getProperty("DATA_TYPE").length() == 0) {
                System.err.println("Data type is not input");
            }
            if (prop.getProperty("PATH").length() == 0) {
                System.err.println("Folder Destination is not input");
            }
            exist = prop.getProperty("COPY_FOLDER") != null && prop.getProperty("DATA_TYPE") != null && prop.getProperty("PATH") != null;
        } catch (IOException ex) {
            ex.printStackTrace();
            System.err.println("Can read file configure!");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("File configure is not found!");
                }
            }
        }
        return exist;
    }
    
    public boolean checkInformationConfig(File f1, File f2) {
        System.out.println("Check Configure File");
        boolean checkInformationConfig = f1.exists() && f1.isDirectory()&& f2.exists() && f2.isDirectory();
        if (f1.exists() == false || f1.isDirectory() == false) {
            System.err.println("Can't find folder Sourse");
        }
        if (f2.exists() == false || f2.isDirectory() == false) {
            System.err.println("Can't make folder Destination");
        }
        return checkInformationConfig;
    }
    
    public String checkInputPathFile(String promt) {
        System.out.print(promt);
        while (true) {
            String result = sc.nextLine().trim();
            File file = new File(result);
            //check file exist or not and path must be file
            if (!file.exists() || !file.isFile()) {
                System.err.println("Path doesn't exist!!!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }
}
