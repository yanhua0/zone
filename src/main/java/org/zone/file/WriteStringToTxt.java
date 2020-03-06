package org.zone.file;

import java.io.*;

public class WriteStringToTxt {

    public void WriteStringToFile(String filePath) {
        try {
            File file = new File(filePath);
            PrintStream ps = new PrintStream(new FileOutputStream(file));
            ps.println("http://www.docin.com/p-315288370.html");// 往文件里写入字符串  
            ps.append("http://www.docin.com/p-315288370.html");// 在已有的基础上添加字符串  
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }
    }

    public void WriteStringToFile2(String filePath) {
        try {
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.append("在已有的基础上添加字符串");
            bw.write("abc\r\n ");// 往已有的文件上添加字符串  
            bw.write("def\r\n ");
            bw.write("hijk ");
            bw.close();
            fw.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }
    }

    public void WriteStringToFile3(String filePath) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filePath));
            pw.println("abc ");
            pw.println("def ");
            pw.println("hef ");
            pw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }
    }

    public void WriteStringToFile4(String filePath) {
        try {
            RandomAccessFile rf = new RandomAccessFile(filePath, "rw");
            rf.writeBytes("op\r\n");
            rf.writeBytes("app\r\n");
            rf.writeBytes("hijklllll");
            rf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void WriteStringToFile5(String filePath,String s) {
        try {
            OutputStreamWriter oStreamWriter = new OutputStreamWriter(new FileOutputStream(filePath), "utf-8");
            oStreamWriter.append(s);
            oStreamWriter.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }
    }
    public static String readTxt(String path) {
        if (path == null || "".equals(path)) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        File file = new File(path);
        InputStreamReader read = null;
        BufferedReader reader = null;
        try {
            read = new InputStreamReader(new FileInputStream(file), "utf-8");
            reader = new BufferedReader(read);
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\n");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (read != null) {
                try {
                    read.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }


        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String filePath = "H:\\link3.txt";
        String s = "http://www.docin.com/p-315288370.html作为";
        // new WriteStringToTxt().WriteStringToFile(filePath);  
        // new WriteStringToTxt().WriteStringToFile2(filePath);  
        // new WriteStringToTxt().WriteStringToFile3(filePath);  
        // new WriteStringToTxt().WriteStringToFile4(filePath);  
      System.out.println(readTxt(filePath));
    }
}  