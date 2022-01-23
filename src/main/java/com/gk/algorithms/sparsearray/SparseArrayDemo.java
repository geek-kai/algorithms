package com.gk.algorithms.sparsearray;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/***
 * @author gk
 * @create 2022-01-23 12:39 下午
 **/
public class SparseArrayDemo {

    public static void main(String[] args) throws IOException {
        int[][] demo = new int[10][11];
        demo[0][4] = 12;
        demo[9][5] = 13;
        demo[2][4] = 13;
        demo[3][4] = 13;

        parentArray(demo);
        SparseArray sparseArray = new SparseArray();
        int[][] sparse = sparseArray.convertArrayToSpares(demo);
        writSparseToFile(sparse);
        parentArray(sparse);

        parentArray(sparseArray.convertSparseToArray(Objects.requireNonNull(readSparseForFile())));
    }

    private static void writSparseToFile(int[][] sparse) throws IOException {
        File file = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "sparseArray.txt");
        System.out.println(file.getPath());
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        for (int[] lines : sparse) {
            StringJoiner joiner = new StringJoiner(",");
            for (int data : lines) {
                joiner.add(data + "");
            }
            bufferedWriter.write(joiner.toString());
            bufferedWriter.newLine();
        }
        bufferedWriter.close();

    }

    /**
     * 从文件读取稀疏数组
     *
     * @return
     * @throws IOException
     */
    private static int[][] readSparseForFile() throws IOException {
        File file = new File(System.getProperty("user.dir") + File.separator + "data" + File.separator + "sparseArray.txt");
        System.out.println(file.getPath());
        if (!file.exists()) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        List<String> lines = bufferedReader.lines().filter(line -> line != null && line.length() > 0).collect(Collectors.toList());
        int[][] sparseArray = new int[lines.size()][3];
        for (int i = 0; i < lines.size(); i++) {
            List<Integer> line = Arrays.stream(lines.get(i).split(",")).map(Integer::parseInt).collect(Collectors.toList());
            for (int j = 0; j < line.size(); j++) {
                sparseArray[i][j] = line.get(j);
            }
        }
        return sparseArray;
    }

    private static void parentArray(int[][] array) {
        for (int[] lines : array) {
            for (int data : lines) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}

