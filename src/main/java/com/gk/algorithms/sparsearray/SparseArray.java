package com.gk.algorithms.sparsearray;

import java.util.ArrayList;
import java.util.List;

/***
 * @author gk
 * @create 2022-01-23 12:27 下午
 **/
public class SparseArray {

    /**
     * 转换数组到稀疏数组
     *
     * @param array
     * @return
     */
    public int[][] convertArrayToSpares(int[][] array) {
        if (array == null) {
            return null;
        }
        List<SparseArrayInfo> arrayInfos = new ArrayList<>();
        int line = array.length;
        int row = array[0].length;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < row; j++) {
                int data = array[i][j];
                if (data != 0) {
                    arrayInfos.add(new SparseArrayInfo(j, i, data));
                }
            }
        }
        int[][] sparseArray = new int[arrayInfos.size() + 1][3];
        int sparseLineStart = 0;
        fillingSparse(sparseArray, line, row, arrayInfos.size(), sparseLineStart);
        for (SparseArrayInfo arrayInfo : arrayInfos) {
            fillingSparse(sparseArray, arrayInfo.line, arrayInfo.row, arrayInfo.data, ++sparseLineStart);
        }
        return sparseArray;

    }

    /**
     * 转换稀疏数组到数组
     *
     * @param sparseArray
     * @return
     */
    public  int[][] convertSparseToArray(int[][] sparseArray) {
        int[][] array = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i <= sparseArray[0][2]; i++) {
            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return array;
    }

    /**
     * 填充稀疏数组数据
     *
     * @param sparseArray
     * @param line
     * @param row
     * @param data
     * @param line
     */
    private void fillingSparse(int[][] sparseArray, int line, int row, int data, int sparseLine) {
        sparseArray[sparseLine][0] = line;
        sparseArray[sparseLine][1] = row;
        sparseArray[sparseLine][2] = data;
    }

    private static class SparseArrayInfo {
        //列号
        private int row;
        //行号
        private int line;
        //数据
        private int data;

        public SparseArrayInfo(int row, int line, int data) {
            this.row = row;
            this.line = line;
            this.data = data;
        }
    }

}

